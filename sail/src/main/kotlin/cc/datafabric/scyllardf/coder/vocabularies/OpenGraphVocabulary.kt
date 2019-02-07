package cc.datafabric.scyllardf.coder.vocabularies

import cc.datafabric.scyllardf.coder.IVocabulary
import org.eclipse.rdf4j.model.IRI
import org.eclipse.rdf4j.model.impl.SimpleValueFactory

class OpenGraphVocabulary : IVocabulary {

    companion object {
        private const val NS = "http://ogp.me/ns#"
        private val VF = SimpleValueFactory.getInstance()
        private val VALUES = setOf<IRI>(
            VF.createIRI(NS, "title"),
            VF.createIRI(NS, "tag")
        )
    }

    override fun getNamespace(): String {
        return NS
    }

    override fun getValues(): Iterator<IRI> {
        return VALUES.iterator()
    }

}