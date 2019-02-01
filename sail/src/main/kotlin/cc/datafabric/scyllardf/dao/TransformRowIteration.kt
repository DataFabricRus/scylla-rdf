package cc.datafabric.scyllardf.dao

import com.datastax.driver.core.ResultSetFuture
import com.datastax.driver.core.Row
import org.eclipse.rdf4j.common.iteration.CloseableIteration
import org.eclipse.rdf4j.sail.SailException

class TransformRowIteration<T>(
    private val base: CloseableIteration<Row, SailException>,
    private val transform: (Row) -> T
) : CloseableIteration<T, SailException> {

    private var filter: ((T) -> Boolean)? = null
    private var next: T? = null

    constructor(future: ResultSetFuture, transform: (Row) -> T)
        : this(ResultSetFutureIteration(future), transform)

    constructor(future: ResultSetFuture, transform: (Row) -> T, filter: ((T) -> Boolean))
        : this(future, transform) {
        this.filter = filter
    }

    constructor(futures: List<ResultSetFuture>, transform: (Row) -> T)
        : this(MultipleResultSetFutureIteration(futures), transform)

    constructor(futures: List<ResultSetFuture>, transform: (Row) -> T, filter: ((T) -> Boolean))
        : this(MultipleResultSetFutureIteration(futures), transform) {
        this.filter = filter
    }

    override fun hasNext(): Boolean {
        if (filter == null) {
            return base.hasNext()
        }

        do {
            if (base.hasNext()) {
                next = transform.invoke(base.next())
            } else {
                next = null
                break
            }
        } while (!filter!!.invoke(next!!))

        return next != null
    }

    override fun next(): T {
        if (filter == null || next == null) {
            return transform.invoke(base.next())
        }

        return next!!
    }

    override fun remove() {
        base.remove()
    }

    override fun close() {
        base.close()
    }
}