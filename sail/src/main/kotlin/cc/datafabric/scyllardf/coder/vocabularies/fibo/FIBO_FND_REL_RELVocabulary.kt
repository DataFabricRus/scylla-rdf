package cc.datafabric.scyllardf.coder.vocabularies.fibo

import cc.datafabric.scyllardf.coder.IVocabulary
import org.eclipse.rdf4j.model.IRI
import org.eclipse.rdf4j.model.impl.SimpleValueFactory

class FIBO_FND_REL_RELVocabulary : IVocabulary {

    companion object {
        private const val NS = "https://spec.edmcouncil.org/fibo/ontology/FND/Relations/Relations/"

        private val VF = SimpleValueFactory.getInstance()
        private val values = arrayListOf<IRI>(
            VF.createIRI(NS, "appliesTo"),
            VF.createIRI(NS, "hasLegalName"),
            VF.createIRI(NS, "hasUniqueIdentifier"),
            VF.createIRI(NS, "hasAlias"),
            VF.createIRI(NS, "hasFormalName"),
            VF.createIRI(NS, "isManagedBy"),
            VF.createIRI(NS, "manages"),
            VF.createIRI(NS, "governs")
        )
    }

    override fun getNamespace(): String {
        return NS
    }

    override fun getValues(): Iterator<IRI> {
        return values.iterator()
    }

}