package com.example.labs.prolog

import com.example.labs.prolog.expression.PredicateExpression
import com.example.labs.prolog.machine.PrologMachineBase
import com.example.labs.prolog.term.Atom
import com.example.labs.prolog.term.EmptyList
import com.example.labs.prolog.term.False
import com.example.labs.prolog.term.True
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ParseKtTest {

	@Test
	fun testParseExpression() {
		assertEquals(
			PredicateExpression("test", listOf(Atom("a"), Atom("b"))),
			parseExpression("test(a, b).")
		)
	}

	@Test
	fun testEquals() {
		val machine = PrologMachineBase()

		machine
			.runMachine("equals(X, X).")

		assertEqualsAsSet(
			machine.runStatement("?- equals(X, [])."),
			listOf(mapOf("X" to EmptyList))
		)
		assertEqualsAsSet(
			machine.runStatement("?- equals([], X)."),
			listOf(mapOf("X" to EmptyList))
		)
	}

	@Test
	fun testFirst() {
		val machine = PrologMachineBase()

		machine
			.runMachine("first(X, [X|T]).")

		assertEqualsAsSet(
			machine.runStatement("?- first(R, [a, b])."),
			listOf(mapOf("R" to Atom("a")))
		)
		assertEqualsAsSet(
			machine.runStatement("?- first(a, [a, b])."),
			True
		)
		assertEqualsAsSet(
			machine.runStatement("?- first(a, [b, a])."),
			False
		)
		assertEqualsAsSet(
			machine.runStatement("?- first(a, [])."),
			False
		)
	}

	@Test
	fun testAppend() {
		val machine = PrologMachineBase()

		machine
			.runMachine("append(X, L, [X|L]).")

		assertEqualsAsSet(
			machine.runStatement("?- append(a, [b, c], R)."),
			listOf(mapOf("R" to parseTerm("[a, b, c]")))
		)
		assertEqualsAsSet(
			machine.runStatement("?- append(a, R, [a, b, c])."),
			listOf(mapOf("R" to parseTerm("[b, c]")))
		)
		assertEqualsAsSet(
			machine.runStatement("?- append(R, [b, c], [a, b, c])."),
			listOf(mapOf("R" to parseTerm("a")))
		)
		assertEqualsAsSet(
			machine.runStatement("?- append(R, [b, v], [a, b, c])."),
			False
		)
	}

	@Test
	fun testRemoveFirst() {
		val machine = PrologMachineBase()

		machine
			.runMachine("removeFirst(X, [_|X]).")

		assertEqualsAsSet(
			machine.runStatement("?- removeFirst(R, [a, b, c])."),
			listOf(mapOf("R" to parseTerm("[b, c]")))
		)
	}

	@Test
	fun constInParameter() {
		val machine = PrologMachineBase()

		machine
			.runMachine("test(a).")
			.runMachine("test(b).")

		assertEqualsAsSet(
			machine.runStatement("?- test(X)."),
			listOf(mapOf("X" to Atom("b")), mapOf("X" to Atom("a")))
		)
	}

	@Test
	fun test1() {
		runMachine(
			"""
last(X, [X]).
last(X, [H|T]) :- last(X, T).
		""".trimIndent()
		)
			.runStatement("?- last(R, [a, b]).")
			.forEach {
				println(it)
			}
	}
}