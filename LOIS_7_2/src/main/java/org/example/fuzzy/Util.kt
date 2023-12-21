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

fun String.joinBackets(
	begin: Char,
	body: Char,
	end: Char,
	begin2Line: Char = begin,
	enf2Line: Char = end,
	center: Char = body,
) =
	when(count { it == '\n' }) {
		0 -> this
		1 -> "!${this}".replace("\n", "\n!")
			.replaceFirst('!', begin2Line)
			.replaceLast('!', enf2Line)

		else -> "!${this}".replace("\n", "\n!")
			.replaceFirst('!', begin)
			.replaceLast('!', end)
			.replace('!', body)
	}

fun String.replaceLast(oldChar: Char, newChar: Char): String {
	var index = indexOfLast {
		it == oldChar
	}

	if(index == -1)
		return this
	return "${substring(0, index)}$newChar${substring(index + 1)}"
}
