package cc.datafabric.scyllardf.model.impl

import cc.datafabric.scyllardf.coder.ICoder
import org.eclipse.rdf4j.model.IRI
import org.eclipse.rdf4j.model.Literal
import org.eclipse.rdf4j.model.impl.SimpleLiteral
import java.math.BigDecimal
import java.math.BigInteger
import java.nio.ByteBuffer
import java.util.Optional
import javax.xml.datatype.XMLGregorianCalendar

internal class EncodedLiteral constructor(
    private val coder: ICoder<Literal>,
    private val hash: ByteBuffer
) : Literal {

    private var decodedLiteral: Literal? = null

    private fun decodeIfNeeded() {
        if (decodedLiteral == null) {
            synchronized(this) {
                if (decodedLiteral == null) {
                    decodedLiteral = coder.decode(hash)
                }
            }
        }
    }

    override fun stringValue(): String {
        decodeIfNeeded()

        return decodedLiteral!!.stringValue()
    }

    override fun getLabel(): String {
        decodeIfNeeded()

        return decodedLiteral!!.label
    }

    override fun getDatatype(): IRI {
        decodeIfNeeded()

        return decodedLiteral!!.datatype
    }

    override fun byteValue(): Byte {
        decodeIfNeeded()

        return decodedLiteral!!.byteValue()
    }

    override fun booleanValue(): Boolean {
        decodeIfNeeded()

        return decodedLiteral!!.booleanValue()
    }

    override fun shortValue(): Short {
        decodeIfNeeded()

        return decodedLiteral!!.shortValue()
    }

    override fun intValue(): Int {
        decodeIfNeeded()

        return decodedLiteral!!.intValue()
    }

    override fun calendarValue(): XMLGregorianCalendar {
        decodeIfNeeded()

        return decodedLiteral!!.calendarValue()
    }

    override fun integerValue(): BigInteger {
        decodeIfNeeded()

        return decodedLiteral!!.integerValue()
    }

    override fun doubleValue(): Double {
        decodeIfNeeded()

        return decodedLiteral!!.doubleValue()
    }

    override fun decimalValue(): BigDecimal {
        decodeIfNeeded()

        return decodedLiteral!!.decimalValue()
    }

    override fun floatValue(): Float {
        decodeIfNeeded()

        return decodedLiteral!!.floatValue()
    }

    override fun longValue(): Long {
        decodeIfNeeded()

        return decodedLiteral!!.longValue()
    }

    override fun getLanguage(): Optional<String> {
        decodeIfNeeded()

        return decodedLiteral!!.language
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        if (other is EncodedLiteral) {
            return this.hash == other.hash
        }
        if (other is SimpleLiteral) {
            decodeIfNeeded()

            return this.decodedLiteral == other
        }

        return false
    }

    override fun hashCode(): Int {
        return hash.hashCode()
    }

}