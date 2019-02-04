package cc.datafabric.scyllardf.coder.vocabularies

import cc.datafabric.scyllardf.coder.IVocabulary
import org.eclipse.rdf4j.model.IRI
import org.eclipse.rdf4j.model.util.Vocabularies
import org.eclipse.rdf4j.model.vocabulary.ORG

class ORGVocabulary : IVocabulary {

    companion object {
        private val values: Array<IRI> = Vocabularies.getIRIs(ORG::class.java).toTypedArray()
    }

    override fun getNamespace(): String {
        return ORG.NAMESPACE
    }

    override fun getValues(): Iterator<IRI> {
        return values.iterator()
    }

}