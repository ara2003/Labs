package com.example.labs.prolog.term

fun HeadTail(
	head: Term,
	tail: Term,
): Term {
	if(head is Head && tail is Tail && head.list == tail.list) {
		return head.list
	}
	return HeadTailList.create(head, tail)
}

data class HeadTailList private constructor(
	val head: Term,
	val tail: Term,
) : Term {

	companion object {

		fun create(
			head: Term,
			tail: Term,
		) = HeadTailList(head, tail)
	}

	override fun match(term: Term): PredicateResult {
		return when(term) {
			is ElementsList -> {
				val elements = term.elements.toList()
				if(elements.isEmpty())
					return False
				val h = head.match(elements.head())
				val t = tail.match(elements.tail())

				h and t
			}

			is Variable -> {
				head.match(term.head) and tail.match(term.tail)
			}

			is Tail -> {
				head.match(term.head) and tail.match(term.tail)
			}

			is Atom -> False
			else -> TODO("$this $term")
		}
	}

	override fun values(values: Map<String, Term>): Term {
		val head = head.values(values)
		return when(val tail = tail.values(values)) {
			is ElementsList -> ElementsList(listOf(head) + tail.elements)
			else -> if(tail.isMaybeList())
				HeadTail(head, tail)
			else
				TODO("$tail ${this.tail} $values")
		}
	}

	override fun toString() = "[$head|$tail]"
}

fun <T> Iterable<T>.head() = first()
fun <T : Term> Iterable<T>.tail() = toList().tail()
fun <T : Term> List<T>.tail() = ElementsList(subList(1, size))