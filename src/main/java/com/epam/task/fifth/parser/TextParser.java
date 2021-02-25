package com.epam.task.fifth.parser;

public class TextParser extends AbstractParser {
    private final static String SPLITTER = "\r\n";

    public TextParser(Parser successor) {
        super(successor);
    }

    @Override
    protected String getSplitter() {
        return SPLITTER;
    }
}
