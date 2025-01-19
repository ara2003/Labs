package com.example.lab;

import com.example.lab.expression.Expression.Type;

import java.util.Objects;

public record Variable(Type type, String name) {

    public Variable(String name) {
        this(Type.ELEMENT, name);
    }

    public Variable {
        Objects.requireNonNull(type);
        Objects.requireNonNull(name);
    }

    public String toCodeString() {
        return switch (type) {
            case ELEMENT -> "element " + name;
            case LIST -> "list " + name;
            case UNIT -> "unit " + name;
            case NOTHING -> "nothing " + name;
        };
    }

}
