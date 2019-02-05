package cc.datafabric.scyllardf.coder.impl

import org.eclipse.rdf4j.model.Literal
import org.eclipse.rdf4j.rio.ntriples.NTriplesUtil
import java.nio.ByteBuffer

internal class LiteralWithLangCoder(coderId: Int) : AbstractCoder<Literal>(coderId) {
    override fun encode(value: Literal?): ByteBuffer? {
        if (value == null) {
            return null
        }

        val valueHash = NTriplesUtil.toNTriplesString(value).toByteArray(Charsets.UTF_8)

        return newHash(coderId, MARKER_VALUE_TYPE_LANG_STRING, valueHash)
    }

    override fun decode(hash: ByteBuffer): Literal {
        val str = String(
            hash.array(),
            CODER_METADATA_OFFSET,
            hash.array().size - CODER_METADATA_OFFSET,
            Charsets.UTF_8
        )

        return NTriplesUtil.parseLiteral(str, VF)
    }
}