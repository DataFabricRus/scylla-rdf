package cc.datafabric.scyllardf.dao

import cc.datafabric.scyllardf.TestUtils.createResultSetFuture
import com.datastax.driver.core.ResultSet
import com.datastax.driver.core.ResultSetFuture
import com.datastax.driver.core.Row
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.mockito.ArgumentMatchers.anyInt
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class TransformResultSetFutureIterationTest {

    @Test
    fun testEmpty() {
        val future = createResultSetFuture(emptyArray())
        val transformIter = TransformRowIteration(future
        ) { it.getString(0) }

        assertFalse(transformIter.hasNext())
        assertThrows<NoSuchElementException> { transformIter.next() }
    }

    @Test
    fun testWithoutFilter() {
        val future = createResultSetFuture(arrayOf("urn:graphs:1", "default"))
        val transformIter = TransformRowIteration(future
        ) { it.getString(0) }

        assertTrue(transformIter.hasNext())
        assertEquals("urn:graphs:1", transformIter.next())

        assertTrue(transformIter.hasNext())
        assertEquals("default", transformIter.next())

        assertFalse(transformIter.hasNext())
        assertThrows<NoSuchElementException> { transformIter.next() }
    }

    @Test
    fun testWithFilterNonEmptyResult() {
        val future1 = createResultSetFuture(arrayOf("urn:graphs:1", "default"))
        val transformIter1 = TransformRowIteration(future1,
            { it.getString(0) }, { it != "default" })

        assertTrue(transformIter1.hasNext())
        assertEquals("urn:graphs:1", transformIter1.next())

        assertFalse(transformIter1.hasNext())
        assertThrows<NoSuchElementException> { transformIter1.next() }

        val future2 = createResultSetFuture(arrayOf("default", "urn:graphs:1"))
        val transformIter2 = TransformRowIteration(future2,
            { it.getString(0) }, { it != "default" })

        assertTrue(transformIter2.hasNext())
        assertEquals("urn:graphs:1", transformIter2.next())

        assertFalse(transformIter2.hasNext())
        assertThrows<NoSuchElementException> { transformIter2.next() }
    }

    @Test
    fun testWithFilterEmptyResult() {
        val future = createResultSetFuture(arrayOf("default"))
        val transformIter = TransformRowIteration(future,
            { it.getString(0) }, { it != "default" })

        assertFalse(transformIter.hasNext())
        assertThrows<NoSuchElementException> { transformIter.next() }
    }

}