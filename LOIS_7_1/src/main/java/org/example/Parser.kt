package org.example

sealed interface Node

data class Leaf(val token: Token) : Node

data class Predicate(val name: String, val arguments: List<Node>) : Node

fun parseTree(tokens: List<Token>): Node {
	if(tokens.size == 1)
		return Leaf(tokens.first())
	val funcName = (tokens.first() as Name).value
	val arguments = tokens.subList(2, tokens.size - 1).splitArguments().map { parseTree(it) }.toList()
	return Predicate(funcName, arguments)
}

fun List<Token>.splitArguments() = sequence {
	val tokens = this@splitArguments
	var arg = mutableListOf<Token>()
	var b = 0
	for(token in tokens) {
		when(token) {
			Comma -> {
				if(b == 0) {
					yield(arg)
					arg = mutableListOf()
				} else
					arg += token
			}

			OpenBracket -> {
				b++
				arg += token
			}

			CloseBracket -> {
				b--
				arg += token
			}

			else -> arg += token
		}
	}
	yield(arg)
}