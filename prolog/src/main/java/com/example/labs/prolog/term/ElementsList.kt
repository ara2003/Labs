package com.example.labs.prolog.term

import com.example.labs.prolog.size

val EmptyList = ElementsList(listOf())

data class ElementsList(
	val elements: Iterable<Term>,
) : Term {

	constructor(vararg elements: Term) : this(listOf(*elements))

	override fun match(term: Term) = when(term) {
		is ElementsList -> {
			if(elements.size != term.elements.size)
				False
			else
				elements.zip(term.elements) { a, b ->
					a.match(b)
				}.foldAnd()
		}

		else -> False
	}

	override fun values(values: Map<String, Term>) = ElementsList(elements.map { it.values(values) })

	override fun toString() = elements.toString()
}