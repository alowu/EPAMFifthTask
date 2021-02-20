package com.epam.task.fifth.parser;

public class ChainBuilder {
    Parser build(){
        return new TextParser(
                new ParagraphParser(
                        new SentenceParser(
                                new LexemeParser()
                        )
                )
        );
    }
}
