/**
Лабораторная работа № 4 по дисциплине "Логические основы интеллектуальных систем"
Выполнена студентами группы 021702 БГУИР Кавковым М.А., Латышевым А.Т., Семченковым Н.А.
Файл, реализующий чтение из файла input.txt
Дата: 10.12.23
 */
package org.example.fuzzy

import org.example.fuzzy.matrix.ImplicationMatrix
import org.example.fuzzy.matrix.MapImplicationMatrix
import org.example.fuzzy.set.FuzzySet
import org.example.fuzzy.set.MapFuzzySet
import java.io.FileInputStream
import java.io.InputStreamReader

val facts = mutableMapOf<String, FuzzySet>()
val rules = mutableMapOf<String, ImplicationMatrix>()

interface ReadMode {

	fun read(line: String)
}

object FactReadMode : ReadMode {

	override fun read(line: String) {
		val node = FuzzySetNode(line.tokens)
		val fact = MapFuzzySet()
		facts[node.name] = fact
		for(element in node.elements)
			fact[element.name] = element.degree
	}
}

object RuleReadMode : ReadMode {

	override fun read(line: String) {
		val node = RuleNode(line.tokens)
		val name = node.name
		val firstFact = facts[node.firstFact]!!
		val secondFact = facts[node.secondFact]!!
		val rule = MapImplicationMatrix()
		for(first in firstFact)
			for(second in secondFact)
				rule[first.element, second.element] = impl(first.degree, second.degree)
		rules[name] = rule
	}
}

object TaskReadMode : ReadMode {

	override fun read(line: String) {
		val node = TaskNode(line.tokens)
		val fact = facts[node.fact]!!
		val rule = rules[node.rule]!!
		val resultMax = MapFuzzySet()
		val resultMin = MapFuzzySet()

		for(e in rule.first)
			resultMax[e] = rule.second.minOf {
				val a = fact[it]
				val b = rule[e, it]
				return@minOf when(b) {
					1f -> a
					0f -> 1f
					else -> a / b
				}
			}
		for(e in rule.first)
			resultMin[e] = rule.second.minOf {
				val a = fact[it]
				val b = rule[e, it]
				return@minOf when(b) {
					1f -> 0f
					0f -> 0f
					else -> a / b
				}
			}
		println("$line min => {$resultMin}")
		println("$line max => {$resultMax}")
	}
}

fun main() {
	val modes = listOf(
		FactReadMode,
		RuleReadMode,
		TaskReadMode
	).iterator()

	FileInputStream("input.txt").use { fin ->
		InputStreamReader(fin).use { reader ->
			var mode = modes.next()
			for(line in reader.readLines()) {
				if(line.isBlank())
					mode = modes.next()
				else
					mode.read(line)
			}
		}
	}
}

