package cc.datafabric.scyllardf.coder.vocabularies.fibo

import cc.datafabric.scyllardf.coder.IVocabulary
import org.eclipse.rdf4j.model.IRI
import org.eclipse.rdf4j.model.impl.SimpleValueFactory

class FIBO_BE_LE_FBOVocabulary : IVocabulary {

    companion object {
        private const val NS = "https://spec.edmcouncil.org/fibo/ontology/BE/LegalEntities/FormalBusinessOrganizations/"

        private val VF = SimpleValueFactory.getInstance()
        private val values = arrayListOf<IRI>(
            VF.createIRI(NS, "hasRegisteredAddress"),
            VF.createIRI(NS, "RegisteredAddress"),
            VF.createIRI(NS, "hasSignatory"),
            VF.createIRI(NS, "hasEquity")
        )
    }

    override fun getNamespace(): String {
        return NS
    }

    override fun getValues(): Iterator<IRI> {
        return values.iterator()
    }

}