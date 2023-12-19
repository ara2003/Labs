/**
Лабораторная работа № 4 по дисциплине "Логические основы интеллектуальных систем"
Выполнена студентами группы 021702 БГУИР Кавковым М.А., Латышев А.Т., Семченков Н.А.
Файл, содержащий интерфейс матрицы импликации
Дата: 10.12.23
 */
package org.example.fuzzy.matrix

interface ImplicationMatrix {

	val first: Iterable<String>
	val second: Iterable<String>

	operator fun get(firstElement: String, secondElement: String): Float
}