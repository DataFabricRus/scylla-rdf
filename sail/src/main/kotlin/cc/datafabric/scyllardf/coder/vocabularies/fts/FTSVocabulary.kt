package cc.datafabric.scyllardf.coder.vocabularies.fts

import cc.datafabric.scyllardf.coder.IVocabulary
import org.eclipse.rdf4j.model.IRI
import org.eclipse.rdf4j.model.impl.SimpleValueFactory

class FTSVocabulary : IVocabulary {

    companion object {
        private const val NS = "https://w3id.org/datafabric.cc/ontologies/fts#"

        private val VF = SimpleValueFactory.getInstance()
        private val values = arrayListOf<IRI>(
            VF.createIRI(NS, "p18_postcode")
        )
    }

    override fun getNamespace(): String {
        return NS
    }

    override fun getValues(): Iterator<IRI> {
        return values.iterator()
    }
}