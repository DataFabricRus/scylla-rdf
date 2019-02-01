package cc.datafabric.scyllardf.dao

import com.datastax.driver.core.ResultSet
import com.datastax.driver.core.ResultSetFuture
import com.datastax.driver.core.Row
import org.eclipse.rdf4j.common.iteration.CloseableIteration
import org.eclipse.rdf4j.sail.SailException

class ResultSetFutureIteration(private val future: ResultSetFuture) : CloseableIteration<Row, SailException> {

    private var resultSet: ResultSet? = null
    private lateinit var iterator: Iterator<Row>

    override fun next(): Row {
        if (resultSet == null) {
            resultSet = future.get()
            iterator = resultSet!!.iterator()
        }

        return iterator.next()
    }

    override fun remove() {
        throw SailException(IllegalStateException("Removal is not supported!"))
    }

    override fun hasNext(): Boolean {
        if (resultSet == null) {
            resultSet = future.get()
            iterator = resultSet!!.iterator()
        }

        return iterator.hasNext()
    }

    override fun close() {
        future.cancel(true)
    }

}