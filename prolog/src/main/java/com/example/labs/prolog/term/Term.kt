package com.example.labs.prolog.term

import antlr4.exampleBaseVisitor
import antlr4.exampleParser

sealed interface Term {

	fun match(term: Term): PredicateResult

	fun values(values: Map<String, Term>): Term

	fun isMaybeList() = true
}

object TermVisitor : exampleBaseVisitor<Term>() {

	private var index = 0

	override fun visitNameTerm(ctx: exampleParser.NameTermContext): Term {
		val text = ctx.ID().text
		return if(text.first().isUpperCase())
			Variable(text)
		else
			Atom(text)
	}

	override fun visitListTermComma(ctx: exampleParser.ListTermCommaContext) =
		ElementsList(ctx.term().map { visit(it) })

	override fun visitListTermHeadTail(ctx: exampleParser.ListTermHeadTailContext) =
		HeadTail(visit(ctx.term(0)), visit(ctx.term(1)))

	override fun visitEmptyTerm(ctx: exampleParser.EmptyTermContext) = Variable("_${index++}")
}