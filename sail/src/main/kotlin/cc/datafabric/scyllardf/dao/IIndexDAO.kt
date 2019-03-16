package cc.datafabric.scyllardf.dao

import com.datastax.driver.core.ResultSetFuture
import org.eclipse.rdf4j.common.iteration.CloseableIteration
import org.eclipse.rdf4j.sail.SailException
import java.nio.ByteBuffer

interface IIndexDAO {
    fun insertInSPOC(subj: ByteBuffer, pred: ByteBuffer, obj: ByteBuffer, context: ByteBuffer): ResultSetFuture
    fun insertInPOSC(subj: ByteBuffer, pred: ByteBuffer, obj: ByteBuffer, context: ByteBuffer): ResultSetFuture
    fun insertInOSPC(subj: ByteBuffer, pred: ByteBuffer, obj: ByteBuffer, context: ByteBuffer): ResultSetFuture
    fun insertInCSPO(subj: ByteBuffer, pred: ByteBuffer, obj: ByteBuffer, context: ByteBuffer): ResultSetFuture
    fun insertInCPOS(subj: ByteBuffer, pred: ByteBuffer, obj: ByteBuffer, context: ByteBuffer): ResultSetFuture
    fun insertInCOSP(subj: ByteBuffer, pred: ByteBuffer, obj: ByteBuffer, context: ByteBuffer): ResultSetFuture
    fun getContextIDs(): CloseableIteration<ByteBuffer, SailException>
    fun clearContext(context: ByteBuffer?)
    fun getNamespaces(): CloseableIteration<Array<String>, SailException>
    fun getNamespace(prefix: String): String?
    fun setNamespace(prefix: String, name: String)
    fun clearNamespaces()
    fun removeNamespace(prefix: String)
    fun addStatement(subj: ByteBuffer, pred: ByteBuffer, obj: ByteBuffer)
    fun addStatement(subj: ByteBuffer, pred: ByteBuffer, obj: ByteBuffer, contexts: List<ByteBuffer?>)
    fun removeStatements(subj: ByteBuffer, pred: ByteBuffer, obj: ByteBuffer, contexts: List<ByteBuffer?>)
    fun getStatements(subj: ByteBuffer?, pred: ByteBuffer?, obj: ByteBuffer?, context: ByteBuffer?): SPOCIteration
    fun getStatements(subj: ByteBuffer?, pred: ByteBuffer?, obj: ByteBuffer?, contexts: List<ByteBuffer?>): SPOCIteration
}