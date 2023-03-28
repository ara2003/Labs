package com.example.lab;

import java.io.IOException;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import antlr4.exampleBaseListener;
import antlr4.exampleLexer;
import antlr4.exampleParser;

public class Main {
	
	public static void main(String[] args) throws IOException {
		var stream = CharStreams.fromStream(Main.class.getClassLoader().getResourceAsStream("test.txt"));
		var lexer = new exampleLexer(stream);
		var tokens = new CommonTokenStream(lexer);
		var parser = new exampleParser(tokens);
		
		var code = parser.code();
		System.out.println(tokens.getTokens().stream().filter(x -> x.getChannel() == 0).mapToInt(x -> x.getType())
				.mapToObj(x -> parser.getVocabulary().getDisplayName(x)).toList());
		
		var listener = new PrintAllTreeListener(parser);
		var t = new ParseTreeWalker();
		t.walk(listener, code);
	}
	
	private static int solveDepth(String string) {
		var index = string.indexOf('\t');
		if(index < 0)
			return 0;
		return string.length() - index;
	}
	
	public static final class MyListener extends exampleBaseListener {
	}
	
	public static final class PrintAllTreeListener implements ParseTreeListener {
		
		private final Parser parser;
		
		int depth;
		
		public PrintAllTreeListener(Parser parser) {
			this.parser = parser;
		}
		
		@Override
		public void enterEveryRule(ParserRuleContext ctx) {
			System.out.print(" ".repeat(depth));
			System.out.println(parser.getRuleNames()[ctx.getRuleIndex()]);
			depth++;
		}
		
		@Override
		public void exitEveryRule(ParserRuleContext ctx) {
			depth--;
		}
		
		@Override
		public void visitErrorNode(ErrorNode node) {
			System.err.print(" ".repeat(depth));
			System.err.println(node.getText());
		}
		
		@Override
		public void visitTerminal(TerminalNode node) {
			System.out.print(" ".repeat(depth));
			System.out.println(node.getText());
			//			System.out.println(parser.getVocabulary().getDisplayName(node.getSymbol().getType()));
		}
		
	}
	
}
