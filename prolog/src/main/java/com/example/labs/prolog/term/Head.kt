package com.example.labs.prolog.term

val Term.head: Term
	get() = when(this) {
		is HeadTailList -> this.head
		else -> Head.create(this)
	}

data class Head private constructor(
	val list: Term,
) : Term {

	companion object {

		fun create(
			list: Term,
		) = Head(list)
	}

	override fun match(term: Term) = when(term) {
		is Atom -> when(list) {
			is Variable -> True
			else -> TODO("$list $term")
		}

		is HeadTailList -> True
		is Head -> list.match(term.list)
		else -> TODO("$this $term")
	}

	override fun values(values: Map<String, Term>) = list.values(values).head

	override fun toString() = "Head($list)"
}