package com.epam.task.fifth.calculator;

import java.util.*;

public class Calculator {
    private List<Interpreter> interpreterList = new ArrayList<>();
    private final String REGEX = " ";

    public Number calculate(String expression) {
        parse(expression);
        ArrayDeque<Double> stack = new ArrayDeque<>();

        for (Interpreter element : interpreterList) {
            element.interpret(stack);
        }
        return stack.pop();
    }

    private void parse(String string) {
        String withoutBrackets = string.replaceAll("[\\[\\]]", "");
        String[] lexemes = withoutBrackets.split(REGEX);

        for (String lexeme : lexemes){
            switch (lexeme) {
                case "+":{
                    interpreterList.add(new Plus());
                    break;
                }
                case "-":{
                    interpreterList.add(new Minus());
                    break;
                }
                case "*":{
                    interpreterList.add(new Multiply());
                    break;
                }
                case "/":{
                    interpreterList.add(new Divide());
                    break;
                }
                default:{
                    interpreterList.add(
                            new NotTerminal(
                                    Double.parseDouble(lexeme)));
                }
            }
        }
    }
}
