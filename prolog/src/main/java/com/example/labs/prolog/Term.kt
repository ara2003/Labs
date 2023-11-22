package com.greentree.commons.serialization.porlog

sealed interface Term {

	fun resolution(values: ValueScope, b: Term): Boolean
}

data class Variable(val name: String) : Term {

	override fun resolution(values: ValueScope, b: Term): Boolean {
		return values.set(name, b)
	}

	override fun toString() = name
}

data class Const(val name: String) : Term {

	override fun resolution(values: ValueScope, b: Term) = this == b

	override fun toString() = name
}

fun v(name: String) = Variable(name)
fun c(name: String) = Const(name)
fun of() = c("[]")
