package cc.datafabric.scyllardf.sail

import cc.datafabric.scyllardf.dao.Coder
import cc.datafabric.scyllardf.dao.ScyllaRDFDAO
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

class ScyllaRDFSailConnection(private val sail: ScyllaRDFSail, private val dao: ScyllaRDFDAO)
    : NotifyingSailConnectionBase(sail) {

    companion object {
        private val LOG = LoggerFactory.getLogger(ScyllaRDFSailConnection::class.java)
        private val VF = SimpleValueFactory.getInstance()
    }

    private val tripleSource = SailTripleSource(this, false, VF)

    override fun removeNamespaceInternal(prefix: String) {
        dao.removeNamespace(prefix)
    }

    override fun setNamespaceInternal(prefix: String?, name: String?) {
        if (prefix != null && name != null) {
            dao.setNamespace(prefix, name)
        }
    }

    override fun getNamespaceInternal(prefix: String?): String? {
        if (prefix == null) {
            throw SailException("There is no namespace with the given prefix!")
        }

        return dao.getNamespace(prefix)
    }

    override fun getNamespacesInternal(): CloseableIteration<out Namespace, SailException> {
        return Coder.toNamespaceIteration(dao.getNamespaces())
    }

    override fun clearNamespacesInternal() {
        dao.clearNamespaces()
    }

    override fun getContextIDsInternal(): CloseableIteration<out Resource, SailException> {
        return Coder.toResourceIteration(dao.getContextIDs())
    }

    override fun addStatementInternal(subj: Resource, pred: IRI, obj: Value, vararg contexts: Resource?) {
        if (contexts.isNullOrEmpty() || (contexts.size == 1 && contexts[0] == null)) {
            dao.addStatement(Coder.encode(subj)!!, Coder.encode(pred)!!, Coder.encode(obj)!!)
        } else {
            dao.addStatement(Coder.encode(subj)!!, Coder.encode(pred)!!, Coder.encode(obj)!!, Coder.encode(contexts))
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

        if (contexts.isNullOrEmpty() || (contexts.size == 1 && contexts[0] == null)) {
            dao.removeStatements(Coder.encode(subj)!!, Coder.encode(pred)!!, Coder.encode(obj)!!, listOf(null))
        } else {
            dao.removeStatements(Coder.encode(subj)!!, Coder.encode(pred)!!, Coder.encode(obj)!!, Coder.encode(contexts))
        }
    }

    override fun getStatementsInternal(
        subj: Resource?, pred: IRI?, obj: Value?, includeInferred: Boolean, vararg contexts: Resource?
    ): CloseableIteration<out Statement, SailException> {
        if (contexts.isNullOrEmpty() || (contexts.size == 1 && contexts[0] == null)) {
            return Coder.toStatementIteration(
                dao.getStatements(Coder.encode(subj), Coder.encode(pred), Coder.encode(obj), null))
        } else {
            return Coder.toStatementIteration(
                dao.getStatements(Coder.encode(subj), Coder.encode(pred), Coder.encode(obj), Coder.encode(contexts)))
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
        val statistics = EvaluationStatistics()

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
            dao.countTotalTriples()
        } else {
            dao.countTriplesInGraphs(contexts.filterNotNull())
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