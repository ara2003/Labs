/**
Лабораторная работа № 5 по дисциплине "Логические основы интеллектуальных систем"
Выполнена студентами группы 021702 БГУИР Кавковым М.А., Латышев А.Т., Семченков Н.А.
Файл, содержащий классы описывающие значения термов
Дата: 10.12.23
 */
package org.example.fuzzy.value

import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

sealed interface Value {

	companion object {

		val All
			get() = range(0f, 1f)
	}

	operator fun plus(other: Value): Value
	operator fun times(other: Value): Value

	operator fun contains(value: Float): Boolean
	operator fun contains(value: Value): Boolean = this * value == value

	fun isEmpty(): Boolean
}

data object NothingValue : Value {

	override fun plus(other: Value) = other

	override fun times(other: Value) = this

	override fun contains(value: Float) = false

	override fun contains(value: Value) = value.isEmpty()

	override fun toString() = "\u2205"

	override fun isEmpty() = true
}

fun number(
	value: Float,
): Value {
	require(value in (0f .. 1f)) { "$value" }
//	val value = Math.clamp(value, 0f, 1f)
	return NumberValue(value)
}

fun NumberValue(value: Float) = NumberValue((value * 100f + .5f).toInt().toByte())

data class NumberValue(
	private val valueByte: Byte,
) : Value {

	val value: Float
		get() = valueByte / 100f

	override fun times(other: Value) = if(value in other)
		this
	else
		NothingValue

	override fun plus(other: Value) = if(value in other)
		other
	else
		PlusValue.newValue(listOf(this, other))

	override fun contains(value: Float) = equals(this.value, value)

	override fun isEmpty() = false

	override fun toString() = "{$value}"
}

data class PlusValue private constructor(
	val elements: Iterable<Value>,
) : Value {

	override fun plus(other: Value) = elements.map { other + it }.reduce { a, b -> a + b }

	override fun times(other: Value) = elements.map { other * it }.reduce { a, b -> a + b }

	override fun contains(value: Float) = elements.any { value in it }

	override fun isEmpty() = elements.all { it.isEmpty() }

	override fun toString() = elements.map { it.toString() }.reduce { a, b -> "$a\u222a$b" }

	companion object {

		fun newValue(elements: Collection<Value>) = PlusValue(elements.toSet())
		fun newValue(vararg elements: Value) = newValue(listOf(*elements))
	}
}

fun range(
	begin: Float,
	end: Float,
): Value {
	val begin = Math.clamp(begin, 0f, 1f)
	val end = Math.clamp(end, 0f, 1f)
	return when {
		equals(begin, end) -> number(begin)
		begin < end -> RangeValue(begin, end)
		else -> NothingValue
	}
}

data class RangeValue(
	val begin: Float,
	val end: Float,
) : Value {

	override fun times(other: Value): Value {
		return when(other) {
			is RangeValue -> {
				val end = min(end, other.end)
				val begin = max(begin, other.begin)
				return range(begin, end)
			}

			else -> other * this
		}
	}

	override fun plus(other: Value): Value {
		return when(other) {
			is RangeValue -> {
				if(max(begin, other.begin) > min(end, other.end))
					PlusValue.newValue(listOf(this, other))
				else {
					val end = max(end, other.end)
					val begin = min(begin, other.begin)
					RangeValue(begin, end)
				}
			}

			else -> other + this
		}
	}

	override fun contains(value: Float) = value in begin .. end

	override fun isEmpty() = false

	override fun toString() = "[$begin, $end]"
}

private fun equals(a: Float, b: Float) = abs(a - b) < 0.001f