package cc.datafabric.scyllardf.model.impl

import cc.datafabric.scyllardf.coder.ICoder
import org.eclipse.rdf4j.model.BNode
import org.eclipse.rdf4j.model.impl.SimpleBNode
import java.nio.ByteBuffer

internal class EncodedBNode(
    private val coder: ICoder<BNode>,
    private val hash: ByteBuffer
) : BNode {

    private var decodedBNode: BNode? = null

    private fun decodeIfNeeded() {
        if (decodedBNode == null) {
            synchronized(this) {
                if (decodedBNode == null) {
                    decodedBNode = coder.decode(hash)
                }
            }
        }
    }

    override fun stringValue(): String {
        decodeIfNeeded()

        return decodedBNode!!.stringValue()
    }

    override fun getID(): String {
        decodeIfNeeded()

        return decodedBNode!!.id
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        if (other is EncodedBNode) {
            return this.hash == other.hash
        }
        if (other is SimpleBNode) {
            decodeIfNeeded()

            return this.decodedBNode == other
        }

        return false
    }

    override fun hashCode(): Int {
        return hash.hashCode()
    }

}