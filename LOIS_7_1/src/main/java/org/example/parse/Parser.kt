package org.example.parse

sealed interface Node

data class FuzzyElementNode(val name: String, val degree: Float) : Node
data class FuzzySetNode(val name: String, val elements: List<FuzzyElementNode>) : Node

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

fun FuzzyElementNode(tokens: Iterator<Token>): FuzzyElementNode = with(tokens) {
	(next() as OpenBracket)
	val name = (next() as Name).value
	(next() as Comma)
	val degree = (next() as Number).value
	(next() as CloseBracket)
	FuzzyElementNode(name, degree)
}

fun FuzzyElementNode(tokens: List<Token>) = FuzzyElementNode(tokens.iterator())
