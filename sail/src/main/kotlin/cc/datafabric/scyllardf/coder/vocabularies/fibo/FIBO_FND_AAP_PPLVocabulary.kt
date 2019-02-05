package cc.datafabric.scyllardf.coder.vocabularies.fibo

import cc.datafabric.scyllardf.coder.IVocabulary
import org.eclipse.rdf4j.model.IRI
import org.eclipse.rdf4j.model.impl.SimpleValueFactory

class FIBO_FND_AAP_PPLVocabulary : IVocabulary {

    companion object {
        private const val NS = "https://spec.edmcouncil.org/fibo/ontology/FND/AgentsAndPeople/People/"

        private val VF = SimpleValueFactory.getInstance()
        private val values = arrayListOf<IRI>(
            VF.createIRI(NS, "hasFirstName"),
            VF.createIRI(NS, "hasGender"),
            VF.createIRI(NS, "hasLastName"),
            VF.createIRI(NS, "hasMiddleNameOrInitial")
        )
    }

    override fun getNamespace(): String {
        return NS
    }

    override fun getValues(): Iterator<IRI> {
        return values.iterator()
    }

}