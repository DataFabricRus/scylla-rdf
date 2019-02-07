package cc.datafabric.scyllardf.coder.vocabularies

import cc.datafabric.scyllardf.coder.IVocabulary
import org.eclipse.rdf4j.model.IRI
import org.eclipse.rdf4j.model.impl.SimpleValueFactory

class ReviewVocabulary : IVocabulary {

    companion object {
        private const val NS = "http://purl.org/stuff/rev#"
        private val VF = SimpleValueFactory.getInstance()
        private val VALUES = setOf<IRI>(
            VF.createIRI(NS, "rating"),
            VF.createIRI(NS, "title"),
            VF.createIRI(NS, "text"),
            VF.createIRI(NS, "totalVotes"),
            VF.createIRI(NS, "reviewer"),
            VF.createIRI(NS, "hasReview")
        )
    }

    override fun getNamespace(): String {
        return NS
    }

    override fun getValues(): Iterator<IRI> {
        return VALUES.iterator()
    }

}