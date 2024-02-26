package com.example.labs.prolog

import antlr4.exampleBaseVisitor
import antlr4.exampleLexer
import antlr4.exampleParser
import com.example.labs.prolog.expression.Expression
import com.example.labs.prolog.expression.PredicateExpression
import com.example.labs.prolog.expression.TrueExpression
import com.example.labs.prolog.machine.PrologMachine
import com.example.labs.prolog.machine.PrologMachineBase
import com.example.labs.prolog.statement.GoalStatement
import com.example.labs.prolog.statement.RuleStatement
import com.example.labs.prolog.statement.Statement
import com.example.labs.prolog.term.PredicateResult
import com.example.labs.prolog.term.Term
import com.example.labs.prolog.term.TermVisitor
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream

fun runMachine(text: String) = PrologMachineBase().runMachine(text)

fun PrologMachine.runMachine(text: String): PrologMachine {
	parseCode(text).program().code().stmt().forEach {
		val input = StatementVisitor.visit(it)
		this.runStatement(input)
	}
	return this
}

fun PrologMachine.runStatement(text: String): PredicateResult {
	val stmt = parseStatement(text)
	return runStatement(stmt)
}

fun parseTerm(text: String): Term {
	val expr = parseCode(text).term()
	return TermVisitor.visit(expr)
}

fun parseExpression(text: String): Expression {
	val expr = parseCode(text).expr()
	return ExpressionVisitor.visit(expr)
}

fun parseStatement(text: String): Statement {
	val stmt = parseCode(text).stmt()
	return StatementVisitor.visit(stmt)
}

fun parseCode(text: String): exampleParser {
	val stream = CharStreams.fromString(text)
	val lexer = exampleLexer(stream)
	val tokens = CommonTokenStream(lexer)
	return exampleParser(tokens)
}

object ExpressionVisitor : exampleBaseVisitor<Expression>() {

	override fun visitPredicate(ctx: exampleParser.PredicateContext): Expression {
		return PredicateExpression(
			ctx.predicateName().ID().text,
			ctx.term().map { TermVisitor.visit(it) },
		)
	}
}

object StatementVisitor : exampleBaseVisitor<Statement>() {

	override fun visitFactStmt(ctx: exampleParser.FactStmtContext): Statement {
		return RuleStatement(
			ExpressionVisitor.visit(ctx.expr()),
			TrueExpression
		)
	}

	override fun visitGoalStmt(ctx: exampleParser.GoalStmtContext): Statement {
		return GoalStatement(ExpressionVisitor.visit(ctx.expr()))
	}

	override fun visitRuleStmt(ctx: exampleParser.RuleStmtContext): Statement {
		return RuleStatement(
			ExpressionVisitor.visit(ctx.expr(0)),
			ExpressionVisitor.visit(ctx.expr(1)),
		)
	}
}
