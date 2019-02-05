package cc.datafabric.scyllardf.coder.impl

import com.google.common.collect.BiMap
import com.google.common.collect.HashBiMap
import com.google.common.primitives.Bytes
import org.eclipse.rdf4j.model.IRI
import java.nio.ByteBuffer

internal class IRIWithFixedNamespaceCoder(coderId: Int) : AbstractCoder<IRI>(coderId) {

    private val dictionary = HashBiMap.create<String, ByteBuffer>()

    init {
        arrayListOf(
            "urn:datafabric:org:",
            "urn:datafabric:value:",
            "urn:datafabric:version:",

            "http://example.com/version/",
            "http://example.com/details/",
            "http://example.com/resource/",
            "http://example.com/lefmethod/",
            "http://example.com/regnumberdate/",
            "http://example.com/region/",
            "http://example.com/address/",
            "http://example.com/kladrcode/",
            "http://example.com/okved/",
            "http://example.com/person/",
            "http://example.com/typeofrepresentative/",
            "http://example.com/country/",
            "http://example.com/legalentity/",
            "http://example.com/publicbody/",
            "http://example.com/founderentity/",
            "http://example.com/pifentity/",
            "http://example.com/lestatus/",
            "http://example.com/cessationmethod/",
            "http://example.com/reorganizationform/",
            "http://example.com/individual/",
            "http://example.com/ieType/",
            "http://example.com/IeRecord/",
            "http://example.com/gender/",
            "http://example.com/taxauthority/"
        ).forEachIndexed { namespaceId, iri ->
            registerEntry(namespaceId.toByte(), dictionary, iri)
        }
    }

    override fun encode(value: IRI?): ByteBuffer? {
        if (value == null) {
            return null
        }

        val hashPrefix = dictionary[value.namespace]
        if (hashPrefix == null) {
            return null
        }

        val hashSuffix = value.localName.toByteArray(Charsets.UTF_8)
        return ByteBuffer.wrap(Bytes.concat(hashPrefix.array(), hashSuffix))
    }

    override fun decode(hash: ByteBuffer): IRI {
        val namespace = dictionary.inverse()[ByteBuffer.wrap(hash.array(), 0, 2)]!!

        return VF.createIRI(
            namespace,
            String(
                hash.array(),
                CODER_METADATA_OFFSET + 1,
                hash.array().size - (CODER_METADATA_OFFSET + 1),
                Charsets.UTF_8
            )
        )
    }

    private fun registerEntry(namespaceId: Byte, index: BiMap<String, ByteBuffer>, value: String) {
        index[value] = newHash(coderId, MARKER_VALUE_TYPE_IRI, byteArrayOf(namespaceId))
    }

}