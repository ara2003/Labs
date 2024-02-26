package com.example.labs.prolog

import com.example.labs.prolog.machine.PrologMachineBase
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class PrologJoinTest {

	private val machine = PrologMachineBase()

	@BeforeEach
	fun addJoinToMachine() {
		machine
			.runMachine("join([], X, X).")
			.runMachine("join([X | Y], Z, [X | W]) :- join( Y, Z, W).")
	}

	@Test
	fun test1() {
		assertEqualsAsSet(
			machine.runStatement("?- join(R, [b], [a, b])."),
			listOf(mapOf("R" to parseTerm("[a]")))
		)
	}

	@Test
	fun test2() {
		assertEqualsAsSet(
			machine.runStatement("?- join([a], R, [a, b])."),
			listOf(mapOf("R" to parseTerm("[b]")))
		)
	}

	@Test
	fun test3() {
		assertEqualsAsSet(
			machine.runStatement("?- join([a], [b], R)."),
			listOf(mapOf("R" to parseTerm("[a, b]")))
		)
	}

	@Test
	fun test4() {
		assertEqualsAsSet(
			machine.runStatement("?- join([a, v], [b, c], R)."),
			listOf(mapOf("R" to parseTerm("[a, v, b, c]")))
		)
	}
}