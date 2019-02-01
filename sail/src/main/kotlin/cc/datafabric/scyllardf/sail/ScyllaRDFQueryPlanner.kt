package cc.datafabric.scyllardf.sail

import org.eclipse.rdf4j.query.BindingSet
import org.eclipse.rdf4j.query.Dataset
import org.eclipse.rdf4j.query.algebra.TupleExpr
import org.eclipse.rdf4j.query.algebra.evaluation.EvaluationStrategy
import org.eclipse.rdf4j.query.algebra.evaluation.QueryOptimizer
import org.eclipse.rdf4j.query.algebra.evaluation.impl.BindingAssigner
import org.eclipse.rdf4j.query.algebra.evaluation.impl.CompareOptimizer
import org.eclipse.rdf4j.query.algebra.evaluation.impl.ConjunctiveConstraintSplitter
import org.eclipse.rdf4j.query.algebra.evaluation.impl.ConstantOptimizer
import org.eclipse.rdf4j.query.algebra.evaluation.impl.DisjunctiveConstraintOptimizer
import org.eclipse.rdf4j.query.algebra.evaluation.impl.EvaluationStatistics
import org.eclipse.rdf4j.query.algebra.evaluation.impl.FilterOptimizer
import org.eclipse.rdf4j.query.algebra.evaluation.impl.IterativeEvaluationOptimizer
import org.eclipse.rdf4j.query.algebra.evaluation.impl.OrderLimitOptimizer
import org.eclipse.rdf4j.query.algebra.evaluation.impl.QueryJoinOptimizer
import org.eclipse.rdf4j.query.algebra.evaluation.impl.QueryModelNormalizer
import org.eclipse.rdf4j.query.algebra.evaluation.impl.SameTermFilterOptimizer

class ScyllaRDFQueryPlanner(
    private val strategy: EvaluationStrategy, private val statistics: EvaluationStatistics
) : QueryOptimizer {

    override fun optimize(tupleExpr: TupleExpr, dataset: Dataset?, bindings: BindingSet) {
        BindingAssigner().optimize(tupleExpr, dataset, bindings)
        ConstantOptimizer(strategy).optimize(tupleExpr, dataset,
            bindings)
        CompareOptimizer().optimize(tupleExpr, dataset, bindings)
        ConjunctiveConstraintSplitter().optimize(tupleExpr, dataset,
            bindings)
        DisjunctiveConstraintOptimizer().optimize(tupleExpr, dataset,
            bindings)
        SameTermFilterOptimizer().optimize(tupleExpr, dataset,
            bindings)
        QueryModelNormalizer().optimize(tupleExpr, dataset, bindings)
        IterativeEvaluationOptimizer().optimize(tupleExpr, dataset,
            bindings)
        FilterOptimizer().optimize(tupleExpr, dataset, bindings)
        OrderLimitOptimizer().optimize(tupleExpr, dataset, bindings)

        PushBindingSetAssignmentUnderExtensionOptimizer().optimize(tupleExpr, dataset, bindings)

        QueryJoinOptimizer(statistics).optimize(tupleExpr, dataset, bindings)
    }
}