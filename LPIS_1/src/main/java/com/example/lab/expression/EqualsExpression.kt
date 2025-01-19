package com.example.lab.expression

import com.example.lab.expression.provider.ExpressionProvider
import com.example.lab.interpreter.InterpreterContext
import com.example.lab.statement.StatementContext

data class EqualsExpressionProvider(
	val first: ExpressionProvider,
	val second: ExpressionProvider,
) : ExpressionProvider {

	override fun getType(context: ExpressionProvider.Context) = Expression.Type.ELEMENT

	override fun provide(context: StatementContext): Expression {
		val first = first.provide(context)
		val second = second.provide(context)
		val firstType = first.getType(context)
		val secondType = second.getType(context)
		require(firstType == secondType) { "$first $second" }
		return when(firstType) {
			Expression.Type.ELEMENT -> EqualsElementExpression(first as ElementExpression, second as ElementExpression)
			Expression.Type.LIST -> TODO()
			Expression.Type.UNIT -> TODO()
			Expression.Type.NOTHING -> TODO()
		}
	}
}

data class EqualsElementExpression(
	val first: ElementExpression,
	val second: ElementExpression
) : ElementExpression {

	override fun runElement(context: InterpreterContext): Int {
		val first = first.runElement(context)
		val second = second.runElement(context)
		return if(first == second)
			1
		else
			0
	}
}