package cc.datafabric.scyllardf.sail

import cc.datafabric.scyllardf.coder.CoderFacade
import cc.datafabric.scyllardf.dao.impl.ScyllaRDFCardinalityDAO
import cc.datafabric.scyllardf.dao.impl.ScyllaRDFDictionaryDAO
import cc.datafabric.scyllardf.dao.impl.ScyllaRDFIndexDAO
import org.cassandraunit.AbstractCassandraUnit4CQLTestCase
import org.cassandraunit.dataset.cql.ClassPathCQLDataSet
import org.eclipse.rdf4j.model.ValueFactory
import org.eclipse.rdf4j.model.impl.SimpleValueFactory
import org.eclipse.rdf4j.query.QueryLanguage
import org.eclipse.rdf4j.repository.sail.SailRepository
import org.eclipse.rdf4j.sail.SailConnection
import org.eclipse.rdf4j.sail.helpers.AbstractSail
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class SomeQueriesTest : AbstractCassandraUnit4CQLTestCase() {

    private lateinit var indexDAO: ScyllaRDFIndexDAO
    private lateinit var cardinalityDAO: ScyllaRDFCardinalityDAO
    private lateinit var dictionaryDAO: ScyllaRDFDictionaryDAO
    private lateinit var coder: CoderFacade
    private lateinit var repository: SailRepository

    override fun getDataSet() = ClassPathCQLDataSet(
            "cc/datafabric/scyllardf/empty.cql", true, true)

    @BeforeEach
    fun beforeEach() {
        super.before()

        cardinalityDAO = ScyllaRDFCardinalityDAO(session)
        cardinalityDAO.createTables()
        cardinalityDAO.prepareStatements()

        dictionaryDAO = ScyllaRDFDictionaryDAO(session)
        dictionaryDAO.createTables()
        dictionaryDAO.prepareStatements()

        indexDAO = ScyllaRDFIndexDAO(session)
        indexDAO.createTables()
        indexDAO.prepareStatements()

        coder = CoderFacade()
        coder.initialize(dictionaryDAO, true)

        val sail = MockAbstractSail()
        val connection = ScyllaRDFSailConnection(
                sail,
                indexDAO,
                cardinalityDAO,
                false,
                coder
        )
        sail.conn = connection

        repository = SailRepository(sail)
        repository.init()
    }

    private class MockAbstractSail : AbstractSail() {

        lateinit var conn : SailConnection

        override fun getConnectionInternal(): SailConnection = conn

        override fun getValueFactory(): ValueFactory = SimpleValueFactory.getInstance()

        override fun isWritable(): Boolean = true

        override fun shutDownInternal() {
        }
    }

    @AfterEach
    fun afterEach() {
        super.after()
    }

    /**
     * @see https://github.com/DataFabricRus/scylla-rdf/issues/9
     */
    @Test
    fun testIssue9OnEmptyStore() {
        val query = """
            PREFIX : <http://example.com/>
            
            SELECT ?s
            WHERE {
                GRAPH <http://example.com/graphname> { 
                    ?s a :ClassName . 
                } 
            }
        """

        val tupleQuery = repository.connection.prepareTupleQuery(QueryLanguage.SPARQL, query)
        val result = tupleQuery.evaluate()

        assertFalse(result.hasNext())
    }

    @Test
    fun testIssue9Query2() {
        val query = """
            SELECT ?s ?o
            WHERE {
                GRAPH <http://example.com/graphname> { 
                    ?s a ?o . 
                } 
            }
        """

        val tupleQuery = repository.connection.prepareTupleQuery(QueryLanguage.SPARQL, query)
        val result = tupleQuery.evaluate()

        assertFalse(result.hasNext())
    }

    @Test
    fun testIssue9Query3() {
        val query = """
            PREFIX : <http://example.com/>
            
            SELECT ?s ?o
            WHERE {
                GRAPH <http://example.com/graphname> { 
                    ?s a/rdfs:subClassOf+ :ClassName . 
                } 
            }
        """

        val tupleQuery = repository.connection.prepareTupleQuery(QueryLanguage.SPARQL, query)
        val result = tupleQuery.evaluate()

        assertFalse(result.hasNext())
    }

}