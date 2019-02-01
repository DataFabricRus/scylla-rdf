package cc.datafabric.scyllardf.dao

import org.eclipse.rdf4j.common.iteration.CloseableIteration
import org.eclipse.rdf4j.model.BNode
import org.eclipse.rdf4j.model.IRI
import org.eclipse.rdf4j.model.Literal
import org.eclipse.rdf4j.model.Namespace
import org.eclipse.rdf4j.model.Resource
import org.eclipse.rdf4j.model.Statement
import org.eclipse.rdf4j.model.Value
import org.eclipse.rdf4j.model.impl.SimpleNamespace
import org.eclipse.rdf4j.model.impl.SimpleValueFactory
import org.eclipse.rdf4j.rio.ntriples.NTriplesUtil
import org.eclipse.rdf4j.sail.SailException
import java.nio.ByteBuffer

object Coder {

    public val CONTEXT_DEFAULT = byteArrayOf(0)

    private const val MARKER_VT_IRI: Byte = 0
    private const val MARKER_VT_BNODE: Byte = 1
    private const val MARKER_VT_LITERAL: Byte = 2

    private val valueFactory = SimpleValueFactory.getInstance()

    fun encode(values: Array<out Resource?>): List<ByteArray?> {
        return values.map {
            if (it != null) {
                Coder.encode(it)
            } else {
                null
            }
        }
    }

    fun encode(value: Resource?): ByteArray? {
        if (value == null) {
            return null
        }

        if (value is IRI) {
            return Coder.encode(value)
        } else if (value is BNode) {
            return Coder.encode(value)
        }

        throw IllegalArgumentException()
    }

    fun encode(value: Value?): ByteArray? {
        if (value == null) {
            return null
        }

        return when (value) {
            is IRI -> Coder.encode(value)
            is BNode -> Coder.encode(value)
            is Literal -> Coder.encode(value)
            else -> throw IllegalArgumentException()
        }
    }

    fun encode(value: IRI?): ByteArray? {
        if (value == null) {
            return null
        }

        val vb = value.stringValue().toByteArray(Charsets.UTF_8)

        val id = ByteArray(vb.size + 1)
        id[0] = MARKER_VT_IRI

        System.arraycopy(vb, 0, id, 1, vb.size)

        return id
    }

    fun encode(value: BNode): ByteArray {
        val vb = value.id.toByteArray(Charsets.UTF_8)

        val id = ByteArray(vb.size + 1)
        id[0] = MARKER_VT_BNODE

        System.arraycopy(vb, 0, id, 1, vb.size)

        return id
    }

    fun encode(value: Literal): ByteArray {
        val vb = NTriplesUtil
            .toNTriplesString(value)
            .toByteArray(Charsets.UTF_8)

        val id = ByteArray(vb.size + 1)
        id[0] = MARKER_VT_LITERAL

        System.arraycopy(vb, 0, id, 1, vb.size)

        return id
    }

    fun encode(stmt: Statement): Array<ByteArray> {
        val subj = Coder.encode(stmt.subject)!!
        val pred = Coder.encode(stmt.predicate)!!
        val obj = Coder.encode(stmt.`object`)!!
        val c = if (stmt.context == null) {
            CONTEXT_DEFAULT
        } else {
            Coder.encode(stmt.context)!!
        }

        return arrayOf(subj, pred, obj, c)
    }

    fun decode(value: ByteArray): Value {
        val str = String(value, 1, value.size - 1, Charsets.UTF_8)

        return when (value[0]) {
            MARKER_VT_IRI -> valueFactory.createIRI(str)
            MARKER_VT_BNODE -> valueFactory.createBNode(str)
            MARKER_VT_LITERAL -> NTriplesUtil.parseLiteral(str, valueFactory)
            else -> throw IllegalArgumentException()
        }
    }

    fun decode(spoc: Array<ByteArray>): Statement {
        return if (spoc[3].contentEquals(CONTEXT_DEFAULT)) {
            valueFactory.createStatement(
                Coder.decode(spoc[0]) as Resource,
                Coder.decode(spoc[1]) as IRI,
                Coder.decode(spoc[2])
            )
        } else {
            valueFactory.createStatement(
                Coder.decode(spoc[0]) as Resource,
                Coder.decode(spoc[1]) as IRI,
                Coder.decode(spoc[2]),
                Coder.decode(spoc[3]) as Resource
            )
        }
    }

    fun toStatementIteration(origin: SPOCIteration): CloseableIteration<Statement, SailException> {
        return object : CloseableIteration<Statement, SailException> {
            override fun next(): Statement {
                return Coder.decode(origin.next())
            }

            override fun remove() {
                origin.remove()
            }

            override fun hasNext(): Boolean {
                return origin.hasNext()
            }

            override fun close() {
                origin.close()
            }

        }
    }

    fun toResourceIteration(origin: CloseableIteration<ByteArray, SailException>)
        : CloseableIteration<out Resource, SailException> {
        return object : CloseableIteration<Resource, SailException> {
            override fun next(): Resource {
                return Coder.decode(origin.next()) as Resource
            }

            override fun remove() {
                origin.remove()
            }

            override fun hasNext(): Boolean {
                return origin.hasNext()
            }

            override fun close() {
                origin.close()
            }
        }
    }

    fun toNamespaceIteration(origin: CloseableIteration<Array<String>, SailException>)
        : CloseableIteration<Namespace, SailException> {
        return object : CloseableIteration<Namespace, SailException> {
            override fun next(): Namespace {
                val array = origin.next()

                return SimpleNamespace(array[0], array[1])
            }

            override fun remove() {
                return origin.remove()
            }

            override fun hasNext(): Boolean {
                return origin.hasNext()
            }

            override fun close() {
                origin.close()
            }
        }
    }

    fun toByteBuffer(bytes: ByteArray): ByteBuffer {
        return ByteBuffer.wrap(bytes)
    }

}