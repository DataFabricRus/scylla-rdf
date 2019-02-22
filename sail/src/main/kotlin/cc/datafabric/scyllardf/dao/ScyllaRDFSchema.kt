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

        STAT_C,
        STAT_S,
        STAT_P,
        STAT_O,
        STAT_SP,
        STAT_PO,
        STAT_SO,

        NS,

        CODER_KNOWN_VOCABULARIES
    }

    val CONTEXT_DEFAULT = ByteBuffer.wrap(byteArrayOf(0))!!

}