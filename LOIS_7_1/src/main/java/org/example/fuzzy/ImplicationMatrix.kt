package org.example.fuzzy

data class ImplicationMatrix<E1, E2>(
	val a: FuzzySet<E1>,
	val b: FuzzySet<E2>,
) {

	operator fun get(e1: E1) = ImplicationFuzzySet(a, b, e1)

	override fun toString(): String {
		val columns = a.elements.map { name ->
			val values = b.elements.map { get(name, it) }
			sequence {
				yield(name.toString())
				yieldAll(values.map { it.toString() })
			}.toList()
		}.toMutableList()
		val firstColumn = mutableListOf<String>()
		columns.add(0, firstColumn)
		firstColumn.add("")
		firstColumn.addAll(b.elements.map { it.toString() })
		return columns.map {
			val maxLength = it.maxOf { s -> s.length }
			it.map { s -> " ".repeat(maxLength - s.length) + s }
		}.transpose().map {
			it.reduce { acc, s -> "$acc $s" }
		}.reduce { acc, s -> "$acc\n$s" }.toString()
	}
}

operator fun <E1, E2> ImplicationMatrix<E1, E2>.get(e1: E1, e2: E2) = this[e1][e2]

operator fun <E1, E2> ImplicationMatrix<E1, E2>.times(other: FuzzySet<E1>): FuzzySet<E2> = TimesFuzzySet(this, other)