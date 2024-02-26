package com.example.labs.prolog

import com.example.labs.prolog.machine.PrologMachineBase
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class PrologRemoveLastTest {

	private val machine = PrologMachineBase()

	@BeforeEach
	fun addToMachine() {
		machine
			.runMachine("removeLast([], [_]).")
			.runMachine("removeLast([_|A], [_|B]) :- removeLast(A, B).")
	}

	@Test
	fun test1() {
		assertEqualsAsSet(
			machine.runStatement("?- removeLast(R, [a, b, c])."),
			listOf(mapOf("R" to parseTerm("[a, b]")))
		)
	}

	@Test
	fun test2() {
		assertEqualsAsSet(
			machine.runStatement("?- removeLast([a, b, c], R)."),
			listOf(mapOf("R" to parseTerm("[a, b, c, X]")))
		)
	}
}