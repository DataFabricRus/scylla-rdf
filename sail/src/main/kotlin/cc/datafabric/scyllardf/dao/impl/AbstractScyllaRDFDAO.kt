package cc.datafabric.scyllardf.dao.impl

import com.datastax.driver.core.BoundStatement
import com.datastax.driver.core.ResultSet
import com.datastax.driver.core.ResultSetFuture
import com.datastax.driver.core.Row
import com.google.common.util.concurrent.ListenableFuture
import com.google.common.util.concurrent.Uninterruptibles
import java.nio.ByteBuffer

internal abstract class AbstractScyllaRDFDAO {

    protected fun setBytesUnsafe(bound: BoundStatement, vararg array: ByteBuffer): BoundStatement {
        array.forEachIndexed { index, it -> bound.setBytesUnsafe(index, it) }

        return bound
    }

    protected fun setBytesUnsafe(bound: BoundStatement, row: Row): BoundStatement {
        row.columnDefinitions.forEach {
            bound.setBytesUnsafe(it.name, row.getBytes(it.name))
        }

        return bound
    }

    protected fun waitUntilDoneAndClear(futures: MutableCollection<out ListenableFuture<*>>) {
        futures.forEach { Uninterruptibles.getUninterruptibly(it) }

        futures.clear()
    }

    protected fun waitUntilDone(vararg futures: ListenableFuture<*>) {
        futures.forEach { Uninterruptibles.getUninterruptibly(it) }
    }

    protected fun waitUntilDone(futures: Collection<ListenableFuture<*>>) {
        futures.forEach { Uninterruptibles.getUninterruptibly(it) }
    }

}