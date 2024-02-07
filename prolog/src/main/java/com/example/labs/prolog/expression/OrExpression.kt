package com.example.labs.prolog.expression

data class OrExpression(
	val first: Expression,
	val second: Expression,
) : Expression {

	override fun solve(context: Expression.Context) =
		first.solve(context) or second.solve(context)

	override fun values(values: Map<String, String>) = OrExpression(first.values(values), second.values(values))
}