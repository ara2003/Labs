package com.example.labs.prolog.expression

import com.example.labs.prolog.term.PredicateResult
import com.example.labs.prolog.term.Term
import com.example.labs.prolog.term.or

data class OrExpression(
	val first: Expression,
	val second: Expression,
) : Expression {

	override fun match(expression: Expression): PredicateResult {
		TODO("Not yet implemented $this $expression")
	}

	override fun solve(context: Expression.Context) =
		first.solve(context) or second.solve(context)

	override fun values(values: Map<String, Term>) = OrExpression(first.values(values), second.values(values))
}