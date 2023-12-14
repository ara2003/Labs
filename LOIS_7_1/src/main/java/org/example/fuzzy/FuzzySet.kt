package org.example.fuzzy

interface FuzzySet<E> : Iterable<FuzzySet.FuzzyElement<E>> {

	override fun iterator(): Iterator<FuzzyElement<E>> = elements.map { SimpleFuzzyElement(it, get(it)) }.iterator()

	operator fun get(element: E): Float

	operator fun contains(element: E): Boolean

	val elements: Collection<E>

	fun toSetString(): String {
		return "{${map { "(${it.element}, ${it.degree})" }.reduce { acc, s -> "$acc, $s" }}}"
	}

	interface FuzzyElement<E> {

		val element: E
		val degree: Float
	}
}

fun <E> FuzzySet<E>.toMap() = elements.associateWith { get(it) }