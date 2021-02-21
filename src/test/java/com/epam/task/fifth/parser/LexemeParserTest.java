package com.epam.task.fifth.parser;

import com.epam.task.fifth.entity.Component;
import com.epam.task.fifth.entity.Leaf;
import org.junit.Assert;
import org.junit.Test;

public class LexemeParserTest {
    private final Parser parser = new LexemeParser();

    @Test
    public void testParserShouldParseStringToLexeme() {
        String given = "test-word";
        Component expected = new Leaf(given);

        Component result = parser.parse(given);

        Assert.assertEquals(expected, result);
    }
}
