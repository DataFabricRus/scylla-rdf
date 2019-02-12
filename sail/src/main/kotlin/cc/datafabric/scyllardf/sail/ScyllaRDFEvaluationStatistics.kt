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
            val cardinality: Double
            if (isBound(sp.subjectVar)) {
                cardinality = if (isBound(sp.predicateVar)) {
                    if (isBound(sp.objectVar)) {
                        1.0
                    } else {
                        return dao.getCardinalitySP(
                            coder.encode(sp.subjectVar.value)!!,
                            coder.encode(sp.predicateVar.value)!!
                        )
                    }
                } else {
                    if (isBound(sp.objectVar)) {
                        //SO
                        return dao.getCardinalitySO(
                            coder.encode(sp.subjectVar.value)!!,
                            coder.encode(sp.objectVar.value)!!
                        )
                    } else {
                        //S
                        dao.getCardinalityS(coder.encode(sp.subjectVar.value)!!)
                    }
                }
            } else {
                if (isBound(sp.predicateVar)) {
                    cardinality = if (isBound(sp.objectVar)) {
                        //PO
                        dao.getCardinalityPO(
                            coder.encode(sp.predicateVar.value)!!,
                            coder.encode(sp.objectVar.value)!!
                        )
                    } else {
                        //P
                        dao.getCardinalityP(coder.encode(sp.predicateVar.value)!!)
                    }
                } else {
                    cardinality = if (isBound(sp.objectVar)) {
                        //O
                        dao.getCardinalityO(coder.encode(sp.objectVar.value)!!)
                    } else {
                        dao.getCardinalityC(coder.encode(sp.contextVar?.value))
                    }
                }
            }

            return cardinality
        }

        private fun isBound(v: Var?): Boolean {
            return v != null && v.hasValue()
        }

    }

}