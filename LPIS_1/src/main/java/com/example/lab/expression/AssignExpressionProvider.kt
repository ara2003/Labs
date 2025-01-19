package com.example.lab.expression

import com.example.lab.expression.Expression.Type.*
import com.example.lab.expression.provider.ExpressionProvider
import com.example.lab.interpreter.InterpreterContext
import com.example.lab.statement.StatementContext

data class AssignExpressionProvider(
	val lvalue: ExpressionProvider,
	val rvalue: ExpressionProvider,
) : ExpressionProvider {

	override fun provide(context: StatementContext): Expression {
		val lvalue = lvalue.provide(context) as AssignTarget
		val rvalue = rvalue.provide(context)
		val type = lvalue.getTypeOrNull(context)
		if(type != null) {
			TODO("$lvalue $rvalue")
		} else {
			val valueType = rvalue.getType(context)
			return when(valueType) {
				ELEMENT -> {
					lvalue.init(context, ELEMENT)
					AssignElementExpression(
						lvalue as ElementAssignTarget,
						rvalue as ElementExpression
					)
				}

				Expression.Type.LIST -> TODO()
				Expression.Type.UNIT -> TODO()
				Expression.Type.NOTHING -> TODO()
			}
		}
	}
}

data class AssignElementExpression(
	val lvalue: ElementAssignTarget,
	val rvalue: ElementExpression,
) : ElementExpression {

	override fun runElement(context: InterpreterContext): Int {
		val value = rvalue.runElement(context)
		lvalue.assign(context, value)
		return value
	}
}