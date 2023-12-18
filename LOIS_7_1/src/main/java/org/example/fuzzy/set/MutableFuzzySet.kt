package org.example.fuzzy.set

interface MutableFuzzySet<E> : FuzzySet<E> {

	operator fun set(element: E, degree: Float)
	fun remove(element: E)
	fun clear()
}