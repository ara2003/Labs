package com.example.lab.statement

import com.example.lab.Function
import com.example.lab.FunctionSignature
import com.example.lab.Variable
import com.example.lab.expression.Expression

class StatementContextImpl private constructor(
	override val isFuncDef: Boolean,
	override val isForDef: Boolean
) : StatementContext {

	private val variables: MutableCollection<Variable> = ArrayList()
	private val functions: MutableCollection<Function> = ArrayList()
	override var isReturn = false

	constructor() : this(false, false)

	override fun funcDefBlock(): StatementContext {
		val block = StatementContextImpl(true, false)
		block.variables.addAll(variables)
		block.functions.addAll(functions)
		return block
	}

	override fun forDefBlock(): StatementContext {
		val block = StatementContextImpl(isFuncDef, true)
		block.variables.addAll(variables)
		block.functions.addAll(functions)
		return block
	}

	override fun block(): StatementContext {
		val block = StatementContextImpl(isFuncDef, isForDef)
		block.variables.addAll(variables)
		block.functions.addAll(functions)
		return block
	}

	override fun setReturn() {
		isReturn = true
	}

	override fun funcDef(function: Function) {
		functions.add(function)
	}

	override fun getReturnTypeOrNull(signature: FunctionSignature): Expression.Type? {
		return functions.singleOrNull { signature == it.signature() }?.returnType
	}

	override fun getVariableTypeOrNull(variable: String): Expression.Type? {
		return variables.singleOrNull { variable == it.name }?.type
	}

	override fun hasFunction(signature: FunctionSignature): Boolean {
		return functions.stream().map { x: Function -> x.signature() }
			.anyMatch { x: FunctionSignature -> x == signature }
	}

	override fun hasVariable(variable: Variable): Boolean {
		return variables.contains(variable)
	}

	override fun hasVariable(name: String): Boolean {
		return variables.stream().anyMatch { x: Variable -> name == x.name }
	}

	override fun initVariable(variable: Variable) {
		require(!hasVariable(variable.name)) { "var alredy init" }
		variables.add(variable)
	}

	override fun toString(): String {
		return "StatementContextImpl [$variables, $functions]"
	}
}
