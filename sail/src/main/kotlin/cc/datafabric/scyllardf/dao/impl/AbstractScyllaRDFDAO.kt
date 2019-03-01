package cc.datafabric.scyllardf.dao.impl

import com.datastax.driver.core.BoundStatement
import java.nio.ByteBuffer

internal abstract class AbstractScyllaRDFDAO {

    protected fun setBytesUnsafe(bound: BoundStatement, vararg array: ByteBuffer): BoundStatement {
        array.forEachIndexed { index, it -> bound.setBytesUnsafe(index, it) }

        return bound
    }

}