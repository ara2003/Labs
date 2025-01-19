package com.example.lab.expression

import com.example.lab.expression.provider.ExpressionProvider
import com.example.lab.interpreter.InterpreterContext
import com.example.lab.statement.StatementContext

data class MergeExpressionProvider(
	val first: ExpressionProvider,
	val second: ExpressionProvider,
) : ExpressionProvider {

	override fun provide(context: StatementContext): Expression {
		val first = first.provide(context)
		val second = second.provide(context)
		val secondType = second.getType(context)
		return when(secondType) {
			Expression.Type.ELEMENT -> MergeElementExpression(first, second as ElementExpression)
			Expression.Type.LIST -> MergeListExpression(first, second as ListExpression)
			Expression.Type.UNIT -> MergeUnitExpression(first, second as UnitExpression)
			Expression.Type.NOTHING -> TODO()
		}
	}
}

data class MergeElementExpression(
	val first: Expression,
	val second: ElementExpression,
) : ElementExpression {

	override fun runElement(context: InterpreterContext): Int {
		first.runInterpreter(context)
		return second.runElement(context)
	}
}

data class MergeListExpression(
	val first: Expression,
	val second: ListExpression,
) : ListExpression {

	override fun runList(context: InterpreterContext): List<Int> {
		first.runInterpreter(context)
		return second.runList(context)
	}
}

data class MergeUnitExpression(
	val first: Expression,
	val second: UnitExpression,
) : UnitExpression {

	override fun runUnit(context: InterpreterContext) {
		first.runInterpreter(context)
		return second.runUnit(context)
	}
}