package cc.datafabric.scyllardf

import com.datastax.driver.core.ResultSet
import com.datastax.driver.core.ResultSetFuture
import com.datastax.driver.core.Row
import org.mockito.ArgumentMatchers
import org.mockito.Mockito

object TestUtils {
    fun createResultSetFuture(elements: Array<String>): ResultSetFuture {
        val list = mutableListOf<Row>()
        elements.forEach {
            val row = Mockito.mock(Row::class.java)
            Mockito.`when`(row.getString(ArgumentMatchers.anyInt())).thenReturn(it)
            list.add(row)
        }

        val iterator: MutableIterator<Row> = list.iterator() as MutableIterator<Row>

        val future = Mockito.mock(ResultSetFuture::class.java)
        val resultSet = Mockito.mock(ResultSet::class.java)
        Mockito.`when`(resultSet.iterator()).thenReturn(iterator)

        Mockito.`when`(future.get()).thenReturn(resultSet)
        Mockito.`when`(future.uninterruptibly).thenReturn(resultSet)
        Mockito.`when`(future.cancel(true)).thenReturn(true)

        return future
    }
}