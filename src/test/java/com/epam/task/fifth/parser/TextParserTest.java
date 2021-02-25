package com.epam.task.fifth.parser;

import com.epam.task.fifth.entity.Component;
import com.epam.task.fifth.entity.Composite;
import com.epam.task.fifth.entity.Leaf;
import com.epam.task.fifth.entity.LeafType;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collections;

import static org.mockito.Mockito.when;

public class TextParserTest {

    private final Parser paragraphParser = Mockito.mock(ParagraphParser.class);
    private final Parser textParser = new TextParser(paragraphParser);

    private final String FIRST_INDENT = "Hello, World!";
    private final String SECOND_INDENT = "I'm here.";
    private final String TEXT = FIRST_INDENT + "\r\n" + SECOND_INDENT;

    @Test
    public void testParseShouldParseTextToParagraphs(){
        //given
        Component first = new Composite(Collections.singletonList(
                new Composite(Arrays.asList(
                        new Leaf("Hello", LeafType.WORD),
                        new Leaf("World", LeafType.WORD)
                ))
        ));

        Component second = new Composite(Collections.singletonList(
                new Composite(Arrays.asList(
                        new Leaf("I'm", LeafType.WORD),
                        new Leaf("Here", LeafType.WORD)
                ))
        ));

        Component expected = new Composite(Arrays.asList(first, second));

        when(paragraphParser.parse(FIRST_INDENT)).thenReturn(first);
        when(paragraphParser.parse(SECOND_INDENT)).thenReturn(second);


        //when
        Component result = textParser.parse(TEXT);

        //then
        Assert.assertEquals(expected, result);
    }
}
