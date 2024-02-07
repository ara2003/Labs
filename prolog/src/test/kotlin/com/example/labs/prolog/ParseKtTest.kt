package com.example.labs.prolog

import org.junit.jupiter.api.Test

class ParseKtTest {

	@Test
	fun test1() {
		runMachine(
			"""
food(burger).	// burger is a food
food(sandwich).	// sandwich is a food
food(pizza).	// pizza is a food
lunch(sandwich).	// sandwich is a lunch
dinner(pizza).	

meal(X) :- food(X).

?- food(pizza).
?- meal(X).
?- dinner(sandwich).

		""".trimIndent()
		)
	}
}