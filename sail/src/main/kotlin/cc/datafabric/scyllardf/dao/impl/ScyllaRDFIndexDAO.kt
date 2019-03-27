package cc.datafabric.scyllardf.dao.impl

import cc.datafabric.scyllardf.dao.IIndexDAO
import cc.datafabric.scyllardf.dao.MultipleResultSetFutureIteration
import cc.datafabric.scyllardf.dao.ResultSetFutureIteration
import cc.datafabric.scyllardf.dao.SPOCIteration
import cc.datafabric.scyllardf.dao.ScyllaRDFSchema
import cc.datafabric.scyllardf.dao.TransformRowIteration
import com.datastax.driver.core.PreparedStatement
import com.datastax.driver.core.ResultSet
import com.datastax.driver.core.ResultSetFuture
import com.datastax.driver.core.Session
import com.google.common.util.concurrent.Futures
import com.google.common.util.concurrent.ListenableFuture
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

    override fun insertInSPOC(subj: ByteBuffer, pred: ByteBuffer, obj: ByteBuffer, context: ByteBuffer): ResultSetFuture {
        return session.executeAsync(setBytesUnsafe(prepInsertSPOC.bind(), subj, pred, obj, context))
    }

    override fun insertInPOSC(subj: ByteBuffer, pred: ByteBuffer, obj: ByteBuffer, context: ByteBuffer): ResultSetFuture {
        return session.executeAsync(setBytesUnsafe(prepInsertPOSC.bind(), pred, obj, subj, context))
    }

    override fun insertInOSPC(subj: ByteBuffer, pred: ByteBuffer, obj: ByteBuffer, context: ByteBuffer): ResultSetFuture {
        return session.executeAsync(setBytesUnsafe(prepInsertOSPC.bind(), obj, subj, pred, context))
    }

    override fun insertInCSPO(subj: ByteBuffer, pred: ByteBuffer, obj: ByteBuffer, context: ByteBuffer): ResultSetFuture {
        return session.executeAsync(setBytesUnsafe(prepInsertCSPO.bind(), context, subj, pred, obj))
    }

    override fun insertInCPOS(subj: ByteBuffer, pred: ByteBuffer, obj: ByteBuffer, context: ByteBuffer): ResultSetFuture {
        return session.executeAsync(setBytesUnsafe(prepInsertCPOS.bind(), context, pred, obj, subj))
    }

    override fun insertInCOSP(subj: ByteBuffer, pred: ByteBuffer, obj: ByteBuffer, context: ByteBuffer): ResultSetFuture {
        return session.executeAsync(setBytesUnsafe(prepInsertCOSP.bind(), context, obj, subj, pred))
    }

    override fun getContextIDs(): CloseableIteration<ByteBuffer, SailException> {
        return TransformRowIteration(session.executeAsync(prepGetContextIds.bind()),
            { row -> row.getBytesUnsafe(0) },
            { value -> value != ScyllaRDFSchema.CONTEXT_DEFAULT })
    }

    /**
     * If context is null or refers to the default graph, then absolutely all triples are removed.
     * Otherwise, only triples in the given graph are removed.
     */
    override fun clearContext(context: ByteBuffer?) {
        if (context == null || context == ScyllaRDFSchema.CONTEXT_DEFAULT) {
            val futures = mutableListOf<ResultSetFuture>()

            futures.add(session.executeAsync("TRUNCATE TABLE ${ScyllaRDFSchema.Table.S_POC}"))
            futures.add(session.executeAsync("TRUNCATE TABLE ${ScyllaRDFSchema.Table.P_OSC}"))
            futures.add(session.executeAsync("TRUNCATE TABLE ${ScyllaRDFSchema.Table.O_SPC}"))

            futures.add(session.executeAsync("TRUNCATE TABLE ${ScyllaRDFSchema.Table.CS_PO}"))
            futures.add(session.executeAsync("TRUNCATE TABLE ${ScyllaRDFSchema.Table.CP_OS}"))
            futures.add(session.executeAsync("TRUNCATE TABLE ${ScyllaRDFSchema.Table.CO_SP}"))

            Futures.allAsList(futures).get()
        }
    }

    override fun getNamespaces(): CloseableIteration<Array<String>, SailException> {
        return TransformRowIteration(session.executeAsync(prepGetNamespaces.bind())) { row ->
            arrayOf(row.getString(0), row.getString(1))
        }
    }

    override fun getNamespace(prefix: String): String? {
        val row = session.execute(prepGetNamespace.bind(prefix)).one()

        if (row != null) {
            return row.getString(1)
        }

        return null
    }

    override fun setNamespace(prefix: String, name: String) {
        session.execute(prepSetNamespace.bind(name, prefix))
    }

    override fun clearNamespaces() {
        session.execute(prepClearNamespaces.bind())
    }

    override fun removeNamespace(prefix: String) {
        session.execute(prepDeleteNamespace.bind(prefix))
    }

    override fun addStatement(subj: ByteBuffer, pred: ByteBuffer, obj: ByteBuffer) {
        addStatementInternal(subj, pred, obj, null).get()
    }

    override fun addStatement(subj: ByteBuffer, pred: ByteBuffer, obj: ByteBuffer, contexts: List<ByteBuffer?>) {
        val batches = contexts
            .map { addStatementInternal(subj, pred, obj, it) }

        Futures.allAsList(batches).get()
    }

    override fun removeStatements(subj: ByteBuffer, pred: ByteBuffer, obj: ByteBuffer, contexts: List<ByteBuffer?>) {
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
//TODO:
//            futures.add(session.executeAsync(setBytesUnsafe(prepDecrementStatC.bind(), c)))
//            futures.add(session.executeAsync(setBytesUnsafe(prepDecrementStatS.bind(), subj)))
//            futures.add(session.executeAsync(setBytesUnsafe(prepDecrementStatP.bind(), pred)))
//            futures.add(session.executeAsync(setBytesUnsafe(prepDecrementStatO.bind(), obj)))
//            futures.add(session.executeAsync(setBytesUnsafe(prepDecrementStatSP.bind(), subj, pred)))
//            futures.add(session.executeAsync(setBytesUnsafe(prepDecrementStatPO.bind(), pred, obj)))
//            futures.add(session.executeAsync(setBytesUnsafe(prepDecrementStatSO.bind(), pred, obj)))
        }

        Futures.allAsList(futures).get()
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
    }

    internal fun prepareStatements() {
        prepGetContextIds = session.prepare("SELECT id FROM ${ScyllaRDFSchema.Table.CARD_C}")

        prepGetNamespaces = session.prepare("SELECT prefix, name FROM ${ScyllaRDFSchema.Table.NS}")
        prepGetNamespace = session.prepare("SELECT prefix, name FROM ${ScyllaRDFSchema.Table.NS} WHERE prefix = ?")
        prepSetNamespace = session.prepare("UPDATE ${ScyllaRDFSchema.Table.NS} SET name = ? WHERE prefix = ?")
        prepClearNamespaces = session.prepare("TRUNCATE TABLE ${ScyllaRDFSchema.Table.NS}")
        prepDeleteNamespace = session.prepare("DELETE name FROM ${ScyllaRDFSchema.Table.NS} WHERE prefix = ?")

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
            "INSERT INTO ${ScyllaRDFSchema.Table.CS_PO} (context, subject, predicate, object) " +
                "VALUES (?, ?, ?, ?)")
        prepInsertCPOS = session.prepare(
            "INSERT INTO ${ScyllaRDFSchema.Table.CP_OS} (context, predicate, object, subject) " +
                "VALUES (?, ?, ?, ?)")
        prepInsertCOSP = session.prepare(
            "INSERT INTO ${ScyllaRDFSchema.Table.CO_SP} (context, object, subject, predicate) " +
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

        return Futures.allAsList(indexes)
    }

}