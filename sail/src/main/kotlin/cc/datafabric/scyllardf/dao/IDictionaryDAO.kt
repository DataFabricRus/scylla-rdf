package cc.datafabric.scyllardf.dao

import org.eclipse.rdf4j.model.IRI
import java.nio.ByteBuffer

interface IDictionaryDAO {

    fun loadKnownVocabulariesDictionary(): Map<IRI, ByteBuffer>

    fun saveKnownVocabulariesDictionary(dictionary: Map<IRI, ByteBuffer>)

}