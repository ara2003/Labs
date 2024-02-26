package com.example.labs.prolog.expression

import com.example.labs.prolog.term.Term
import com.example.labs.prolog.term.True

data object TrueExpression : Expression {

	override fun match(expression: Expression) = True

	override fun solve(context: Expression.Context) = True

	override fun values(values: Map<String, Term>) = ResultExpression(values)
}