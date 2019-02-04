package cc.datafabric.scyllardf.coder.vocabularies

import cc.datafabric.scyllardf.coder.IVocabulary
import org.eclipse.rdf4j.model.IRI
import org.eclipse.rdf4j.model.util.Vocabularies
import org.eclipse.rdf4j.model.vocabulary.RDF

class RDFVocabulary : IVocabulary {

    companion object {
        private val values: Array<IRI> = Vocabularies.getIRIs(RDF::class.java).toTypedArray()
    }

    override fun getNamespace(): String {
        return RDF.NAMESPACE
    }

    override fun getValues(): Iterator<IRI> {
        return values.iterator()
    }

}