package com.example.labs.prolog.statement

import com.example.labs.prolog.expression.Expression
import com.example.labs.prolog.expression.TrueExpression
import com.example.labs.prolog.expression.match
import com.example.labs.prolog.expression.values
import com.example.labs.prolog.isEmpty
import com.example.labs.prolog.term.PredicateResult
import com.example.labs.prolog.term.Term
import com.example.labs.prolog.term.foldOr

data class RuleStatement(
	val premise: Expression,
	val consequence: Expression,
) : DataStatement {

	constructor(premise: Expression) : this(premise, TrueExpression)

	override fun solve(context: Expression.Context, expression: Expression): PredicateResult {
		val expressionToPremise = premise.match(expression)
		if(expressionToPremise.isEmpty())
			return expressionToPremise
		println("{")
		println(this)
		println(expression)
		println("expressionToPremise: $expressionToPremise")
		val aaa = expressionToPremise.map { consequence.values(it) }
		println(aaa)
		val premiseToConsequence = aaa.map {
			it.solve(context)
		}.foldOr()
		println("premiseToConsequence: $premiseToConsequence")
		val consequenceResultPremise = premise.values(premiseToConsequence)
		println("consequenceResultPremise: $consequenceResultPremise")
		val resultPremise = consequenceResultPremise.values(premiseToConsequence)
		println("resultPremise: $resultPremise")
		val resultToExpression = expression.match(resultPremise)
		println(resultToExpression)
		println("}")
		return resultToExpression
	}

	//	override fun solve(context: Expression.Context, expression: Expression): PredicateResult {
//		return when(expression) {
//			is PredicateExpression -> {
//				if(predicateName != expression.predicateName)
//					return False
//				if(parameters.size != expression.arguments.size)
//					return False
//				val a = expression.arguments.zip(parameters) { a, b -> a.match(b) }
//				val aa = a.fold(False, PredicateResult::or)
//				val c = parameters.zip(expression.arguments) { a, b -> a.match(b) }.flatten()
//					.map { body.values(it).solve(context) }
//				val result = c.fold(True, PredicateResult::and)
//				val cc = aa composition result
//				println(parameters)
//				println(expression.arguments)
////				println(a)
////				println(aa)
//				println(c)
//				println(result)
//				println(body)
//				println(result)
//				println()
//				cc
//			}
//
//			is TrueExpression -> True
//			else -> TODO("Not yet implemented $this $expression")
//		}
//	}
	//	override fun solve(context: Expression.Context, expression: Expression): PredicateResult {
//		return when(expression) {
//			is PredicateExpression -> {
//				if(predicateName != expression.predicateName)
//					return False
//				val result = mutableMapOf<String, Term>()
//				val arguments = mutableMapOf<String, Term>()
//				parameters.zip(expression.arguments).forEach { (p, a) ->
//					val res = p.match(a)
////					println("> $arguments $res $p $a")
//					if(!arguments.merge(res))
//						return False
//				}
//				parameters.zip(expression.arguments).forEach { (p, a) ->
//					val res = a.match(p)
//					if(res != null && !result.merge(res))
//						return False
//				}
//				val res = result.mapValues { it.value.values(arguments) }
//				println(this)
//				println(arguments)
//				println(res)
//				println()
//				return False
//			}
//
//			is TrueExpression -> True(listOf(mapOf()))
//			else -> TODO("Not yet implemented $this $expression")
//		}
//	}
	override fun toString() = if(consequence is TrueExpression)
		"$premise."
	else
		"$premise :- $consequence."
}

private fun <K, V : Term> MutableMap<K, V>.merge(other: Map<K, V>): Boolean {
//	println("$this $other")
	for((key, value) in other) {
		val t = this[key]
		if(t != null && value != t) {
//			println("$value $t ${value.match(t)}")
			if(value.match(t) != null)
				return false
		}
		this[key] = value
	}
	return true
}
