/**
Лабораторная работа № 5 по дисциплине "Логические основы интеллектуальных систем"
Выполнена студентами группы 021702 БГУИР Кавковым М.А., Латышев А.Т., Семченков Н.А.
Файл, содержащий классы описывающие системы уровнений
Дата: 10.12.23
 */
package org.example.fuzzy.solution

import org.example.fuzzy.joinBackets
import org.example.fuzzy.value.NumberValue
import org.example.fuzzy.value.Value
import org.example.fuzzy.value.number

sealed interface Solution {
	data object AnySolution : Solution {

		override fun times(other: Solution): Solution = other

		override fun plus(other: Solution): Solution = this

		override fun contains(other: Solution) = true
	}

	data object NothingSolution : Solution {

		override fun times(other: Solution): Solution = this

		override fun plus(other: Solution): Solution = other

		override fun contains(other: Solution) = other == this
	}

	operator fun times(other: Solution): Solution = when {
		this in other -> this
		other in this -> other
		else -> TimesSolution(this, other)
	}

	operator fun plus(other: Solution): Solution = when {
		this in other -> other
		other in this -> this
		else -> PlusSolution(this, other)
	}

	operator fun contains(other: Solution): Boolean
}

data class ValueSolution(
	val name: String,
	val value: Value,
) : Solution {

	constructor(
		name: String,
		value: Float,
	) : this(name, number(value))

	override fun contains(other: Solution): Boolean = when(other) {
		is ValueSolution -> other.name == name && other.value in value
//		is PlusSolution -> other.arguments.all { contains(it) }
//		is TimesSolution -> other.arguments.all { contains(it) }
		Solution.AnySolution -> false
		Solution.NothingSolution -> true
		else -> {
			TODO("$this\n$other")
		}
	}

	override fun toString(): String {
		if(value is NumberValue)
			return "$name=${value.value}"
		return "$name\u2208$value"
	}
}

data class PlusSolution(
	val arguments: Iterable<Solution>,
) : Solution {

	constructor(vararg arguments: Solution) : this(listOf(*arguments))

	override fun contains(other: Solution) = arguments.any { other in it }

	override fun toString() = arguments.joinToString("\n") { it.toString() }
		.joinBackets('\u23a1', '\u23a2', '\u23a3')
}

data class TimesSolution(
	val arguments: Iterable<Solution>,
) : Solution {

	constructor(vararg arguments: Solution) : this(listOf(*arguments))

	override fun contains(other: Solution) = arguments.all { other in it }

	override fun toString() = arguments.joinToString("\n") { it.toString() }
		.joinBackets('\u23a7', '\u23a2', '\u23a9', '\u23b0', '\u23b1')
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

private fun <T> table(
	collection: Iterable<T>,
	block: (T, T) -> Unit,
) {
	val list = collection.toList()
	for(a in list)
		for(b in list)
			if(a == b)
				break
			else
				block(a, b)
}