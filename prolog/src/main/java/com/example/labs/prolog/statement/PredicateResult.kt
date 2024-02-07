package com.example.labs.prolog.statement

sealed interface PredicateResult {

	fun map(block: (Map<String, String>) -> Map<String, String>): PredicateResult

	infix fun or(other: PredicateResult): PredicateResult
	infix fun and(other: PredicateResult): PredicateResult
}

data object False : PredicateResult {

	override fun map(block: (Map<String, String>) -> Map<String, String>) = this

	override fun or(other: PredicateResult) = other
	override fun and(other: PredicateResult) = this
}

data class True(
	val values: Iterable<Map<String, String>>,
) : PredicateResult {

	override fun map(block: (Map<String, String>) -> Map<String, String>) = True(values.map(block))

	override fun or(other: PredicateResult) = when(other) {
		is False -> False.or(this)
		is True -> True((values + other.values).distinct())
	}

	override fun and(other: PredicateResult) = when(other) {
		is False -> False.and(this)
		else -> TODO()
	}
}

infix fun PredicateResult.or(other: PredicateResult) = this.or(other)
infix fun PredicateResult.and(other: PredicateResult) = this.and(other)