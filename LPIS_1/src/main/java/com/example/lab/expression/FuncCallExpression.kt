package com.example.lab.expression

import com.example.lab.FunctionSignature
import com.example.lab.expression.provider.ExpressionProvider
import com.example.lab.interpreter.InterpreterContext
import com.example.lab.statement.StatementContext

data class FuncCallExpressionProvider(
	val name: String,
	val arguments: List<ExpressionProvider>
) : ExpressionProvider {

	override fun provide(context: StatementContext): Expression {
		return FuncCallExpression(name, arguments.map { it.provide(context) })
	}
}

data class FuncCallExpression(
	val name: String,
	val arguments: List<Expression>,
) : UnitExpression {

	private fun signature(context: ExpressionProvider.Context): FunctionSignature {
		val argTypes = arguments.map { it.getType(context) }
		return FunctionSignature(name, argTypes)
	}

	override fun getTypeOrNull(context: ExpressionProvider.Context) = context.getReturnType(signature(context))

	override fun runUnit(context: InterpreterContext) {
		context.callFunctionVoid(name, arguments.map { it.runAny(context) })
	}
}

private fun Expression.runAny(context: InterpreterContext) = when(this) {
	is ElementExpression -> runElement(context)
	is ListExpression -> runList(context)
	is NothingExpression -> runInterpreter(context)
	is UnitExpression -> runUnit(context)
	else -> TODO()
}