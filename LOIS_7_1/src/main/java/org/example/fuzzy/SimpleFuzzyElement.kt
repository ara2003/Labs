package org.example.fuzzy

data class SimpleFuzzyElement<E>(override val element: E, override val degree: Float) : FuzzySet.FuzzyElement<E>