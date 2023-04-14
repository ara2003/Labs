package com.example.lab.expression;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import com.example.lab.SemanticChecker;
import com.example.lab.Type;
import com.example.lab.Variable;
import com.example.lab.statement.StatementContext;

public interface Expression extends SemanticChecker {
	
	default Stream<Variable> useVariables(StatementContext context) {
		return useVariables().map(x -> new Variable(context.getVariableType(x), x));
	}
	
	Stream<String> useVariables();
	Stream<String> useFunctions();
	
	Type tryResolveResultType();
	
	String toMathString();
	
	default String toMathStringWithBrackets() {
		return toMathString();
	}
	
	default Integer tryGetConstElementValue() {
		return null;
	}
	
	default List<Integer> tryGetConstListValue() {
		return null;
	}
	
	default Type resolveResultType(StatementContext context) {
		return Objects.requireNonNull(tryResolveResultType(), () -> getClass().getSimpleName());
	}
	
	@Override
	default void checkSemantic(StatementContext context) {
		context.checkSemantic(useVariables(context));
	}
	
}
