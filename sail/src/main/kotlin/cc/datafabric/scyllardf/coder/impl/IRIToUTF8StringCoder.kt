package cc.datafabric.scyllardf.coder.impl

import org.eclipse.rdf4j.model.IRI
import org.eclipse.rdf4j.model.impl.SimpleValueFactory
import java.nio.ByteBuffer

internal class IRIToUTF8StringCoder(coderId: Int) : AbstractCoder<IRI>(coderId) {

    override fun encode(value: IRI?): ByteBuffer? {
        if (value == null) {
            return null
        }

        val valueHash = value.stringValue().toByteArray(Charsets.UTF_8)

        return newHash(coderId, MARKER_VALUE_TYPE_IRI, valueHash)
    }

    override fun decode(hash: ByteBuffer): IRI {
        val str = String(
            hash.array(),
            CODER_METADATA_OFFSET,
            hash.array().size - CODER_METADATA_OFFSET,
            Charsets.UTF_8
        )

        return VF.createIRI(str)
    }

}