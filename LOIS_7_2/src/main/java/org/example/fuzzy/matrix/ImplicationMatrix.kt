package org.example.fuzzy.matrix

interface ImplicationMatrix {

	val first: Iterable<String>
	val second: Iterable<String>

	operator fun get(firstElement: String, secondElement: String): Float
}