package cc.datafabric.scyllardf.dao

interface ScyllaRDFSchema {

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

        NS
    }

    enum class Index {
        S_POC_INDEX_C,
        P_OSC_INDEX_C,
        O_SPC_INDEX_C
    }

}