/**
Лабораторная работа № 5 по дисциплине "Логические основы интеллектуальных систем"
Выполнена студентами группы 021702 БГУИР Кавковым М.А., Латышевым А.Т., Семченковым Н.А.
Файл, реализующий парсер
Дата: 10.12.23
 */
package org.example.fuzzy

sealed interface Node

data class FuzzyRelationElementNode(val arguments: PairNode, val degree: Float) : Node
data class FuzzyRelationNode(val name: String, val elements: List<FuzzyRelationElementNode>) : Node
data class PairNode(val first: String, val second: String) : Node

data class FuzzyElementNode(val name: String, val degree: Float) : Node
data class FuzzySetNode(val name: String, val elements: List<FuzzyElementNode>) : Node

data class TaskNode(val fact: String, val rule: String) : Node

fun FuzzyRelationElementNode(tokens: Iterable<Token>) = FuzzyRelationElementNode(tokens.iterator())
fun FuzzyRelationElementNode(tokens: Iterator<Token>): FuzzyRelationElementNode = with(tokens) {
	(next() as OpenBracket)
	val arguments = PairNode(this)
	(next() as Comma)
	val value = (next() as Number).value
	(next() as CloseBracket)
	FuzzyRelationElementNode(arguments, value)
}

fun PairNode(tokens: Iterable<Token>) = PairNode(tokens.iterator())
fun PairNode(tokens: Iterator<Token>): PairNode = with(tokens) {
	(next() as OpenContourBracket)
	val first = (next() as Name).value
	(next() as Comma)
	val second = (next() as Name).value
	(next() as CloseContourBracket)
	PairNode(first, second)
}

fun TaskNode(tokens: Iterable<Token>) = TaskNode(tokens.iterator())
fun TaskNode(tokens: Iterator<Token>): TaskNode = with(tokens) {
	(next() as OpenBracket)
	val fact = (next() as Name).value
	(next() as Comma)
	val rule = (next() as Name).value
	(next() as CloseBracket)
	TaskNode(fact, rule)
}

fun FuzzySetNode(tokens: List<Token>): FuzzySetNode = with(tokens) {
	val name = (get(0) as Name).value
	(get(1) as Equals)
	(get(2) as OpenSetBracket)
	val elements = mutableListOf<FuzzyElementNode>()
	var i = 3
	run {
		if(get(i) !is OpenBracket)
			return@run
		val a = FuzzyElementNode(tokens.subList(i, i + 5))
		elements.add(a)
		i += 5
	}
	while(true) {
		if(get(i) !is Comma)
			break
		i++
		val a = FuzzyElementNode(tokens.subList(i, i + 5))
		elements.add(a)
		i += 5
	}
	FuzzySetNode(name, elements)
}

fun FuzzyRelationNode(tokens: List<Token>): FuzzyRelationNode = with(tokens) {
	val name = (get(0) as Name).value
	(get(1) as Equals)
	(get(2) as OpenSetBracket)
	val elements = mutableListOf<FuzzyRelationElementNode>()
	var i = 3
	run {
		if(get(i) !is OpenBracket)
			return@run
		val a = FuzzyRelationElementNode(tokens.subList(i, i + 9))
		elements.add(a)
		i += 9
	}
	while(true) {
		if(get(i) !is Comma)
			break
		i++
		val a = FuzzyRelationElementNode(tokens.subList(i, i + 9))
		elements.add(a)
		i += 9
	}
	FuzzyRelationNode(name, elements)
}

fun FuzzyElementNode(tokens: Iterator<Token>): FuzzyElementNode = with(tokens) {
	(next() as OpenBracket)
	val name = (next() as Name).value
	(next() as Comma)
	val degree = (next() as Number).value
	(next() as CloseBracket)
	FuzzyElementNode(name, degree)
}

fun FuzzyElementNode(tokens: List<Token>) = FuzzyElementNode(tokens.iterator())
