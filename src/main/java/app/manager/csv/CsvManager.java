package app.manager.csv;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CsvManager {
    private static final Logger LOG = LoggerFactory.getLogger(CsvManager.class);
    public void execute() throws IOException {
        File csvFile = new File("test.csv");
        CSVWriter csvWriter = new CSVWriter(new FileWriter(csvFile));
        List<String[]> csvRows = new ArrayList<>();
        String[] csvTitle = {"ONE","TWO","THREE"};
        csvRows.add(csvTitle);
        String[] csv = {"123","456","789"};
        for(int i = 0;i < 100;i++){
            csvRows.add(csv);
        }
        csvWriter.writeAll(csvRows);
        csvWriter.close();
        CSVReader csvReader = new CSVReader(new FileReader(csvFile));
        String[] title = csvReader.readNext();
        LOG.info("title is {}", Arrays.toString(title));
        for (String col:title){
            LOG.info(col);
        }
        for(String[] row : csvReader.readAll()){
            StringBuilder string = new StringBuilder();
            for(String col:row){
                string.append(col);
            }
            LOG.info("col is {}",string);
        }

    }
}
