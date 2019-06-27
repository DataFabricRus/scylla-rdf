package cc.datafabric.scyllardf.dao

import java.nio.ByteBuffer

object ScyllaRDFSchema {

    enum class Table {
        S_POC,
        P_OSC,
        O_SPC,
        CS_PO,
        CP_OS,
        CO_SP,

        CARD_C,
        CARD_P,
        CARD_PO,

        NS,

        CODER_KNOWN_VOCABULARIES
    }

    const val CARD_PO_NUM_BUCKETS = 16

    const val EMPTY_PREFIX = "\u0000"

    val CONTEXT_DEFAULT = ByteBuffer.wrap(byteArrayOf(0))!!

}