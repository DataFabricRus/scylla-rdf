package cc.datafabric.scyllardf.dao

import cc.datafabric.scyllardf.TestUtils.createResultSetFuture
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class MultipleResultSetFutureIterationTest {

    @Test
    fun testEmpty() {
        val iteration = MultipleResultSetFutureIteration(emptyList())

        assertFalse(iteration.hasNext())
        assertThrows<NoSuchElementException> { iteration.next() }
    }

    @Test
    fun testNonEmpty() {
        val iteration = MultipleResultSetFutureIteration(arrayListOf(
                createResultSetFuture(arrayOf("1", "2")),
                createResultSetFuture(arrayOf("3", "4"))
        ))

        assertTrue { iteration.hasNext() }
        assertEquals("1", iteration.next().getString(0))

        assertTrue { iteration.hasNext() }
        assertEquals("2", iteration.next().getString(0))

        assertTrue { iteration.hasNext() }
        assertEquals("3", iteration.next().getString(0))

        assertTrue { iteration.hasNext() }
        assertEquals("4", iteration.next().getString(0))

        assertFalse(iteration.hasNext())
        assertThrows<NoSuchElementException> { iteration.next() }
    }

}