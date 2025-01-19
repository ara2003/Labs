package com.example.lab.expression

import com.example.lab.SemanticError
import com.example.lab.Variable
import com.example.lab.expression.provider.ExpressionProvider
import com.example.lab.expression.provider.ExpressionProviderImpl
import com.example.lab.interpreter.InterpreterContext
import com.example.lab.statement.StatementContext

data class VariableExpression(
	val name: String,
) : ListExpression, ElementExpression, ElementAssignTarget, ListAssignTarget {

	override fun assign(context: InterpreterContext, value: Int) {
		context.setValue(name, value)
	}

	override fun assign(context: InterpreterContext, value: List<Int>) {
		context.setValue(name, value)
	}

	override fun init(context: StatementContext, type: Expression.Type): Boolean {
		if(context.hasVariable(name)) {
			val ctxType = context.getVariableType(name)
			if(ctxType != type) return SemanticError.print("set '$type' to '$ctxType' variable", -1)
			return true
		}
		context.initVariable(Variable(type, name))
		return true
	}

	override fun getTypeOrNull(context: ExpressionProvider.Context) = context.getVariableTypeOrNull(name)

	override fun runList(context: InterpreterContext) = context.getValueList(name)

	override fun runElement(context: InterpreterContext) = context.getValueElement(name)

	override fun runInterpreter(context: InterpreterContext) {
	}

	companion object {

		fun provider(name: String) = ExpressionProviderImpl(VariableExpression(name))
	}
}