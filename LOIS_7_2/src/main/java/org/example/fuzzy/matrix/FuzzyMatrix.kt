/**
Лабораторная работа № 4 по дисциплине "Логические основы интеллектуальных систем"
Выполнена студентами группы 021702 БГУИР Кавковым М.А., Латышев А.Т., Семченков Н.А.
Файл, содержащий интерфейс матрицы импликации
Дата: 10.12.23
 */
package org.example.fuzzy.matrix

interface FuzzyMatrix {

	val first: Iterable<String>
	val second: Iterable<String>

	operator fun get(firstElement: String, secondElement: String): Float
}

fun FuzzyMatrix.toMutableFuzzyMatrix(): MutableFuzzyMatrix {
	val result = MapFuzzyMatrix()
	for(f in first)
		for(s in second)
			result[f, s] = get(f, s)
	return result
}

fun FuzzyMatrix.toFuzzyMatrix(): FuzzyMatrix = toMutableFuzzyMatrix()