package app.controller;

import app.bean.MergeParam;
import app.bean.ResponseCode;
import app.bean.WebResponse;
import app.controller.bean.DatabaseBean;
import app.manager.csv.CsvManager;
import app.manager.csv.CsvMergeManager;
import app.mapper.AppMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Random;

@RestController
@RequestMapping("/app")
public class AppController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AppController.class);

    @Autowired
    private WebResponse webResponse;

    @Autowired
    private AppMapper appMapper;

    @Autowired
    private CsvManager csvManager;

    @Autowired
    private CsvMergeManager csvMergeManager;

    @RequestMapping("/create")
    public String createDatabase(@RequestBody DatabaseBean databaseBean)
    {
//        appMapper.creatDatabase(databaseBean.getDatabaseName());
        LOGGER.info("create database success.basename is {}",databaseBean.getDatabaseName());
        LOGGER.info("select id from one. value is {}",appMapper.selectOne());
        return "SUCCESS";
    }

    @RequestMapping("/getCsv")
    public WebResponse getCsv(){

        try {
            csvManager.excute();
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
