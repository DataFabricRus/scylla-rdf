package cc.datafabric.scyllardf.sail

import cc.datafabric.scyllardf.coder.CoderFacade
import cc.datafabric.scyllardf.coder.ICoderFacade
import cc.datafabric.scyllardf.dao.impl.ScyllaRDFDAOFactory
import org.eclipse.rdf4j.model.ValueFactory
import org.eclipse.rdf4j.model.impl.SimpleValueFactory
import org.eclipse.rdf4j.sail.NotifyingSailConnection
import org.eclipse.rdf4j.sail.SailException
import org.eclipse.rdf4j.sail.helpers.AbstractNotifyingSail
import org.slf4j.LoggerFactory

class ScyllaRDFSail(private val config: ScyllaRDFSailConfig) : AbstractNotifyingSail() {

    companion object {
        private val LOG = LoggerFactory.getLogger(ScyllaRDFSail::class.java)
    }

    private lateinit var daoFactory: ScyllaRDFDAOFactory
    private lateinit var coder: CoderFacade

    override fun initializeInternal() {
        try {
            daoFactory = ScyllaRDFDAOFactory.create(
                    config.scyllaHosts, config.scyllaPort, config.scyllaKeyspace, config.scyllaReplicationFactor)

            coder = CoderFacade()
            coder.initialize(daoFactory.getDictionaryDAO(), true)
        } catch (ex: Exception) {
            throw SailException(ex)
        }
    }

    override fun getConnectionInternal(): NotifyingSailConnection {
        LOG.debug("getConnectionInternal")
        return ScyllaRDFSailConnection(
            this,
            daoFactory.getIndexDAO(),
            daoFactory.getCardinalityDAO(),
            config.cardinalityEstimationEnabled
        )
    }

    override fun getValueFactory(): ValueFactory {
        return SimpleValueFactory.getInstance()
    }

    override fun isWritable(): Boolean {
        return true
    }

    override fun shutDownInternal() {
        daoFactory.close()
    }


    fun getCoder(): ICoderFacade {
        return coder
    }
}