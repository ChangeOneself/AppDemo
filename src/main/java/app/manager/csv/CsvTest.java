package app.manager.csv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CsvTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(CsvTest.class);


    public static void main(String[] args) {
        for(int i = 0;i<100;i++){
            LOGGER.info("num = {[]}",i);
        }
    }
}
