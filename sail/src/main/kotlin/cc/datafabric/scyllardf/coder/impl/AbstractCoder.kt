package cc.datafabric.scyllardf.coder.impl

import cc.datafabric.scyllardf.coder.ICoder
import org.eclipse.rdf4j.model.Value
import org.eclipse.rdf4j.model.impl.SimpleValueFactory
import java.nio.ByteBuffer
import kotlin.experimental.and
import kotlin.experimental.or

internal abstract class AbstractCoder<T : Value>(coderId: Int) : ICoder<T> {

    companion object {
        const val MARKER_VALUE_TYPE_LANG_STRING: Byte = 0
        const val MARKER_VALUE_TYPE_IRI: Byte = 1
        const val MARKER_VALUE_TYPE_BNODE: Byte = 2
        const val MARKER_VALUE_TYPE_LITERAL: Byte = 3

        const val CODER_METADATA_OFFSET = 1

        private const val MASK_VALUE_TYPE: Byte = 0b00000011
        private const val MASK_CODER_ID: Byte = 0b01111100

        val VF = SimpleValueFactory.getInstance()

        fun valueType(array: ByteBuffer): Byte {
            return array[0] and MASK_VALUE_TYPE
        }

        fun coderId(array: ByteBuffer): Int {
            return (array[0] and MASK_CODER_ID).toInt() shr 2
        }
    }

    protected val coderId: Byte = (coderId shl 2).toByte()

    protected fun newHash(coderId: Byte, valueType: Byte, vhash: ByteArray): ByteBuffer {
        val hash = ByteArray(vhash.size + 1)
        hash[0] = (coderId or valueType)

        System.arraycopy(vhash, 0, hash, 1, vhash.size)

        return ByteBuffer.wrap(hash)
    }
}