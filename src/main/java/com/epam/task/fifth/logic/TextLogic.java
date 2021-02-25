package com.epam.task.fifth.logic;

import com.epam.task.fifth.calculator.Calculator;
import com.epam.task.fifth.entity.Component;
import com.epam.task.fifth.entity.Composite;
import com.epam.task.fifth.entity.Leaf;
import com.epam.task.fifth.entity.LeafType;

import java.util.List;
import java.util.stream.Collectors;

public class TextLogic {

    public Composite paragraphsSort(Composite text) {
        List<Component> current = text.get();
        Composite sortedParagraphs = new Composite(current.stream()
                .sorted((first, second) -> {
                    List<Component> firstParagraph = ((Composite) first).get();
                    List<Component> secondParagraph = ((Composite) second).get();

                    return firstParagraph.size() - secondParagraph.size();
                })
                .collect(Collectors.toList()));

        return sortedParagraphs;
    }

    public Composite sentenceSort(Composite sentence) {
        List<Component> current = sentence.get();
        Composite sortedSentence = new Composite(current.stream()
                .sorted((first, second) -> {
                    String firstLexeme = first.toString();
                    String secondLexeme = second.toString();

                    return firstLexeme.length() - secondLexeme.length();
                })
                .collect(Collectors.toList()));

        return sortedSentence;
    }

    private Component calculate(Component expression, Calculator calculator) {
        String lexeme = ((Leaf)expression).getLexeme();

        Double result = (Double) calculator.calculate(lexeme);

        return new Leaf(result.toString(), LeafType.WORD);
    }

    public String restore(Composite composite) {
        List<Component> lexemes = composite.get();
        StringBuilder stringBuilder = new StringBuilder();
        Calculator calculator = new Calculator();

        for (Component lexeme : lexemes) {
            Component toNumber = lexeme;

            if (((Leaf)lexeme).getType() == LeafType.EXPRESSION) {
                toNumber = calculate(lexeme, calculator);
            }
            String word = toNumber.toString();

            stringBuilder.append(word).append(" ");
        }

        return stringBuilder.toString().trim();
    }
}
