package com.example.lab;

import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.TerminalNode;

public final class PrintAllTreeListener implements ParseTreeListener {
	
	private final Parser parser;
	
	int depth;
	
	public PrintAllTreeListener(Parser parser) {
		this.parser = parser;
	}
	
	@Override
	public void enterEveryRule(ParserRuleContext ctx) {
		System.out.print("  ".repeat(depth));
		System.out.println(parser.getRuleNames()[ctx.getRuleIndex()]);
		depth++;
	}
	
	@Override
	public void exitEveryRule(ParserRuleContext ctx) {
		depth--;
	}
	
	@Override
	public void visitErrorNode(ErrorNode node) {
		System.err.print("  ".repeat(depth));
		System.err.println(node.getText());
	}
	
	@Override
	public void visitTerminal(TerminalNode node) {
		System.out.print("  ".repeat(depth));
		System.out.print(parser.getVocabulary().getDisplayName(node.getSymbol().getType()));
		System.out.print("  ");
		System.out.println(node.getText());
	}
	
}
