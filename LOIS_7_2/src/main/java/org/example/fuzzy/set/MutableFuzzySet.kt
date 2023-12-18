package org.example.fuzzy.set

interface MutableFuzzySet : FuzzySet {

	operator fun set(element: String, degree: Float)
	fun remove(element: String)
	fun clear()
}