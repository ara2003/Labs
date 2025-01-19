package com.example.lab.expression

import com.example.lab.interpreter.InterpreterContext
import com.example.lab.statement.StatementContext

sealed interface AssignTarget : Expression {

	fun init(context: StatementContext, type: Expression.Type): Boolean
}

interface ListAssignTarget : ListExpression, AssignTarget {

	fun assign(context: InterpreterContext, value: List<Int>)
}

interface ElementAssignTarget : ElementExpression, AssignTarget {

	fun assign(context: InterpreterContext, value: Int)
}