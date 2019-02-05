package cc.datafabric.scyllardf.coder.vocabularies.fibo

import cc.datafabric.scyllardf.coder.IVocabulary
import org.eclipse.rdf4j.model.IRI
import org.eclipse.rdf4j.model.impl.SimpleValueFactory

class FIBO_FND_UTL_BTVocabulary : IVocabulary {

    companion object {
        private const val NS = "https://spec.edmcouncil.org/fibo/ontology/FND/Utilities/BusinessFacingTypes/"

        private val VF = SimpleValueFactory.getInstance()
        private val values = arrayListOf<IRI>(
            VF.createIRI(NS, "hasPercentageValue")
        )
    }

    override fun getNamespace(): String {
        return NS
    }

    override fun getValues(): Iterator<IRI> {
        return values.iterator()
    }

}