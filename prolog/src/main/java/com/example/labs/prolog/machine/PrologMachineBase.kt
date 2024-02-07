package com.example.labs.prolog.machine

import com.example.labs.prolog.expression.Expression
import com.example.labs.prolog.statement.DataStatement
import com.example.labs.prolog.statement.False
import com.example.labs.prolog.statement.GoalStatement
import com.example.labs.prolog.statement.PredicateResult
import com.example.labs.prolog.statement.Statement

class PrologMachineBase : PrologMachine, Expression.Context {

	private val facts = mutableListOf<DataStatement>()

	override fun runStatement(statement: Statement) {
		when(statement) {
			is DataStatement -> facts.add(statement)
			is GoalStatement -> {
				val a = statement.expression.solve(this)
				println("$statement = $a")
			}
		}
	}

	override fun solve(expression: Expression) =
		facts.map { it.solve(this, expression) }.fold(False, PredicateResult::or)
}
