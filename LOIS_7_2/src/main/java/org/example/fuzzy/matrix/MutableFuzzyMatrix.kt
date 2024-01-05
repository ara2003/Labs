/**
Лабораторная работа № 5 по дисциплине "Логические основы интеллектуальных систем"
Выполнена студентами группы 021702 БГУИР Кавковым М.А., Латышев А.Т., Семченков Н.А.
Файл, содержащий интерфейс изменяемой матрицы импликации
Дата: 10.12.23
 */
package org.example.fuzzy.matrix

interface MutableFuzzyMatrix : FuzzyMatrix {

	operator fun set(firstElement: String, secondElement: String, degree: Float)
}