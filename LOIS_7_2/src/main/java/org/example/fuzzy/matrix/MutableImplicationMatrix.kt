package org.example.fuzzy.matrix

interface MutableImplicationMatrix : ImplicationMatrix {

	operator fun set(firstElement: String, secondElement: String, degree: Float)
}