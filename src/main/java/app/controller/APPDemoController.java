package app.controller;

import app.bean.ResponseCode;
import app.bean.WebResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/appdemo")
public class APPDemoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(APPDemoController.class);

    @RequestMapping("/test")
    public WebResponse getTestCode() {
        LOGGER.info(ResponseCode.valueOf("FAILURE").toString());
        LOGGER.info(ResponseCode.FAILURE.toString());
        for (ResponseCode code : ResponseCode.values()) {
            LOGGER.info(code.getResponseCode() + "");
            LOGGER.info(code.getResponseDescription() + "");
        }
        return new WebResponse();
    }
}