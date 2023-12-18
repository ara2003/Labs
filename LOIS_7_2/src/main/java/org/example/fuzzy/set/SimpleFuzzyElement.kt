package org.example.fuzzy.set

data class SimpleFuzzyElement(override val element: String, override val degree: Float) : FuzzySet.FuzzyElement