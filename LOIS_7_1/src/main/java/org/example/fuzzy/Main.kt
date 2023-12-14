package org.example.fuzzy

import org.example.parse.FuzzySetNode
import org.example.parse.tokens
import java.io.InputStreamReader

interface ReadMode {

	fun read(line: String)
}

class FactReadMode(
	private val facts: MutableMap<String, FuzzySet<String>>,
) : ReadMode {

	override fun read(line: String) {
		val node = FuzzySetNode(line.tokens)
		val set = MapFuzzySet<String>()
		facts[node.name] = set
		for(element in node.elements)
			set[element.name] = element.degree
	}
}

class RuleReadMode(
	private val facts: Map<String, FuzzySet<String>>,
	private val rules: MutableMap<String, ImplicationMatrix<String, String>>,
) : ReadMode {

	override fun read(line: String) {
		val indexFirstEquals = line.indexOf('=')
		val indexSecondEquals = line.indexOf("=>")
		val indexOpen = line.indexOf('(')
		val indexClose = line.indexOf(')')
		val rule = line.substring(0, indexFirstEquals).trim()
		val fact1 = facts[line.substring(indexOpen + 1, indexSecondEquals).trim()]!!
		val fact2 = facts[line.substring(indexSecondEquals + 2, indexClose).trim()]!!
		rules[rule] = ImplicationMatrix(fact1, fact2)
	}
}

class TaskReadMode(
	private val facts: Map<String, FuzzySet<String>>,
	private val rules: Map<String, ImplicationMatrix<String, String>>,
) : ReadMode {

	override fun read(line: String) {
		val indexOpen = line.indexOf('(')
		val indexClose = line.indexOf(')')
		val indexComma = line.indexOf(',')
		val fact = facts[line.substring(indexOpen + 1, indexComma).trim()]!!
		val rule = rules[line.substring(indexComma + 1, indexClose).trim()]!!
		println("$line = ${TimesFuzzySet(rule, fact)}")
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

	Unit::class.java.classLoader.getResourceAsStream("input.txt")?.let {
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

