package cc.datafabric.scyllardf.coder.vocabularies

import cc.datafabric.scyllardf.coder.IVocabulary
import org.eclipse.rdf4j.model.IRI
import org.eclipse.rdf4j.model.util.Vocabularies
import org.eclipse.rdf4j.model.vocabulary.XMLSchema

class XMLSCHEMAVocabulary : IVocabulary {

    companion object {
        private val values: Array<IRI> = Vocabularies.getIRIs(XMLSchema::class.java).toTypedArray()
    }

    override fun getNamespace(): String {
        return XMLSchema.NAMESPACE
    }

    override fun getValues(): Iterator<IRI> {
        return values.iterator()
    }

}