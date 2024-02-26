package com.example.labs.prolog.statement

import com.example.labs.prolog.expression.Expression
import com.example.labs.prolog.term.PredicateResult

interface DataStatement : Statement {

	fun solve(context: Expression.Context, expression: Expression): PredicateResult
}