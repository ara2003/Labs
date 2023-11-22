package com.example.lab.interpreter;

import com.example.lab.FunctionContext;

import java.util.List;

public interface InterpreterContext extends FunctionContext {

    void returnVoid();

    void callFunctionVoid(String name, List<Object> arguments);

    void setValue(String name, int value);

    void setValue(String name, List<Integer> value);

    int getValueElement(String name);

    List<Integer> getValueList(String name);

    InterpreterContext block();

}
