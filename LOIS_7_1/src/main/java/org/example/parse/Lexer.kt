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

data object Implication : Token

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
			else -> {
				when {
					c.isDigit -> {
						val begin = i
						var end = i
						while(++end < text.length && (text[end].isDigit || text[end].isLetter()));
						yield(Number(substring(begin, end).toFloat()))
						i = end - 1
					}

					c.isLetter() -> {
						val begin = i
						var end = i
						while(++end < text.length && text[end].isDigit);
						yield(Name(substring(begin, end)))
						i = end - 1
					}

					c == '=' -> if(i + 1 == text.length || text[i + 1] != '>') {
						yield(Equals)
					} else {
						yield(Implication)
						i++
					}

					else -> throw UnsupportedOperationException("character = $c")
				}
			}
		}
	}
}.toList()