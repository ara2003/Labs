package com.example.lab.expression

import com.example.lab.expression.provider.ExpressionProviderImpl
import com.example.lab.interpreter.InterpreterContext

data class LiteralElementExpression(
	val literal: Int,
) : ElementExpression {

	override fun runElement(context: InterpreterContext) = literal

	companion object {

		fun provider(literal: Int) = ExpressionProviderImpl(LiteralElementExpression(literal))
	}
}