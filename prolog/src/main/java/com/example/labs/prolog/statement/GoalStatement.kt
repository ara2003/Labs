package com.example.labs.prolog.statement

import com.example.labs.prolog.expression.Expression

data class GoalStatement(
	val expression: Expression,
) : Statement {

	override fun toString() = "?- $expression."
}
