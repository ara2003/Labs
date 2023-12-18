package org.example.fuzzy

fun impl(a: Float, b: Float) =
	if(a <= b)
		1f
	else
		b / a

fun tNorm(a: Float, b: Float) = a * b

fun <E> List<List<E>>.transpose(): List<List<E>> {
	val result = mutableListOf<MutableList<E>>()
	for(list in this.withIndex()) {
		for(a in list.value.withIndex()) {
			result.safeGet(a.index).safeSet(list.index, a.value)
		}
	}
	return result
}

private fun <E> MutableList<E>.safeSet(index: Int, value: E) {
	if(index < size) {
		set(index, value)
		return
	}
	if(index == size) {
		add(value)
		return
	}
	TODO()
}

private fun <E> MutableList<MutableList<E>>.safeGet(index: Int): MutableList<E> {
	while(size <= index)
		add(mutableListOf())
	return get(index)
}
