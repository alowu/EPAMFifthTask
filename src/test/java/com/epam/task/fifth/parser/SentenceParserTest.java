package com.epam.task.fifth.parser;

import com.epam.task.fifth.entity.Component;
import com.epam.task.fifth.entity.Composite;
import com.epam.task.fifth.entity.Leaf;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.mockito.Mockito.when;

public class SentenceParserTest {
    private final Parser lexemeParser = Mockito.mock(LexemeParser.class);
    private final Parser sentenceParser = new SentenceParser(lexemeParser);

    private final String FIRST_WORD = "Hello";
    private final String SECOND_WORD = "world";
    private final String TEXT = FIRST_WORD + ", " + SECOND_WORD;

    @Test
    public void testParseShouldParseSentencesToWords(){
        Component first = new Leaf(FIRST_WORD);
        Component second = new Leaf(SECOND_WORD);

        Component expected = new Composite(Arrays.asList(first, second));

        when(lexemeParser.parse(FIRST_WORD)).thenReturn(first);
        when(lexemeParser.parse(SECOND_WORD)).thenReturn(second);

        Component result = sentenceParser.parse(TEXT);

        Assert.assertEquals(expected, result);
    }
}
