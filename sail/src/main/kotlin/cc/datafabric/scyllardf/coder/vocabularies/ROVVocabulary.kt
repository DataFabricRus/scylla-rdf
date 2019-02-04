package cc.datafabric.scyllardf.coder.vocabularies

import cc.datafabric.scyllardf.coder.IVocabulary
import org.eclipse.rdf4j.model.IRI
import org.eclipse.rdf4j.model.util.Vocabularies
import org.eclipse.rdf4j.model.vocabulary.ROV

class ROVVocabulary : IVocabulary {

    companion object {
        private val values: Array<IRI> = Vocabularies.getIRIs(ROV::class.java).toTypedArray()
    }

    override fun getNamespace(): String {
        return ROV.NAMESPACE
    }

    override fun getValues(): Iterator<IRI> {
        return values.iterator()
    }

}