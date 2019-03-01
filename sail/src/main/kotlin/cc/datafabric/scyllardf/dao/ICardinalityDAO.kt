package cc.datafabric.scyllardf.dao

import com.datastax.driver.core.ResultSetFuture
import java.nio.ByteBuffer

interface ICardinalityDAO {

    fun withCache(): ICardinalityDAO

    fun numTriples(): Long

    fun contextCardinality(context: ByteBuffer?): Long

    fun subjectCardinality(subj: ByteBuffer): Long

    fun predicateCardinality(pred: ByteBuffer): Long

    fun objectCardinality(obj: ByteBuffer): Long

    fun objectAndPredicateCardinality(pred: ByteBuffer, obj: ByteBuffer): Long

    fun incrementCardC(context: ByteBuffer, add: Long): ResultSetFuture

    fun incrementCardP(pred: ByteBuffer, add: Long): ResultSetFuture

    fun incrementCardPO(pred: ByteBuffer, obj: ByteBuffer, add: Long): ResultSetFuture

    fun incrementCards(subj: ByteBuffer, pred: ByteBuffer, obj: ByteBuffer, context: ByteBuffer?): List<ResultSetFuture>

    fun incrementCards(subj: ByteBuffer, pred: ByteBuffer, obj: ByteBuffer, contexts: List<ByteBuffer?>)
        : List<ResultSetFuture>

    fun decrementCards(subj: ByteBuffer, pred: ByteBuffer, obj: ByteBuffer, context: ByteBuffer?): List<ResultSetFuture>

    fun decrementCards(subj: ByteBuffer, pred: ByteBuffer, obj: ByteBuffer, contexts: List<ByteBuffer?>)
        : List<ResultSetFuture>
}