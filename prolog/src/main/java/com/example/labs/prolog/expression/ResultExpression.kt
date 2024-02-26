package com.example.labs.prolog.expression

import com.example.labs.prolog.term.PredicateResult
import com.example.labs.prolog.term.Term

data class ResultExpression(
	val result: PredicateResult,
) : Expression {

	override fun match(expression: Expression): PredicateResult {
		TODO("Not yet implemented $this $expression")
	}

	constructor(values: Map<String, Term>) : this(listOf(values))

	override fun solve(context: Expression.Context) = result

	override fun values(values: Map<String, Term>) = TODO()//AndExpression(this, ResultExpression(values))
}
