/**
Лабораторная работа № 4 по дисциплине "Логические основы интеллектуальных систем"
Выполнена студентами группы 021702 БГУИР Кавковым М.А., Латышев А.Т., Семченков Н.А.
Файл класс, реализующий изменяемую матрицу импликации на основе Map
Дата: 10.12.23
 */
package org.example.fuzzy.matrix

class MapImplicationMatrix : MutableImplicationMatrix {

	private val map = mutableMapOf<String, MutableMap<String, Float>>()

	private fun getMap(firstElement: String) = map.getOrPut(firstElement) { mutableMapOf() }

	override fun get(firstElement: String, secondElement: String) = getMap(firstElement)[secondElement]
		?: throw NoSuchElementException("first = $firstElement, second = $secondElement")

	override fun set(firstElement: String, secondElement: String, degree: Float) {
		getMap(firstElement)[secondElement] = degree
	}

	override val first: Iterable<String>
		get() = map.keys
	override val second: Iterable<String>
		get() = map[first.first()]!!.keys
}