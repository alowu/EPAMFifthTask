package com.epam.task.fifth.calculator;

import java.util.ArrayDeque;

public class Multiply implements Interpreter{
    @Override
    public void interpret(ArrayDeque<Double> stack) {
        double first = stack.pop();
        double second = stack.pop();
        stack.push(first * second);
    }
}
