package com.example.labs.prolog.expression

import com.example.labs.prolog.size
import com.example.labs.prolog.term.False
import com.example.labs.prolog.term.PredicateResult
import com.example.labs.prolog.term.Term
import com.example.labs.prolog.term.foldAnd

data class PredicateExpression(
	val predicateName: String,
	val arguments: Iterable<Term>,
) : Expression {

	override fun match(expression: Expression): PredicateResult {
		if(expression is PredicateExpression) {
			if(expression.predicateName != predicateName)
				return False
			val a = arguments
			val b = expression.arguments
			if(a.size != b.size)
				return False
			return a.zip(b) { a, b ->
				a.match(b)
			}.foldAnd()
		}
		return False
	}

	override fun solve(context: Expression.Context) = context.solve(this)

	override fun values(values: Map<String, Term>) =
		PredicateExpression(predicateName, arguments.map { it.values(values) })

	//	override fun solve(context: Expression.Context, expression: Expression): PredicateResult {
//		return when(expression) {
//			is PredicateExpression -> {
//				if(predicateName != expression.predicateName)
//					return False
//				val a = arguments
//				val b = expression.arguments
//
//				if(a.size != b.size)
//					return False
//				val result = mutableMapOf<String, String>()
//				a.zip(b).forEach { (f, q) ->
//					if(f.isQ)
//						if(q.isQ) {
//						} else {
//						}
//					else
//						if(q.isQ) {
//							result[q] = f
//						} else {
//							if(f != q)
//								return False
//						}
//				}
//				return True(listOf(result))
//			}
//
//			TrueExpression -> TODO()
//			is AndExpression -> TODO()
//		}
//	}
	override fun toString() = "$predicateName(${arguments.joinToString(", ") { it.toString() }})"
}
