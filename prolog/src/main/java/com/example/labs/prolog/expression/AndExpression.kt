package com.example.labs.prolog.expression

import com.example.labs.prolog.term.PredicateResult
import com.example.labs.prolog.term.Term
import com.example.labs.prolog.term.and

data class AndExpression(
	val first: Expression,
	val second: Expression,
) : Expression {

	override fun match(expression: Expression): PredicateResult {
		TODO("Not yet implemented $this $expression")
	}

	override fun solve(context: Expression.Context) =
		first.solve(context) and second.solve(context)

	override fun values(values: Map<String, Term>) = AndExpression(first.values(values), second.values(values))
}