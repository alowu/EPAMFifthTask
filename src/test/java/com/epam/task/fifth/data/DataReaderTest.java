package com.epam.task.fifth.data;

import org.junit.Assert;
import org.junit.Test;

public class DataReaderTest {
    private final String VALID_PATH = "Data/testData.txt";
    private final String INVALID_PATH = "Data/d.txt";

    private final DataReader dataReader = new DataReader();

    @Test
    public void testReadShouldReadWhenFilepathCorrect() throws DataException {
        String expected = "Hello,\r\n" +
                "World!";

        String result = dataReader.read(VALID_PATH);

        Assert.assertEquals(expected, result);
    }

    @Test(expected = DataException.class)
    public void testReadShouldThrowExceptionWhenFilepathInvalid() throws DataException {
        dataReader.read(INVALID_PATH);
    }
}
