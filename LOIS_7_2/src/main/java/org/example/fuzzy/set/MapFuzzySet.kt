/**
Лабораторная работа № 5 по дисциплине "Логические основы интеллектуальных систем"
Выполнена студентами группы 021702 БГУИР Кавковым М.А., Латышев А.Т., Семченков Н.А.
Файл класс, реализующий изменяемое нечеткое множество на основе Map
Дата: 10.12.23
 */
package org.example.fuzzy.set

class MapFuzzySet : MutableFuzzySet {

	private val map = mutableMapOf<String, Float>()

	override fun iterator() = map.map { SimpleFuzzyElement(it.key, it.value) }.iterator()

	override fun set(element: String, degree: Float) {
		map[element] = degree
	}

	override fun contains(element: String) = map.containsKey(element)

	override operator fun get(element: String) =
		map[element] ?: throw NullPointerException("element $element not contains")

	override fun remove(element: String) {
		map.remove(element)
	}

	override fun clear() {
		map.clear()
	}

	override fun equals(other: Any?): Boolean {
		if(this === other) return true
		if(javaClass != other?.javaClass) return false

		other as MapFuzzySet

		return map == other.map
	}

	override fun hashCode(): Int {
		return map.hashCode()
	}

	override fun toString() = toSetString()

	override val elements: Collection<String>
		get() = map.keys
}

fun MapFuzzySet(vararg elements: Pair<String, Float>): MapFuzzySet {
	val result = MapFuzzySet()
	for(element in elements)
		result[element.first] = element.second
	return result
}