package com.epam.task.fifth.calculator;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {
    private final String EXPRESSION = "[2 11 25 * + 5 / 21 + 5 * 125 - 81 9 / +]";
    private final double EXPECTED = 20;
    private final double DELTA = 1e6;

    @Test
    public void testCalculateShouldReturnExpressionResultWhenExpressionStringApplied(){
        Calculator calculator = new Calculator();

        double actual = (double) calculator.calculate(EXPRESSION);

        Assert.assertEquals(EXPECTED, actual, DELTA);
    }
}
