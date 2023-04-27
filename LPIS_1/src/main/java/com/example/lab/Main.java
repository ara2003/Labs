package com.example.lab;

import java.io.File;
import java.io.IOException;
import java.util.BitSet;
import java.util.List;

import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;

import com.example.lab.statement.StatementContextImpl;

import antlr4.exampleLexer;
import antlr4.exampleParser;

public class Main {
	
	
	public static void main(String[] args) throws IOException {
		for(var f : new File("src/main/resources/tests").listFiles())
			print(f);
	}
	
	public static void print(File in) throws IOException {
		var stream = CharStreams.fromFileName(in.getCanonicalPath());
		var lexer = new exampleLexer(stream);
		var tokens = new CommonTokenStream(lexer);
		var parser = new exampleParser(tokens);
		
		parser.removeErrorListeners();
		parser.addErrorListener(new ANTLRErrorListener() {
			
			@Override
			public void reportAmbiguity(Parser recognizer, DFA dfa, int startIndex, int stopIndex, boolean exact,
					BitSet ambigAlts, ATNConfigSet configs) {
				//				System.out.printf("Ambiguity at indexes: %d %d\n", startIndex, stopIndex);
			}
			
			@Override
			public void reportAttemptingFullContext(Parser recognizer, DFA dfa, int startIndex, int stopIndex,
					BitSet conflictingAlts, ATNConfigSet configs) {
				//				System.out.printf("Attempting Full Context at indexes: %d %d\n", startIndex, stopIndex);
			}
			
			@Override
			public void reportContextSensitivity(Parser recognizer, DFA dfa, int startIndex, int stopIndex,
					int prediction, ATNConfigSet configs) {
				//				System.out.printf("Context Sensitivity at indexes: %d %d\n", startIndex, stopIndex);
			}
			
			@Override
			public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line,
					int charPositionInLine, String msg, RecognitionException e) {
				System.out.printf("Syntax error line: %d colum: %d message: %s\n", line, charPositionInLine, msg);
			}
		});
		
		var code = parser.program();
		
		//		System.out.println(in);
		//		System.out.println(code.getText());
		//		System.out.println(tokens.getTokens().stream().filter(x -> x.getChannel() == 0).mapToInt(x -> x.getType())
		//				.mapToObj(x -> parser.getVocabulary().getDisplayName(x)).reduce((a, b) -> a + " " + b).get());
		//		System.out.println(tokens.getTokens().stream().filter(x -> x.getChannel() == 0).map(x -> x.getText()).toList());
		
		//		var listener = new PrintAllTreeListener(parser);
		//		var t = new ParseTreeWalker();
		//		t.walk(listener, code);
		
			var visitor = new StatementParseTreeVisitor(new ExpressionParseTreeVisitor(), new LValueParseTreeVisitor());
			var result = visitor.visit(code);
			
			var context = new StatementContextImpl();
			context.funcDef(new Function("input", List.of(), ReturnType.ELEMENT));
			context.funcDef(new Function("print", List.of(Type.ELEMENT), ReturnType.VOID));
			context.funcDef(new Function("print", List.of(Type.LIST), ReturnType.VOID));
			context.funcDef(new Function("add", List.of(Type.LIST, Type.ELEMENT), ReturnType.VOID));
			context.funcDef(new Function("range", List.of(Type.ELEMENT), ReturnType.LIST));
			context.funcDef(new Function("range", List.of(Type.ELEMENT, Type.ELEMENT), ReturnType.LIST));
			context.funcDef(new Function("range", List.of(Type.ELEMENT, Type.ELEMENT, Type.ELEMENT), ReturnType.LIST));
			
			result.checkContextSemantic(context);
			
			//			System.out.println(context.getReturnType(new FunctionSignature("fact", List.of(Type.ELEMENT))));
			
		//		System.out.println(result.toCodeString(context));
		
		//		for(var e : result.usedExpressions().toList()) {
		//			System.out.println(e.toMathString());
		//			System.out.println(e.useVariables(context).toList());
		//			System.out.println(e.useFunctions().toList());
		//			System.out.println(e.tryResolveResultType());
		//			System.out.println(e.tryGetConstElementValue());
		//			System.out.println(e.tryGetConstListValue());
		//			System.out.println();
		//		}
	}
	
	
}
