package cc.datafabric.scyllardf.dao.impl

import cc.datafabric.scyllardf.dao.ICardinalityDAO
import cc.datafabric.scyllardf.dao.IDictionaryDAO
import cc.datafabric.scyllardf.dao.IIndexDAO
import com.datastax.driver.core.Cluster
import com.datastax.driver.core.ConsistencyLevel
import com.datastax.driver.core.HostDistance
import com.datastax.driver.core.PoolingOptions
import com.datastax.driver.core.QueryOptions
import com.datastax.driver.core.Session
import com.datastax.driver.core.Statement
import com.datastax.driver.core.WriteType
import com.datastax.driver.core.exceptions.DriverException
import com.datastax.driver.core.policies.DefaultRetryPolicy
import com.datastax.driver.core.policies.LoggingRetryPolicy
import com.datastax.driver.core.policies.RetryPolicy
import com.datastax.driver.core.policies.RoundRobinPolicy
import com.datastax.driver.core.policies.TokenAwarePolicy
import org.slf4j.LoggerFactory
import java.io.Closeable
import java.net.InetAddress

class ScyllaRDFDAOFactory private constructor(
    private val cluster: Cluster, private val keyspace: String
) : Closeable {

    companion object {
        private val LOG = LoggerFactory.getLogger(ScyllaRDFDAOFactory::class.java)

        fun create(hosts: List<InetAddress>, port: Int, keyspace: String): ScyllaRDFDAOFactory {
            return create(hosts, port, keyspace, PoolingOptions()
                .setMaxRequestsPerConnection(HostDistance.LOCAL, 1024)
                .setMaxRequestsPerConnection(HostDistance.REMOTE, 256)
            )
        }

        fun create(
            hosts: List<InetAddress>,
            port: Int, keyspace: String,
            poolingOptions: PoolingOptions
        ): ScyllaRDFDAOFactory {
            val cluster = Cluster.builder()
                .addContactPoints(hosts)
                .withPort(port)
                .withLoadBalancingPolicy(TokenAwarePolicy(RoundRobinPolicy()))
                .withQueryOptions(QueryOptions().setConsistencyLevel(ConsistencyLevel.ONE))
                .withPoolingOptions(poolingOptions)
                .withRetryPolicy(LoggingRetryPolicy(TolerantRetryPolicy()))
                .build()

            val dao = ScyllaRDFDAOFactory(cluster, keyspace)
            dao.initialize()

            return dao
        }
    }

    private val session: Session = cluster.connect()

    private lateinit var cardinalityDAO: ScyllaRDFCardinalityDAO
    private lateinit var dictionaryDAO: ScyllaRDFDictionaryDAO
    private lateinit var indexDAO: ScyllaRDFIndexDAO

    private fun initialize() {
        val protocolVersion = cluster.configuration.protocolOptions.protocolVersion?.toInt()
        LOG.info("Scylla cluster supports {} protocol version", protocolVersion)

        session.execute("CREATE KEYSPACE IF NOT EXISTS $keyspace " +
            "WITH replication = { 'class': 'SimpleStrategy', 'replication_factor': 1 }")
        session.execute("USE $keyspace")

        // Cardinality DAO
        cardinalityDAO = ScyllaRDFCardinalityDAO(session)
        cardinalityDAO.createTables()
        cardinalityDAO.prepareStatements()

        // Dictionary DAO
        dictionaryDAO = ScyllaRDFDictionaryDAO(session)
        dictionaryDAO.createTables()
        dictionaryDAO.prepareStatements()

        // Index DAO
        indexDAO = ScyllaRDFIndexDAO(session)
        indexDAO.createTables()
        indexDAO.prepareStatements()
    }

    fun getCardinalityDAO(): ICardinalityDAO {
        return cardinalityDAO
    }

    fun getIndexDAO(): IIndexDAO {
        return indexDAO
    }

    fun getDictionaryDAO(): IDictionaryDAO {
        return dictionaryDAO
    }

    override fun close() {
        cluster.close()
    }

    private class TolerantRetryPolicy : RetryPolicy {

        companion object {
            private val DEFAULT = DefaultRetryPolicy.INSTANCE
        }

        override fun onReadTimeout(
            statement: Statement?,
            cl: ConsistencyLevel?,
            requiredResponses: Int,
            receivedResponses: Int,
            dataRetrieved: Boolean,
            nbRetry: Int
        ): RetryPolicy.RetryDecision {
            return DEFAULT
                .onReadTimeout(statement, cl, requiredResponses, receivedResponses, dataRetrieved, nbRetry)
        }

        override fun onWriteTimeout(
            statement: Statement?,
            cl: ConsistencyLevel?,
            writeType: WriteType?,
            requiredAcks: Int,
            receivedAcks: Int,
            nbRetry: Int
        ): RetryPolicy.RetryDecision {
            if (writeType == WriteType.SIMPLE && nbRetry < 3) {
                return RetryPolicy.RetryDecision.retry(cl)
            }

            return DEFAULT.onWriteTimeout(statement, cl, writeType, requiredAcks, receivedAcks, nbRetry)
        }

        override fun onUnavailable(
            statement: Statement?,
            cl: ConsistencyLevel?,
            requiredReplica: Int,
            aliveReplica: Int,
            nbRetry: Int
        ): RetryPolicy.RetryDecision {
            return DEFAULT.onUnavailable(statement, cl, requiredReplica, aliveReplica, nbRetry)
        }

        override fun onRequestError(
            statement: Statement?,
            cl: ConsistencyLevel?,
            e: DriverException?,
            nbRetry: Int
        ): RetryPolicy.RetryDecision {
            return DEFAULT.onRequestError(statement, cl, e, nbRetry)
        }

        override fun init(cluster: Cluster?) {
        }

        override fun close() {
        }

    }

}