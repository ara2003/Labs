package org.example.fuzzy

import org.example.fuzzy.matrix.ImplicationMatrix
import org.example.fuzzy.set.FuzzySet
import org.example.fuzzy.set.MapFuzzySet
import java.io.InputStreamReader

interface ReadMode {

	fun read(line: String)
}

class FactReadMode(
	private val facts: MutableMap<String, FuzzySet<String>>,
) : ReadMode {

	override fun read(line: String) {
		val node = FuzzySetNode(line.tokens)
		val fact = MapFuzzySet<String>()
		facts[node.name] = fact
		for(element in node.elements)
			fact[element.name] = element.degree
	}
}

class RuleReadMode(
	private val facts: Map<String, FuzzySet<String>>,
	private val rules: MutableMap<String, ImplicationMatrix<String, String>>,
) : ReadMode {

	override fun read(line: String) {
		val node = RuleNode(line.tokens)
		val name = node.name
		val firstFact = facts[node.firstFact]!!
		val secondFact = facts[node.secondFact]!!
		rules[name] = ImplicationMatrix(firstFact, secondFact)
	}
}

class TaskReadMode(
	private val facts: Map<String, FuzzySet<String>>,
	private val rules: Map<String, ImplicationMatrix<String, String>>,
) : ReadMode {

	override fun read(line: String) {
		val node = TaskNode(line.tokens)
		val fact = facts[node.fact]!!
		val rule = rules[node.rule]!!
		println("$line => {${TimesFuzzySet(rule, fact)}}")
	}
}

fun main() {
	val facts = mutableMapOf<String, FuzzySet<String>>()
	val rules = mutableMapOf<String, ImplicationMatrix<String, String>>()
	val modes = listOf(
		FactReadMode(facts),
		RuleReadMode(facts, rules),
		TaskReadMode(facts, rules)
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

