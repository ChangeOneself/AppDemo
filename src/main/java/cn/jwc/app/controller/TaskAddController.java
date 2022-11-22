package cn.jwc.app.controller;

import cn.jwc.app.bean.ResultCode;
import cn.jwc.app.bean.ResultResponse;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: AppDemo
 * @description: 任务创建Controller
 * @author: Mr.Jiang
 * @create: 2022-11-22 23:17
 **/
@RestController
@RequestMapping("/baseTask")
public class TaskAddController {
    public static final Logger LOGGER = LoggerFactory.getLogger(TaskAddController.class);

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResultResponse insertTask(@RequestBody JSONObject paramJson) {
        LOGGER.info("paramJson = {}", paramJson);
        return ResultResponse.builder().resultCode(ResultCode.SUCCESS.getResultCode()).build();
    }
}
