package com.example.labs.prolog.machine

import com.example.labs.prolog.expression.Expression
import com.example.labs.prolog.statement.DataStatement
import com.example.labs.prolog.statement.GoalStatement
import com.example.labs.prolog.statement.Statement
import com.example.labs.prolog.term.False
import com.example.labs.prolog.term.PredicateResult
import com.example.labs.prolog.term.or

class PrologMachineBase : PrologMachine, Expression.Context {

	private val facts = mutableListOf<DataStatement>()

	override fun runStatement(statement: Statement): PredicateResult {
		return when(statement) {
			is DataStatement -> {
				facts.add(statement)
				False
			}

			is GoalStatement -> {
				solve(statement.expression)
			}
		}
	}

	override fun solve(expression: Expression): PredicateResult =
		facts.map { it.solve(this, expression) }.fold(False, PredicateResult::or)
}
