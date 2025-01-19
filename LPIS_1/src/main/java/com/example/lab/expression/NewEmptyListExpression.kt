package com.example.lab.expression

import com.example.lab.interpreter.InterpreterContext

data object NewEmptyListExpression : ListExpression {

	override fun runList(context: InterpreterContext) = listOf<Int>()
}

data class NewListExpression(
	val args: List<ElementExpression>,
) : ListExpression {

	override fun runList(context: InterpreterContext) = args.map { it.runElement(context) }
}