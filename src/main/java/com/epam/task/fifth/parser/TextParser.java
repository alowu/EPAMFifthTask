package com.epam.task.fifth.parser;

import com.epam.task.fifth.entity.Component;
import com.epam.task.fifth.entity.Composite;

import java.util.Arrays;

public class TextParser extends AbstractParser {
    private final static String SPLITTER = "\r\n";

    public TextParser(Parser successor) {
        super(successor);
    }

    @Override
    public Component parse(String string) {
        String[] paragraphs = string.split(SPLITTER);

        Composite text = new Composite();
        Arrays.stream(paragraphs).forEach(paragraph->{
            Component component = getSuccessor().parse(paragraph);
            text.add(component);
        });

        return text;
    }
}
