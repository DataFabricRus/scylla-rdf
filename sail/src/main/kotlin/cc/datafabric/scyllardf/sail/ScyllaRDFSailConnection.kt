package cc.datafabric.scyllardf.sail

import cc.datafabric.scyllardf.dao.ICardinalityDAO
import cc.datafabric.scyllardf.dao.IIndexDAO
import org.eclipse.rdf4j.common.iteration.CloseableIteration
import org.eclipse.rdf4j.model.IRI
import org.eclipse.rdf4j.model.Namespace
import org.eclipse.rdf4j.model.Resource
import org.eclipse.rdf4j.model.Statement
import org.eclipse.rdf4j.model.Value
import org.eclipse.rdf4j.model.impl.SimpleValueFactory
import org.eclipse.rdf4j.query.BindingSet
import org.eclipse.rdf4j.query.Dataset
import org.eclipse.rdf4j.query.QueryEvaluationException
import org.eclipse.rdf4j.query.algebra.QueryRoot
import org.eclipse.rdf4j.query.algebra.TupleExpr
import org.eclipse.rdf4j.query.algebra.evaluation.impl.EvaluationStatistics
import org.eclipse.rdf4j.query.algebra.evaluation.impl.StrictEvaluationStrategyFactory
import org.eclipse.rdf4j.sail.SailException
import org.eclipse.rdf4j.sail.evaluation.SailTripleSource
import org.eclipse.rdf4j.sail.helpers.NotifyingSailConnectionBase
import org.slf4j.LoggerFactory

class ScyllaRDFSailConnection(
    private val sail: ScyllaRDFSail,
    private val indexDao: IIndexDAO,
    private val cardinalityDao: ICardinalityDAO,
    private val cardinalityEstimationEnabled: Boolean
) : NotifyingSailConnectionBase(sail) {

    companion object {
        private val LOG = LoggerFactory.getLogger(ScyllaRDFSailConnection::class.java)
        private val VF = SimpleValueFactory.getInstance()
    }

    private val tripleSource = SailTripleSource(this, false, VF)

    override fun removeNamespaceInternal(prefix: String) {
        indexDao.removeNamespace(prefix)
    }

    override fun setNamespaceInternal(prefix: String?, name: String?) {
        if (prefix != null && name != null) {
            indexDao.setNamespace(prefix, name)
        }
    }

    override fun getNamespaceInternal(prefix: String?): String? {
        if (prefix == null) {
            throw SailException("There is no namespace with the given prefix!")
        }

        return indexDao.getNamespace(prefix)
    }

    override fun getNamespacesInternal(): CloseableIteration<out Namespace, SailException> {
        return sail.getCoder().toNamespaceIteration(indexDao.getNamespaces())
    }

    override fun clearNamespacesInternal() {
        indexDao.clearNamespaces()
    }

    override fun getContextIDsInternal(): CloseableIteration<out Resource, SailException> {
        return sail.getCoder().toResourceIteration(indexDao.getContextIDs())
    }

    override fun addStatementInternal(subj: Resource, pred: IRI, obj: Value, vararg contexts: Resource?) {
        val s = sail.getCoder().encode(subj)!!
        val p = sail.getCoder().encode(pred)!!
        val o = sail.getCoder().encode(obj)!!

        if (contexts.isNullOrEmpty() || (contexts.size == 1 && contexts[0] == null)) {
            indexDao.addStatement(s, p, o)

            cardinalityDao.incrementCards(s, p, o, null)
        } else {
            val c = sail.getCoder().encode(contexts)

            indexDao.addStatement(s, p, o, c)

            cardinalityDao.incrementCards(s, p, o, c)
        }
    }

    override fun removeStatementsInternal(subj: Resource?, pred: IRI?, obj: Value?, vararg contexts: Resource?) {
        if (subj == null || pred == null || obj == null) {
            /**
             * It's not possible to remove by a partial BGP, because it's inefficient, e.g. remove *,P,*,* from CSPO.
             *
             * We may want to use materialized views to support this functionality.
             */
            throw SailException("All subject, predicate and object must be set!")
        }

        val s = sail.getCoder().encode(subj)!!
        val p = sail.getCoder().encode(pred)!!
        val o = sail.getCoder().encode(obj)!!

        if (contexts.isNullOrEmpty() || (contexts.size == 1 && contexts[0] == null)) {
            indexDao.removeStatements(s, p, o, listOf(null))

            cardinalityDao.decrementCards(s, p, o, null)
        } else {
            val c = sail.getCoder().encode(contexts)
            indexDao.removeStatements(s, p, o, c)

            cardinalityDao.decrementCards(s, p, o, c)
        }
    }

    override fun getStatementsInternal(
        subj: Resource?, pred: IRI?, obj: Value?, includeInferred: Boolean, vararg contexts: Resource?
    ): CloseableIteration<out Statement, SailException> {
        return if (contexts.isNullOrEmpty() || (contexts.size == 1 && contexts[0] == null)) {
            sail.getCoder().toStatementIteration(indexDao.getStatements(
                sail.getCoder().encode(subj),
                sail.getCoder().encode(pred),
                sail.getCoder().encode(obj),
                null
            ))
        } else {
            sail.getCoder().toStatementIteration(indexDao.getStatements(
                sail.getCoder().encode(subj),
                sail.getCoder().encode(pred),
                sail.getCoder().encode(obj),
                sail.getCoder().encode(contexts)
            ))
        }
    }

    override fun evaluateInternal(
        tupleExpr: TupleExpr, dataset: Dataset?, bindings: BindingSet, includeInferred: Boolean
    ): CloseableIteration<out BindingSet, QueryEvaluationException> {
        val expr = if (tupleExpr !is QueryRoot) {
            QueryRoot(tupleExpr);
        } else {
            tupleExpr
        }

        val strategy = StrictEvaluationStrategyFactory().createEvaluationStrategy(dataset, tripleSource)

        val statistics: EvaluationStatistics = if (cardinalityEstimationEnabled) {
            LOG.debug("The cardinality estimation is used!")

            ScyllaRDFEvaluationStatistics(cardinalityDao.withCache(), sail.getCoder())
        } else {
            EvaluationStatistics()
        }

        val queryPlanner = ScyllaRDFQueryPlanner(strategy, statistics)
        queryPlanner.optimize(expr, dataset, bindings)

        LOG.debug("Query: {}", expr)

        return strategy.evaluate(expr, bindings)
    }

    override fun pendingRemovals(): Boolean {
        return false
    }

    override fun sizeInternal(vararg contexts: Resource?): Long {
        return if (contexts.isNullOrEmpty() || contexts[0] == null) {
            cardinalityDao.numTriples()
        } else {
            contexts.filterNotNull()
                .stream()
                .map { cardinalityDao.contextCardinality(sail.getCoder().encode(it)) }
                .reduce { a: Long, b: Long -> a + b }
                .orElse(0)
        }
    }

    override fun clearInternal(vararg contexts: Resource?) {
        LOG.debug("closeInternal")
    }

    override fun startTransactionInternal() {
        LOG.debug("startTransactionInternal")
    }

    override fun commitInternal() {
        LOG.debug("commitInternal")
    }

    override fun rollbackInternal() {
        LOG.debug("rollbackInternal")
    }

    override fun closeInternal() {
        LOG.debug("closeInternal")
    }
}