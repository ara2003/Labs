package com.example.labs.prolog.term

import com.example.labs.prolog.isEmpty

typealias PredicateResult = Iterable<ResultRow>
typealias ResultRow = Map<String, Term>
@Deprecated("", ReplaceWith("ResultRow"))
typealias PredicateResultRow = ResultRow

infix fun PredicateResult.or(other: PredicateResult) = (this + other).toSet()
infix fun PredicateResult.and(other: PredicateResult) = run {
	val res = this.rect(other) { a, b -> a merge b }
	if(res.isEmpty())
		False
	else
		res.toSet()
}

fun Iterable<PredicateResult>.foldOr() = fold(False, PredicateResult::or)
fun Iterable<PredicateResult>.foldAnd() = fold(True, PredicateResult::and)

infix fun PredicateResult.composition(other: PredicateResult): PredicateResult {
	return this.rect(other) { a, b ->
		a composition b
	}
}

private fun <K, V, R : Any> Map<K, V>.mapValuesNotNull(transform: (Map.Entry<K, V>) -> R?) =
	mapValues(transform).filterValues { it != null } as Map<K, R>

infix fun <A, B, C> Map<A, B>.composition(other: Map<B, C>): Map<A, C> {
	val result = mutableMapOf<A, C>()
	for((a, b) in this) {
		val c = other[b]
		if(c != null)
			result[a] = c
	}
	return result
}

@JvmName("compositionTerm")
infix fun ResultRow.composition(other: ResultRow): ResultRow {
	val result = mutableMapOf<String, Term>()
	for((a, b) in this) {
		val c = b.values(other)
		result[a] = c
	}
	return result
}

fun Boolean.toResult() = if(this)
	True
else
	False

val False = setOf<Map<String, Term>>() as PredicateResult
val True = setOf(mapOf<String, Term>()) as PredicateResult

private infix fun <K, V : Term> Map<K, V>.merge(other: Map<K, V>): Map<K, V> {
	val other = other.toMutableMap()
	val result = mutableMapOf<K, V>()
	for((k, v) in this) {
		val o = other[k]
		if(o == null)
			result[k] = v
		else {
			other.remove(k)
			when {
				v.match(o) != False -> result[k] = o
				o.match(v) != False -> result[k] = v
				else -> {
					TODO("> $k $v $o")
					return mapOf()
				}
			}
		}
	}
	result.putAll(other)
	return result
}

private fun <T1, T2, R> Iterable<T1>.rect(other: Iterable<T2>, block: (T1, T2) -> R): Iterable<R> {
	val result = mutableListOf<R>()
	for(a in this)
		for(b in other)
			result.add(block(a, b))
	return result
}