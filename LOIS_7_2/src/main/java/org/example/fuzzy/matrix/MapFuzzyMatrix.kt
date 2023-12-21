/**
Лабораторная работа № 4 по дисциплине "Логические основы интеллектуальных систем"
Выполнена студентами группы 021702 БГУИР Кавковым М.А., Латышев А.Т., Семченков Н.А.
Файл класс, реализующий изменяемую матрицу импликации на основе Map
Дата: 10.12.23
 */
package org.example.fuzzy.matrix

class MapFuzzyMatrix : MutableFuzzyMatrix {

	private val map = mutableMapOf<String, MutableMap<String, Float>>()

	private fun getMap(firstElement: String) = map.getOrPut(firstElement) { mutableMapOf() }

	override fun get(firstElement: String, secondElement: String) = getMap(firstElement)[secondElement]
		?: throw NoSuchElementException("first = $firstElement, second = $secondElement")

	override fun set(firstElement: String, secondElement: String, degree: Float) {
		getMap(firstElement)[secondElement] = degree
	}

	override fun toString(): String {
		val columns = first.map { name ->
			val values = second.map { get(name, it) }
			sequence {
				yield(name.toString())
				yieldAll(values.map { it.toString() })
			}.toList()
		}.toMutableList()
		val firstColumn = mutableListOf<String>()
		columns.add(0, firstColumn)
		firstColumn.add("")
		firstColumn.addAll(second.map { it.toString() })
		return columns.map {
			val maxLength = it.maxOf { s -> s.length }
			it.map { s -> " ".repeat(maxLength - s.length) + s }
		}.transpose().map {
			it.reduce { acc, s -> "$acc $s" }
		}.reduce { acc, s -> "$acc\n$s" }.toString()
	}

	override val first: Iterable<String>
		get() = map.keys
	override val second: Iterable<String>
		get() = map[first.first()]!!.keys
}

fun <E> List<List<E>>.transpose(): List<List<E>> {
	val result = mutableListOf<MutableList<E>>()
	for(list in this.withIndex()) {
		for(a in list.value.withIndex()) {
			result.safeGet(a.index).safeSet(list.index, a.value)
		}
	}
	return result
}

private fun <E> MutableList<E>.safeSet(index: Int, value: E) {
	if(index < size) {
		set(index, value)
		return
	}
	if(index == size) {
		add(value)
		return
	}
	TODO()
}

private fun <E> MutableList<MutableList<E>>.safeGet(index: Int): MutableList<E> {
	while(size <= index)
		add(mutableListOf())
	return get(index)
}