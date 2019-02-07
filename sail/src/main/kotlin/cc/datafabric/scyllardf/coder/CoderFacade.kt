package cc.datafabric.scyllardf.coder

import cc.datafabric.scyllardf.coder.impl.AbstractCoder
import cc.datafabric.scyllardf.coder.impl.BNodeDefaultCoder
import cc.datafabric.scyllardf.coder.impl.IRIDefaultCoder
import cc.datafabric.scyllardf.coder.impl.IRIFromKnownVocabularyCoder
import cc.datafabric.scyllardf.coder.impl.IRIWithFixedNamespaceCoder
import cc.datafabric.scyllardf.coder.impl.LiteralWithLangCoder
import cc.datafabric.scyllardf.coder.impl.LiteralDefaultCoder
import cc.datafabric.scyllardf.coder.impl.LiteralWithPrimitiveDatatypeCoder
import cc.datafabric.scyllardf.dao.SPOCIteration
import cc.datafabric.scyllardf.dao.ScyllaRDFDAO
import cc.datafabric.scyllardf.dao.ScyllaRDFSchema
import org.eclipse.rdf4j.common.iteration.CloseableIteration
import org.eclipse.rdf4j.model.BNode
import org.eclipse.rdf4j.model.IRI
import org.eclipse.rdf4j.model.Literal
import org.eclipse.rdf4j.model.Namespace
import org.eclipse.rdf4j.model.Resource
import org.eclipse.rdf4j.model.Statement
import org.eclipse.rdf4j.model.Value
import org.eclipse.rdf4j.model.impl.SimpleNamespace
import org.eclipse.rdf4j.model.vocabulary.RDF
import org.eclipse.rdf4j.sail.SailException
import java.nio.ByteBuffer

public object CoderFacade {
    private val iriCoders = mutableListOf<ICoder<IRI>>()
    private val bnodeCoders = mutableListOf<ICoder<BNode>>()
    private val langStringCoders = mutableListOf<ICoder<Literal>>()
    private val literalCoders = mutableListOf<ICoder<Literal>>()

    private var isInitialized = false

    fun initialize(dao: ScyllaRDFDAO) {
        synchronized(this) {
            if (!isInitialized) {
                /**
                 * IRI coders
                 */
                var knownVocabsDict = dao.loadKnownVocabulariesDictionary()
                val knownVocabsCoder = IRIFromKnownVocabularyCoder(0)
                knownVocabsDict = knownVocabsCoder.initialize(knownVocabsDict)
                dao.updateKnownVocabulariesDictionary(knownVocabsDict)
                iriCoders.add(0, knownVocabsCoder)

                iriCoders.add(1, IRIWithFixedNamespaceCoder(1))
                iriCoders.add(2, IRIDefaultCoder(2))

                /**
                 * BNode coders
                 */
                bnodeCoders.add(0, BNodeDefaultCoder(0))

                /**
                 * Lang string coders
                 */
                langStringCoders.add(0, LiteralWithLangCoder(0))

                /**
                 * Typed literal coders
                 */
                literalCoders.add(0, LiteralWithPrimitiveDatatypeCoder(0))
                literalCoders.add(1, LiteralDefaultCoder(1))

                isInitialized = true
            }
        }
    }

    fun encode(values: Array<out Resource?>): List<ByteBuffer?> {
        return values.map {
            if (it != null) {
                encode(it)
            } else {
                null
            }
        }
    }

    fun encode(value: Resource?): ByteBuffer? {
        if (value == null) {
            return null
        }

        if (value is IRI) {
            return encode(value)
        } else if (value is BNode) {
            return encode(value)
        }

        throw IllegalArgumentException("Unsupported RDF resource type!")
    }

    fun encode(value: Value?): ByteBuffer? {
        if (value == null) {
            return null
        }

        return when (value) {
            is IRI -> encode(value)
            is BNode -> encode(value)
            is Literal -> encode(value)
            else -> throw IllegalArgumentException("Unsupported RDF value type!")
        }
    }

    fun encode(value: IRI?): ByteBuffer? {
        if (value == null) {
            return null
        }

        var hash: ByteBuffer? = null
        for (coder in iriCoders) {
            hash = coder.encode(value)
            if (hash != null) {
                break
            }
        }

        return hash!!
    }

    fun encode(value: BNode): ByteBuffer {
        var hash: ByteBuffer? = null
        for (coder in bnodeCoders) {
            hash = coder.encode(value)
            if (hash != null) {
                break
            }
        }

        return hash!!
    }

    fun encode(value: Literal): ByteBuffer {
        var hash: ByteBuffer? = null

        if (value.datatype == RDF.LANGSTRING) {
            for (coder in langStringCoders) {
                hash = coder.encode(value)
                if (hash != null) {
                    break
                }
            }
        } else {
            for (coder in literalCoders) {
                hash = coder.encode(value)
                if (hash != null) {
                    break
                }
            }
        }

        return hash!!
    }

    fun encode(stmt: Statement): Array<ByteBuffer> {
        val subj = encode(stmt.subject)!!
        val pred = encode(stmt.predicate)!!
        val obj = encode(stmt.`object`)!!
        val c = if (stmt.context == null) {
            ScyllaRDFSchema.CONTEXT_DEFAULT
        } else {
            encode(stmt.context)!!
        }

        return arrayOf(subj, pred, obj, c)
    }

    fun decode(hash: ByteBuffer): Value {
        val valueType = AbstractCoder.valueType(hash)
        val coderId = AbstractCoder.coderId(hash)

        return when (valueType) {
            AbstractCoder.MARKER_VALUE_TYPE_IRI -> iriCoders[coderId].decode(hash)
            AbstractCoder.MARKER_VALUE_TYPE_BNODE -> bnodeCoders[coderId].decode(hash)
            AbstractCoder.MARKER_VALUE_TYPE_LANG_STRING -> langStringCoders[coderId].decode(hash)
            AbstractCoder.MARKER_VALUE_TYPE_LITERAL -> literalCoders[coderId].decode(hash)
            else -> throw IllegalArgumentException("Could find the suitable coder!")
        }
    }

    fun decode(spoc: Array<ByteBuffer>): Statement {
        return if (spoc[3] == ScyllaRDFSchema.CONTEXT_DEFAULT) {
            AbstractCoder.VF.createStatement(
                decode(spoc[0]) as Resource,
                decode(spoc[1]) as IRI,
                decode(spoc[2])
            )
        } else {
            AbstractCoder.VF.createStatement(
                decode(spoc[0]) as Resource,
                decode(spoc[1]) as IRI,
                decode(spoc[2]),
                decode(spoc[3]) as Resource
            )
        }
    }

    fun toStatementIteration(origin: SPOCIteration): CloseableIteration<Statement, SailException> {
        return object : CloseableIteration<Statement, SailException> {
            override fun next(): Statement {
                return decode(origin.next())
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

    fun toResourceIteration(origin: CloseableIteration<ByteBuffer, SailException>)
        : CloseableIteration<out Resource, SailException> {
        return object : CloseableIteration<Resource, SailException> {
            override fun next(): Resource {
                return decode(origin.next()) as Resource
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

}