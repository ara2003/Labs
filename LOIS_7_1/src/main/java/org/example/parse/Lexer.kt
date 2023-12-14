package org.example.parse

sealed interface Token

data class Number(val value: Float) : Token
data class Name(val value: String) : Token

data object OpenBracket : Token
data object CloseBracket : Token

data object OpenSetBracket : Token
data object CloseSetBracket : Token

data object Equals : Token

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
			'{' -> yield(OpenSetBracket)
			'}' -> yield(CloseSetBracket)
			'=' -> yield(Equals)
			else -> {
				val begin = i
				var end = i
				if(c.isDigit) {
					while(++end < text.length && (text[end].isDigit || text[end].isLetter()));
					yield(Number(substring(begin, end).toFloat()))
				} else {
					while(++end < text.length && text[end].isDigit);
					yield(Name(substring(begin, end)))
				}
				i = end - 1
			}
		}
	}
}.toList()