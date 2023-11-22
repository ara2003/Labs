package com.greentree.commons.serialization.porlog

fun prolog(block: PrologScope.() -> Unit) {
	object : PrologScope {
		val templates = mutableListOf<Pair<Predicate, List<Predicate>>>()

		override fun predicate(predicate: Predicate, conditions: List<Predicate>) {
			templates.add(predicate to conditions)
		}

		override fun question(predicate: Predicate): Iterable<Map<String, Term>> = sequence {
			for((p, conditions) in templates) {
				val values = mutableMapOf<String, Term>()
				if(!p.resolution(predicate, values.asValueScope()))
					continue
				println(values)
				if(!predicate.resolution(p, values.asValueScope()))
					continue
				println(values)
				if(false)
					yield(values)
			}
		}.toSet()
	}.block()
}

private fun Predicate.set(params: Map<String, Term>) =
	Predicate(name, args.map { if(it is Variable) params[it.name] ?: it else it })

fun MutableMap<String, Term>.asValueScope() = object : ValueScope {
	val map get() = this@asValueScope

	override fun set(name: String, value: Term): Boolean {
		val v = map[name]
		if(v != null) {
			if(value is Const && v is Const)
				return value == v
			if(value is Const && v is Variable) {
				map[v.name] = value
				map[name] = value
				return true
			}
			if(value is Variable && v is Const) {
				return v == map[value.name]
			}
			TODO("set $map $name $value $v")
		}
		map[name] = value
		return true
	}
}

fun interface ValueScope {

	operator fun set(name: String, value: Term): Boolean
}

data class Predicate(val name: String, val args: List<Term>) {

	fun resolution(obj: Predicate, values: ValueScope) =
		obj.name == this.name && args.size == obj.args.size && args.zip(obj.args)
			.sortedBy { (a, b) -> if(a is Const) 0 else 1 }.map { (a, b) ->
				println("$a $b ${a.resolution({ n, v -> true }, b)}")
				a.resolution(values, b)
			}.all { it }

	override fun toString() = "$name(${args.map { it.toString() }.reduce { a, b -> "$a, $b" }})"
}

interface PrologScope {

	fun predicate(predicate: Predicate, conditions: List<Predicate>)
	fun question(predicate: Predicate): Iterable<Map<String, Term>>
}

fun PrologScope.predicate(name: String, vararg args: Term) = predicate(Predicate(name, args.toList()), listOf())
fun PrologScope.predicate(name: String, vararg args: Term, block: suspend SequenceScope<Predicate>.() -> Unit) =
	predicate(Predicate(name, args.toList()), sequence(block).toList())

fun PrologScope.question(name: String, vararg args: Term) = question(Predicate(name, args.toList()))

fun main() {
	prolog {
		predicate("append", v("X"), of(), v("X"))
		predicate("append", of(), v("X"), v("X"))
//		predicate("append", v("X"), v("Y"), v("Z")) {
//			yield(Predicate("append", listOf(v("Y"), v("X"), v("Z"))))
//		}
		question("append", v("Y"), of(), of()).forEach {
			println(it)
		}
	}
}

