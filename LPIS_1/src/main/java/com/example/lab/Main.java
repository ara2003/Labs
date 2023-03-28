package com.example.lab;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import antlr4.exampleBaseListener;
import antlr4.exampleLexer;
import antlr4.exampleParser;
import antlr4.exampleParser.Atom_exprContext;
import antlr4.exampleParser.ExprContext;
import antlr4.exampleParser.Id_exprContext;
import antlr4.exampleParser.Mult_exprContext;

public class Main {
	
	
	public static void main(String[] args) {
		var stream = CharStreams.fromString("""
				
				a = 2 + 2 ** 2
				
				""");
		var lexer = new exampleLexer(stream);
		var tokens = new CommonTokenStream(lexer);
		var parser = new exampleParser(tokens);
		
		lexer.printHello();
		
		//		var code = parser.code();
		//		
		//		var listener = new PrintAllTreeListener(parser);
		//		var t = new ParseTreeWalker();
		//		t.walk(listener, code);
		
	}
	
	public static final class MyListener extends exampleBaseListener {
	}
	
	public static final class PrintAllTreeListener implements ParseTreeListener {
		
		private final exampleParser parser;
		
		public PrintAllTreeListener(exampleParser parser) {
			this.parser = parser;
		}
		
		@Override
		public void visitTerminal(TerminalNode node) {
			System.out.print(" ".repeat(depth));
			System.out.println(node.getText());
		}
		
		@Override
		public void visitErrorNode(ErrorNode node) {
			System.out.println("error: " + node);
		}
		
		int depth;
		
		@Override
		public void enterEveryRule(ParserRuleContext ctx) {
			System.out.print("|".repeat(depth));
			System.out.println(parser.getRuleNames()[ctx.getRuleIndex()]);
			depth++;
		}
		
		@Override
		public void exitEveryRule(ParserRuleContext ctx) {
			depth--;
		}
		
	}
	
}
