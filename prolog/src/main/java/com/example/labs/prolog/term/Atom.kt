package com.example.labs.prolog.term

data class Atom(val name: String) : Term {

	init {
		require(name.first().isLowerCase())
	}

	override fun match(term: Term) = equals(term).toResult()

	override fun values(values: Map<String, Term>) = this

	override fun toString() = name

	override fun isMaybeList() = false
}