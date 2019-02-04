package cc.datafabric.scyllardf.coder

import org.eclipse.rdf4j.model.IRI

interface IVocabulary {

    fun getNamespace(): String

    fun getValues(): Iterator<IRI>

}