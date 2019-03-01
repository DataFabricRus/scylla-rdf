package cc.datafabric.scyllardf.dao.impl

import java.rmi.server.RMISocketFactory
import javax.management.JMX
import javax.management.MBeanServerConnection
import javax.management.MalformedObjectNameException
import javax.management.ObjectName
import javax.management.remote.JMXConnector
import javax.management.remote.JMXConnectorFactory
import javax.management.remote.JMXServiceURL


class ScyllaJMXDAO private constructor(private val host: String) {

    companion object {
        private const val URL_FORMAT = "service:jmx:rmi:///jndi/rmi://[%s]:%d/jmxrmi"
        private const val DEFAULT_PORT = 7199
        private const val METRIC_ESTIMATED_PARTITION_COUNT = "EstimatedPartitionCount"

        fun create(host: String): ScyllaJMXDAO {
            val dao = ScyllaJMXDAO(host)
            dao.init()
            return dao
        }
    }

    private lateinit var jmxConnector: JMXConnector
    private lateinit var mbeanServerConn: MBeanServerConnection

    private fun init() {
        val jmxUrl = JMXServiceURL(String.format(URL_FORMAT, host, DEFAULT_PORT))

        val env = mutableMapOf<String, Any>()
        env["com.sun.jndi.rmi.factory.socket"] = RMISocketFactory.getDefaultSocketFactory()

        jmxConnector = JMXConnectorFactory.connect(jmxUrl, env)
        mbeanServerConn = jmxConnector.mBeanServerConnection
    }

    fun getNumberOfPartitions(keyspace: String, tableName: String): Long {
        try {
            val type = if (tableName.contains(".")) "IndexTable" else "Table"
            val oName = ObjectName(String.format(
                "org.apache.cassandra.metrics:type=%s,keyspace=%s,scope=%s,name=%s",
                type, keyspace, tableName, METRIC_ESTIMATED_PARTITION_COUNT)
            )

            val obj = JMX.newMBeanProxy(mbeanServerConn, oName, JmxGaugeMBean::class.java).value
            if (obj == -1L) {
                return 0
            }

            return obj as Long
        } catch (e: MalformedObjectNameException) {
            throw RuntimeException(e)
        }

    }

    private interface MetricMBean {
        fun objectName(): ObjectName
    }

    private interface JmxGaugeMBean : MetricMBean {
        val value: Any
    }

}