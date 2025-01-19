package com.example.lab

import antlr4.exampleBaseVisitor
import antlr4.exampleParser.*
import com.example.lab.expression.AssignExpressionProvider
import com.example.lab.expression.EqualsExpressionProvider
import com.example.lab.expression.FuncCallExpressionProvider
import com.example.lab.expression.IfExpressionProvider
import com.example.lab.expression.LiteralElementExpression
import com.example.lab.expression.MergeExpressionProvider
import com.example.lab.expression.VariableExpression
import com.example.lab.expression.provider.ExpressionProvider
import org.antlr.v4.runtime.ParserRuleContext

object ExpressionParseTreeVisitor : exampleBaseVisitor<ExpressionProvider>() {

	override fun visitMergeCode(ctx: MergeCodeContext): ExpressionProvider {
		return MergeExpressionProvider(visit(ctx.stmt()), visit(ctx.code()))
	}

	override fun visitAssignStmt(ctx: AssignStmtContext): ExpressionProvider {
		val lvalue = visit(ctx.lvalue())
		val rvalue = visit(ctx.rvalue())
		return AssignExpressionProvider(lvalue, rvalue)
	}

	override fun visitVarName(ctx: VarNameContext): ExpressionProvider {
		return VariableExpression.provider(ctx.text)
	}

	override fun visitNumberExpr(ctx: NumberExprContext): ExpressionProvider {
		return LiteralElementExpression.provider(ctx.text.toInt())
	}

	override fun visitCompareExpr(ctx: CompareExprContext) = visitBiExpression(ctx)
	override fun visitLogicExpr(ctx: LogicExprContext) = visitBiExpression(ctx)
	override fun visitSumExpr(ctx: SumExprContext) = visitBiExpression(ctx)

	private fun visitBiExpression(ctx: ParserRuleContext): ExpressionProvider {
		var result = visit(ctx.getChild(0))
		var i = 1
		while(i < ctx.childCount) {
			val sign = ctx.getChild(i).text
			val expr = ctx.getChild(i + 1).accept(this)
			result = when(sign) {
//				"+" -> SumExpression.newExpression(result, expr)
//				"-" -> NegativeExpression.newExpression(result, expr)
//				"*" -> MultExpression.newExpression(result, expr)
//				"/" -> DivExpression.newExpression(result, expr)
//				"%" -> RemainderDivisionExpression.newExpression(result, expr)
//				"^" -> XORExpression.newExpression(result, expr)
//				"and" -> AndExpression.newExpression(result, expr)
//				"or" -> OrExpression.newExpression(result, expr)
				"==" -> EqualsExpressionProvider(result, expr)
//				"!=" -> NotEqualsExpression.newExpression(result, expr)
//				">=" -> MoreOrEqualsExpression.newExpression(result, expr)
//				">" -> MoreExpression.newExpression(result, expr)
//				"<=" -> LessOrEqualsExpression.newExpression(result, expr)
//				"<" -> LessOrEqualsExpression.newExpression(result, expr)
				else -> throw IllegalArgumentException("Unexpected value: $sign")
			}
			i += 2
		}
		return result
	}

	override fun visitIfExpr(ctx: IfExprContext): ExpressionProvider {
		val expr = visit(ctx.rvalue())
		val then = visit(ctx.codeBlockStmt())
		val `else` = ctx.elseStmt()?.let { visit(it) }
		return IfExpressionProvider(expr, then, `else`)
	}

	override fun visitFuncCallExpr(ctx: FuncCallExprContext): ExpressionProvider {
		val name = ctx.ID().text
		val arguments = ctx.arguments().rvalue().map { visit(it) }
		return FuncCallExpressionProvider(name, arguments)
	}

	override fun aggregateResult(aggregate: ExpressionProvider?, nextResult: ExpressionProvider?): ExpressionProvider? {
		if(aggregate == null)
			return nextResult
		if(nextResult == null)
			return aggregate
		throw UnsupportedOperationException("$aggregate $nextResult")
	}
}
