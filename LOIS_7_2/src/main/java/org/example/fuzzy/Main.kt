package org.example.fuzzy

import org.example.fuzzy.matrix.ImplicationMatrix
import org.example.fuzzy.matrix.MapImplicationMatrix
import org.example.fuzzy.set.FuzzySet
import org.example.fuzzy.set.MapFuzzySet
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
		val result = MapFuzzySet()

		for(e in rule.first)
			result[e] = rule.second.minOf {
				impl(rule[e, it], fact[it])
			}

		println("$line => {$result}")
	}
}

fun main() {
	val modes = listOf(
		FactReadMode,
		RuleReadMode,
		TaskReadMode
	).iterator()

	Unit::class.java.classLoader.getResourceAsStream("input.txt")!!.let {
		InputStreamReader(it).use { reader ->
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
