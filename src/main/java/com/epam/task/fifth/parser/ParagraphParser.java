package com.epam.task.fifth.parser;

import com.epam.task.fifth.entity.Component;
import com.epam.task.fifth.entity.Composite;

import java.util.Arrays;

public class ParagraphParser extends AbstractParser {
    private final static String SPLITTER = "[.?!]+ ?";

    public ParagraphParser(Parser successor) {
        super(successor);
    }

    @Override
    public Component parse(String string) {
        String[] sentences = string.split(SPLITTER);

        Composite text = new Composite();
        Arrays.stream(sentences).forEach(sentence->{
            Component component = getSuccessor().parse(sentence);
            text.add(component);
        });

        return text;
    }
}
