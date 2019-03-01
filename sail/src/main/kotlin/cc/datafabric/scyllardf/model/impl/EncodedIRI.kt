package cc.datafabric.scyllardf.model.impl

import cc.datafabric.scyllardf.coder.ICoder
import org.eclipse.rdf4j.model.IRI
import org.eclipse.rdf4j.model.impl.SimpleIRI
import java.nio.ByteBuffer

internal class EncodedIRI constructor(
    private val coder: ICoder<IRI>,
    private val hash: ByteBuffer
) : IRI {

    private var decodedIRI: IRI? = null

    private fun decodeIfNeeded() {
        if (decodedIRI == null) {
            synchronized(this) {
                if (decodedIRI == null) {
                    decodedIRI = coder.decode(hash)
                }
            }
        }
    }

    override fun stringValue(): String {
        decodeIfNeeded()

        return decodedIRI!!.stringValue()
    }

    override fun getNamespace(): String {
        decodeIfNeeded()

        return decodedIRI!!.namespace
    }

    override fun getLocalName(): String {
        decodeIfNeeded()

        return decodedIRI!!.localName
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        if (other is EncodedIRI) {
            return this.hash == other.hash
        }
        if (other is SimpleIRI) {
            decodeIfNeeded()

            return decodedIRI == other
        }

        return false
    }

    override fun hashCode(): Int {
        return hash.hashCode()
    }

    override fun toString(): String {
        decodeIfNeeded()

        return decodedIRI!!.toString()
    }

}