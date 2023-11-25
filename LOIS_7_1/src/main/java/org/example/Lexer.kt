package org.example

sealed interface Token

data class Number(val value: Double) : Token
data class Name(val value: String) : Token

data object OpenBracket : Token
data object CloseBracket : Token

data object Comma : Token

val String.tokens
	get() = tokens()
val Char.isDigit
	get() = isDigit() || this == '-' || this == '.'

fun String.tokens() = sequence {
	val text = this@tokens
	var i = -1
	while(++i < text.length) {
		val c = text[i]
		when(c) {
			' ', '\t', '\n' -> {}
			',' -> yield(Comma)
			'(' -> yield(OpenBracket)
			')' -> yield(CloseBracket)
			else -> {
				val begin = i
				var end = i
				if(c.isDigit) {
					while(++end < text.length && text[end].isDigit);
					yield(Number(substring(begin, end).toDouble()))
				} else {
					while(++end < text.length && text[end].isLetter());
					yield(Name(substring(begin, end)))
				}
				i = end - 1
			}
		}
	}
}.toList()