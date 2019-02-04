package cc.datafabric.scyllardf.coder

import org.eclipse.rdf4j.model.Value
import java.nio.ByteBuffer

internal interface ICoder<T : Value> {

    fun encode(value: T?): ByteBuffer?

    fun decode(hash: ByteBuffer): T

}