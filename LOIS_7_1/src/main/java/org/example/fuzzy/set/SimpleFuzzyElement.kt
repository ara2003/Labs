package org.example.fuzzy.set

data class SimpleFuzzyElement<E>(override val element: E, override val degree: Float) : FuzzySet.FuzzyElement<E>