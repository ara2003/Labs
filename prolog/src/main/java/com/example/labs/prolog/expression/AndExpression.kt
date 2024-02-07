package com.example.labs.prolog.expression

data class AndExpression(
	val first: Expression,
	val second: Expression,
) : Expression {

	override fun solve(context: Expression.Context) =
		first.solve(context) and second.solve(context)

	override fun values(values: Map<String, String>) = AndExpression(first.values(values), second.values(values))
}