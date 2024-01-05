/**
Лабораторная работа № 5 по дисциплине "Логические основы интеллектуальных систем"
Выполнена студентами группы 021702 БГУИР Кавковым М.А., Латышев А.Т., Семченков Н.А.
Файл, содержащий интерфейс матрицы импликации
Дата: 10.12.23
 */
package org.example.fuzzy.set

import org.example.fuzzy.set.FuzzySet.*

/**
 * Интерфейс описывающий нечеткое множесво
 * @param E - над каким типом задоно множество
 */
interface FuzzySet : Iterable<FuzzyElement> {

	override fun iterator(): Iterator<FuzzyElement> = elements.map { SimpleFuzzyElement(it, get(it)) }.iterator()

	/**
	 * @return степень принадлежности элемента
	 */
	operator fun get(element: String): Float

	/**
	 * Принадлежит ли элемент множеству.
	 */
	operator fun contains(element: String): Boolean

	val elements: Collection<String>

	fun toSetString(): String {
		return "{${map { "(${it.element}, ${it.degree})" }.reduceOrNull { acc, s -> "$acc, $s" } ?: ""}}"
	}

	interface FuzzyElement {

		val element: String
		val degree: Float

		operator fun component1() = element
		operator fun component2() = degree
	}
}

data class SimpleFuzzyElement(override val element: String, override val degree: Float) : FuzzyElement
