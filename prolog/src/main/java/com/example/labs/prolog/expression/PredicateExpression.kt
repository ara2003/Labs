package com.example.labs.prolog.expression

val String.isQ
	get() = first().isUpperCase()

data class PredicateExpression(
	val predicateName: String,
	val arguments: Iterable<String>,
) : Expression {

	override fun solve(context: Expression.Context) = context.solve(this)

	override fun values(values: Map<String, String>) =
		PredicateExpression(predicateName, arguments.map { values[it] ?: it })
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
}
