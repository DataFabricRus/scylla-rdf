package cc.datafabric.scyllardf.sail

import com.datastax.driver.core.Cluster
import org.eclipse.rdf4j.model.IRI
import org.eclipse.rdf4j.model.Model
import org.eclipse.rdf4j.model.Resource
import org.eclipse.rdf4j.model.impl.SimpleValueFactory
import org.eclipse.rdf4j.model.util.Models
import org.eclipse.rdf4j.sail.config.AbstractSailImplConfig
import org.eclipse.rdf4j.sail.config.SailConfigException
import java.net.InetAddress

class ScyllaRDFSailConfig : AbstractSailImplConfig() {

    companion object {
        private const val NAMESPACE_PREFIX = "http://www.openrdf.org/config/sail#scylla-rdf-"

        private val VF = SimpleValueFactory.getInstance()

        private val SCYLLA_KEYSPACE: IRI = VF.createIRI(NAMESPACE_PREFIX, "keyspace")
        private val SCYLLA_HOSTS: IRI = VF.createIRI(NAMESPACE_PREFIX, "hosts")
        private val SCYLLA_PORT: IRI = VF.createIRI(NAMESPACE_PREFIX, "port")

        private val ELASTICSEARCH_HOST: IRI = VF.createIRI(NAMESPACE_PREFIX, "elasticsearchHost")
        private val ELASTICSEARCH_MAX_DOCUMENTS: IRI = VF
            .createIRI(NAMESPACE_PREFIX, "elasticsearchMaxDocuments")
    }

    var scyllaKeyspace: String = "triplestore"
    var scyllaHosts = mutableListOf<InetAddress>()
    var scyllaPort: Int = 9042

    var elasticsearchHost: String? = null
    var elasticsearchMaxDocuments: Int = 100

    override fun export(m: Model): Resource {
        val implNode = super.export(m)

        m.add(implNode, SCYLLA_KEYSPACE, VF.createLiteral(scyllaKeyspace))

        val scyllaHostsAsString = scyllaHosts.map { it -> it.hostName }.joinToString()
        m.add(implNode, SCYLLA_HOSTS, VF.createLiteral(scyllaHostsAsString))

        m.add(implNode, SCYLLA_PORT, VF.createLiteral(scyllaPort))

        if (elasticsearchHost != null) {
            m.add(implNode, ELASTICSEARCH_HOST, VF.createLiteral(elasticsearchHost))
            m.add(implNode, ELASTICSEARCH_MAX_DOCUMENTS, VF.createLiteral(elasticsearchMaxDocuments))
        }

        return implNode
    }

    override fun parse(m: Model, implNode: Resource) {
        super.parse(m, implNode)

        try {
            scyllaKeyspace = Models.getPropertyString(m, implNode, SCYLLA_KEYSPACE)
                .orElseThrow { SailConfigException("Scylla Keyspace is required!") }
            Models.getPropertyString(m, implNode, SCYLLA_HOSTS)
                .orElseThrow { SailConfigException("Scylla Hosts is required!") }
                .split(",")
                .map { InetAddress.getByName(it) }
                .toCollection(scyllaHosts)
            scyllaPort = Models.getPropertyLiteral(m, implNode, SCYLLA_PORT)
                .orElseThrow { SailConfigException("Scylla Port is required!") }
                .stringValue().toInt()

            elasticsearchHost = Models.getPropertyString(m, implNode, ELASTICSEARCH_HOST).orElse(null)
            if (!elasticsearchHost.isNullOrEmpty()) {
                elasticsearchMaxDocuments = Models.getPropertyLiteral(m, implNode, ELASTICSEARCH_MAX_DOCUMENTS)
                    .orElseThrow { SailConfigException("Elasticsearch Max Documents is required!") }
                    .stringValue().toInt()
            }
        } catch (ex: NumberFormatException) {
            throw SailConfigException(ex)
        }
    }

}