package cc.datafabric.scyllardf.dao

import com.datastax.driver.core.Row
import org.eclipse.rdf4j.common.iteration.CloseableIteration
import org.eclipse.rdf4j.sail.SailException
import java.nio.ByteBuffer

class SPOCIteration(private val rowIteration: CloseableIteration<Row, SailException>)
    : CloseableIteration<Array<ByteBuffer>, SailException> {

    override fun next(): Array<ByteBuffer> {
        val row = rowIteration.next()

        return Array(4) { i -> row.getBytesUnsafe(i) }
    }

    override fun remove() {
        rowIteration.remove()
    }

    override fun hasNext(): Boolean {
        return rowIteration.hasNext()
    }

    override fun close() {
        rowIteration.close()
    }

}