package app.manager.csv;

import app.bean.CsvDownLoadParam;
import app.bean.MergeParam;
import app.bean.ResponseCode;
import app.bean.WebResponse;
import app.util.AppFileUtil;
import app.util.ExcelStyleFatory;
import com.opencsv.CSVReader;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.*;

@Service
public class CsvMergeManager {

    @Qualifier("getInterlationa")
    @Autowired
    private Map<String, Properties> getInterlationa;
    @Autowired
    private WebResponse webResponse;
    private Properties properties;
    private List<String> needCsvName;
    private Workbook workbook = new SXSSFWorkbook();
    private static final String BASE_DIR = System.getProperty("user.dir")+File.separator;
    private static final String BASE_DIR_TEMP = BASE_DIR+"TEMP"+File.separator;
    private static final String DIR_TESTFILE = BASE_DIR_TEMP+"test.xlsx";
    public WebResponse excute(MergeParam mergeParam) {
        try(OutputStream outputStream = new FileOutputStream(DIR_TESTFILE)){
            needCsvName = getNeedCsvName(mergeParam);
            createSummary();
            createOtherSheet();
            workbook.write(outputStream);
        }catch (Exception e){
            webResponse.setResultCode(ResponseCode.FAILURE);
            webResponse.setDescription("this is reason:"+e.getMessage());
            webResponse.setResultUri("33333");
            return webResponse;
        }finally {
            new File(BASE_DIR_TEMP).delete();
            try {
                workbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        webResponse.setResultCode(ResponseCode.SUCCESS);
        webResponse.setDescription("OK");
        webResponse.setResultUri("33333");
        return webResponse;
    }

    /**
     * 生成其他的Sheet页
     * @throws IOException
     */
    private void createOtherSheet() throws IOException {
        for(int i = 0;i<needCsvName.size();i++){
            CSVReader csvReader = new CSVReader(new FileReader(
                    new File(BASE_DIR_TEMP+needCsvName.get(0)+".csv")));
            List<String[]> rows = csvReader.readAll();
           Sheet newSheet = workbook.createSheet(needCsvName.get(i));
            for (int j = 0;j<rows.size();j++){
                if(j == 0){
                    Row zoreRow = newSheet.createRow(j);
                    String[] csvTile = properties.getProperty(needCsvName.get(0)).split(",");
                    for(int k = 0;k<csvTile.length;k++){
                        Cell newCell = zoreRow.createCell(k);
                        newCell.setCellValue(csvTile[k]);
//                        newCell.setCellStyle(ExcelStyleFatory.titleStyle());
                    }
                }
                Row newRow = newSheet.createRow(j);
                String[] row = rows.get(j);
                for(int k = 0;k<row.length;k++){
                    Cell newCell = newRow.createCell(k);
                    newCell.setCellValue(row[k]);
//                    newCell.setCellStyle(ExcelStyleFatory.titleStyle());
                }
            }
        }
    }

    private void createSummary() {
        Sheet oneSheet = workbook.createSheet();
        Row oneRow = oneSheet.createRow(0);
        Cell oneOneCell = oneRow.createCell(0);
        oneOneCell.setCellValue(properties.getProperty(needCsvName.get(0)+"_sheetName"));
        oneOneCell.setCellStyle(ExcelStyleFatory.titleStyle());
        Cell oneTwoCell = oneRow.createCell(1);
        oneTwoCell.setCellValue(123);
        Row twoRow = oneSheet.createRow(1);
        Cell twoOneCell = twoRow.createCell(0);
        twoOneCell.setCellValue(properties.getProperty(needCsvName.get(1)+"_sheetName"));
        twoOneCell.setCellStyle(ExcelStyleFatory.titleStyle());
        Cell twoTwoCell = twoRow.createCell(1);
        twoTwoCell.setCellValue(456);
        Row threeRow = oneSheet.createRow(2);
        Cell threeOneCell = threeRow.createCell(0);
        threeOneCell.setCellValue(properties.getProperty(needCsvName.get(2)+"_sheetName"));
        threeOneCell.setCellStyle(ExcelStyleFatory.titleStyle());
        Cell threeTwoCell = threeRow.createCell(1);
        threeTwoCell.setCellValue(789);
    }

    private List<String> getNeedCsvName(MergeParam mergeParam) {
        if("zh_CN".equalsIgnoreCase(mergeParam.getLocal()))
        {
            properties = getInterlationa.get("zh");
        }else {
            properties = getInterlationa.get("en");
        }
        List<String> needCsvName = new ArrayList<>();
        List<CsvDownLoadParam> csvList = mergeParam.getCsvFile();
        for(CsvDownLoadParam csvDownLoadParam:csvList){
            if(StringUtils.isNotBlank(csvDownLoadParam.getCsvUUID())){
                needCsvName.add(csvDownLoadParam.getCsvName());
            }
        }
        return needCsvName;
    }
}
