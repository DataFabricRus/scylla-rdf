package cc.datafabric.scyllardf.coder

import cc.datafabric.scyllardf.dao.SPOCIteration
import org.eclipse.rdf4j.common.iteration.CloseableIteration
import org.eclipse.rdf4j.model.BNode
import org.eclipse.rdf4j.model.IRI
import org.eclipse.rdf4j.model.Literal
import org.eclipse.rdf4j.model.Namespace
import org.eclipse.rdf4j.model.Resource
import org.eclipse.rdf4j.model.Statement
import org.eclipse.rdf4j.model.Value
import org.eclipse.rdf4j.sail.SailException
import java.nio.ByteBuffer

interface ICoderFacade {

    fun encode(values: Array<out Resource?>): List<ByteBuffer?>

    fun encode(value: Resource?): ByteBuffer?

    fun encode(value: Value?): ByteBuffer?

    fun encode(value: IRI?): ByteBuffer?

    fun encode(value: BNode): ByteBuffer

    fun encode(value: Literal): ByteBuffer

    fun encode(stmt: Statement): Array<ByteBuffer>

    fun decode(hash: ByteBuffer): Value

    fun decode(spoc: Array<ByteBuffer>): Statement

    fun toStatementIteration(origin: SPOCIteration): CloseableIteration<Statement, SailException>

    fun toResourceIteration(origin: CloseableIteration<ByteBuffer, SailException>)
        : CloseableIteration<out Resource, SailException>

    fun toNamespaceIteration(origin: CloseableIteration<Array<String>, SailException>)
        : CloseableIteration<Namespace, SailException>

}