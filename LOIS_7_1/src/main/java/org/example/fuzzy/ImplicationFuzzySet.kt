package org.example.fuzzy

class ImplicationFuzzySet<E1, E2>(
	private val first: FuzzySet<E1>,
	private val second: FuzzySet<E2>,
	private val firstElement: E1,
) : FuzzySet<E2> {

	override fun get(secondElement: E2) = impl(first[firstElement], second[secondElement])

	override fun contains(secondElement: E2) = secondElement in second

	override val elements: Collection<E2>
		get() = second.elements
}
