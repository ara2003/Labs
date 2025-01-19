package com.example.lab.expression

import com.example.lab.expression.provider.ExpressionProvider
import com.example.lab.interpreter.InterpreterContext

sealed interface Expression {

	fun getTypeOrNull(context: ExpressionProvider.Context): Type?
	fun getType(context: ExpressionProvider.Context): Type =
		getTypeOrNull(context) ?: throw NullPointerException("$this has not type")

	fun runInterpreter(context: InterpreterContext)

	enum class Type {
		ELEMENT, LIST, UNIT, NOTHING;
	}
}

interface ElementExpression : Expression {

	override fun getTypeOrNull(context: ExpressionProvider.Context): Expression.Type? = Expression.Type.ELEMENT

	fun runElement(context: InterpreterContext): Int

	override fun runInterpreter(context: InterpreterContext) {
		runElement(context)
	}
}

interface ListExpression : Expression {

	override fun getTypeOrNull(context: ExpressionProvider.Context): Expression.Type? = Expression.Type.LIST

	fun runList(context: InterpreterContext): List<Int>

	override fun runInterpreter(context: InterpreterContext) {
		runList(context)
	}
}

interface UnitExpression : Expression {

	override fun getTypeOrNull(context: ExpressionProvider.Context): Expression.Type? = Expression.Type.UNIT

	fun runUnit(context: InterpreterContext)

	override fun runInterpreter(context: InterpreterContext) {
		runUnit(context)
	}
}

interface NothingExpression : Expression {

	override fun getTypeOrNull(context: ExpressionProvider.Context): Expression.Type? = Expression.Type.NOTHING

	override fun runInterpreter(context: InterpreterContext) {
		TODO("Nothing")
	}
}
