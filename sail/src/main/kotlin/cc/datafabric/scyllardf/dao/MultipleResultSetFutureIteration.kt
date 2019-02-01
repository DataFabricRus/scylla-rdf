package cc.datafabric.scyllardf.dao

import com.datastax.driver.core.ResultSet
import com.datastax.driver.core.ResultSetFuture
import com.datastax.driver.core.Row
import org.eclipse.rdf4j.common.iteration.CloseableIteration
import org.eclipse.rdf4j.sail.SailException

class MultipleResultSetFutureIteration(private val futures: List<ResultSetFuture>)
    : CloseableIteration<Row, SailException> {

    private var futureIdx = 0
    private var resultSet: ResultSet? = null
    private lateinit var iterator: Iterator<Row>

    override fun next(): Row {
        while (resultSet == null || !iterator.hasNext()) {
            if (futures.isNotEmpty() && futureIdx < futures.size) {
                resultSet = futures[futureIdx].get()
                iterator = resultSet!!.iterator()

                futureIdx++;
            } else {
                throw NoSuchElementException()
            }
        }

        return iterator.next()
    }

    override fun remove() {
        throw SailException(IllegalStateException("Removal is not supported!"))
    }

    override fun hasNext(): Boolean {
        while (resultSet == null || !iterator.hasNext()) {
            if (futures.isNotEmpty() && futureIdx < futures.size) {
                resultSet = futures[futureIdx].get()
                iterator = resultSet!!.iterator()

                futureIdx++;
            } else {
                return false
            }
        }

        return iterator.hasNext()
    }

    override fun close() {
        futures.forEach { it.cancel(true) }
    }
}