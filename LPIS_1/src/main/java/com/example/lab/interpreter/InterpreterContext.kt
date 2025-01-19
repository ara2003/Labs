package com.example.lab.interpreter

import com.example.lab.FunctionContext

interface InterpreterContext : FunctionContext {

	fun returnVoid()

	fun callFunctionVoid(name: String, arguments: List<Any>)

	fun setValue(name: String, value: Int)

	fun setValue(name: String?, value: List<Int>)

	fun getValueElement(name: String): Int

	fun getValueList(name: String): List<Int>

	override fun block(): InterpreterContext
}
