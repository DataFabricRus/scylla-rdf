package cc.datafabric.scyllardf.dao.impl

import cc.datafabric.scyllardf.dao.ScyllaRDFSchema
import org.cassandraunit.AbstractCassandraUnit4CQLTestCase
import org.cassandraunit.dataset.cql.ClassPathCQLDataSet
import org.eclipse.rdf4j.common.iteration.Iterations
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import java.nio.ByteBuffer

class ScyllaRDFIndexDAOTest : AbstractCassandraUnit4CQLTestCase() {

    companion object {
        val querySPOC = "SELECT * FROM ${ScyllaRDFSchema.Table.S_POC} WHERE subject = ? AND predicate = ? AND object = ? AND context = ?"
        val queryPOSC = "SELECT * FROM ${ScyllaRDFSchema.Table.P_OSC} WHERE subject = ? AND predicate = ? AND object = ? AND context = ?"
        val queryOSPC = "SELECT * FROM ${ScyllaRDFSchema.Table.O_SPC} WHERE subject = ? AND predicate = ? AND object = ? AND context = ?"
        val queryCSPO = "SELECT * FROM ${ScyllaRDFSchema.Table.CS_PO} WHERE subject = ? AND predicate = ? AND object = ? AND context = ?"
        val queryCPOS = "SELECT * FROM ${ScyllaRDFSchema.Table.CP_OS} WHERE subject = ? AND predicate = ? AND object = ? AND context = ?"
        val queryCOSP = "SELECT * FROM ${ScyllaRDFSchema.Table.CO_SP} WHERE subject = ? AND predicate = ? AND object = ? AND context = ?"

        val subj = toByteBuffer("urn:subj")
        val pred = toByteBuffer("urn:pred")
        val obj = toByteBuffer("urn:obj")

        val graph1 = toByteBuffer("urn:graph:1")
        val graph2 = toByteBuffer("urn:graph:2")

        private fun toByteBuffer(str: String): ByteBuffer {
            return ByteBuffer.wrap(str.toByteArray(Charsets.UTF_8))
        }
    }

    private lateinit var dao: ScyllaRDFIndexDAO

    override fun getDataSet() = ClassPathCQLDataSet(
            "cc/datafabric/scyllardf/empty.cql", true, true)

    @Before
    fun beforeEach() {
        super.before()

        dao = ScyllaRDFIndexDAO(session)
        dao.createTables()
        dao.prepareStatements()
    }

    @After
    fun afterEach() {
        super.after()
    }

    @Test
    fun addStatementsIntoDefaultContext() {
        dao.addStatement(subj, pred, obj)

        val iter = dao.getStatements(null, null, null, null)

        checkAllTables(1, subj, pred, obj, ScyllaRDFSchema.CONTEXT_DEFAULT)
    }

    @Test
    fun addStatementsIntoNonDefaultContext() {
        dao.addStatement(subj, pred, obj, listOf(graph1))

        checkAllTables(1, subj, pred, obj, graph1)
    }

    @Test
    fun clearDefaultContext() {
        dao.addStatement(subj, pred, obj)
        dao.addStatement(subj, pred, obj, listOf(graph1))

        checkAllTables(1, subj, pred, obj, ScyllaRDFSchema.CONTEXT_DEFAULT)
        checkAllTables(1, subj, pred, obj, graph1)

        dao.clearContext(null)

        checkAllTables(0, subj, pred, obj, ScyllaRDFSchema.CONTEXT_DEFAULT)
        checkAllTables(0, subj, pred, obj, graph1)
    }

    @Test
    fun clearNonDefaultContext() {
        dao.addStatement(subj, pred, obj)
        dao.addStatement(subj, pred, obj, listOf(graph1))
        dao.addStatement(subj, pred, obj, listOf(graph2))

        assertEquals(3, Iterations.asList(dao.getStatements(null, null, null, null)).size)

        checkAllTables(1, subj, pred, obj, graph2)

        dao.clearContext(graph2)

        checkAllTables(0, subj, pred, obj, graph2)
    }

    @Test
    fun testSetEmptyNamespace() {
        val prefix = ""
        val namespace = "urn:uuid:"
        dao.setNamespace(prefix, namespace)

        assertEquals(namespace, dao.getNamespace(prefix))

        val pair = dao.getNamespaces().next()
        assertEquals(prefix, pair[0])
        assertEquals(namespace, pair[1])

        dao.clearNamespaces()
    }

    private fun checkAllTables(expected: Int, subj: ByteBuffer, pred: ByteBuffer, obj: ByteBuffer, context: ByteBuffer) {
        assertEquals(expected, session.execute(querySPOC, subj, pred, obj, context).all().size)
        assertEquals(expected, session.execute(queryPOSC, subj, pred, obj, context).all().size)
        assertEquals(expected, session.execute(queryOSPC, subj, pred, obj, context).all().size)

        if (context != ScyllaRDFSchema.CONTEXT_DEFAULT) {
            assertEquals(expected, session.execute(queryCSPO, subj, pred, obj, context).all().size)
            assertEquals(expected, session.execute(queryCPOS, subj, pred, obj, context).all().size)
            assertEquals(expected, session.execute(queryCOSP, subj, pred, obj, context).all().size)
        }
    }

}
