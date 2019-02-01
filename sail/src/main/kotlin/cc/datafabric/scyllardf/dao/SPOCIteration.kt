package cc.datafabric.scyllardf.dao

import com.datastax.driver.core.Row
import org.eclipse.rdf4j.common.iteration.CloseableIteration
import org.eclipse.rdf4j.sail.SailException

class SPOCIteration(private val rowIteration: CloseableIteration<Row, SailException>)
    : CloseableIteration<Array<ByteArray>, SailException> {

    override fun next(): Array<ByteArray> {
        val row = rowIteration.next()

        return Array(4) { i -> row.getBytesUnsafe(i).array() }
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