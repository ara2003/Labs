package com.example.labs.prolog.expression

import com.example.labs.prolog.statement.True

data object TrueExpression : Expression {

	override fun solve(context: Expression.Context) = True(listOf(mapOf()))

	override fun values(values: Map<String, String>) = TrueExpression
}