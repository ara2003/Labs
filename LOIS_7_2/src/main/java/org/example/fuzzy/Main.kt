/**
Лабораторная работа № 5 по дисциплине "Логические основы интеллектуальных систем"
Выполнена студентами группы 021702 БГУИР Кавковым М.А., Латышевым А.Т., Семченковым Н.А.
Файл, реализующий чтение из файла input.txt
Дата: 10.12.23
 */
package org.example.fuzzy

import org.example.fuzzy.matrix.FuzzyMatrix
import org.example.fuzzy.matrix.MapFuzzyMatrix
import org.example.fuzzy.matrix.toMutableFuzzyMatrix
import org.example.fuzzy.set.FuzzySet
import org.example.fuzzy.set.MapFuzzySet
import org.example.fuzzy.solution.Solution
import org.example.fuzzy.solution.ValueSolution
import org.example.fuzzy.value.range
import java.io.FileInputStream
import java.io.InputStreamReader

val facts = mutableMapOf<String, FuzzySet>()
val rules = mutableMapOf<String, FuzzyMatrix>()

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
		val node = FuzzyRelationNode(line.tokens)
		val name = node.name
		val rule = MapFuzzyMatrix()
		for(element in node.elements)
			rule[element.arguments.first, element.arguments.second] = element.degree
		rules[name] = rule
	}
}

object TaskReadMode : ReadMode {

	override fun read(line: String) {
		val node = TaskNode(line.tokens)
		val fact = facts[node.fact]!!
		val rule = rules[node.rule]!!.toMutableFuzzyMatrix()
		var result: Solution = Solution.AnySolution
//		println(rule)
//		println(fact)
		for((y, degree) in fact) {
			var yresult: Solution = Solution.NothingSolution
			for(x in rule.first) {
				if(rule[x, y] < degree)
					continue
				var xresult: Solution = ValueSolution(x, degree / rule[x, y])
				for(ox in rule.first)
					if(ox != x) {
						val a = degree / rule[ox, y]
						if(a <= 1f)
							xresult *= ValueSolution(ox, range(0f, a))
					}
				yresult += xresult
			}
			result *= yresult
		}
		println(result)
		println()
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

