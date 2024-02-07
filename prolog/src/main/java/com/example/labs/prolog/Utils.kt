package com.example.labs.prolog

val Iterable<*>.size: Int
	get() {
		var size = 0
		val iter = iterator()
		while(iter.hasNext()) {
			iter.next()
			size++
		}
		return size
	}

interface TreeScope<in T> {

	fun yield(node: T)
}

fun <T> tree(root: T, function: TreeScope<T>.(T) -> Boolean): Collection<T> {
	val result = mutableListOf<T>()
	val tree = object : TreeScope<T> {
		override fun yield(node: T) {
			if(function(node))
				result.add(node)
		}
	}
	tree.yield(root)
	return result
}

infix fun <E> Iterable<E>.cross(other: Iterable<E>) = run {
	val mut = other.toMutableList()
	filter {
		mut.remove(it)
	}
}