package org.example.fuzzy.matrix

import org.example.fuzzy.impl
import org.example.fuzzy.set.FuzzySet
import org.example.fuzzy.transpose

data class ImplicationMatrix<E1, E2>(
	val first: FuzzySet<E1>,
	val second: FuzzySet<E2>,
) {

	operator fun get(firstElement: E1, secondElement: E2) = impl(first[firstElement], second[secondElement])

	override fun toString(): String {
		val columns = first.elements.map { name ->
			val values = second.elements.map { get(name, it) }
			sequence {
				yield(name.toString())
				yieldAll(values.map { it.toString() })
			}.toList()
		}.toMutableList()
		val firstColumn = mutableListOf<String>()
		columns.add(0, firstColumn)
		firstColumn.add("")
		firstColumn.addAll(second.elements.map { it.toString() })
		return columns.map {
			val maxLength = it.maxOf { s -> s.length }
			it.map { s -> " ".repeat(maxLength - s.length) + s }
		}.transpose().map {
			it.reduce { acc, s -> "$acc $s" }
		}.reduce { acc, s -> "$acc\n$s" }.toString()
	}
}