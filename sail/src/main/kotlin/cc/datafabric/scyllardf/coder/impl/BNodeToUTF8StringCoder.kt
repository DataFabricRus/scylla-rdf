package cc.datafabric.scyllardf.coder.impl

import org.eclipse.rdf4j.model.BNode
import java.nio.ByteBuffer

internal class BNodeToUTF8StringCoder(coderId: Int) : AbstractCoder<BNode>(coderId) {

    override fun encode(value: BNode?): ByteBuffer? {
        if (value == null) {
            return null
        }

        val valueHash = value.stringValue().toByteArray(Charsets.UTF_8)

        return newHash(coderId, MARKER_VALUE_TYPE_BNODE, valueHash)
    }

    override fun decode(hash: ByteBuffer): BNode {
        val str = String(
            hash.array(),
            CODER_METADATA_OFFSET,
            hash.array().size - CODER_METADATA_OFFSET,
            Charsets.UTF_8
        )

        return VF.createBNode(str)
    }
}