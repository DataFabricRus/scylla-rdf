package cc.datafabric.scyllardf.dao

import java.nio.ByteBuffer

interface ICardinalityDAO {

    fun getCardinalityC(context: ByteBuffer?): Double

    fun getCardinalityS(subj: ByteBuffer): Double

    fun getCardinalityP(pred: ByteBuffer): Double

    fun getCardinalityO(obj: ByteBuffer): Double

    fun getCardinalitySP(subj: ByteBuffer, pred: ByteBuffer): Double

    fun getCardinalitySO(subj: ByteBuffer, obj: ByteBuffer): Double

    fun getCardinalityPO(pred: ByteBuffer, obj: ByteBuffer): Double

}