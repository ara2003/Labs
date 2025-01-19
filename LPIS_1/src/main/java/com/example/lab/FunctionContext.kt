package com.example.lab

import com.example.lab.expression.provider.ExpressionProvider

interface FunctionContext : ExpressionProvider.Context {

	fun block(): FunctionContext
}
