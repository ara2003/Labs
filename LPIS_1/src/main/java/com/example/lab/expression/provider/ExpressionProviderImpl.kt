package com.example.lab.expression.provider

import com.example.lab.expression.Expression
import com.example.lab.expression.provider.ExpressionProvider.*
import com.example.lab.statement.StatementContext

data class ExpressionProviderImpl(val expression: Expression) : ExpressionProvider {

	override fun getType(context: Context) = expression.getType(context)
	override fun provide(context: StatementContext) = expression
}