package cc.datafabric.scyllardf.coder.impl

import org.eclipse.rdf4j.model.IRI
import org.eclipse.rdf4j.model.impl.SimpleValueFactory
import org.eclipse.rdf4j.model.vocabulary.RDF
import org.eclipse.rdf4j.model.vocabulary.RDFS
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.nio.ByteBuffer
import kotlin.test.assertNull

class IRIFromKnownVocabularyCoderTest {

    @Test
    public fun testWithoutExistingDictionary() {
        val coder0 = IRIFromKnownVocabularyCoder(0)
        coder0.initialize(emptyMap())

        var expectedHash0 = ByteBuffer.wrap(byteArrayOf(
            0b00000001, // coderId and valueType
            0,
            0,
            0b00000001 // RDF.TYPE is 1
        ))
        assertEquals(expectedHash0, coder0.encode(RDF.TYPE))
        assertEquals(RDF.TYPE, coder0.decode(expectedHash0))

        expectedHash0 = ByteBuffer.wrap(byteArrayOf(
            0b00000001, // coderId and valueType
            0,
            0,
            0b00000111 // RDF.STATEMENT is 7
        ))
        assertEquals(expectedHash0, coder0.encode(RDF.STATEMENT))
        assertEquals(RDF.STATEMENT, coder0.decode(expectedHash0))

        expectedHash0 = ByteBuffer.wrap(byteArrayOf(
            0b00000001, // coderId and valueType
            0,
            0,
            0b00010100 // RDF.STATEMENT is 20
        ))
        assertEquals(expectedHash0, coder0.encode(RDFS.LITERAL))
        assertEquals(RDFS.LITERAL, coder0.decode(expectedHash0))

        val coder2 = IRIFromKnownVocabularyCoder(2)
        coder2.initialize(emptyMap())

        var expectedHash1 = ByteBuffer.wrap(byteArrayOf(
            0b00001001, // coderId and valueType
            0,
            0,
            0b00000001 // RDF.TYPE is 1
        ))
        assertEquals(expectedHash1, coder2.encode(RDF.TYPE))
        assertEquals(RDF.TYPE, coder2.decode(expectedHash1))

        expectedHash1 = ByteBuffer.wrap(byteArrayOf(
            0b00001001, // coderId and valueType
            0,
            0,
            0b00000111 // RDF.STATEMENT is 7
        ))
        assertEquals(expectedHash1, coder2.encode(RDF.STATEMENT))
        assertEquals(RDF.STATEMENT, coder2.decode(expectedHash1))

        expectedHash1 = ByteBuffer.wrap(byteArrayOf(
            0b00001001, // coderId and valueType
            0,
            0,
            0b00010100 // RDF.STATEMENT is 20
        ))
        assertEquals(expectedHash1, coder2.encode(RDFS.LITERAL))
        assertEquals(RDFS.LITERAL, coder2.decode(expectedHash1))
    }

    @Test
    public fun testWithExistingDictionary() {
        val coder1 = IRIFromKnownVocabularyCoder(0)
        val dictionary1 = coder1.initialize(emptyMap())

        val coder2 = IRIFromKnownVocabularyCoder(0)
        val dictionary2 = coder2.initialize(dictionary1)

        assertEquals(dictionary1, dictionary2)

        val dictionary3 = mutableMapOf<IRI, ByteBuffer>()
        dictionary3.put(
            SimpleValueFactory.getInstance().createIRI("http://example.com/1"),
            ByteBuffer.wrap(byteArrayOf(0b00000001, 0, 0, 0b00000000))
        )
        val coder3 = IRIFromKnownVocabularyCoder(0)
        coder3.initialize(dictionary3)

        val expectedHash3 = ByteBuffer.wrap(byteArrayOf(
            0b00000001, // coderId and valueType
            0,
            0,
            0b00000010 // RDF.TYPE is 2
        ))
        assertEquals(expectedHash3, coder3.encode(RDF.TYPE))
    }

    @Test
    public fun testInexistentMapping() {
        val coder0 = IRIFromKnownVocabularyCoder(0)
        coder0.initialize(emptyMap())

        assertNull(coder0.encode(SimpleValueFactory.getInstance().createIRI("http://example.com/1")))
        assertNull(coder0.encode(null))
    }

}