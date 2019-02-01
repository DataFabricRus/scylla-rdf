package cc.datafabric.scyllardf.dao

import cc.datafabric.scyllardf.dao.Coder.CONTEXT_DEFAULT
import com.datastax.driver.core.BoundStatement
import com.datastax.driver.core.Cluster
import com.datastax.driver.core.PreparedStatement
import com.datastax.driver.core.ResultSet
import com.datastax.driver.core.ResultSetFuture
import com.datastax.driver.core.Session
import com.datastax.driver.core.policies.RoundRobinPolicy
import com.google.common.collect.Iterables
import com.google.common.util.concurrent.Futures
import com.google.common.util.concurrent.ListenableFuture
import org.eclipse.rdf4j.common.iteration.CloseableIteration
import org.eclipse.rdf4j.model.Resource
import org.eclipse.rdf4j.sail.SailException
import org.slf4j.LoggerFactory
import java.io.Closeable
import java.net.InetAddress

class ScyllaRDFDAO private constructor(private val cluster: Cluster, private val keyspace: String) : Closeable {

    companion object {
        private const val MAX_BATCH_SIZE = 65536

        private val LOG = LoggerFactory.getLogger(ScyllaRDFDAO::class.java)

        fun create(hosts: List<InetAddress>, port: Int, keyspace: String): ScyllaRDFDAO {
            val cluster = Cluster.builder()
                .addContactPoints(hosts)
                .withPort(port)
                .withLoadBalancingPolicy(RoundRobinPolicy())
                .build()

            val dao = ScyllaRDFDAO(cluster, keyspace)
            dao.init()

            return dao
        }
    }

    private lateinit var prepGetContextIds: PreparedStatement
    private lateinit var prepGetNamespaces: PreparedStatement
    private lateinit var prepGetNamespace: PreparedStatement
    private lateinit var prepSetNamespace: PreparedStatement
    private lateinit var prepClearNamespaces: PreparedStatement
    private lateinit var prepDeleteNamespace: PreparedStatement
    private lateinit var prepCountTotalTriples: PreparedStatement
    private lateinit var prepCountTriplesInGraphs: PreparedStatement

    private lateinit var prepSelect_SPOC_S: PreparedStatement
    private lateinit var prepSelect_SPOC_SP: PreparedStatement
    private lateinit var prepSelect_SPOC_SPO: PreparedStatement
    private lateinit var prepSelect_SPOC_ALL: PreparedStatement
    private lateinit var prepSelect_POSC_P: PreparedStatement
    private lateinit var prepSelect_POSC_PO: PreparedStatement
    private lateinit var prepSelect_OSPC_O: PreparedStatement
    private lateinit var prepSelect_OSPC_OS: PreparedStatement
    private lateinit var prepSelect_CSPO_CS: PreparedStatement
    private lateinit var prepSelect_CSPO_CSP: PreparedStatement
    private lateinit var prepSelect_CSPO_CSPO: PreparedStatement
    private lateinit var prepSelect_CSPO_C: PreparedStatement
    private lateinit var prepSelect_CPOS_CP: PreparedStatement
    private lateinit var prepSelect_CPOS_CPO: PreparedStatement
    private lateinit var prepSelect_COSP_CO: PreparedStatement
    private lateinit var prepSelect_COSP_COS: PreparedStatement

    private lateinit var prepInsertSPOC: PreparedStatement
    private lateinit var prepInsertPOSC: PreparedStatement
    private lateinit var prepInsertOSPC: PreparedStatement
    private lateinit var prepInsertCSPO: PreparedStatement
    private lateinit var prepInsertCPOS: PreparedStatement
    private lateinit var prepInsertCOSP: PreparedStatement

    private lateinit var prepDeleteSPOC: PreparedStatement
    private lateinit var prepDeletePOSC: PreparedStatement
    private lateinit var prepDeleteOSPC: PreparedStatement
    private lateinit var prepDeleteCSPO: PreparedStatement
    private lateinit var prepDeleteCPOS: PreparedStatement
    private lateinit var prepDeleteCOSP: PreparedStatement

    private lateinit var prepIncrementStatC: PreparedStatement
    private lateinit var prepIncrementStatS: PreparedStatement
    private lateinit var prepIncrementStatP: PreparedStatement
    private lateinit var prepIncrementStatO: PreparedStatement
    private lateinit var prepIncrementStatSP: PreparedStatement
    private lateinit var prepIncrementStatPO: PreparedStatement

    private lateinit var prepDecrementStatC: PreparedStatement
    private lateinit var prepDecrementStatS: PreparedStatement
    private lateinit var prepDecrementStatP: PreparedStatement
    private lateinit var prepDecrementStatO: PreparedStatement
    private lateinit var prepDecrementStatSP: PreparedStatement
    private lateinit var prepDecrementStatPO: PreparedStatement

    private val session: Session = cluster.connect()

    fun insertInSPOC(subj: ByteArray, pred: ByteArray, obj: ByteArray, context: ByteArray): ResultSetFuture {
        return session.executeAsync(setBytesUnsafe(prepInsertSPOC.bind(), subj, pred, obj, context))
    }

    fun insertInPOSC(subj: ByteArray, pred: ByteArray, obj: ByteArray, context: ByteArray): ResultSetFuture {
        return session.executeAsync(setBytesUnsafe(prepInsertPOSC.bind(), pred, obj, subj, context))
    }

    fun insertInOSPC(subj: ByteArray, pred: ByteArray, obj: ByteArray, context: ByteArray): ResultSetFuture {
        return session.executeAsync(setBytesUnsafe(prepInsertOSPC.bind(), obj, subj, pred, context))
    }

    fun insertInCSPO(subj: ByteArray, pred: ByteArray, obj: ByteArray, context: ByteArray): ResultSetFuture {
        return session.executeAsync(setBytesUnsafe(prepInsertCSPO.bind(), context, obj, subj, pred))
    }

    fun insertInCPOS(subj: ByteArray, pred: ByteArray, obj: ByteArray, context: ByteArray): ResultSetFuture {
        return session.executeAsync(setBytesUnsafe(prepInsertCPOS.bind(), context, obj, subj, pred))
    }

    fun insertInCOSP(subj: ByteArray, pred: ByteArray, obj: ByteArray, context: ByteArray): ResultSetFuture {
        return session.executeAsync(setBytesUnsafe(prepInsertCOSP.bind(), context, obj, subj, pred))
    }

    fun incrementStatistics(subj: ByteArray, pred: ByteArray, obj: ByteArray, context: ByteArray)
        : List<ResultSetFuture> {
        val futures = ArrayList<ResultSetFuture>(6)

        futures.add(session.executeAsync(setBytesUnsafe(prepIncrementStatC.bind(), context)))
        futures.add(session.executeAsync(setBytesUnsafe(prepIncrementStatS.bind(), subj)))
        futures.add(session.executeAsync(setBytesUnsafe(prepIncrementStatP.bind(), pred)))
        futures.add(session.executeAsync(setBytesUnsafe(prepIncrementStatO.bind(), obj)))
        futures.add(session.executeAsync(setBytesUnsafe(prepIncrementStatSP.bind(), subj, pred)))
        futures.add(session.executeAsync(setBytesUnsafe(prepIncrementStatPO.bind(), pred, obj)))

        return futures
    }

    fun countTotalTriples(): Long {
        /**
         * We have to aggregate on the client side, because of https://github.com/scylladb/scylla/issues/3174
         */

        return session.execute(prepCountTotalTriples.bind()).all()
            .parallelStream()
            .map { it.getLong(0) }
            .filter { it != null }
            .reduce { l: Long, r: Long -> l + r }
            .orElse(0)
    }

    fun countTriplesInGraphs(contextIDs: List<Resource>): Long {
        return session.execute(prepCountTriplesInGraphs.bind().setList(0, contextIDs.map { it.stringValue() }))
            .all().parallelStream()
            .map { it.getLong(0) }
            .filter { it != null }
            .reduce { l: Long, r: Long -> l + r }
            .orElseThrow { SailException("Couldn't count total number of triples!") }
    }

    fun getContextIDs(): CloseableIteration<ByteArray, SailException> {
        return TransformRowIteration(session.executeAsync(prepGetContextIds.bind()),
            { row -> row.getBytesUnsafe(0).array() },
            { value -> !value!!.contentEquals(Coder.CONTEXT_DEFAULT) })
    }

    fun getNamespaces(): CloseableIteration<Array<String>, SailException> {
        return TransformRowIteration(session.executeAsync(prepGetNamespaces.bind())) { row ->
            arrayOf(row.getString(0), row.getString(1))
        }
    }

    fun getNamespace(prefix: String): String? {
        val row = session.execute(prepGetNamespace.bind(prefix)).one()

        if (row != null) {
            return row.getString(1)
        }

        return null
    }

    fun setNamespace(prefix: String, name: String) {
        session.execute(prepSetNamespace.bind(name, prefix))
    }

    fun clearNamespaces() {
        session.execute(prepClearNamespaces.bind())
    }

    fun removeNamespace(prefix: String) {
        session.execute(prepDeleteNamespace.bind(prefix))
    }

    fun addStatement(subj: ByteArray, pred: ByteArray, obj: ByteArray) {
        addStatementInternal(subj, pred, obj, null).get()
    }

    fun addStatement(subj: ByteArray, pred: ByteArray, obj: ByteArray, contexts: List<ByteArray?>) {
        if (12 * contexts.size < MAX_BATCH_SIZE) {
            val batches = contexts
                .map { addStatementInternal(subj, pred, obj, it) }

            Futures.allAsList(batches).get()
        } else {
            // TODO: Should be fixed
            throw IllegalArgumentException("Too much contexts to add into!")
        }
    }

    fun removeStatements(subj: ByteArray, pred: ByteArray, obj: ByteArray, contexts: List<ByteArray?>) {
        val futures = mutableListOf<ResultSetFuture>()

        contexts.forEach {
            val c = it ?: CONTEXT_DEFAULT

            futures.add(session.executeAsync(setBytesUnsafe(prepDeleteSPOC.bind(), subj, pred, obj, c)))
            futures.add(session.executeAsync(setBytesUnsafe(prepDeletePOSC.bind(), pred, obj, subj, c)))
            futures.add(session.executeAsync(setBytesUnsafe(prepDeleteOSPC.bind(), obj, subj, pred, c)))

            if (it != null) {
                futures.add(session.executeAsync(setBytesUnsafe(prepDeleteCSPO.bind(), c, subj, pred, obj)))
                futures.add(session.executeAsync(setBytesUnsafe(prepDeleteCPOS.bind(), c, pred, obj, subj)))
                futures.add(session.executeAsync(setBytesUnsafe(prepDeleteCOSP.bind(), c, obj, subj, pred)))
            }

            futures.add(session.executeAsync(setBytesUnsafe(prepDecrementStatC.bind(), c)))
            futures.add(session.executeAsync(setBytesUnsafe(prepDecrementStatS.bind(), subj)))
            futures.add(session.executeAsync(setBytesUnsafe(prepDecrementStatP.bind(), pred)))
            futures.add(session.executeAsync(setBytesUnsafe(prepDecrementStatO.bind(), obj)))
            futures.add(session.executeAsync(setBytesUnsafe(prepDecrementStatSP.bind(), subj, pred)))
            futures.add(session.executeAsync(setBytesUnsafe(prepDecrementStatPO.bind(), pred, obj)))
        }

        Futures.allAsList(futures).get()
    }

    fun getStatements(subj: ByteArray?, pred: ByteArray?, obj: ByteArray?, context: ByteArray?): SPOCIteration {
        return SPOCIteration(ResultSetFutureIteration(querySPOC(subj, pred, obj, context)))
    }

    fun getStatements(subj: ByteArray?, pred: ByteArray?, obj: ByteArray?, contexts: List<ByteArray?>)
        : SPOCIteration {
        return SPOCIteration(MultipleResultSetFutureIteration(contexts.map {
            querySPOC(subj, pred, obj, it)
        }))
    }

    override fun close() {
        cluster.close()
    }

    private fun init() {
        val protocolVersion = cluster.configuration.protocolOptions.protocolVersion?.toInt()
        LOG.info("Scylla cluster supports {} protocol version", protocolVersion)

        session.execute("CREATE KEYSPACE IF NOT EXISTS $keyspace " +
            "WITH replication = { 'class': 'SimpleStrategy', 'replication_factor': 1 }")
        session.execute("USE $keyspace")

        createTables()

        prepareStatements()
    }

    private fun createTables() {
        val futures = mutableListOf<ResultSetFuture>()

        futures.add(session.executeAsync("CREATE TABLE IF NOT EXISTS ${ScyllaRDFSchema.Table.S_POC} (" +
            "subject blob, predicate blob, object blob, context blob, " +
            "PRIMARY KEY (subject, predicate, object, context))"))
        futures.add(session.executeAsync("CREATE TABLE IF NOT EXISTS ${ScyllaRDFSchema.Table.P_OSC} (" +
            "predicate blob, object blob, subject blob, context blob, " +
            "PRIMARY KEY (predicate, object, subject, context))"))
        futures.add(session.executeAsync("CREATE TABLE IF NOT EXISTS ${ScyllaRDFSchema.Table.O_SPC} (" +
            "object blob, subject blob, predicate blob, context blob, " +
            "PRIMARY KEY (object, subject, predicate, context))"))
        futures.add(session.executeAsync("CREATE TABLE IF NOT EXISTS ${ScyllaRDFSchema.Table.CS_PO} (" +
            "context blob, subject blob, predicate blob, object blob, " +
            "PRIMARY KEY ((context, subject), predicate, object))"))
        futures.add(session.executeAsync("CREATE TABLE IF NOT EXISTS ${ScyllaRDFSchema.Table.CP_OS} (" +
            "context blob, predicate blob, object blob, subject blob, " +
            "PRIMARY KEY ((context, predicate), object, subject))"))
        futures.add(session.executeAsync("CREATE TABLE IF NOT EXISTS ${ScyllaRDFSchema.Table.CO_SP} (" +
            "context blob, object blob, subject blob, predicate blob, " +
            "PRIMARY KEY ((context, object), subject, predicate))"))

        /**
         * Tables for statistics
         */
        futures.add(session.executeAsync("CREATE TABLE IF NOT EXISTS ${ScyllaRDFSchema.Table.STAT_C} " +
            "(id blob PRIMARY KEY, counter counter)"))
        futures.add(session.executeAsync("CREATE TABLE IF NOT EXISTS ${ScyllaRDFSchema.Table.STAT_S} " +
            "(id blob PRIMARY KEY, counter counter)"))
        futures.add(session.executeAsync("CREATE TABLE IF NOT EXISTS ${ScyllaRDFSchema.Table.STAT_P} " +
            "(id blob PRIMARY KEY, counter counter)"))
        futures.add(session.executeAsync("CREATE TABLE IF NOT EXISTS ${ScyllaRDFSchema.Table.STAT_O} " +
            "(id blob PRIMARY KEY, counter counter)"))
        futures.add(session.executeAsync("CREATE TABLE IF NOT EXISTS ${ScyllaRDFSchema.Table.STAT_SP} " +
            "(subject blob, predicate blob, counter counter, PRIMARY KEY ((subject, predicate)))"))
        futures.add(session.executeAsync("CREATE TABLE IF NOT EXISTS ${ScyllaRDFSchema.Table.STAT_PO} " +
            "(predicate blob, object blob, counter counter, PRIMARY KEY ((predicate, object)))"))

        /**
         * Table for namespaces
         */
        futures.add(session.executeAsync("CREATE TABLE IF NOT EXISTS ${ScyllaRDFSchema.Table.NS} " +
            "(prefix text, name text, PRIMARY KEY(prefix))"))

        Futures.allAsList(futures).get()
    }

    private fun prepareStatements() {
        // TODO: Do it in parallel
        prepGetContextIds = session.prepare("SELECT id FROM ${ScyllaRDFSchema.Table.STAT_C}")

        prepGetNamespaces = session.prepare("SELECT prefix, name FROM ${ScyllaRDFSchema.Table.NS}")
        prepGetNamespace = session.prepare("SELECT prefix, name FROM ${ScyllaRDFSchema.Table.NS} WHERE prefix = ?")
        prepSetNamespace = session.prepare("UPDATE ${ScyllaRDFSchema.Table.NS} SET name = ? WHERE prefix = ?")
        prepClearNamespaces = session.prepare("TRUNCATE TABLE ${ScyllaRDFSchema.Table.NS}")
        prepDeleteNamespace = session.prepare("DELETE name FROM ${ScyllaRDFSchema.Table.NS} WHERE prefix = ?")

        prepCountTotalTriples = session.prepare("SELECT counter FROM ${ScyllaRDFSchema.Table.STAT_C}")
        prepCountTriplesInGraphs = session.prepare(
            "SELECT counter FROM ${ScyllaRDFSchema.Table.STAT_C} WHERE id IN (?)")

        prepInsertSPOC = session.prepare(
            "INSERT INTO ${ScyllaRDFSchema.Table.S_POC} (subject, predicate, object, context) " +
                "VALUES (?, ?, ?, ?)")
        prepInsertPOSC = session.prepare(
            "INSERT INTO ${ScyllaRDFSchema.Table.P_OSC} (predicate, object, subject, context) " +
                "VALUES (?, ?, ?, ?)")
        prepInsertOSPC = session.prepare(
            "INSERT INTO ${ScyllaRDFSchema.Table.O_SPC} (object, subject, predicate, context) " +
                "VALUES (?, ?, ?, ?)")
        prepInsertCSPO = session.prepare(
            "INSERT INTO ${ScyllaRDFSchema.Table.S_POC} (context, subject, predicate, object) " +
                "VALUES (?, ?, ?, ?)")
        prepInsertCPOS = session.prepare(
            "INSERT INTO ${ScyllaRDFSchema.Table.P_OSC} (context, predicate, object, subject) " +
                "VALUES (?, ?, ?, ?)")
        prepInsertCOSP = session.prepare(
            "INSERT INTO ${ScyllaRDFSchema.Table.O_SPC} (context, object, subject, predicate) " +
                "VALUES (?, ?, ?, ?)")

        prepDeleteSPOC = session.prepare("DELETE FROM ${ScyllaRDFSchema.Table.S_POC} WHERE " +
            "subject = ? AND predicate = ? AND object = ? AND context = ?")
        prepDeletePOSC = session.prepare("DELETE FROM ${ScyllaRDFSchema.Table.P_OSC} WHERE " +
            "predicate = ? AND object = ? AND subject = ? AND context = ?")
        prepDeleteOSPC = session.prepare("DELETE FROM ${ScyllaRDFSchema.Table.O_SPC} WHERE " +
            "object = ? AND subject = ? AND predicate = ? AND context = ?")
        prepDeleteCSPO = session.prepare("DELETE FROM ${ScyllaRDFSchema.Table.CS_PO} WHERE " +
            "context = ? AND subject = ? AND predicate = ? AND object = ?")
        prepDeleteCPOS = session.prepare("DELETE FROM ${ScyllaRDFSchema.Table.CP_OS} WHERE " +
            "context = ? AND predicate = ? AND object = ? AND subject = ?")
        prepDeleteCOSP = session.prepare("DELETE FROM ${ScyllaRDFSchema.Table.CO_SP} WHERE " +
            "context = ? AND object = ? AND subject = ? AND predicate = ?")

        prepSelect_SPOC_S = session.prepare("SELECT subject, predicate, object, context " +
            "FROM ${ScyllaRDFSchema.Table.S_POC} " +
            "WHERE subject = ?")
        prepSelect_SPOC_SP = session.prepare("SELECT subject, predicate, object, context " +
            "FROM ${ScyllaRDFSchema.Table.S_POC} " +
            "WHERE subject = ? AND predicate = ?")
        prepSelect_SPOC_SPO = session.prepare("SELECT subject, predicate, object, context " +
            "FROM ${ScyllaRDFSchema.Table.S_POC} " +
            "WHERE subject = ? AND predicate = ? AND object = ?")
        prepSelect_SPOC_ALL = session.prepare("SELECT subject, predicate, object, context " +
            "FROM ${ScyllaRDFSchema.Table.S_POC}")
        prepSelect_POSC_PO = session.prepare("SELECT subject, predicate, object, context " +
            "FROM ${ScyllaRDFSchema.Table.P_OSC} " +
            "WHERE predicate = ? AND object = ?")
        prepSelect_POSC_P = session.prepare("SELECT subject, predicate, object, context " +
            "FROM ${ScyllaRDFSchema.Table.P_OSC} " +
            "WHERE predicate = ?")
        prepSelect_OSPC_OS = session.prepare("SELECT subject, predicate, object, context " +
            "FROM ${ScyllaRDFSchema.Table.O_SPC} " +
            "WHERE object = ? AND subject = ?")
        prepSelect_OSPC_O = session.prepare("SELECT subject, predicate, object, context " +
            "FROM ${ScyllaRDFSchema.Table.O_SPC} " +
            "WHERE object = ?")
        prepSelect_CSPO_CS = session.prepare("SELECT subject, predicate, object, context " +
            "FROM ${ScyllaRDFSchema.Table.CS_PO} " +
            "WHERE context = ? AND subject = ?")
        prepSelect_CSPO_CSP = session.prepare("SELECT subject, predicate, object, context " +
            "FROM ${ScyllaRDFSchema.Table.CS_PO} " +
            "WHERE context = ? AND subject = ? AND predicate = ?")
        prepSelect_CSPO_CSPO = session.prepare("SELECT subject, predicate, object, context " +
            "FROM ${ScyllaRDFSchema.Table.CS_PO} " +
            "WHERE context = ? AND subject = ? AND predicate = ? AND object = ?")
        prepSelect_CPOS_CP = session.prepare("SELECT subject, predicate, object, context " +
            "FROM ${ScyllaRDFSchema.Table.CP_OS} " +
            "WHERE context = ? AND predicate = ? AND object = ?")
        prepSelect_CPOS_CPO = session.prepare("SELECT subject, predicate, object, context " +
            "FROM ${ScyllaRDFSchema.Table.CP_OS} " +
            "WHERE context = ? AND predicate = ? AND object = ? AND subject = ?")
        prepSelect_COSP_CO = session.prepare("SELECT subject, predicate, object, context " +
            "FROM ${ScyllaRDFSchema.Table.CO_SP} " +
            "WHERE context = ? AND object = ? AND subject = ? AND predicate = ?")
        prepSelect_COSP_COS = session.prepare("SELECT subject, predicate, object, context " +
            "FROM ${ScyllaRDFSchema.Table.CO_SP} " +
            "WHERE context = ? AND object = ? AND subject = ?")
        prepSelect_CSPO_C = session.prepare("SELECT subject, predicate, object, context " +
            "FROM ${ScyllaRDFSchema.Table.CS_PO} WHERE context = ? ALLOW FILTERING")

        prepIncrementStatC = session.prepare("UPDATE ${ScyllaRDFSchema.Table.STAT_C} " +
            "SET counter = counter + 1 WHERE id = ?")
        prepIncrementStatS = session.prepare("UPDATE ${ScyllaRDFSchema.Table.STAT_S} " +
            "SET counter = counter + 1 WHERE id = ?")
        prepIncrementStatP = session.prepare("UPDATE ${ScyllaRDFSchema.Table.STAT_P} " +
            "SET counter = counter + 1 WHERE id = ?")
        prepIncrementStatO = session.prepare("UPDATE ${ScyllaRDFSchema.Table.STAT_O} " +
            "SET counter = counter + 1 WHERE id = ?")
        prepIncrementStatSP = session.prepare("UPDATE ${ScyllaRDFSchema.Table.STAT_SP} " +
            "SET counter = counter + 1 WHERE subject = ? AND predicate = ?")
        prepIncrementStatPO = session.prepare("UPDATE ${ScyllaRDFSchema.Table.STAT_PO} " +
            "SET counter = counter + 1 WHERE predicate = ? AND object = ?")

        prepDecrementStatC = session.prepare("UPDATE ${ScyllaRDFSchema.Table.STAT_C} " +
            "SET counter = counter - 1 WHERE id = ?")
        prepDecrementStatS = session.prepare("UPDATE ${ScyllaRDFSchema.Table.STAT_S} " +
            "SET counter = counter - 1 WHERE id = ?")
        prepDecrementStatP = session.prepare("UPDATE ${ScyllaRDFSchema.Table.STAT_P} " +
            "SET counter = counter - 1 WHERE id = ?")
        prepDecrementStatO = session.prepare("UPDATE ${ScyllaRDFSchema.Table.STAT_O} " +
            "SET counter = counter - 1 WHERE id = ?")
        prepDecrementStatSP = session.prepare("UPDATE ${ScyllaRDFSchema.Table.STAT_SP} " +
            "SET counter = counter - 1 WHERE subject = ? AND predicate = ?")
        prepDecrementStatPO = session.prepare("UPDATE ${ScyllaRDFSchema.Table.STAT_PO} " +
            "SET counter = counter - 1 WHERE predicate = ? AND object = ?")
    }

    private fun querySPOC(subj: ByteArray?, pred: ByteArray?, obj: ByteArray?, context: ByteArray?)
        : ResultSetFuture {
        val c = context ?: CONTEXT_DEFAULT

        LOG.debug("s: {}, p: {}, o: {}, c: {}", subj != null, pred != null, obj != null, context != null)

        return if (context == null) {
            if (subj == null) {
                if (pred == null) {
                    if (obj == null) {
                        session.executeAsync(prepSelect_SPOC_ALL.bind())
                    } else {
                        session.executeAsync(setBytesUnsafe(prepSelect_OSPC_O.bind(), obj))
                    }
                } else {
                    if (obj == null) {
                        session.executeAsync(setBytesUnsafe(prepSelect_POSC_P.bind(), pred))
                    } else {
                        session.executeAsync(setBytesUnsafe(prepSelect_POSC_PO.bind(), pred, obj))
                    }
                }
            } else {
                if (pred == null) {
                    if (obj == null) {
                        session.executeAsync(setBytesUnsafe(prepSelect_SPOC_S.bind(), subj))
                    } else {
                        session.executeAsync(setBytesUnsafe(prepSelect_OSPC_OS.bind(), obj, subj))
                    }
                } else {
                    if (obj == null) {
                        session.executeAsync(setBytesUnsafe(prepSelect_SPOC_SP.bind(), subj, pred))
                    } else {
                        session.executeAsync(setBytesUnsafe(prepSelect_SPOC_SPO.bind(), subj, pred, obj))
                    }
                }
            }
        } else {
            if (subj == null) {
                if (pred == null) {
                    if (obj == null) {
                        session.executeAsync(setBytesUnsafe(prepSelect_CSPO_C.bind(), c))
                    } else {
                        session.executeAsync(setBytesUnsafe(prepSelect_COSP_CO.bind(), c, obj))
                    }
                } else {
                    if (obj == null) {
                        session.executeAsync(setBytesUnsafe(prepSelect_CPOS_CP.bind(), c, pred))
                    } else {
                        session.executeAsync(setBytesUnsafe(prepSelect_CPOS_CPO.bind(), c, pred, obj))
                    }
                }
            } else {
                if (pred == null) {
                    if (obj == null) {
                        session.executeAsync(setBytesUnsafe(prepSelect_CSPO_CS.bind(), c, subj))
                    } else {
                        session.executeAsync(setBytesUnsafe(prepSelect_COSP_COS.bind(), c, obj, subj))
                    }
                } else {
                    if (obj == null) {
                        session.executeAsync(setBytesUnsafe(prepSelect_CSPO_CSP.bind(), c, subj, pred))
                    } else {
                        session.executeAsync(setBytesUnsafe(prepSelect_CSPO_CSPO.bind(), c, subj, pred, obj))
                    }
                }
            }
        }
    }

    private fun addStatementInternal(subj: ByteArray, pred: ByteArray, obj: ByteArray, context: ByteArray?)
        : ListenableFuture<List<ResultSet>> {
        val indexes = ArrayList<ResultSetFuture>(3)
        indexes.add(insertInSPOC(subj, pred, obj, CONTEXT_DEFAULT))
        indexes.add(insertInPOSC(subj, pred, obj, CONTEXT_DEFAULT))
        indexes.add(insertInOSPC(subj, pred, obj, CONTEXT_DEFAULT))

        if (context != null) {
            indexes.add(insertInCSPO(subj, pred, obj, context))
            indexes.add(insertInCPOS(subj, pred, obj, context))
            indexes.add(insertInCOSP(subj, pred, obj, context))
        }

        val stats = incrementStatistics(subj, pred, obj, context ?: CONTEXT_DEFAULT)

        return Futures.allAsList(Iterables.concat(indexes, stats))
    }

    private fun setBytesUnsafe(bound: BoundStatement, vararg array: ByteArray): BoundStatement {
        array.forEachIndexed { index, it ->
            bound.setBytesUnsafe(index, Coder.toByteBuffer(it))
        }

        return bound
    }

}