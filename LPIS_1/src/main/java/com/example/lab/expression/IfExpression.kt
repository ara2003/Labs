package com.example.lab.expression

import com.example.lab.expression.provider.ExpressionProvider
import com.example.lab.interpreter.InterpreterContext
import com.example.lab.statement.StatementContext

data class IfExpressionProvider(
	val condition: ExpressionProvider,
	val then: ExpressionProvider,
	val `else`: ExpressionProvider?,
) : ExpressionProvider {

	override fun provide(context: StatementContext): Expression {
		val condition = condition.provide(context) as ElementExpression
		val then = then.provide(context)
		if(`else` != null) {
			val `else` = `else`.provide(context)
			val thenType = then.getType(context)
			val elseType = `else`.getType(context)
			require(thenType == elseType) { "$then $`else`" }
			return when(thenType) {
				Expression.Type.ELEMENT -> IfElementExpressionWithElse(
					condition,
					then as ElementExpression,
					`else` as ElementExpression
				)

				Expression.Type.LIST -> IfListExpressionWithElse(
					condition,
					then as ListExpression,
					`else` as ListExpression
				)

				Expression.Type.UNIT -> TODO()
				Expression.Type.NOTHING -> TODO()
			}
		} else {
			val thenType = then.getType(context)
			return when(thenType) {
				Expression.Type.ELEMENT -> IfElementExpression(
					condition,
					then as ElementExpression,
				)

				Expression.Type.LIST -> IfListExpression(
					condition,
					then as ListExpression,
				)

				Expression.Type.UNIT -> TODO()
				Expression.Type.NOTHING -> TODO()
			}
		}
	}
}

data class IfElementExpression(
	val condition: ElementExpression,
	val then: ElementExpression,
) : UnitExpression {

	override fun runUnit(context: InterpreterContext) {
		if(condition.runElement(context) != 0)
			then.runElement(context)
	}
}

data class IfListExpression(
	val condition: ElementExpression,
	val then: ListExpression,
) : UnitExpression {

	override fun runUnit(context: InterpreterContext) {
		if(condition.runElement(context) != 0)
			then.runList(context)
	}
}

data class IfElementExpressionWithElse(
	val condition: ElementExpression,
	val then: ElementExpression,
	val `else`: ElementExpression,
) : ElementExpression {

	override fun runElement(context: InterpreterContext) = if(condition.runElement(context) != 0)
		then.runElement(context)
	else
		`else`.runElement(context)
}

data class IfListExpressionWithElse(
	val condition: ElementExpression,
	val then: ListExpression,
	val `else`: ListExpression,
) : ListExpression {

	override fun runList(context: InterpreterContext) = if(condition.runElement(context) != 0)
		then.runList(context)
	else
		`else`.runList(context)
}