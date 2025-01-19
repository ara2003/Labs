package com.example.lab.expression.provider

import com.example.lab.FunctionSignature
import com.example.lab.expression.Expression
import com.example.lab.expression.Expression.*
import com.example.lab.statement.StatementContext

interface ExpressionProvider {

	fun getType(context: Context): Type? = null

	interface Context {

		fun getReturnTypeOrNull(function: FunctionSignature): Type?
		fun getVariableTypeOrNull(name: String): Type?

		fun getReturnType(function: FunctionSignature): Type =
			getReturnTypeOrNull(function) ?: throw NullPointerException("$function")

		fun getVariableType(name: String): Type = getVariableTypeOrNull(name) ?: throw NullPointerException(name)
	}

	fun provide(context: StatementContext): Expression
}