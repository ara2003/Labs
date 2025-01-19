package com.example.lab.interpreter

import com.example.lab.FunctionSignature
import com.example.lab.expression.Expression
import com.example.lab.statement.StatementContext

class InterpreterContextImpl(private val context: StatementContext) : InterpreterContext {

	private val values: MutableMap<String?, Any> = HashMap()

	override fun returnVoid() {
	}

	override fun callFunctionVoid(name: String, arguments: List<Any>) {
		if(name == "print") {
			println(arguments[0])
		}
	}

	override fun setValue(name: String, value: Int) {
		values[name] = value
	}

	override fun setValue(name: String?, value: List<Int>) {
		values[name] = value
	}

	override fun getValueElement(name: String): Int {
		return values[name] as Int
	}

	override fun getValueList(name: String): List<Int> {
		return values[name] as List<Int>
	}

	override fun block(): InterpreterContext {
		val block = InterpreterContextImpl(context.block())
		block.values.putAll(values)
		return block
	}

	override fun getReturnTypeOrNull(function: FunctionSignature): Expression.Type? {
		return context.getReturnTypeOrNull(function)
	}

	override fun getVariableTypeOrNull(name: String): Expression.Type? {
		return context.getVariableTypeOrNull(name)
	}
}
