/**
Лабораторная работа № 4 по дисциплине "Логические основы интеллектуальных систем"
Выполнена студентами группы 021702 БГУИР Кавковым М.А., Латышевым А.Т., Семченковым Н.А.
Файл, реализующий тнорму и импикацию Гогена
Дата: 10.12.23
 */
package org.example.fuzzy

fun impl(a: Float, b: Float) =
	if(a <= b)
		1f
	else
		b / a

fun tNorm(a: Float, b: Float) = a * b
