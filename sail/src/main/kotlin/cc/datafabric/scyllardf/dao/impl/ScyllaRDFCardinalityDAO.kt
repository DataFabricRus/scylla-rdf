package cc.datafabric.scyllardf.dao.impl

import cc.datafabric.scyllardf.dao.ICardinalityDAO
import cc.datafabric.scyllardf.dao.ScyllaRDFSchema
import com.datastax.driver.core.PreparedStatement
import com.datastax.driver.core.ResultSetFuture
import com.datastax.driver.core.Session
import com.google.common.base.Function
import com.google.common.cache.CacheBuilder
import com.google.common.cache.CacheLoader
import com.google.common.hash.HashCode
import com.google.common.hash.Hashing
import com.google.common.primitives.Bytes
import java.nio.ByteBuffer
import java.util.concurrent.TimeUnit

/**
 * @see <a href="https://github.com/DataFabricRus/scylla-rdf/issues/1">ISSUE-1</a>
 */
internal class ScyllaRDFCardinalityDAO(private val session: Session) : AbstractScyllaRDFDAO(), ICardinalityDAO {

    private lateinit var selectCardC: PreparedStatement
    private lateinit var selectCardS: PreparedStatement
    private lateinit var selectCardP: PreparedStatement
    private lateinit var selectCardO: PreparedStatement
    private lateinit var selectCardPO: PreparedStatement

    private lateinit var prepIncCardC: PreparedStatement
    private lateinit var prepIncCardP: PreparedStatement
    private lateinit var prepIncCardPO: PreparedStatement

    private lateinit var prepDecCardC: PreparedStatement
    private lateinit var prepDecCardP: PreparedStatement
    private lateinit var prepDecCardPO: PreparedStatement

    internal fun createTables() {
        session.execute("CREATE TABLE IF NOT EXISTS ${ScyllaRDFSchema.Table.CARD_C} " +
                "(id blob PRIMARY KEY, counter counter)")
        session.execute("CREATE TABLE IF NOT EXISTS ${ScyllaRDFSchema.Table.CARD_P} " +
                "(id blob PRIMARY KEY, counter counter)")
        session.execute("CREATE TABLE IF NOT EXISTS ${ScyllaRDFSchema.Table.CARD_PO} (" +
                "predicate blob, bucket int, counter counter, " +
                "PRIMARY KEY (predicate, bucket))")
    }

    internal fun prepareStatements() {
        selectCardC = session.prepare("SELECT counter FROM ${ScyllaRDFSchema.Table.CARD_C} WHERE id IN (?)")
        selectCardS = session.prepare("SELECT SUM(partitions_count) FROM system.size_estimates " +
                "WHERE keyspace_name = '${session.loggedKeyspace}' AND table_name = '${ScyllaRDFSchema.Table.S_POC}'")
        selectCardP = session.prepare("SELECT counter FROM ${ScyllaRDFSchema.Table.CARD_P} WHERE id = ?")
        selectCardO = session.prepare("SELECT SUM(partitions_count) FROM system.size_estimates " +
                "WHERE keyspace_name = '${session.loggedKeyspace}' AND table_name = '${ScyllaRDFSchema.Table.O_SPC}'")
        selectCardPO = session.prepare("SELECT counter FROM ${ScyllaRDFSchema.Table.CARD_PO} " +
                "WHERE predicate = ? AND bucket = ?")

        prepIncCardC = session.prepare("UPDATE ${ScyllaRDFSchema.Table.CARD_C} " +
                "SET counter = counter + ? WHERE id = ?")
        prepIncCardP = session.prepare("UPDATE ${ScyllaRDFSchema.Table.CARD_P} " +
                "SET counter = counter + ? WHERE id = ?")
        prepIncCardPO = session.prepare("UPDATE ${ScyllaRDFSchema.Table.CARD_PO} " +
                "SET counter = counter + ? WHERE predicate = ? AND bucket = ?")

        prepDecCardC = session.prepare("UPDATE ${ScyllaRDFSchema.Table.CARD_C} " +
                "SET counter = counter - ? WHERE id = ?")
        prepDecCardP = session.prepare("UPDATE ${ScyllaRDFSchema.Table.CARD_P} " +
                "SET counter = counter - ? WHERE id = ?")
        prepDecCardPO = session.prepare("UPDATE ${ScyllaRDFSchema.Table.CARD_PO} " +
                "SET counter = counter - ? WHERE predicate = ? AND bucket = ?")
    }

    override fun withCache(): ICardinalityDAO {
        return CachedCardinalityDAO(this)
    }

    override fun numTriples(): Long {
        val row = session.execute(selectCardC.bind(ScyllaRDFSchema.CONTEXT_DEFAULT))
                .one()

        return row?.getLong(0) ?: 0L
    }

    override fun contextCardinality(context: ByteBuffer?): Long {
        val c = context ?: ScyllaRDFSchema.CONTEXT_DEFAULT

        val row = session.execute(selectCardC.bind(c)).one()

        return row?.getLong(0) ?: 0L
    }

    override fun subjectCardinality(subj: ByteBuffer): Long {
        val row = session.execute(selectCardS.bind()).one()

        return row?.getLong(0) ?: 0L
    }

    override fun predicateCardinality(pred: ByteBuffer): Long {
        val row = session.execute(selectCardP.bind(pred)).one()

        return row?.getLong(0) ?: 0L
    }

    override fun objectCardinality(obj: ByteBuffer): Long {
        val row = session.execute(selectCardO.bind()).one()

        return row?.getLong(0) ?: 0L
    }

    override fun objectAndPredicateCardinality(pred: ByteBuffer, obj: ByteBuffer): Long {
        val bucket = objectToBucketNumber(obj)

        val row = session.execute(selectCardPO.bind().setBytesUnsafe(0, pred).setInt(1, bucket)).one()

        return row?.getLong(0) ?: 0L
    }

    override fun incrementCardC(context: ByteBuffer, add: Long): List<ResultSetFuture> {
        val futures = mutableListOf<ResultSetFuture>()
        if (context != ScyllaRDFSchema.CONTEXT_DEFAULT) {
            futures.add(session.executeAsync(prepIncCardC.bind()
                    .setLong(0, add)
                    .setBytesUnsafe(1, ScyllaRDFSchema.CONTEXT_DEFAULT)
            ))
        }
        futures.add(session.executeAsync(prepIncCardC.bind()
                .setLong(0, add)
                .setBytesUnsafe(1, context)
        ))

        return futures
    }

    override fun incrementCardP(pred: ByteBuffer, add: Long): ResultSetFuture {
        return session.executeAsync(prepIncCardP.bind()
                .setLong(0, add)
                .setBytesUnsafe(1, pred)
        )
    }

    override fun incrementCardPO(pred: ByteBuffer, obj: ByteBuffer, add: Long): ResultSetFuture {
        val bucket = objectToBucketNumber(obj)

        return session.executeAsync(prepIncCardPO.bind()
                .setLong(0, add)
                .setBytesUnsafe(1, pred)
                .setInt(2, bucket)
        )
    }

    override fun incrementCards(subj: ByteBuffer, pred: ByteBuffer, obj: ByteBuffer, context: ByteBuffer?)
            : List<ResultSetFuture> {
        val futures = ArrayList<ResultSetFuture>(3)

        futures.addAll(incrementCardC(context ?: ScyllaRDFSchema.CONTEXT_DEFAULT, 1))
        futures.add(incrementCardP(pred, 1))
        futures.add(incrementCardPO(pred, obj, 1))

        return futures
    }

    override fun incrementCards(subj: ByteBuffer, pred: ByteBuffer, obj: ByteBuffer, contexts: List<ByteBuffer?>)
            : List<ResultSetFuture> {
        val futures = mutableListOf<ResultSetFuture>()

        contexts
                .map { incrementCards(subj, pred, obj, it) }
                .forEach { futures.addAll(it) }

        return futures
    }

    private fun decrementCardC(context: ByteBuffer, add: Long): ResultSetFuture {
        return session.executeAsync(prepDecCardC.bind()
                .setLong(0, add)
                .setBytesUnsafe(1, context)
        )
    }

    private fun decrementCardP(pred: ByteBuffer, add: Long): ResultSetFuture {
        return session.executeAsync(prepDecCardP.bind()
                .setLong(0, add)
                .setBytesUnsafe(1, pred)
        )
    }

    private fun decrementCardPO(pred: ByteBuffer, obj: ByteBuffer, add: Long): ResultSetFuture {
        val bucket = objectToBucketNumber(obj)

        return session.executeAsync(prepDecCardPO.bind()
                .setLong(0, add)
                .setBytesUnsafe(1, pred)
                .setInt(2, bucket)
        )
    }

    override fun decrementCards(subj: ByteBuffer, pred: ByteBuffer, obj: ByteBuffer, context: ByteBuffer?): List<ResultSetFuture> {
        val futures = ArrayList<ResultSetFuture>(3)

        futures.add(decrementCardC(context ?: ScyllaRDFSchema.CONTEXT_DEFAULT, 1))
        futures.add(decrementCardP(pred, 1))
        futures.add(decrementCardPO(pred, obj, 1))

        return futures
    }

    override fun decrementCards(subj: ByteBuffer, pred: ByteBuffer, obj: ByteBuffer, contexts: List<ByteBuffer?>): List<ResultSetFuture> {
        val futures = mutableListOf<ResultSetFuture>()

        contexts
                .map { decrementCards(subj, pred, obj, it) }
                .forEach { futures.addAll(it) }

        return futures
    }

    override fun clearContext(context: ByteBuffer?) {
        if (context == null || context == ScyllaRDFSchema.CONTEXT_DEFAULT) {
            waitUntilDone(
                    session.executeAsync("TRUNCATE TABLE ${ScyllaRDFSchema.Table.CARD_C}"),
                    session.executeAsync("TRUNCATE TABLE ${ScyllaRDFSchema.Table.CARD_P}"),
                    session.executeAsync("TRUNCATE TABLE ${ScyllaRDFSchema.Table.CARD_PO}")
            )
        } else {
            session.execute("DELETE FROM ${ScyllaRDFSchema.Table.CARD_C} WHERE id = ?", context)
        }
    }

    private fun objectToBucketNumber(obj: ByteBuffer): Int {
        return Hashing.consistentHash(HashCode.fromInt(obj.hashCode()), ScyllaRDFSchema.CARD_PO_NUM_BUCKETS)
    }

    private class CachedCardinalityDAO(private val wrapped: ScyllaRDFCardinalityDAO) : ICardinalityDAO {

        companion object {
            private const val SCYLLA_ESTIMATOR_CARD_S = 0
            private const val SCYLLA_ESTIMATOR_CARD_O = 1
            private const val INDEX_NUM_TRIPLES = 2
        }

        private val nonEvictingCache = CacheBuilder
                .newBuilder()
                .initialCapacity(3)
                .refreshAfterWrite(60, TimeUnit.SECONDS)
                .build<Int, Long>(CacheLoader.from(scyllaEstimatesCacheLoader()))
        private val evictingCache = CacheBuilder
                .newBuilder()
                .maximumSize(1000)
                .expireAfterAccess(5, TimeUnit.MINUTES)
                .build<ByteBuffer, Long>()

        override fun withCache(): ICardinalityDAO {
            throw IllegalStateException("Can't create the cached version of cached version!")
        }

        override fun numTriples(): Long {
            return nonEvictingCache.get(INDEX_NUM_TRIPLES)
        }

        override fun contextCardinality(context: ByteBuffer?): Long {
            return evictingCache.get(context ?: ScyllaRDFSchema.CONTEXT_DEFAULT) {
                wrapped.contextCardinality(context)
            }
        }

        override fun subjectCardinality(subj: ByteBuffer): Long {
            return nonEvictingCache.get(SCYLLA_ESTIMATOR_CARD_S)
        }

        override fun predicateCardinality(pred: ByteBuffer): Long {
            return evictingCache.get(pred) { wrapped.predicateCardinality(pred) }
        }

        override fun objectCardinality(obj: ByteBuffer): Long {
            return nonEvictingCache.get(SCYLLA_ESTIMATOR_CARD_O)
        }

        override fun objectAndPredicateCardinality(pred: ByteBuffer, obj: ByteBuffer): Long {
            return evictingCache.get(ByteBuffer.wrap(Bytes.concat(pred.array(), obj.array()))) {
                wrapped.objectAndPredicateCardinality(pred, obj)
            }
        }

        override fun incrementCardC(context: ByteBuffer, add: Long): List<ResultSetFuture> {
            return wrapped.incrementCardC(context, add)
        }

        override fun incrementCardP(pred: ByteBuffer, add: Long): ResultSetFuture {
            return wrapped.incrementCardP(pred, add)
        }

        override fun incrementCardPO(pred: ByteBuffer, obj: ByteBuffer, add: Long): ResultSetFuture {
            return wrapped.incrementCardPO(pred, obj, add)
        }

        override fun incrementCards(subj: ByteBuffer, pred: ByteBuffer, obj: ByteBuffer, context: ByteBuffer?): List<ResultSetFuture> {
            return wrapped.incrementCards(subj, pred, obj, context)
        }

        override fun incrementCards(subj: ByteBuffer, pred: ByteBuffer, obj: ByteBuffer, contexts: List<ByteBuffer?>): List<ResultSetFuture> {
            return wrapped.incrementCards(subj, pred, obj, contexts)
        }

        override fun decrementCards(subj: ByteBuffer, pred: ByteBuffer, obj: ByteBuffer, context: ByteBuffer?): List<ResultSetFuture> {
            return wrapped.decrementCards(subj, pred, obj, context)
        }

        override fun decrementCards(subj: ByteBuffer, pred: ByteBuffer, obj: ByteBuffer, contexts: List<ByteBuffer?>): List<ResultSetFuture> {
            return wrapped.decrementCards(subj, pred, obj, contexts)
        }

        override fun clearContext(context: ByteBuffer?) {
            wrapped.clearContext(context)
        }

        private fun scyllaEstimatesCacheLoader(): Function<Int, Long> {
            return Function {
                when (it) {
                    SCYLLA_ESTIMATOR_CARD_S -> wrapped.subjectCardinality(ByteBuffer.allocate(0))
                    SCYLLA_ESTIMATOR_CARD_O -> wrapped.objectCardinality(ByteBuffer.allocate(0))
                    INDEX_NUM_TRIPLES -> wrapped.numTriples()
                    else -> throw IllegalArgumentException()
                }
            }
        }
    }
}