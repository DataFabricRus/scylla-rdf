package cc.datafabric.scyllardf.sail

import cc.datafabric.scyllardf.coder.ICoderFacade
import cc.datafabric.scyllardf.dao.ICardinalityDAO
import org.eclipse.rdf4j.query.algebra.StatementPattern
import org.eclipse.rdf4j.query.algebra.Var
import org.eclipse.rdf4j.query.algebra.evaluation.impl.EvaluationStatistics

class ScyllaRDFEvaluationStatistics(private val dao: ICardinalityDAO, private val coder: ICoderFacade)
    : EvaluationStatistics() {

    override fun createCardinalityCalculator(): CardinalityCalculator {
        return ScyllaRDFCardinalityCalculator(dao, coder)
    }

    private class ScyllaRDFCardinalityCalculator(private val dao: ICardinalityDAO, private val coder: ICoderFacade)
        : CardinalityCalculator() {

        override fun getCardinality(sp: StatementPattern): Double {
            return if (isBound(sp.subjectVar) && isBound(sp.predicateVar) && isBound(sp.objectVar)) {
                0.0
            } else {
                getSubjectCardinality(sp) * getPredicateCardinality(sp) * getObjectCardinality(sp)
            }
        }

        override fun getSubjectCardinality(v: Var?): Double {
            return if (isBound(v)) {
                dao.subjectCardinality(coder.encode(v!!.value)!!).div(dao.numTriples().toDouble())
            } else {
                1.0
            }
        }

        override fun getPredicateCardinality(v: Var?): Double {
            return if (isBound(v)) {
                dao.predicateCardinality(coder.encode(v!!.value)!!).div(dao.numTriples().toDouble())
            } else {
                1.0
            }
        }

        override fun getObjectCardinality(v: Var?): Double {
            return if (isBound(v)) {
                dao.objectCardinality(coder.encode(v!!.value)!!).div(dao.numTriples().toDouble())
            } else {
                1.0
            }
        }

        override fun getObjectCardinality(sp: StatementPattern): Double {
            return if (isBound(sp.predicateVar) && isBound(sp.objectVar)) {
                dao.objectAndPredicateCardinality(
                    coder.encode(sp.predicateVar.value)!!,
                    coder.encode(sp.objectVar.value)!!
                ).div(dao.numTriples().toDouble())
            } else if (isBound(sp.objectVar)) {
                getObjectCardinality(sp.objectVar)
            } else {
                1.0
            }
        }

        private fun isBound(v: Var?): Boolean {
            return v != null && v.hasValue()
        }

    }

}