package com.epam.task.fifth.parser;

public class ParagraphParser extends AbstractParser {
    private final static String SPLITTER = "[.?!]+ ?";

    public ParagraphParser(Parser successor) {
        super(successor);
    }

    @Override
    protected String getSplitter() {
        return SPLITTER;
    }
}
