package org.example.fuzzy.solution

import org.example.fuzzy.joinBackets
import org.example.fuzzy.value.NothingValue
import org.example.fuzzy.value.NumberValue
import org.example.fuzzy.value.Value
import org.example.fuzzy.value.number

sealed interface Solution {
	data object Empty : Solution {

		override fun contains(other: Solution) = false

		override fun injectTimes(name: String, value: Value) = this

		override fun injectPlus(name: String, value: Value) = this
	}

	operator fun contains(other: Solution): Boolean

	fun injectTimes(name: String, value: Value): Solution
	fun injectPlus(name: String, value: Value): Solution
}

fun ValueSolution(
	name: String,
	value: Float,
) = ValueSolution(name, number(value))

data class ValueSolution(
	val name: String,
	val value: Value,
) : Solution {

	override fun contains(other: Solution): Boolean = when(other) {
		is ValueSolution -> other.value in value
		is PlusSolution -> other.arguments.all { contains(it) }
		is TimesSolution -> other[name] in value
		Solution.Empty -> true
	}

	override fun injectTimes(name: String, value: Value) =
		if(this.name == name) {
			ValueSolution(name, value * this.value)
		} else
			this

	override fun injectPlus(name: String, value: Value) =
		if(this.name == name)
			ValueSolution(name, value + this.value)
		else
			this

	override fun toString(): String {
		if(value is NumberValue)
			return "$name=${value.value}"
		return "$name\u2208$value"
	}
}

data class PlusSolution private constructor(
	val arguments: Iterable<Solution>,
) : Solution {

	override fun contains(other: Solution) = arguments.any { other in it }

	override fun toString() = arguments.joinToString("\n") { it.toString() }
		.joinBackets('\u23a1', '\u23a2', '\u23a3')

	override fun injectTimes(name: String, value: Value) =
		newSolution(arguments.map { it.injectTimes(name, value) }.filter { it != ValueSolution(name, value) })

	override fun injectPlus(name: String, value: Value) =
		newSolution(arguments.map { it.injectPlus(name, value) })

	companion object {

		fun newSolution(
			arguments: Collection<Solution>,
		): Solution {
			var arguments: Collection<Solution> = arguments.flatMap {
				when(it) {
					is PlusSolution -> it.arguments
					else -> listOf(it)
				}
			}.toSet()
			val injectListValues = mutableMapOf<String, MutableList<Value>>()
			for(arg in arguments)
				if(arg is ValueSolution)
					injectListValues.getOrPut(arg.name) { mutableListOf() }.add(arg.value)
			val injectValues = injectListValues
				.mapValues { (_, it) -> it.fold(NothingValue as Value) { a, b -> a + b } }
			arguments = arguments
				.map {
					var result: Solution = it
					for((name, value) in injectValues)
						result = result.injectPlus(name, value)
					result
				}.filter { it !is Solution.Empty }.flatMap {
					when(it) {
						is PlusSolution -> it.arguments
						else -> listOf(it)
					}
				}.toSet()
			if(arguments.any { it is ValueSolution && it.value is NothingValue })
				return Solution.Empty
			return when {
				arguments.size == 1 -> arguments.first()
				else -> {
					PlusSolution(arguments)
				}
			}
		}
	}
}

data class TimesSolution private constructor(
	val arguments: Iterable<Solution>,
) : Solution {

	override fun injectTimes(name: String, value: Value) =
		newSolution(arguments.map { it.injectTimes(name, value) })

	override fun injectPlus(name: String, value: Value) =
		newSolution(arguments.map { it.injectPlus(name, value) })

	override fun contains(other: Solution) = arguments.all { other in it }

	override fun toString() = arguments.joinToString("\n") { it.toString() }
		.joinBackets('\u23a7', '\u23a2', '\u23a9', '\u23b0', '\u23b1')

	operator fun get(name: String) = arguments.filterIsInstance<ValueSolution>().first { it.name == name }.value

	companion object {

		fun newSolution(
			arguments: Collection<Solution>,
		): Solution {
			var arguments: Collection<Solution> = arguments.flatMap {
				when(it) {
					is TimesSolution -> it.arguments
					else -> listOf(it)
				}
			}.toSet()
			val injectListValues = mutableMapOf<String, MutableList<Value>>()
			for(arg in arguments)
				if(arg is ValueSolution)
					injectListValues.getOrPut(arg.name) { mutableListOf() }.add(arg.value)
			val injectValues = injectListValues.mapValues { (_, it) -> it.fold(Value.All) { a, b -> a * b } }
			arguments = arguments
				.map {
					var result: Solution = it
					for((name, value) in injectValues)
						result = result.injectTimes(name, value)
					result
				}.filter { it !is Solution.Empty }.flatMap {
					when(it) {
						is TimesSolution -> it.arguments
						else -> listOf(it)
					}
				}.toSet()
			if(arguments.any { it is ValueSolution && it.value is NothingValue })
				return Solution.Empty
			return when {
				arguments.size == 1 -> arguments.first()
				else -> {
					TimesSolution(arguments)
				}
			}
		}
	}
}

fun <T, R> Iterable<T>.reduceOne(block: (T, T) -> R): Iterable<R> {
	val result = mutableListOf<R>()
	val iter = iterator()
	if(!iter.hasNext())
		return result
	var a = iter.next()
	while(iter.hasNext()) {
		val b = iter.next()
		val r = block(a, b)
		result.add(r)
		a = b
	}
	return result
}

private fun <T> repeatResult(value: T, block: (T) -> T): T {
	var result = value
	while(true) {
		val a = block(result)
		if(result == a)
			return result
		result = a
	}
}