package cc.datafabric.scyllardf.sail

import cc.datafabric.scyllardf.coder.CoderFacade
import cc.datafabric.scyllardf.dao.ScyllaRDFDAO
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

    private lateinit var dao: ScyllaRDFDAO
    private lateinit var coder: CoderFacade

    override fun initializeInternal() {
        try {
            dao = ScyllaRDFDAO.create(config.scyllaHosts, config.scyllaPort, config.scyllaKeyspace)

            coder = CoderFacade
            coder.initialize(dao)
        } catch (ex: Exception) {
            throw SailException(ex)
        }
    }

    override fun getConnectionInternal(): NotifyingSailConnection {
        LOG.debug("getConnectionInternal");
        return ScyllaRDFSailConnection(this, dao)
    }

    override fun getValueFactory(): ValueFactory {
        return SimpleValueFactory.getInstance()
    }

    override fun isWritable(): Boolean {
        return true
    }

    override fun shutDownInternal() {
        LOG.debug("shutDownInternal");
        dao.close()
    }


    fun getCoder(): CoderFacade {
        return coder
    }
}