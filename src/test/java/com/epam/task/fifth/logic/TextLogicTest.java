package com.epam.task.fifth.logic;

import com.epam.task.fifth.entity.Component;
import com.epam.task.fifth.entity.Composite;
import com.epam.task.fifth.entity.Leaf;
import com.epam.task.fifth.entity.LeafType;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

public class TextLogicTest {
    private final TextLogic textLogic = new TextLogic();

    private final Component PARAGRAPH_FIRST = new Composite(Arrays.asList(
            new Composite(Arrays.asList(
                    new Leaf("Hello", LeafType.WORD),
                    new Leaf("world", LeafType.WORD)
            )),
            new Composite(Arrays.asList(
                    new Leaf("I'm", LeafType.WORD),
                    new Leaf("here", LeafType.WORD)
            )))
    );
    private final Component PARAGRAPH_SECOND = new Composite(Collections.singletonList(
            new Composite(Arrays.asList(
                    new Leaf("Hello", LeafType.WORD),
                    new Leaf("there", LeafType.WORD)
            )))
    );
    private final Component FIRST_WORD = new Leaf("one", LeafType.WORD);
    private final Component SECOND_WORD = new Leaf("[5 2 *]", LeafType.EXPRESSION);
    private final Component SECOND_WORD_AFTER = new Leaf("10.0", LeafType.WORD);
    private final Component THIRD_WORD = new Leaf("three", LeafType.WORD);

    private final Composite WORDS = new Composite(
            Arrays.asList(
                    FIRST_WORD,
                    SECOND_WORD,
                    THIRD_WORD
            )
    );

    private final Composite EXPECTED_WORDS = new Composite(
            Arrays.asList(
                    FIRST_WORD,
                    THIRD_WORD,
                    SECOND_WORD
            )
    );

    private final String EXPECTED_TEXT = FIRST_WORD +
            " " + SECOND_WORD_AFTER +
            " " + THIRD_WORD;

    private final Composite PARAGRAPHS = new Composite(
            Arrays.asList(
                    PARAGRAPH_FIRST,
                    PARAGRAPH_SECOND
            )
    );

    private final Composite EXPECTED_PARAGRAPHS = new Composite(
            Arrays.asList(
                    PARAGRAPH_SECOND,
                    PARAGRAPH_FIRST
            )
    );


    @Test
    public void testParagraphSortShouldSortParagraphs() {

        Component result = textLogic.paragraphsSort(PARAGRAPHS);

        Assert.assertEquals(EXPECTED_PARAGRAPHS, result);
    }

    @Test
    public void testSentenceSortShouldSortWordsInSentences() {

        Component result = textLogic.sentenceSort(WORDS);

        Assert.assertEquals(EXPECTED_WORDS, result);
    }

    @Test
    public void testRestoreShouldRestoreTextFromComponent() {

        String result = textLogic.restore(WORDS);

        Assert.assertEquals(EXPECTED_TEXT, result);
    }
}
