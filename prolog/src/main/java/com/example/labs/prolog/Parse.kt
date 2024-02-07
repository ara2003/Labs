package com.example.labs.prolog

import antlr4.exampleBaseVisitor
import antlr4.exampleLexer
import antlr4.exampleParser
import com.example.labs.prolog.expression.Expression
import com.example.labs.prolog.expression.PredicateExpression
import com.example.labs.prolog.expression.TrueExpression
import com.example.labs.prolog.machine.PrologMachineBase
import com.example.labs.prolog.statement.GoalStatement
import com.example.labs.prolog.statement.RuleStatement
import com.example.labs.prolog.statement.Statement
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream

fun runMachine(text: String) {
	val stream = CharStreams.fromString(text)
	val lexer = exampleLexer(stream)
	val tokens = CommonTokenStream(lexer)
	val parser = exampleParser(tokens)
	val program = parser.program()
	val machine = PrologMachineBase()
	program.code().stmt().forEach {
		val input = StatementVisitor.visit(it)
		machine.runStatement(input)
	}
}

object ExpressionVisitor : exampleBaseVisitor<Expression>() {

	override fun visitPredicate(ctx: exampleParser.PredicateContext): Expression {
		return PredicateExpression(
			ctx.predicateName().ID().text,
			ctx.term().map { it.ID().text },
		)
	}
}

object StatementVisitor : exampleBaseVisitor<Statement>() {

	override fun visitFactStmt(ctx: exampleParser.FactStmtContext): Statement {
		return RuleStatement(
			ctx.predicateName().ID().text,
			ctx.term().map { it.ID().text },
			TrueExpression
		)
	}

	override fun visitGoalStmt(ctx: exampleParser.GoalStmtContext): Statement {
		return GoalStatement(ExpressionVisitor.visit(ctx.expr()))
	}

	override fun visitRuleStmt(ctx: exampleParser.RuleStmtContext): Statement {
		return RuleStatement(
			ctx.predicateName().ID().text,
			ctx.term().map { it.ID().text },
			ExpressionVisitor.visit(ctx.expr())
		)
	}
}
