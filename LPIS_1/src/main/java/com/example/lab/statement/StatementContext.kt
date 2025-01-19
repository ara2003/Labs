package com.example.lab.statement

import com.example.lab.Function
import com.example.lab.FunctionContext
import com.example.lab.FunctionSignature
import com.example.lab.Variable

interface StatementContext : FunctionContext {

	fun funcDefBlock(): StatementContext

	fun forDefBlock(): StatementContext

	override fun block(): StatementContext

	val isReturn: Boolean

	fun setReturn()

	val isFuncDef: Boolean
	val isForDef: Boolean

	fun funcDef(function: Function)

	fun hasFunction(signature: FunctionSignature): Boolean

	fun hasVariable(variable: Variable): Boolean {
		return hasVariable(variable.name)
	}

	fun hasVariable(name: String): Boolean

	fun initVariable(name: String) {
		initVariable(Variable(name))
	}

	fun initVariable(variable: Variable)
}
