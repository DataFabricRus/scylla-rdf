package cc.datafabric.scyllardf.coder.impl

import cc.datafabric.scyllardf.coder.IVocabulary
import com.google.common.collect.BiMap
import com.google.common.collect.HashBiMap
import org.eclipse.rdf4j.model.IRI
import org.slf4j.LoggerFactory
import java.nio.ByteBuffer
import java.util.ServiceLoader
import java.util.concurrent.atomic.AtomicInteger

internal class IRIFromKnownVocabularyCoder(coderId: Int) : AbstractCoder<IRI>(coderId) {

    companion object {
        private const val VALUE_HASH_BYTES = 3

        private val LOG = LoggerFactory.getLogger(IRIFromKnownVocabularyCoder::class.java)
    }

    private val dictionary = HashBiMap.create<IRI, ByteBuffer>()

    fun initialize(loadedDictionary: Map<IRI, ByteBuffer>): Map<IRI, ByteBuffer> {
        val counter = if (!loadedDictionary.isEmpty()) {
            LOG.info("Dictionary isn't empty, found ${loadedDictionary.size} entries")

            AtomicInteger(loadedDictionary.size)
        } else {
            LOG.info("Dictionary is empty")

            AtomicInteger(0)
        }

        val serviceLoader = ServiceLoader.load(IVocabulary::class.java)

        if (!loadedDictionary.isEmpty()) {
            dictionary.putAll(loadedDictionary)

            var numVocabs = 0
            serviceLoader.forEach { vocab ->
                LOG.info("Refreshing [${vocab.getNamespace()}] vocabulary...")
                vocab.getValues().forEach {
                    if (!dictionary.containsKey(it)) {
                        registerEntry(counter, dictionary, it)
                    }
                }

                numVocabs++
            }

            LOG.info("Refreshed $numVocabs vocabularies")
        } else {
            var numVocabs = 0
            serviceLoader.forEach { vocab ->
                LOG.info("Registering [${vocab.getNamespace()}] vocabulary...")

                vocab.getValues().forEach {
                    registerEntry(counter, dictionary, it)
                }

                numVocabs++
            }

            LOG.info("Registered $numVocabs vocabularies")
        }

        LOG.info("Dictionary size is ${dictionary.size}")
        LOG.info("Inverse dictionary size is ${dictionary.inverse().size}")

        return dictionary
    }

    override fun encode(value: IRI?): ByteBuffer? {
        return dictionary[value]
    }

    override fun decode(hash: ByteBuffer): IRI {
        return dictionary.inverse()[hash]!!
    }

    private fun registerEntry(counter: AtomicInteger, index: BiMap<IRI, ByteBuffer>, value: IRI) {
        val counterHash = ByteBuffer.allocate(Integer.BYTES)
            .putInt(0, counter.incrementAndGet())
            .array()
        val valueHash = ByteArray(VALUE_HASH_BYTES)
        System.arraycopy(counterHash, 1, valueHash, 0, VALUE_HASH_BYTES)

        index[value] = newHash(coderId, MARKER_VALUE_TYPE_IRI, valueHash)
    }

}