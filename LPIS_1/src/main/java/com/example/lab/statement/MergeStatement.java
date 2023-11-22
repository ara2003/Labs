package com.example.lab.statement;

import com.example.lab.ReturnType;
import com.example.lab.SemanticError;
import com.example.lab.interpreter.InterpreterContext;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public record MergeStatement(List<? extends Statement> statements) implements Statement {

    public MergeStatement(List<? extends Statement> statements) {
        this.statements = new ArrayList<>(openStatement(statements).toList());
    }

    private Stream<? extends Statement> openStatement(Collection<? extends Statement> list) {
        return list.stream().flatMap(x -> openStatement(x));
    }

    private Stream<? extends Statement> openStatement(Statement statement) {
        if (statement instanceof EmptyStatement)
            return Stream.empty();
        if (statement instanceof MergeStatement ms)
            return ms.statements.stream();
        return Stream.of(statement);
    }

    @Override
    public void runInterpreter(InterpreterContext context) {
        for (var s : statements)
            s.runInterpreter(context);
    }

    @Override
    public Optional<ReturnType> tryResolveReturnType(StatementContext context) {
        var list = new ArrayList<>(statements.stream().map(x -> x.tryResolveReturnType(context))
                .map(x -> x.orElse(null)).distinct().toList());
        if (list.size() == 1)
            return Optional.ofNullable(list.get(0));
        list.remove(null);
        if (list.size() == 1)
            return Optional.ofNullable(list.get(0));
        throw new UnsupportedOperationException("list: " + list);
    }

    public static Statement newStatement(Statement s, List<? extends Statement> statements) {
        return new MergeStatement(Stream.concat(Stream.of(s), statements.stream()).toList());
    }

    public static Statement newStatement(Statement... statements) {
        return newStatement(List.of(statements));
    }

    public static Statement newStatement(List<? extends Statement> statements) {
        return new MergeStatement(statements);
    }

    @Override
    public boolean checkContextSemantic(StatementContext context) {
        boolean result = true;
        for (var x : statements)
            result &= x.checkContextSemantic(context);
        var list = new ArrayList<>(statements.stream().map(x -> x.tryResolveReturnType(context))
                .map(x -> x.orElse(null)).distinct().toList());
        if (list.size() != 1) {
            list.remove(null);
            if (list.size() != 1)
                result &= SemanticError.print("can not resolve return type", line());
        }
        return result;
    }

}
