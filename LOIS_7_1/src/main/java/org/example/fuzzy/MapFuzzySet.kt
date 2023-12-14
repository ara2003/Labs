package org.example.fuzzy

class MapFuzzySet<E> : MutableFuzzySet<E> {

	private val map = mutableMapOf<E, Float>()

	override fun iterator() = map.map { SimpleFuzzyElement(it.key, it.value) }.iterator()

	override fun set(element: E, degree: Float) {
		map[element] = degree
	}

	override fun contains(element: E) = map.containsKey(element)

	override operator fun get(element: E) = map[element] ?: throw NullPointerException("element $element not contains")

	override fun remove(element: E) {
		map.remove(element)
	}

	override fun clear() {
		map.clear()
	}

	override fun equals(other: Any?): Boolean {
		if(this === other) return true
		if(javaClass != other?.javaClass) return false

		other as MapFuzzySet<*>

		return map == other.map
	}

	override fun hashCode(): Int {
		return map.hashCode()
	}

	override fun toString() = toSetString()

	override val elements: Collection<E>
		get() = map.keys
}