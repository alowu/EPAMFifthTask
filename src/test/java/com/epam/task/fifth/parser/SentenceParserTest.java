package com.epam.task.fifth.parser;

import com.epam.task.fifth.entity.Component;
import com.epam.task.fifth.entity.Composite;
import com.epam.task.fifth.entity.Leaf;
import com.epam.task.fifth.entity.LeafType;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class SentenceParserTest {
    private final String SENTENCE = "Hello, world [1 5 8 * +]";
    private final Component EXPECTED = new Composite(Arrays.asList(
            new Leaf("Hello", LeafType.WORD),
            new Leaf("world", LeafType.WORD),
            new Leaf("[1 5 8 * +]", LeafType.EXPRESSION)
    ));
    private final SentenceParser sentenceParser = new SentenceParser();

    @Test
    public void testParseShouldParseSentencesToLexemes() {
        //when
        Component result = sentenceParser.parse(SENTENCE);

        //then
        Assert.assertEquals(EXPECTED, result);
    }
}
