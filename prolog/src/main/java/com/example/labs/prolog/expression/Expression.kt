package com.example.labs.prolog.expression

import com.example.labs.prolog.term.PredicateResult
import com.example.labs.prolog.term.Term
import com.example.labs.prolog.term.foldOr

sealed interface Expression {

	fun match(expression: Expression): PredicateResult

	fun solve(context: Context): PredicateResult

	fun values(values: Map<String, Term>): Expression

	interface Context {

		fun solve(expression: Expression): PredicateResult
	}
}

fun Expression.match(values: Iterable<Expression>) = values.map { match(it) }.foldOr()
fun Expression.values(values: Iterable<Map<String, Term>>) = values.map { values(it) }

fun Iterable<Expression>.values(values: Iterable<Map<String, Term>>) = flatMap { it.values(values) }

fun Expression.values(context: Expression.Context, values: PredicateResult) =
	values.map { values(it).solve(context) }.foldOr()