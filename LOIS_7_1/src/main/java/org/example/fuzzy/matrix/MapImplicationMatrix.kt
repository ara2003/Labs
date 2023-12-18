package org.example.fuzzy.matrix

import org.example.fuzzy.set.FuzzySet
import org.example.fuzzy.set.MapFuzzySet

class MapImplicationMatrix : MutableImplicationMatrix {

	private val map = mutableMapOf<String, MutableMap<String, Float>>()

	private fun getMap(firstElement: String) = map.getOrPut(firstElement) { mutableMapOf() }

	override fun get(firstElement: String, secondElement: String) = getMap(firstElement)[secondElement]!!

	override fun set(firstElement: String, secondElement: String, degree: Float) {
		getMap(firstElement)[secondElement] = degree
	}

	override fun get(firstElement: String): FuzzySet {
		val result = MapFuzzySet()
		for(e in getMap(firstElement))
			result[e.key] = e.value
		return result
	}
}