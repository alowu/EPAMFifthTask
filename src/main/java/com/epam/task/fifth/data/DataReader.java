package com.epam.task.fifth.data;

import org.apache.log4j.Logger;

import java.io.*;

public class DataReader {
    private static final Logger LOG = Logger.getLogger(DataReader.class);

    public String read(String fileName) throws DataException {
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;

        try{
            FileInputStream fileInputStream = new FileInputStream(fileName);
            inputStreamReader = new InputStreamReader(fileInputStream);
            bufferedReader = new BufferedReader(inputStreamReader);

            StringBuilder stringBuilder = new StringBuilder();

            while(bufferedReader.ready()){
                char symbol =(char) bufferedReader.read();
                stringBuilder.append(symbol);
            }

            return new String(stringBuilder);
        } catch (IOException e) {
            throw new DataException(e.getMessage(), e);
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
            } catch (IOException e) {
                LOG.error(e.getMessage(), e);
            }
        }
    }
}
