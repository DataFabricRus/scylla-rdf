package cc.datafabric.scyllardf.sail

import org.eclipse.rdf4j.query.BindingSet
import org.eclipse.rdf4j.query.Dataset
import org.eclipse.rdf4j.query.algebra.BindingSetAssignment
import org.eclipse.rdf4j.query.algebra.Extension
import org.eclipse.rdf4j.query.algebra.Join
import org.eclipse.rdf4j.query.algebra.TupleExpr
import org.eclipse.rdf4j.query.algebra.evaluation.QueryOptimizer
import org.eclipse.rdf4j.query.algebra.evaluation.impl.QueryJoinOptimizer
import org.eclipse.rdf4j.query.algebra.helpers.AbstractQueryModelVisitor

/**
 * Makes sure that [BindingSetAssignment] is lower than [Extension] before entering [QueryJoinOptimizer],
 * otherwise it makes query suboptimal by putting [BindingSetAssignment] on the right side of the join.
 *
 * In example, the following snippet:
 *
 *  <pre>
 *  {@code
 *      Join
 *          BindingSetAssignment(...)
 *          Extension
 *              ExtensionElem (...)
 *                  Var (name=...)
 *  }
 *  </pre>
 *
 * should be rewritten to:
 *
 *  <pre>
 *  {@code
 *      Extension
 *          ExtensionElem (...)
 *              Var (name=...)
 *      Join
 *          BindingSetAssignment(...)
 *  }
 *  </pre>
 *
 * @author Maxim Kolchin (kolchinmax@gmail.com)
 * @see [RDF4J-1229](https://github.com/eclipse/rdf4j/issues/1229)
 */
class PushBindingSetAssignmentUnderExtensionOptimizer : QueryOptimizer {
    override fun optimize(tupleExpr: TupleExpr, dataset: Dataset?, bindings: BindingSet) {
        tupleExpr.visit(JoinWithBSAAndExtensionVisitor())
    }

    private inner class JoinWithBSAAndExtensionVisitor : AbstractQueryModelVisitor<RuntimeException>() {

        @Throws(RuntimeException::class)
        override fun meet(node: Join) {
            super.meet(node)

            val leftArg = node.leftArg
            val rightArg = node.rightArg

            var bindingSet: BindingSetAssignment? = null
            var extension: Extension? = null
            if (leftArg is BindingSetAssignment && rightArg is Extension) {
                bindingSet = leftArg
                extension = rightArg
            } else if (leftArg is Extension && rightArg is BindingSetAssignment) {
                extension = leftArg
                bindingSet = rightArg
            }

            if (bindingSet != null && extension != null) {
                val newJoin = Join(bindingSet, extension.arg.clone())

                extension.arg.replaceWith(newJoin)

                node.replaceWith(extension)
            }
        }
    }
}
