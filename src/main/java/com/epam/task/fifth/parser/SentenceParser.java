package com.epam.task.fifth.parser;

import com.epam.task.fifth.entity.Component;
import com.epam.task.fifth.entity.Composite;

import java.util.Arrays;

public class SentenceParser extends AbstractParser {
    private final static String SPLITTER = " ";

    public SentenceParser(Parser successor) {
        super(successor);
    }

    @Override
    public Component parse(String string) {
        String[] words = string.split(SPLITTER);

        Composite text = new Composite();
        Arrays.stream(words).forEach(word->{
            Component component = getSuccessor().parse(word);
            text.add(component);
        });

        return text;
    }
}
