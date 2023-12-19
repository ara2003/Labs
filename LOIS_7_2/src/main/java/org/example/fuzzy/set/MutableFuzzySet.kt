/**
Лабораторная работа № 4 по дисциплине "Логические основы интеллектуальных систем"
Выполнена студентами группы 021702 БГУИР Кавковым М.А., Латышев А.Т., Семченков Н.А.
Файл, содержащий интерфейс изменяемой матрицы импликации
Дата: 10.12.23
 */
package org.example.fuzzy.set

interface MutableFuzzySet : FuzzySet {

	operator fun set(element: String, degree: Float)
	fun remove(element: String)
	fun clear()
}