package cc.datafabric.scyllardf.coder.impl

import com.google.common.collect.BiMap
import com.google.common.collect.HashBiMap
import com.google.common.primitives.Bytes
import org.eclipse.rdf4j.model.IRI
import org.eclipse.rdf4j.model.Literal
import org.eclipse.rdf4j.model.vocabulary.XMLSchema
import java.nio.ByteBuffer

internal class LiteralWithPrimitiveDatatypeCoder(coderId: Int) : AbstractCoder<Literal>(coderId) {

    private val dictionary = HashBiMap.create<IRI, ByteBuffer>()

    init {
        arrayListOf<IRI>(
            XMLSchema.BOOLEAN, XMLSchema.BASE64BINARY,
            XMLSchema.HEXBINARY, XMLSchema.FLOAT,
            XMLSchema.DECIMAL, XMLSchema.INTEGER,
            XMLSchema.INT, XMLSchema.DOUBLE,
            XMLSchema.ANYURI, XMLSchema.QNAME,
            XMLSchema.NOTATION, XMLSchema.STRING,
            XMLSchema.DURATION, XMLSchema.DATETIME,
            XMLSchema.TIME, XMLSchema.DATE,
            XMLSchema.GYEARMONTH, XMLSchema.GYEAR,
            XMLSchema.GMONTHDAY, XMLSchema.GDAY,
            XMLSchema.GMONTH
        ).forEachIndexed { datatypeId, iri ->
            registerEntry(datatypeId.toByte(), dictionary, iri)
        }
    }

    override fun encode(value: Literal?): ByteBuffer? {
        if (value == null) {
            return null
        }

        val hashPrefix = dictionary[value.datatype]
        if (hashPrefix == null) {
            return null
        }

        val hashSuffix = value.stringValue().toByteArray(Charsets.UTF_8)
        return ByteBuffer.wrap(Bytes.concat(hashPrefix.array(), hashSuffix))
    }

    override fun decode(hash: ByteBuffer): Literal {
        val datatype = dictionary.inverse()[ByteBuffer.wrap(hash.array(), 0, 2)]!!

        return VF.createLiteral(
            String(
                hash.array(),
                CODER_METADATA_OFFSET + 1,
                hash.array().size - (CODER_METADATA_OFFSET + 1),
                Charsets.UTF_8
            ),
            datatype
        )
    }

    private fun registerEntry(datatypeId: Byte, index: BiMap<IRI, ByteBuffer>, value: IRI) {
        index[value] = newHash(coderId, MARKER_VALUE_TYPE_LITERAL, byteArrayOf(datatypeId))
    }

}