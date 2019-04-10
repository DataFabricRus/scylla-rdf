package cc.datafabric.scyllardf.coder

import cc.datafabric.scyllardf.coder.impl.AbstractCoder
import cc.datafabric.scyllardf.coder.impl.BNodeDefaultCoder
import cc.datafabric.scyllardf.coder.impl.IRIDefaultCoder
import cc.datafabric.scyllardf.coder.impl.IRIFromKnownVocabularyCoder
import cc.datafabric.scyllardf.coder.impl.IRIWithFixedNamespaceCoder
import cc.datafabric.scyllardf.coder.impl.LiteralDefaultCoder
import cc.datafabric.scyllardf.coder.impl.LiteralWithLangCoder
import cc.datafabric.scyllardf.coder.impl.LiteralWithPrimitiveDatatypeCoder
import cc.datafabric.scyllardf.dao.IDictionaryDAO
import cc.datafabric.scyllardf.dao.SPOCIteration
import cc.datafabric.scyllardf.dao.ScyllaRDFSchema
import cc.datafabric.scyllardf.model.impl.EncodedBNode
import cc.datafabric.scyllardf.model.impl.EncodedIRI
import cc.datafabric.scyllardf.model.impl.EncodedLiteral
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

public class CoderFacade : ICoderFacade {

    private lateinit var iriCoders: Array<ICoder<IRI>>
    private lateinit var bnodeCoders: Array<ICoder<BNode>>
    private lateinit var langStringCoders: Array<ICoder<Literal>>
    private lateinit var literalCoders: Array<ICoder<Literal>>

    private var isInitialized = false

    /**
     * @param saveOnChangesInDictionary true may cause consistency issues if executed in parallel
     */
    fun initialize(dao: IDictionaryDAO, saveOnChangesInDictionary: Boolean = false) {
        if (!isInitialized) {
            /**
             * IRI coders
             */
            var knownVocabsDict = dao.loadKnownVocabulariesDictionary()
            val knownVocabsCoder = IRIFromKnownVocabularyCoder(0)
            knownVocabsDict = knownVocabsCoder.initialize(knownVocabsDict)

            if (saveOnChangesInDictionary) {
                dao.saveKnownVocabulariesDictionary(knownVocabsDict)
            }

            iriCoders = arrayOf(
                knownVocabsCoder,
                IRIWithFixedNamespaceCoder(1),
                IRIDefaultCoder(2)
            )

            /**
             * BNode coders
             */
            bnodeCoders = arrayOf(BNodeDefaultCoder(0))

            /**
             * Lang string coders
             */
            langStringCoders = arrayOf(LiteralWithLangCoder(0))

            /**
             * Typed literal coders
             */
            literalCoders = arrayOf(
                LiteralWithPrimitiveDatatypeCoder(0),
                LiteralDefaultCoder(1)
            )

            isInitialized = true
        } else {
            throw IllegalStateException("CoderFacade was already initialized!")
        }
    }

    override fun encode(values: Array<out Resource?>): List<ByteBuffer?> {
        return values.map {
            if (it != null) {
                encode(it)
            } else {
                null
            }
        }
    }

    override fun encode(value: Resource?): ByteBuffer? {
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

    override fun encode(value: Value?): ByteBuffer? {
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

    override fun encode(value: IRI?): ByteBuffer? {
        if (value == null) {
            return null
        }

        for (coder in iriCoders) {
            val hash = coder.encode(value)
            if (hash != null) {
                return hash
            }
        }

        throw IllegalStateException("Couldn't find an appropriate coder!")
    }

    override fun encode(value: BNode): ByteBuffer {
        for (coder in bnodeCoders) {
            val hash = coder.encode(value)
            if (hash != null) {
                return hash
            }
        }

        throw IllegalStateException("Couldn't find an appropriate coder!")
    }

    override fun encode(value: Literal): ByteBuffer {
        if (value.datatype == RDF.LANGSTRING) {
            for (coder in langStringCoders) {
                val hash = coder.encode(value)
                if (hash != null) {
                    return hash
                }
            }
        } else {
            for (coder in literalCoders) {
                val hash = coder.encode(value)
                if (hash != null) {
                    return hash
                }
            }
        }

        throw IllegalStateException("Couldn't find an appropriate coder!")
    }

    override fun encode(stmt: Statement): Array<ByteBuffer> {
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

    override fun decode(hash: ByteBuffer): Value {
        val valueType = AbstractCoder.valueType(hash)
        val coderId = AbstractCoder.coderId(hash)

        return when (valueType) {
            AbstractCoder.MARKER_VALUE_TYPE_IRI -> EncodedIRI(iriCoders[coderId], hash)
            AbstractCoder.MARKER_VALUE_TYPE_BNODE -> EncodedBNode(bnodeCoders[coderId], hash)
            AbstractCoder.MARKER_VALUE_TYPE_LANG_STRING -> EncodedLiteral(langStringCoders[coderId], hash)
            AbstractCoder.MARKER_VALUE_TYPE_LITERAL -> EncodedLiteral(literalCoders[coderId], hash)
            else -> throw IllegalStateException("Could find an appropriate coder!")
        }
    }

    override fun decode(spoc: Array<ByteBuffer>): Statement {
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

    override fun toStatementIteration(origin: SPOCIteration): CloseableIteration<Statement, SailException> {
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

    override fun toResourceIteration(origin: CloseableIteration<ByteBuffer, SailException>)
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

    override fun toNamespaceIteration(origin: CloseableIteration<Array<String>, SailException>)
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