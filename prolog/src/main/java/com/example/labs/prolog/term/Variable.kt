package com.example.labs.prolog.term

data class Variable(val name: String) : Term {

	init {
		require(name.first().isBeginOfVariable())
	}

	override fun match(term: Term) = if(term is Variable && name == term.name)
		True
	else
		listOf(mapOf(name to term))

	override fun values(values: Map<String, Term>) = values[name] ?: this

	override fun toString() = name
}

private fun Char.isBeginOfVariable() = isUpperCase() || this == '_'
