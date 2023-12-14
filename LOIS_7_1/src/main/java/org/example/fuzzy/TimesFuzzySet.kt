package org.example.fuzzy

data class TimesFuzzySet<E1, E2>(
	val relation: ImplicationMatrix<E1, E2>,
	val other: FuzzySet<E1>,
) : FuzzySet<E2> {

	override fun get(element: E2) = relation.a.elements.map { tNorm(relation[it][element], other[it]) }.max()

	override fun contains(element: E2) = relation.b.contains(element)

	override val elements: Collection<E2>
		get() = relation.b.elements

	override fun toString() = toSetString()
}
