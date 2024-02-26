package com.example.labs.prolog.term

val Term.tail: Term
	get() = when(this) {
		is HeadTailList -> this.tail
		else -> Tail.create(this)
	}

data class Tail private constructor(
	val list: Term,
) : Term {

	companion object {

		fun create(
			list: Term,
		) = Tail(list)
	}

	override fun match(term: Term) = when(term) {
		is ElementsList -> {
			val tail = term.elements.tail()
			list.match(tail)
		}

		is Tail -> list.match(term.list)
		else -> TODO("$this $term")
	}

	override fun values(values: Map<String, Term>) = list.values(values).tail

	override fun toString() = "Tail($list)"
}