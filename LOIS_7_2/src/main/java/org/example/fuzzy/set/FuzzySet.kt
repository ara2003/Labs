package org.example.fuzzy.set

/**
 * Интерфейс описывающий нечеткое множесво
 * @param E - над каким типом задоно множество
 */
interface FuzzySet : Iterable<FuzzySet.FuzzyElement> {

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
	}
}
