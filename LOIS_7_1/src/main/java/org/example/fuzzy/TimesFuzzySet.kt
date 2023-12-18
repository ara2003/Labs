package org.example.fuzzy

import org.example.fuzzy.matrix.ImplicationMatrix
import org.example.fuzzy.set.FuzzySet

data class TimesFuzzySet<E1, E2>(
	val relation: ImplicationMatrix<E1, E2>,
	val other: FuzzySet<E1>,
) : FuzzySet<E2> {

	override fun get(element: E2) = relation.first.elements.maxOf { tNorm(relation[it, element], other[it]) }

	override fun contains(element: E2) = relation.second.contains(element)

	override val elements: Collection<E2>
		get() = relation.second.elements

	override fun toString() = toSetString()
}
