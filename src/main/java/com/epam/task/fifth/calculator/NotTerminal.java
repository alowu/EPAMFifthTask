package com.epam.task.fifth.calculator;

import java.util.ArrayDeque;

public class NotTerminal implements Interpreter{
    private double number;

    public NotTerminal(double number) {
        this.number = number;
    }

    @Override
    public void interpret(ArrayDeque<Double> stack) {
        stack.push(number);
    }
}
