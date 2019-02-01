package cc.datafabric.scyllardf.sail

import org.eclipse.rdf4j.sail.Sail
import org.eclipse.rdf4j.sail.config.SailConfigException
import org.eclipse.rdf4j.sail.config.SailFactory
import org.eclipse.rdf4j.sail.config.SailImplConfig
import org.eclipse.rdf4j.sail.elasticsearch.ElasticsearchIndex
import org.eclipse.rdf4j.sail.evaluation.TupleFunctionEvaluationMode
import org.eclipse.rdf4j.sail.lucene.LuceneSail

class ScyllaRDFSailFactory : SailFactory {

    companion object {
        const val SAIL_TYPE = "openrdf:ScyllaRDFStore"
    }

    override fun getSailType(): String {
        return SAIL_TYPE
    }

    override fun getConfig(): SailImplConfig {
        return ScyllaRDFSailConfig()
    }

    override fun getSail(config: SailImplConfig): Sail {
        if (SAIL_TYPE != config.type) {
            throw SailConfigException("Invalid Sail type: " + config.type)
        }

        if (config is ScyllaRDFSailConfig) {
            try {
                val scyllaRDFSailConfig: ScyllaRDFSailConfig = config

                val scyllaRDFSail = ScyllaRDFSail(scyllaRDFSailConfig)

                if (!scyllaRDFSailConfig.elasticsearchHost.isNullOrEmpty()) {
                    val fullTextSail = LuceneSail()

                    fullTextSail.setParameter(LuceneSail.INDEX_CLASS_KEY, ElasticsearchIndex::class.java.name)
                    fullTextSail.setParameter(LuceneSail.EVALUATION_MODE_KEY,
                        TupleFunctionEvaluationMode.NATIVE.name)
                    fullTextSail.setParameter(LuceneSail.MAX_DOCUMENTS_KEY,
                        scyllaRDFSailConfig.elasticsearchMaxDocuments.toString())
                    fullTextSail.setParameter(ElasticsearchIndex.TRANSPORT_KEY, scyllaRDFSailConfig.elasticsearchHost)
                    fullTextSail.setParameter(ElasticsearchIndex.INDEX_NAME_KEY, ElasticsearchIndex.DEFAULT_INDEX_NAME)
                    fullTextSail.setParameter(ElasticsearchIndex.DOCUMENT_TYPE_KEY,
                        ElasticsearchIndex.DEFAULT_DOCUMENT_TYPE)
                    fullTextSail.baseSail = scyllaRDFSail

                    return fullTextSail
                }

                return scyllaRDFSail
            } catch (ex: Exception) {
                throw SailConfigException(ex)
            }
        } else {
            throw SailConfigException("Invalid configuration: $config");
        }
    }

}