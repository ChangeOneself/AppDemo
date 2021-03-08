package app.controller;

import app.bean.MergeParam;
import app.bean.ResponseCode;
import app.bean.WebResponse;
import app.controller.bean.DatabaseBean;
import app.manager.csv.CsvManager;
import app.manager.csv.CsvMergeManager;
import app.mapper.MySqlMapper;
import app.pgmapper.PgSqlMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/app")
public class AppController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AppController.class);

    @Autowired
    private WebResponse webResponse;

    @Autowired
    private MySqlMapper mySqlMapper;

    @Autowired
    private PgSqlMapper pgSqlMapper;

    @Autowired
    private CsvManager csvManager;

    @Autowired
    private CsvMergeManager csvMergeManager;

    @RequestMapping("/create")
    public String createDatabase(@RequestBody DatabaseBean databaseBean)
    {
        mySqlMapper.createAppTable();
        mySqlMapper.insertDataForPeople();
        LOGGER.info("insert data success.");
        mySqlMapper.updateDataForPeople();
        LOGGER.info("update data success.");
        pgSqlMapper.createTable("app","rrrr1112341242342");
        LOGGER.info("create database success.basename is {}",databaseBean.getDatabaseName());
        return "SUCCESS";
    }

    @RequestMapping("/getCsv")
    public WebResponse getCsv(){

        try {
            csvManager.execute();
            webResponse.setResultCode(ResponseCode.SUCCESS);
            webResponse.setResultUri("");
            webResponse.setDescription("20000");
        } catch (IOException e) {
            e.printStackTrace();
            webResponse.setResultCode(ResponseCode.FAILURE);
            webResponse.setResultUri("");
            webResponse.setDescription(e.getMessage());
        }
        return webResponse;
    }

    @RequestMapping("/csvMerge")
    @ResponseBody
    public WebResponse csvMergeExcute(@RequestBody MergeParam mergeParam){
        LOGGER.info(mergeParam.toString());
        return csvMergeManager.excute(mergeParam);
    }
}
