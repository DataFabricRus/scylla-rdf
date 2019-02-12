package cc.datafabric.scyllardf.dao

import com.datastax.driver.core.BoundStatement
import com.datastax.driver.core.Cluster
import com.datastax.driver.core.ConsistencyLevel
import com.datastax.driver.core.PreparedStatement
import com.datastax.driver.core.QueryOptions
import com.datastax.driver.core.ResultSet
import com.datastax.driver.core.ResultSetFuture
import com.datastax.driver.core.Session
import com.datastax.driver.core.policies.RoundRobinPolicy
import com.google.common.collect.Iterables
import com.google.common.util.concurrent.Futures
import com.google.common.util.concurrent.ListenableFuture
import org.eclipse.rdf4j.common.iteration.CloseableIteration
import org.eclipse.rdf4j.model.IRI
import org.eclipse.rdf4j.model.Resource
import org.eclipse.rdf4j.model.impl.SimpleValueFactory
import org.eclipse.rdf4j.sail.SailException
import org.slf4j.LoggerFactory
import java.io.Closeable
import java.net.InetAddress
import java.nio.ByteBuffer
import java.util.stream.Collectors

class ScyllaRDFDAO private constructor(
    private val cluster: Cluster, private val keyspace: String
) : ICardinalityDAO, Closeable {

    companion object {
        private const val MAX_BATCH_SIZE = 65536
        private const val MAX_CONCURRENT_ASYNC_QUERIES = 100

        private val LOG = LoggerFactory.getLogger(ScyllaRDFDAO::class.java)

        fun create(hosts: List<InetAddress>, port: Int, keyspace: String): ScyllaRDFDAO {
            val cluster = Cluster.builder()
                .addContactPoints(hosts)
                .withPort(port)
                .withLoadBalancingPolicy(RoundRobinPolicy())
                .withQueryOptions(QueryOptions().setConsistencyLevel(ConsistencyLevel.ONE))
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

    private lateinit var prepSelectStatS: PreparedStatement
    private lateinit var prepSelectStatP: PreparedStatement
    private lateinit var prepSelectStatO: PreparedStatement
    private lateinit var prepSelectStatSP: PreparedStatement
    private lateinit var prepSelectStatPO: PreparedStatement
    private lateinit var prepSelectStatSO: PreparedStatement

    private lateinit var prepIncrementStatC: PreparedStatement
    private lateinit var prepIncrementStatS: PreparedStatement
    private lateinit var prepIncrementStatP: PreparedStatement
    private lateinit var prepIncrementStatO: PreparedStatement
    private lateinit var prepIncrementStatSP: PreparedStatement
    private lateinit var prepIncrementStatPO: PreparedStatement
    private lateinit var prepIncrementStatSO: PreparedStatement

    private lateinit var prepIncrementStatCBy: PreparedStatement
    private lateinit var prepIncrementStatSBy: PreparedStatement
    private lateinit var prepIncrementStatPBy: PreparedStatement
    private lateinit var prepIncrementStatOBy: PreparedStatement
    private lateinit var prepIncrementStatSPBy: PreparedStatement
    private lateinit var prepIncrementStatPOBy: PreparedStatement
    private lateinit var prepIncrementStatSOBy: PreparedStatement

    private lateinit var prepDecrementStatC: PreparedStatement
    private lateinit var prepDecrementStatS: PreparedStatement
    private lateinit var prepDecrementStatP: PreparedStatement
    private lateinit var prepDecrementStatO: PreparedStatement
    private lateinit var prepDecrementStatSP: PreparedStatement
    private lateinit var prepDecrementStatPO: PreparedStatement
    private lateinit var prepDecrementStatSO: PreparedStatement

    private lateinit var prepInsertKnownVocabulariesDictionary: PreparedStatement

    private val session: Session = cluster.connect()

    fun insertInSPOC(subj: ByteBuffer, pred: ByteBuffer, obj: ByteBuffer, context: ByteBuffer): ResultSetFuture {
        return session.executeAsync(setBytesUnsafe(prepInsertSPOC.bind(), subj, pred, obj, context))
    }

    fun insertInPOSC(subj: ByteBuffer, pred: ByteBuffer, obj: ByteBuffer, context: ByteBuffer): ResultSetFuture {
        return session.executeAsync(setBytesUnsafe(prepInsertPOSC.bind(), pred, obj, subj, context))
    }

    fun insertInOSPC(subj: ByteBuffer, pred: ByteBuffer, obj: ByteBuffer, context: ByteBuffer): ResultSetFuture {
        return session.executeAsync(setBytesUnsafe(prepInsertOSPC.bind(), obj, subj, pred, context))
    }

    fun insertInCSPO(subj: ByteBuffer, pred: ByteBuffer, obj: ByteBuffer, context: ByteBuffer): ResultSetFuture {
        return session.executeAsync(setBytesUnsafe(prepInsertCSPO.bind(), context, obj, subj, pred))
    }

    fun insertInCPOS(subj: ByteBuffer, pred: ByteBuffer, obj: ByteBuffer, context: ByteBuffer): ResultSetFuture {
        return session.executeAsync(setBytesUnsafe(prepInsertCPOS.bind(), context, obj, subj, pred))
    }

    fun insertInCOSP(subj: ByteBuffer, pred: ByteBuffer, obj: ByteBuffer, context: ByteBuffer): ResultSetFuture {
        return session.executeAsync(setBytesUnsafe(prepInsertCOSP.bind(), context, obj, subj, pred))
    }

    fun incrementStatCBy(context: ByteBuffer, add: Long): ResultSetFuture {
        return session.executeAsync(prepIncrementStatCBy.bind()
            .setLong(0, add)
            .setBytesUnsafe(1, context)
        )
    }

    fun incrementStatSBy(subj: ByteBuffer, add: Long): ResultSetFuture {
        return session.executeAsync(prepIncrementStatSBy.bind()
            .setLong(0, add)
            .setBytesUnsafe(1, subj)
        )
    }

    fun incrementStatPBy(pred: ByteBuffer, add: Long): ResultSetFuture {
        return session.executeAsync(prepIncrementStatPBy.bind()
            .setLong(0, add)
            .setBytesUnsafe(1, pred)
        )
    }

    fun incrementStatOBy(obj: ByteBuffer, add: Long): ResultSetFuture {
        return session.executeAsync(prepIncrementStatOBy.bind()
            .setLong(0, add)
            .setBytesUnsafe(1, obj)
        )
    }

    fun incrementStatSPBy(subj: ByteBuffer, pred: ByteBuffer, add: Long): ResultSetFuture {
        return session.executeAsync(prepIncrementStatSPBy.bind()
            .setLong(0, add)
            .setBytesUnsafe(1, subj)
            .setBytesUnsafe(2, pred)
        )
    }

    fun incrementStatPOBy(pred: ByteBuffer, obj: ByteBuffer, add: Long): ResultSetFuture {
        return session.executeAsync(prepIncrementStatPOBy.bind()
            .setLong(0, add)
            .setBytesUnsafe(1, pred)
            .setBytesUnsafe(2, obj)
        )
    }

    fun incrementStatSOBy(subj: ByteBuffer, obj: ByteBuffer, add: Long): ResultSetFuture {
        return session.executeAsync(prepIncrementStatSOBy.bind()
            .setLong(0, add)
            .setBytesUnsafe(1, subj)
            .setBytesUnsafe(2, obj)
        )
    }

    fun incrementStatistics(subj: ByteBuffer, pred: ByteBuffer, obj: ByteBuffer, context: ByteBuffer)
        : List<ResultSetFuture> {
        val futures = ArrayList<ResultSetFuture>(6)

        futures.add(session.executeAsync(setBytesUnsafe(prepIncrementStatC.bind(), context)))
        futures.add(session.executeAsync(setBytesUnsafe(prepIncrementStatS.bind(), subj)))
        futures.add(session.executeAsync(setBytesUnsafe(prepIncrementStatP.bind(), pred)))
        futures.add(session.executeAsync(setBytesUnsafe(prepIncrementStatO.bind(), obj)))
        futures.add(session.executeAsync(setBytesUnsafe(prepIncrementStatSP.bind(), subj, pred)))
        futures.add(session.executeAsync(setBytesUnsafe(prepIncrementStatPO.bind(), pred, obj)))
        futures.add(session.executeAsync(setBytesUnsafe(prepIncrementStatSO.bind(), subj, obj)))

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

    fun getContextIDs(): CloseableIteration<ByteBuffer, SailException> {
        return TransformRowIteration(session.executeAsync(prepGetContextIds.bind()),
            { row -> row.getBytesUnsafe(0) },
            { value -> value != ScyllaRDFSchema.CONTEXT_DEFAULT })
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

    fun addStatement(subj: ByteBuffer, pred: ByteBuffer, obj: ByteBuffer) {
        addStatementInternal(subj, pred, obj, null).get()
    }

    fun addStatement(subj: ByteBuffer, pred: ByteBuffer, obj: ByteBuffer, contexts: List<ByteBuffer?>) {
        if (12 * contexts.size < MAX_BATCH_SIZE) {
            val batches = contexts
                .map { addStatementInternal(subj, pred, obj, it) }

            Futures.allAsList(batches).get()
        } else {
            // TODO: Should be fixed
            throw IllegalArgumentException("Too much contexts to add into!")
        }
    }

    fun removeStatements(subj: ByteBuffer, pred: ByteBuffer, obj: ByteBuffer, contexts: List<ByteBuffer?>) {
        val futures = mutableListOf<ResultSetFuture>()

        contexts.forEach {
            val c = it ?: ScyllaRDFSchema.CONTEXT_DEFAULT

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
            futures.add(session.executeAsync(setBytesUnsafe(prepDecrementStatSO.bind(), pred, obj)))
        }

        Futures.allAsList(futures).get()
    }

    fun getStatements(subj: ByteBuffer?, pred: ByteBuffer?, obj: ByteBuffer?, context: ByteBuffer?): SPOCIteration {
        return SPOCIteration(ResultSetFutureIteration(querySPOC(subj, pred, obj, context)))
    }

    fun getStatements(subj: ByteBuffer?, pred: ByteBuffer?, obj: ByteBuffer?, contexts: List<ByteBuffer?>)
        : SPOCIteration {
        return SPOCIteration(MultipleResultSetFutureIteration(contexts.map {
            querySPOC(subj, pred, obj, it)
        }))
    }

    fun loadKnownVocabulariesDictionary(): Map<IRI, ByteBuffer> {
        val valueFactory = SimpleValueFactory.getInstance()
        return session.execute("SELECT key, value FROM ${ScyllaRDFSchema.Table.CODER_KNOWN_VOCABULARIES}")
            .all()
            .stream()
            .map { row ->
                Pair(valueFactory.createIRI(row.getString(0)), row.getBytesUnsafe(1))
            }
            .collect(Collectors.toMap({ it.first }, { it.second }))
    }

    fun updateKnownVocabulariesDictionary(dictionary: Map<IRI, ByteBuffer>) {
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

    override fun getCardinalityC(context: ByteBuffer?): Double {
        return if (context == null) {
            countTotalTriples().toDouble()
        } else {
            countTriplesInGraphs(listOf(context as Resource)).toDouble()
        }
    }

    override fun getCardinalityS(subj: ByteBuffer): Double {
        return session.execute(prepSelectStatS.bind(subj)).one().getLong(0).toDouble()
    }

    override fun getCardinalityP(pred: ByteBuffer): Double {
        return session.execute(prepSelectStatP.bind(pred)).one().getLong(0).toDouble()
    }

    override fun getCardinalityO(obj: ByteBuffer): Double {
        return session.execute(prepSelectStatO.bind(obj)).one().getLong(0).toDouble()
    }

    override fun getCardinalitySP(subj: ByteBuffer, pred: ByteBuffer): Double {
        return session.execute(prepSelectStatSP.bind(subj, pred)).one().getLong(0).toDouble()
    }

    override fun getCardinalitySO(subj: ByteBuffer, obj: ByteBuffer): Double {
        return session.execute(prepSelectStatSO.bind(subj, obj)).one().getLong(0).toDouble()
    }

    override fun getCardinalityPO(pred: ByteBuffer, obj: ByteBuffer): Double {
        return session.execute(prepSelectStatPO.bind(pred, obj)).one().getLong(0).toDouble()
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
        session.execute("CREATE TABLE IF NOT EXISTS ${ScyllaRDFSchema.Table.S_POC} (" +
            "subject blob, predicate blob, object blob, context blob, " +
            "PRIMARY KEY (subject, predicate, object, context))")
        session.execute("CREATE TABLE IF NOT EXISTS ${ScyllaRDFSchema.Table.P_OSC} (" +
            "predicate blob, object blob, subject blob, context blob, " +
            "PRIMARY KEY (predicate, object, subject, context))")
        session.execute("CREATE TABLE IF NOT EXISTS ${ScyllaRDFSchema.Table.O_SPC} (" +
            "object blob, subject blob, predicate blob, context blob, " +
            "PRIMARY KEY (object, subject, predicate, context))")
        session.execute("CREATE TABLE IF NOT EXISTS ${ScyllaRDFSchema.Table.CS_PO} (" +
            "context blob, subject blob, predicate blob, object blob, " +
            "PRIMARY KEY ((context, subject), predicate, object))")
        session.execute("CREATE TABLE IF NOT EXISTS ${ScyllaRDFSchema.Table.CP_OS} (" +
            "context blob, predicate blob, object blob, subject blob, " +
            "PRIMARY KEY ((context, predicate), object, subject))")
        session.execute("CREATE TABLE IF NOT EXISTS ${ScyllaRDFSchema.Table.CO_SP} (" +
            "context blob, object blob, subject blob, predicate blob, " +
            "PRIMARY KEY ((context, object), subject, predicate))")

        /**
         * Tables for statistics
         */
        session.execute("CREATE TABLE IF NOT EXISTS ${ScyllaRDFSchema.Table.STAT_C} " +
            "(id blob PRIMARY KEY, counter counter)")
        session.execute("CREATE TABLE IF NOT EXISTS ${ScyllaRDFSchema.Table.STAT_S} " +
            "(id blob PRIMARY KEY, counter counter)")
        session.execute("CREATE TABLE IF NOT EXISTS ${ScyllaRDFSchema.Table.STAT_P} " +
            "(id blob PRIMARY KEY, counter counter)")
        session.execute("CREATE TABLE IF NOT EXISTS ${ScyllaRDFSchema.Table.STAT_O} " +
            "(id blob PRIMARY KEY, counter counter)")
        session.execute("CREATE TABLE IF NOT EXISTS ${ScyllaRDFSchema.Table.STAT_SP} " +
            "(subject blob, predicate blob, counter counter, PRIMARY KEY ((subject, predicate)))")
        session.execute("CREATE TABLE IF NOT EXISTS ${ScyllaRDFSchema.Table.STAT_PO} " +
            "(predicate blob, object blob, counter counter, PRIMARY KEY ((predicate, object)))")
        session.execute("CREATE TABLE IF NOT EXISTS ${ScyllaRDFSchema.Table.STAT_SO} " +
            "(subject blob, object blob, counter counter, PRIMARY KEY ((subject, object)))")

        /**
         * Table for namespaces
         */
        session.execute("CREATE TABLE IF NOT EXISTS ${ScyllaRDFSchema.Table.NS} " +
            "(prefix text, name text, PRIMARY KEY(prefix))")

        /**
         * Table for the known vocabularies coder
         */
        session.execute("CREATE TABLE IF NOT EXISTS ${ScyllaRDFSchema.Table.CODER_KNOWN_VOCABULARIES} " +
            "(key text, value blob, PRIMARY KEY(key))")
    }

    private fun prepareStatements() {
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

        prepSelectStatS = session.prepare("SELECT counter FROM ${ScyllaRDFSchema.Table.STAT_S} WHERE id = ?")
        prepSelectStatP = session.prepare("SELECT counter FROM ${ScyllaRDFSchema.Table.STAT_P} WHERE id = ?")
        prepSelectStatO = session.prepare("SELECT counter FROM ${ScyllaRDFSchema.Table.STAT_O} WHERE id = ?")
        prepSelectStatSP = session.prepare("SELECT counter FROM ${ScyllaRDFSchema.Table.STAT_SP} " +
            "WHERE subject = ? AND predicate = ?")
        prepSelectStatPO = session.prepare("SELECT counter FROM ${ScyllaRDFSchema.Table.STAT_PO} " +
            "WHERE predicate = ? AND object = ?")
        prepSelectStatSO = session.prepare("SELECT counter FROM ${ScyllaRDFSchema.Table.STAT_SO} " +
            "WHERE subject = ? AND object = ?")

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
        prepIncrementStatSO = session.prepare("UPDATE ${ScyllaRDFSchema.Table.STAT_SO} " +
            "SET counter = counter + 1 WHERE subject = ? AND object = ?")

        prepIncrementStatCBy = session.prepare("UPDATE ${ScyllaRDFSchema.Table.STAT_C} " +
            "SET counter = counter + ? WHERE id = ?")
        prepIncrementStatSBy = session.prepare("UPDATE ${ScyllaRDFSchema.Table.STAT_S} " +
            "SET counter = counter + ? WHERE id = ?")
        prepIncrementStatPBy = session.prepare("UPDATE ${ScyllaRDFSchema.Table.STAT_P} " +
            "SET counter = counter + ? WHERE id = ?")
        prepIncrementStatOBy = session.prepare("UPDATE ${ScyllaRDFSchema.Table.STAT_O} " +
            "SET counter = counter + ? WHERE id = ?")
        prepIncrementStatSPBy = session.prepare("UPDATE ${ScyllaRDFSchema.Table.STAT_SP} " +
            "SET counter = counter + ? WHERE subject = ? AND predicate = ?")
        prepIncrementStatPOBy = session.prepare("UPDATE ${ScyllaRDFSchema.Table.STAT_PO} " +
            "SET counter = counter + ? WHERE predicate = ? AND object = ?")
        prepIncrementStatSOBy = session.prepare("UPDATE ${ScyllaRDFSchema.Table.STAT_SO} " +
            "SET counter = counter + ? WHERE subject = ? AND object = ?")

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
        prepDecrementStatSO = session.prepare("UPDATE ${ScyllaRDFSchema.Table.STAT_SO} " +
            "SET counter = counter - 1 WHERE subject = ? AND object = ?")

        prepInsertKnownVocabulariesDictionary = session.prepare(
            "INSERT INTO ${ScyllaRDFSchema.Table.CODER_KNOWN_VOCABULARIES} (key, value) VALUES (?, ?)")
    }

    private fun querySPOC(subj: ByteBuffer?, pred: ByteBuffer?, obj: ByteBuffer?, context: ByteBuffer?)
        : ResultSetFuture {
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
                        session.executeAsync(setBytesUnsafe(prepSelect_CSPO_C.bind(), context))
                    } else {
                        session.executeAsync(setBytesUnsafe(prepSelect_COSP_CO.bind(), context, obj))
                    }
                } else {
                    if (obj == null) {
                        session.executeAsync(setBytesUnsafe(prepSelect_CPOS_CP.bind(), context, pred))
                    } else {
                        session.executeAsync(setBytesUnsafe(prepSelect_CPOS_CPO.bind(), context, pred, obj))
                    }
                }
            } else {
                if (pred == null) {
                    if (obj == null) {
                        session.executeAsync(setBytesUnsafe(prepSelect_CSPO_CS.bind(), context, subj))
                    } else {
                        session.executeAsync(setBytesUnsafe(prepSelect_COSP_COS.bind(), context, obj, subj))
                    }
                } else {
                    if (obj == null) {
                        session.executeAsync(setBytesUnsafe(prepSelect_CSPO_CSP.bind(), context, subj, pred))
                    } else {
                        session.executeAsync(setBytesUnsafe(prepSelect_CSPO_CSPO.bind(), context, subj, pred, obj))
                    }
                }
            }
        }
    }

    private fun addStatementInternal(subj: ByteBuffer, pred: ByteBuffer, obj: ByteBuffer, context: ByteBuffer?)
        : ListenableFuture<List<ResultSet>> {
        val indexes = ArrayList<ResultSetFuture>(3)
        indexes.add(insertInSPOC(subj, pred, obj, ScyllaRDFSchema.CONTEXT_DEFAULT))
        indexes.add(insertInPOSC(subj, pred, obj, ScyllaRDFSchema.CONTEXT_DEFAULT))
        indexes.add(insertInOSPC(subj, pred, obj, ScyllaRDFSchema.CONTEXT_DEFAULT))

        if (context != null) {
            indexes.add(insertInCSPO(subj, pred, obj, context))
            indexes.add(insertInCPOS(subj, pred, obj, context))
            indexes.add(insertInCOSP(subj, pred, obj, context))
        }

        val stats = incrementStatistics(
            subj, pred, obj, context ?: ScyllaRDFSchema.CONTEXT_DEFAULT)

        return Futures.allAsList(Iterables.concat(indexes, stats))
    }

    private fun setBytesUnsafe(bound: BoundStatement, vararg array: ByteBuffer): BoundStatement {
        array.forEachIndexed { index, it -> bound.setBytesUnsafe(index, it) }

        return bound
    }

}