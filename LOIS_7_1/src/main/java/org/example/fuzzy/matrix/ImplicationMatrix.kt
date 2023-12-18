package org.example.fuzzy.matrix

import org.example.fuzzy.set.FuzzySet

interface ImplicationMatrix {

	operator fun get(firstElement: String, secondElement: String): Float
	operator fun get(firstElement: String): FuzzySet
}