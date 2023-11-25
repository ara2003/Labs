package org.example

import java.util.*
import kotlin.math.max
import kotlin.math.min

val functions = mutableMapOf<String, Class<out Expression>>()

fun main() {
	loop@ for(cls in Expression::class.sealedSubclasses.map { it.java }) {
		val constructors = cls.constructors
		if(constructors.size > 1)
			continue
		val constructor = constructors.first()
		for(param in constructor.parameters) {
			if(param.type != Expression::class.java)
				continue@loop
		}
		val name = cls.simpleName.removeSuffix("Expression").lowercase(Locale.getDefault())
		functions[name] = cls
	}
	val e = parse("or(a, .1)")
	for(i in range(.0, 1.0, .1))
		println(e.value("a" to i))
}

fun range(begin: Double, end: Double, step: Double) = sequence {
	var i = begin
	while(i < end) {
		yield(i)
		i += step
	}
}

fun Expression.value(vararg pairs: Pair<String, Double>) = value(mapOf(*pairs))

sealed interface Expression {

	fun value(values: Map<String, Double>): Double
}

data class ConstExpression(val value: Double) : Expression {

	override fun value(values: Map<String, Double>) = value

	override fun toString() = "$value"
}

data class VariableExpression(val name: String) : Expression {

	override fun value(values: Map<String, Double>) = values[name] ?: throw NullPointerException("variable $name")

	override fun toString() = "$name"
}

data class NotExpression(val a: Expression) : Expression {

	override fun value(values: Map<String, Double>) = 1 - a.value(values)

	override fun toString() = "!$a"
}

data class AndExpression(val a: Expression, val b: Expression) : Expression {

	override fun value(values: Map<String, Double>) = min(a.value(values), b.value(values))

	override fun toString() = "and($a, $b)"
}

data class ImplExpression(val a: Expression, val b: Expression) : Expression {

	override fun value(values: Map<String, Double>) = min(1.0, b.value(values) / a.value(values))

	override fun toString() = "and($a, $b)"
}

data class OrExpression(val a: Expression, val b: Expression) : Expression {

	override fun value(values: Map<String, Double>) = max(a.value(values), b.value(values))

	override fun toString() = "or($a, $b)"
}

fun and(a: Expression, b: Expression) = AndExpression(a, b)
fun or(a: Expression, b: Expression) = OrExpression(a, b)
fun not(a: Expression) = NotExpression(a)

fun parse(text: String) = parse(parseTree(text.tokens))

fun parse(token: Token) = when(token) {
	is Name -> VariableExpression(token.value)
	is Number -> ConstExpression(token.value)
	else -> TODO()
}

fun parse(node: Node): Expression = when(node) {
	is Leaf -> parse(node.token)
	is Predicate -> {
		val funcName = node.name
		val arguments = node.arguments.map { parse(it) }
		val cls = functions[funcName] ?: TODO("not found function $funcName")
		cls.constructors.first().newInstance(*arguments.toTypedArray()) as Expression
	}
}
