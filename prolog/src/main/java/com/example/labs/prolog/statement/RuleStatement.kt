package com.example.labs.prolog.statement

import com.example.labs.prolog.expression.Expression
import com.example.labs.prolog.expression.PredicateExpression
import com.example.labs.prolog.expression.isQ

data class RuleStatement(
	val predicateName: String,
	val parameters: Iterable<String>,
	val body: Expression,
) : DataStatement {

	override fun solve(context: Expression.Context, expression: Expression): PredicateResult {
		when(expression) {
			is PredicateExpression -> {
				if(predicateName != expression.predicateName)
					return False
				val result = mutableMapOf<String, String>()
				val arguments = mutableMapOf<String, String>()
				parameters.zip(expression.arguments).forEach { (p, a) ->
					if(p.isQ)
						arguments[p] = a
					else
						if(a.isQ) {
							result[a] = p
						} else {
							if(p != a)
								return False
						}
				}
				return body.values(arguments).solve(context).map {
					it + result
				}
			}

			else -> {}
		}
		TODO("Not yet implemented $this $expression")
	}
}
