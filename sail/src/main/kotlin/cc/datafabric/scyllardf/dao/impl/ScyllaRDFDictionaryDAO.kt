package cc.datafabric.scyllardf.dao.impl

import cc.datafabric.scyllardf.dao.IDictionaryDAO
import cc.datafabric.scyllardf.dao.ScyllaRDFSchema
import com.datastax.driver.core.PreparedStatement
import com.datastax.driver.core.ResultSetFuture
import com.datastax.driver.core.Session
import com.google.common.util.concurrent.Futures
import org.eclipse.rdf4j.model.IRI
import org.eclipse.rdf4j.model.impl.SimpleValueFactory
import java.nio.ByteBuffer
import java.util.stream.Collectors

internal class ScyllaRDFDictionaryDAO(private val session: Session) : IDictionaryDAO {

    companion object {
        private const val MAX_CONCURRENT_ASYNC_QUERIES = 100
    }

    private lateinit var prepInsertKnownVocabulariesDictionary: PreparedStatement

    internal fun createTables() {
        session.execute("CREATE TABLE IF NOT EXISTS ${ScyllaRDFSchema.Table.CODER_KNOWN_VOCABULARIES} " +
            "(key text, value blob, PRIMARY KEY(key))")
    }

    internal fun prepareStatements() {
        prepInsertKnownVocabulariesDictionary = session.prepare(
            "INSERT INTO ${ScyllaRDFSchema.Table.CODER_KNOWN_VOCABULARIES} (key, value) VALUES (?, ?)")
    }

    override fun loadKnownVocabulariesDictionary(): Map<IRI, ByteBuffer> {
        val valueFactory = SimpleValueFactory.getInstance()
        return session.execute("SELECT key, value FROM ${ScyllaRDFSchema.Table.CODER_KNOWN_VOCABULARIES}")
            .all()
            .stream()
            .map { row ->
                Pair(valueFactory.createIRI(row.getString(0)), row.getBytesUnsafe(1))
            }
            .collect(Collectors.toMap({ it.first }, { it.second }))
    }

    override fun saveKnownVocabulariesDictionary(dictionary: Map<IRI, ByteBuffer>) {
        var batch = mutableListOf<ResultSetFuture>()
        dictionary.forEach { key, value ->
            batch.add(session.executeAsync(prepInsertKnownVocabulariesDictionary.bind()
                .setString(0, key.stringValue())
                .setBytesUnsafe(1, value)
            ))

            if (batch.size > MAX_CONCURRENT_ASYNC_QUERIES) {
                Futures.allAsList(batch).get()

                batch = mutableListOf<ResultSetFuture>()
            }
        }
    }

}