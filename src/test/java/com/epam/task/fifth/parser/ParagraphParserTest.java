package com.epam.task.fifth.parser;

import com.epam.task.fifth.entity.Component;
import com.epam.task.fifth.entity.Composite;
import com.epam.task.fifth.entity.Leaf;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.mockito.Mockito.when;

public class ParagraphParserTest {
    private final Parser sentenceParser = Mockito.mock(SentenceParser.class);
    private final Parser paragraphParser = new ParagraphParser(sentenceParser);

    private final String FIRST_SEN = "Hello, world";
    private final String SECOND_SEN = "I'm here";
    private final String TEXT = FIRST_SEN + "! " + SECOND_SEN + ".";

    @Test
    public void testParseShouldParseParagraphsToSentences() {
        //given
        Component first = new Composite(Arrays.asList(
                new Leaf("Hello"),
                new Leaf("world")
        ));
        Component second = new Composite(Arrays.asList(
                new Leaf("I'm"),
                new Leaf("here")
        ));
        Component expected = new Composite(Arrays.asList(first, second));

        when(sentenceParser.parse(FIRST_SEN)).thenReturn(first);
        when(sentenceParser.parse(SECOND_SEN)).thenReturn(second);

        //when
        Component result = paragraphParser.parse(TEXT);

        //then
        Assert.assertEquals(expected, result);
    }
}
