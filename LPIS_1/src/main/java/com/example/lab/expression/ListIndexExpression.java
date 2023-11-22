package com.example.lab.expression;

import com.example.lab.FunctionContext;
import com.example.lab.SemanticError;
import com.example.lab.Type;
import com.example.lab.interpreter.InterpreterContext;
import com.example.lab.statement.AssignTarget;
import com.example.lab.statement.StatementContext;

public record ListIndexExpression(Expression list, Expression index) implements AssignTarget {

    @Override
    public Type getType(FunctionContext context) {
        return Type.ELEMENT;
    }

    @Override
    public boolean checkContextSemantic(StatementContext context) {
        var result = true;
        var typeList = list.getType(context);
        if (typeList != Type.LIST)
            result &= SemanticError.print("type of list in get list index is not list", line());
        var typeIndex = index.getType(context);
        if (typeIndex != Type.ELEMENT)
            result &= SemanticError.print("type of index in get list index is not element", line());
        return result;
    }

    @Override
    public int line() {
        return list.line();
    }

    @Override
    public boolean init(StatementContext context, Type type) {
        if (type != Type.ELEMENT)
            return SemanticError.print("set '" + type + "' to 'element' variable", line());
        return true;
    }

    @Override
    public void assign(InterpreterContext context, Expression expr) {
        throw new IllegalArgumentException();
    }

}
