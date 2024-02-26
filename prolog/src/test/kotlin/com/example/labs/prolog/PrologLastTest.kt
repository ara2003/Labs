package com.example.labs.prolog

import com.example.labs.prolog.machine.PrologMachineBase
import com.example.labs.prolog.term.Atom
import com.example.labs.prolog.term.False
import com.example.labs.prolog.term.True
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class PrologLastTest {

	private val machine = PrologMachineBase()

	@BeforeEach
	fun addJoinToMachine() {
		machine
			.runMachine("last(X, [X]).")
			.runMachine("last(X, [H|T]) :- last(X, T).")
	}

	@Test
	fun test1() {
		assertEqualsAsSet(
			machine.runStatement("?- last(R, [a, b])."),
			listOf(mapOf("R" to Atom("b")))
		)
	}

	@Test
	fun test2() {
		assertEqualsAsSet(
			machine.runStatement("?- last(b, [a, b])."),
			True
		)
	}

	@Test
	fun test3() {
		assertEqualsAsSet(
			machine.runStatement("?- last(a, [a, b])."),
			False
		)
	}
}