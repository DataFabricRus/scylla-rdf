package cc.datafabric.scyllardf.dao.impl

import cc.datafabric.scyllardf.dao.IIndexDAO
import cc.datafabric.scyllardf.dao.MultipleResultSetFutureIteration
import cc.datafabric.scyllardf.dao.ResultSetFutureIteration
import cc.datafabric.scyllardf.dao.SPOCIteration
import cc.datafabric.scyllardf.dao.ScyllaRDFSchema
import cc.datafabric.scyllardf.dao.ScyllaRDFSchema.EMPTY_PREFIX
import cc.datafabric.scyllardf.dao.TransformRowIteration
import com.datastax.driver.core.PreparedStatement
import com.datastax.driver.core.ResultSetFuture
import com.datastax.driver.core.Session
import org.eclipse.rdf4j.common.iteration.CloseableIteration
import org.eclipse.rdf4j.sail.SailException
import java.nio.ByteBuffer

internal class ScyllaRDFIndexDAO(private val session: Session) : AbstractScyllaRDFDAO(), IIndexDAO {

    private lateinit var prepGetContextIds: PreparedStatement
    private lateinit var prepGetNamespaces: PreparedStatement
    private lateinit var prepGetNamespace: PreparedStatement
    private lateinit var prepSetNamespace: PreparedStatement
    private lateinit var prepClearNamespaces: PreparedStatement
    private lateinit var prepDeleteNamespace: PreparedStatement

    private lateinit var selectSPOCByS: PreparedStatement
    private lateinit var selectSPOCBySP: PreparedStatement
    private lateinit var selectSPOCBySPO: PreparedStatement
    private lateinit var selectSPOC: PreparedStatement
    private lateinit var selectPOSCByP: PreparedStatement
    private lateinit var selectPOSCByPO: PreparedStatement
    private lateinit var selectOSPCByO: PreparedStatement
    private lateinit var selectOSPCByOS: PreparedStatement
    private lateinit var selectCSPOByCS: PreparedStatement
    private lateinit var selectCSPOByCSP: PreparedStatement
    private lateinit var selectCSPOByCSPO: PreparedStatement
    private lateinit var selectCSPOByC: PreparedStatement
    private lateinit var selectCPOSByCP: PreparedStatement
    private lateinit var selectCPOSByCPO: PreparedStatement
    private lateinit var selectCOSPByCO: PreparedStatement
    private lateinit var selectCOSPByCOS: PreparedStatement

    private lateinit var insertSPOC: PreparedStatement
    private lateinit var insertPOSC: PreparedStatement
    private lateinit var insertOSPC: PreparedStatement
    private lateinit var insertCSPO: PreparedStatement
    private lateinit var insertCPOS: PreparedStatement
    private lateinit var insertCOSP: PreparedStatement

    private lateinit var deleteSPOC: PreparedStatement
    private lateinit var deletePOSC: PreparedStatement
    private lateinit var deleteOSPC: PreparedStatement
    private lateinit var deleteCSPO: PreparedStatement
    private lateinit var deleteCPOS: PreparedStatement
    private lateinit var deleteCOSP: PreparedStatement

    override fun insertInSPOC(subj: ByteBuffer, pred: ByteBuffer, obj: ByteBuffer, context: ByteBuffer): ResultSetFuture {
        return session.executeAsync(setBytesUnsafe(insertSPOC.bind(), subj, pred, obj, context))
    }

    override fun insertInPOSC(subj: ByteBuffer, pred: ByteBuffer, obj: ByteBuffer, context: ByteBuffer): ResultSetFuture {
        return session.executeAsync(setBytesUnsafe(insertPOSC.bind(), pred, obj, subj, context))
    }

    override fun insertInOSPC(subj: ByteBuffer, pred: ByteBuffer, obj: ByteBuffer, context: ByteBuffer): ResultSetFuture {
        return session.executeAsync(setBytesUnsafe(insertOSPC.bind(), obj, subj, pred, context))
    }

    override fun insertInCSPO(subj: ByteBuffer, pred: ByteBuffer, obj: ByteBuffer, context: ByteBuffer): ResultSetFuture {
        return session.executeAsync(setBytesUnsafe(insertCSPO.bind(), context, subj, pred, obj))
    }

    override fun insertInCPOS(subj: ByteBuffer, pred: ByteBuffer, obj: ByteBuffer, context: ByteBuffer): ResultSetFuture {
        return session.executeAsync(setBytesUnsafe(insertCPOS.bind(), context, pred, obj, subj))
    }

    override fun insertInCOSP(subj: ByteBuffer, pred: ByteBuffer, obj: ByteBuffer, context: ByteBuffer): ResultSetFuture {
        return session.executeAsync(setBytesUnsafe(insertCOSP.bind(), context, obj, subj, pred))
    }

    override fun getContextIDs(): CloseableIteration<ByteBuffer, SailException> {
        return TransformRowIteration(session.executeAsync(prepGetContextIds.bind()),
                { row -> row.getBytesUnsafe(0) },
                { value -> value != ScyllaRDFSchema.CONTEXT_DEFAULT })
    }

    /**
     * If context is null or refers to the default graph, then absolutely all triples are removed. Otherwise,
     * only triples in the given graph are removed.
     */
    override fun clearContext(context: ByteBuffer?) {
        if (context == null || context == ScyllaRDFSchema.CONTEXT_DEFAULT) {
            clearAllContexts()
        } else {
            session.execute(setBytesUnsafe(selectCSPOByC.bind(), context)).forEach {
                waitUntilDone(
                        session.executeAsync(setBytesUnsafe(deleteSPOC.bind(), it)),
                        session.executeAsync(setBytesUnsafe(deletePOSC.bind(), it)),
                        session.executeAsync(setBytesUnsafe(deleteOSPC.bind(), it)),

                        session.executeAsync(setBytesUnsafe(deleteCPOS.bind(), it)),
                        session.executeAsync(setBytesUnsafe(deleteCOSP.bind(), it)),
                        session.executeAsync(setBytesUnsafe(deleteCSPO.bind(), it))
                )
            }
        }
    }

    private fun clearAllContexts() {
        val futures = mutableListOf<ResultSetFuture>()

        futures.add(session.executeAsync("TRUNCATE TABLE ${ScyllaRDFSchema.Table.S_POC}"))
        futures.add(session.executeAsync("TRUNCATE TABLE ${ScyllaRDFSchema.Table.P_OSC}"))
        futures.add(session.executeAsync("TRUNCATE TABLE ${ScyllaRDFSchema.Table.O_SPC}"))

        futures.add(session.executeAsync("TRUNCATE TABLE ${ScyllaRDFSchema.Table.CS_PO}"))
        futures.add(session.executeAsync("TRUNCATE TABLE ${ScyllaRDFSchema.Table.CP_OS}"))
        futures.add(session.executeAsync("TRUNCATE TABLE ${ScyllaRDFSchema.Table.CO_SP}"))

        waitUntilDone(futures)
    }

    override fun getNamespaces(): CloseableIteration<Array<String>, SailException> {
        return TransformRowIteration(session.executeAsync(prepGetNamespaces.bind())) {
            val prefix = it.getString(0)
            if (prefix == EMPTY_PREFIX) {
                arrayOf("", it.getString(1))
            } else {
                arrayOf(prefix, it.getString(1))
            }
        }
    }

    override fun getNamespace(prefix: String): String? {
        val p = if (prefix.isBlank()) EMPTY_PREFIX else prefix

        val row = session.execute(prepGetNamespace.bind(p)).one()

        if (row != null) {
            return row.getString(1)
        }

        return null
    }

    override fun setNamespace(prefix: String, name: String) {
        val p = if (prefix.isBlank()) EMPTY_PREFIX else prefix

        session.execute(prepSetNamespace.bind(name, p))
    }

    override fun clearNamespaces() {
        session.execute(prepClearNamespaces.bind())
    }

    override fun removeNamespace(prefix: String) {
        session.execute(prepDeleteNamespace.bind(prefix))
    }

    override fun addStatement(subj: ByteBuffer, pred: ByteBuffer, obj: ByteBuffer, context: ByteBuffer?): List<ResultSetFuture> {
        return addStatementInternal(subj, pred, obj, context)
    }

    override fun addStatementBlocking(subj: ByteBuffer, pred: ByteBuffer, obj: ByteBuffer) {
        waitUntilDoneAndClear(
                addStatementInternal(subj, pred, obj, null)
        )
    }

    override fun addStatementBlocking(subj: ByteBuffer, pred: ByteBuffer, obj: ByteBuffer, contexts: List<ByteBuffer?>) {
        val batch = mutableListOf<ResultSetFuture>()

        contexts.forEach { batch.addAll(addStatementInternal(subj, pred, obj, it)) }

        waitUntilDoneAndClear(batch)
    }

    override fun removeStatement(subj: ByteBuffer, pred: ByteBuffer, obj: ByteBuffer, vararg context: ByteBuffer?)
            : List<ResultSetFuture> {
        val futures = mutableListOf<ResultSetFuture>()

        context.forEach { futures.addAll(removeStatementInternal(subj, pred, obj, it)) }

        return futures
    }

    override fun removeStatementBlocking(subj: ByteBuffer, pred: ByteBuffer, obj: ByteBuffer, contexts: List<ByteBuffer?>) {
        val futures = mutableListOf<ResultSetFuture>()

        contexts.forEach { futures.addAll(removeStatementInternal(subj, pred, obj, it)) }

        waitUntilDone(futures)
    }

    override fun getStatements(subj: ByteBuffer?, pred: ByteBuffer?, obj: ByteBuffer?, context: ByteBuffer?): SPOCIteration {
        return SPOCIteration(ResultSetFutureIteration(querySPOC(subj, pred, obj, context)))
    }

    override fun getStatements(subj: ByteBuffer?, pred: ByteBuffer?, obj: ByteBuffer?, contexts: List<ByteBuffer?>)
            : SPOCIteration {
        return SPOCIteration(MultipleResultSetFutureIteration(contexts.map {
            querySPOC(subj, pred, obj, it)
        }))
    }

    internal fun createTables() {
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
         * Table for namespaces
         */
        session.execute("CREATE TABLE IF NOT EXISTS ${ScyllaRDFSchema.Table.NS} " +
                "(prefix text, name text, PRIMARY KEY(prefix))")

        session.execute("CREATE TABLE IF NOT EXISTS ${ScyllaRDFSchema.Table.CARD_C} " +
                "(id blob PRIMARY KEY, counter counter)")
    }

    internal fun prepareStatements() {
        prepGetContextIds = session.prepare("SELECT id FROM ${ScyllaRDFSchema.Table.CARD_C}")

        prepGetNamespaces = session.prepare("SELECT prefix, name FROM ${ScyllaRDFSchema.Table.NS}")
        prepGetNamespace = session.prepare("SELECT prefix, name FROM ${ScyllaRDFSchema.Table.NS} WHERE prefix = ?")
        prepSetNamespace = session.prepare("UPDATE ${ScyllaRDFSchema.Table.NS} SET name = ? WHERE prefix = ?")
        prepClearNamespaces = session.prepare("TRUNCATE TABLE ${ScyllaRDFSchema.Table.NS}")
        prepDeleteNamespace = session.prepare("DELETE name FROM ${ScyllaRDFSchema.Table.NS} WHERE prefix = ?")

        insertSPOC = session.prepare(
                "INSERT INTO ${ScyllaRDFSchema.Table.S_POC} (subject, predicate, object, context) " +
                        "VALUES (?, ?, ?, ?)")
        insertPOSC = session.prepare(
                "INSERT INTO ${ScyllaRDFSchema.Table.P_OSC} (predicate, object, subject, context) " +
                        "VALUES (?, ?, ?, ?)")
        insertOSPC = session.prepare(
                "INSERT INTO ${ScyllaRDFSchema.Table.O_SPC} (object, subject, predicate, context) " +
                        "VALUES (?, ?, ?, ?)")
        insertCSPO = session.prepare(
                "INSERT INTO ${ScyllaRDFSchema.Table.CS_PO} (context, subject, predicate, object) " +
                        "VALUES (?, ?, ?, ?)")
        insertCPOS = session.prepare(
                "INSERT INTO ${ScyllaRDFSchema.Table.CP_OS} (context, predicate, object, subject) " +
                        "VALUES (?, ?, ?, ?)")
        insertCOSP = session.prepare(
                "INSERT INTO ${ScyllaRDFSchema.Table.CO_SP} (context, object, subject, predicate) " +
                        "VALUES (?, ?, ?, ?)")

        deleteSPOC = session.prepare("DELETE FROM ${ScyllaRDFSchema.Table.S_POC} WHERE " +
                "subject = ? AND predicate = ? AND object = ? AND context = ?")
        deletePOSC = session.prepare("DELETE FROM ${ScyllaRDFSchema.Table.P_OSC} WHERE " +
                "predicate = ? AND object = ? AND subject = ? AND context = ?")
        deleteOSPC = session.prepare("DELETE FROM ${ScyllaRDFSchema.Table.O_SPC} WHERE " +
                "object = ? AND subject = ? AND predicate = ? AND context = ?")
        deleteCSPO = session.prepare("DELETE FROM ${ScyllaRDFSchema.Table.CS_PO} WHERE " +
                "context = ? AND subject = ? AND predicate = ? AND object = ?")
        deleteCPOS = session.prepare("DELETE FROM ${ScyllaRDFSchema.Table.CP_OS} WHERE " +
                "context = ? AND predicate = ? AND object = ? AND subject = ?")
        deleteCOSP = session.prepare("DELETE FROM ${ScyllaRDFSchema.Table.CO_SP} WHERE " +
                "context = ? AND object = ? AND subject = ? AND predicate = ?")

        selectSPOCByS = session.prepare("SELECT subject, predicate, object, context " +
                "FROM ${ScyllaRDFSchema.Table.S_POC} " +
                "WHERE subject = ?")
        selectSPOCBySP = session.prepare("SELECT subject, predicate, object, context " +
                "FROM ${ScyllaRDFSchema.Table.S_POC} " +
                "WHERE subject = ? AND predicate = ?")
        selectSPOCBySPO = session.prepare("SELECT subject, predicate, object, context " +
                "FROM ${ScyllaRDFSchema.Table.S_POC} " +
                "WHERE subject = ? AND predicate = ? AND object = ?")
        selectSPOC = session.prepare("SELECT subject, predicate, object, context " +
                "FROM ${ScyllaRDFSchema.Table.S_POC}")
        selectPOSCByPO = session.prepare("SELECT subject, predicate, object, context " +
                "FROM ${ScyllaRDFSchema.Table.P_OSC} " +
                "WHERE predicate = ? AND object = ?")
        selectPOSCByP = session.prepare("SELECT subject, predicate, object, context " +
                "FROM ${ScyllaRDFSchema.Table.P_OSC} " +
                "WHERE predicate = ?")
        selectOSPCByOS = session.prepare("SELECT subject, predicate, object, context " +
                "FROM ${ScyllaRDFSchema.Table.O_SPC} " +
                "WHERE object = ? AND subject = ?")
        selectOSPCByO = session.prepare("SELECT subject, predicate, object, context " +
                "FROM ${ScyllaRDFSchema.Table.O_SPC} " +
                "WHERE object = ?")
        selectCSPOByCS = session.prepare("SELECT subject, predicate, object, context " +
                "FROM ${ScyllaRDFSchema.Table.CS_PO} " +
                "WHERE context = ? AND subject = ?")
        selectCSPOByCSP = session.prepare("SELECT subject, predicate, object, context " +
                "FROM ${ScyllaRDFSchema.Table.CS_PO} " +
                "WHERE context = ? AND subject = ? AND predicate = ?")
        selectCSPOByCSPO = session.prepare("SELECT subject, predicate, object, context " +
                "FROM ${ScyllaRDFSchema.Table.CS_PO} " +
                "WHERE context = ? AND subject = ? AND predicate = ? AND object = ?")
        selectCPOSByCP = session.prepare("SELECT subject, predicate, object, context " +
                "FROM ${ScyllaRDFSchema.Table.CP_OS} " +
                "WHERE context = ? AND predicate = ? AND object = ?")
        selectCPOSByCPO = session.prepare("SELECT subject, predicate, object, context " +
                "FROM ${ScyllaRDFSchema.Table.CP_OS} " +
                "WHERE context = ? AND predicate = ? AND object = ? AND subject = ?")
        selectCOSPByCO = session.prepare("SELECT subject, predicate, object, context " +
                "FROM ${ScyllaRDFSchema.Table.CO_SP} " +
                "WHERE context = ? AND object = ? AND subject = ? AND predicate = ?")
        selectCOSPByCOS = session.prepare("SELECT subject, predicate, object, context " +
                "FROM ${ScyllaRDFSchema.Table.CO_SP} " +
                "WHERE context = ? AND object = ? AND subject = ?")
        selectCSPOByC = session.prepare("SELECT subject, predicate, object, context " +
                "FROM ${ScyllaRDFSchema.Table.CS_PO} WHERE context = ? ALLOW FILTERING")
    }

    private fun querySPOC(subj: ByteBuffer?, pred: ByteBuffer?, obj: ByteBuffer?, context: ByteBuffer?)
            : ResultSetFuture {
        return if (context == null) {
            if (subj == null) {
                if (pred == null) {
                    if (obj == null) {
                        session.executeAsync(selectSPOC.bind())
                    } else {
                        session.executeAsync(setBytesUnsafe(selectOSPCByO.bind(), obj))
                    }
                } else {
                    if (obj == null) {
                        session.executeAsync(setBytesUnsafe(selectPOSCByP.bind(), pred))
                    } else {
                        session.executeAsync(setBytesUnsafe(selectPOSCByPO.bind(), pred, obj))
                    }
                }
            } else {
                if (pred == null) {
                    if (obj == null) {
                        session.executeAsync(setBytesUnsafe(selectSPOCByS.bind(), subj))
                    } else {
                        session.executeAsync(setBytesUnsafe(selectOSPCByOS.bind(), obj, subj))
                    }
                } else {
                    if (obj == null) {
                        session.executeAsync(setBytesUnsafe(selectSPOCBySP.bind(), subj, pred))
                    } else {
                        session.executeAsync(setBytesUnsafe(selectSPOCBySPO.bind(), subj, pred, obj))
                    }
                }
            }
        } else {
            if (subj == null) {
                if (pred == null) {
                    if (obj == null) {
                        session.executeAsync(setBytesUnsafe(selectCSPOByC.bind(), context))
                    } else {
                        session.executeAsync(setBytesUnsafe(selectCOSPByCO.bind(), context, obj))
                    }
                } else {
                    if (obj == null) {
                        session.executeAsync(setBytesUnsafe(selectCPOSByCP.bind(), context, pred))
                    } else {
                        session.executeAsync(setBytesUnsafe(selectCPOSByCPO.bind(), context, pred, obj))
                    }
                }
            } else {
                if (pred == null) {
                    if (obj == null) {
                        session.executeAsync(setBytesUnsafe(selectCSPOByCS.bind(), context, subj))
                    } else {
                        session.executeAsync(setBytesUnsafe(selectCOSPByCOS.bind(), context, obj, subj))
                    }
                } else {
                    if (obj == null) {
                        session.executeAsync(setBytesUnsafe(selectCSPOByCSP.bind(), context, subj, pred))
                    } else {
                        session.executeAsync(setBytesUnsafe(selectCSPOByCSPO.bind(), context, subj, pred, obj))
                    }
                }
            }
        }
    }

    private fun removeStatementInternal(subj: ByteBuffer, pred: ByteBuffer, obj: ByteBuffer, context: ByteBuffer?)
            : MutableList<ResultSetFuture> {
        val futures = mutableListOf<ResultSetFuture>()

        val c = context ?: ScyllaRDFSchema.CONTEXT_DEFAULT

        futures.add(session.executeAsync(setBytesUnsafe(deleteSPOC.bind(), subj, pred, obj, c)))
        futures.add(session.executeAsync(setBytesUnsafe(deletePOSC.bind(), pred, obj, subj, c)))
        futures.add(session.executeAsync(setBytesUnsafe(deleteOSPC.bind(), obj, subj, pred, c)))

        if (context != null) {
            futures.add(session.executeAsync(setBytesUnsafe(deleteCSPO.bind(), c, subj, pred, obj)))
            futures.add(session.executeAsync(setBytesUnsafe(deleteCPOS.bind(), c, pred, obj, subj)))
            futures.add(session.executeAsync(setBytesUnsafe(deleteCOSP.bind(), c, obj, subj, pred)))
        }

        //TODO: https://github.com/DataFabricRus/scylla-rdf/issues/3
        //futures.add(session.executeAsync(setBytesUnsafe(prepDecrementStatC.bind(), c)))
        //futures.add(session.executeAsync(setBytesUnsafe(prepDecrementStatS.bind(), subj)))
        //futures.add(session.executeAsync(setBytesUnsafe(prepDecrementStatP.bind(), pred)))
        //futures.add(session.executeAsync(setBytesUnsafe(prepDecrementStatO.bind(), obj)))
        //futures.add(session.executeAsync(setBytesUnsafe(prepDecrementStatSP.bind(), subj, pred)))
        //futures.add(session.executeAsync(setBytesUnsafe(prepDecrementStatPO.bind(), pred, obj)))
        //futures.add(session.executeAsync(setBytesUnsafe(prepDecrementStatSO.bind(), pred, obj)))

        return futures
    }

    private fun addStatementInternal(subj: ByteBuffer, pred: ByteBuffer, obj: ByteBuffer, context: ByteBuffer?)
            : MutableList<ResultSetFuture> {
        val indexes = mutableListOf<ResultSetFuture>()

        indexes.add(insertInSPOC(subj, pred, obj, context ?: ScyllaRDFSchema.CONTEXT_DEFAULT))
        indexes.add(insertInPOSC(subj, pred, obj, context ?: ScyllaRDFSchema.CONTEXT_DEFAULT))
        indexes.add(insertInOSPC(subj, pred, obj, context ?: ScyllaRDFSchema.CONTEXT_DEFAULT))

        if (context != null && context != ScyllaRDFSchema.CONTEXT_DEFAULT) {
            indexes.add(insertInCSPO(subj, pred, obj, context))
            indexes.add(insertInCPOS(subj, pred, obj, context))
            indexes.add(insertInCOSP(subj, pred, obj, context))
        }

        return indexes
    }

}