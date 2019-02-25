package cc.datafabric.scyllardf.dao.impl

import cc.datafabric.scyllardf.dao.ICardinalityDAO
import cc.datafabric.scyllardf.dao.ScyllaRDFSchema
import com.datastax.driver.core.PreparedStatement
import com.datastax.driver.core.ResultSetFuture
import com.datastax.driver.core.Session
import com.google.common.hash.HashCode
import com.google.common.hash.Hashing
import java.nio.ByteBuffer

internal class ScyllaRDFCardinalityDAO(private val session: Session) : AbstractScyllaRDFDAO(), ICardinalityDAO {

    private lateinit var prepQueryCardC: PreparedStatement
    private lateinit var prepQueryCardS: PreparedStatement
    private lateinit var prepQueryCardP: PreparedStatement
    private lateinit var prepQueryCardO: PreparedStatement
    private lateinit var prepQueryCardPO: PreparedStatement

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
        prepQueryCardC = session.prepare("SELECT counter FROM ${ScyllaRDFSchema.Table.CARD_C} WHERE id IN (?)")
        prepQueryCardS = session.prepare("SELECT SUM(partitions_count) FROM system.size_estimates " +
            "WHERE keyspace_name = '${session.loggedKeyspace}' AND table_name = '${ScyllaRDFSchema.Table.S_POC}'")
        prepQueryCardP = session.prepare("SELECT counter FROM ${ScyllaRDFSchema.Table.CARD_P} WHERE id = ?")
        prepQueryCardO = session.prepare("SELECT SUM(partitions_count) FROM system.size_estimates " +
            "WHERE keyspace_name = '${session.loggedKeyspace}' AND table_name = '${ScyllaRDFSchema.Table.O_SPC}'")
        prepQueryCardPO = session.prepare("SELECT counter FROM ${ScyllaRDFSchema.Table.CARD_PO} " +
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

    /**
     * TODO
     */
    override fun withCache(): ICardinalityDAO {
        return this
    }

    override fun numTriples(): Long {
        val row = session.execute(prepQueryCardC.bind(ScyllaRDFSchema.CONTEXT_DEFAULT))
            .one()

        return row?.getLong(0) ?: 0L
    }

    override fun contextCardinality(context: ByteBuffer?): Long {
        val c = context ?: ScyllaRDFSchema.CONTEXT_DEFAULT

        return session.execute(prepQueryCardC.bind(c))
            .one()
            .getLong(0)
    }

    override fun subjectCardinality(subj: ByteBuffer): Long {
        val row = session.execute(prepQueryCardS.bind()).one()

        return row?.getLong(0) ?: 0L
    }

    override fun predicateCardinality(pred: ByteBuffer): Long {
        return session.execute(prepQueryCardP.bind(pred)).one().getLong(0)
    }

    override fun objectCardinality(obj: ByteBuffer): Long {
        val row = session.execute(prepQueryCardO.bind()).one()

        return row?.getLong(0) ?: 0L
    }

    override fun objectAndPredicateCardinality(pred: ByteBuffer, obj: ByteBuffer): Long {
        val bucket = objectToBucketNumber(obj)

        return session.execute(prepQueryCardPO.bind()
            .setBytesUnsafe(0, pred)
            .setInt(1, bucket)
        ).one().getLong(0)
    }

    override fun incrementCardC(context: ByteBuffer, add: Long): ResultSetFuture {
        return session.executeAsync(prepIncCardC.bind()
            .setLong(0, add)
            .setBytesUnsafe(1, context)
        )
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

        futures.add(incrementCardC(context ?: ScyllaRDFSchema.CONTEXT_DEFAULT, 1))
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

    private fun objectToBucketNumber(obj: ByteBuffer): Int {
        return Hashing.consistentHash(HashCode.fromInt(obj.hashCode()), ScyllaRDFSchema.CARD_PO_NUM_BUCKETS)
    }
}