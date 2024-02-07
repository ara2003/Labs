package com.example.labs.prolog.expression

import com.example.labs.prolog.statement.PredicateResult

sealed interface Expression {

	fun solve(context: Context): PredicateResult

	fun values(values: Map<String, String>): Expression

	interface Context {

		fun solve(expression: Expression): PredicateResult
	}
}