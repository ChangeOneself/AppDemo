package cn.jwc.app;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: AppDemo
 * @description: AppDemo启动类
 * @author: Mr.Jiang
 * @create: 2022-06-18 12:39
 **/
@SpringBootApplication
@RestController
@EnableAspectJAutoProxy(proxyTargetClass = true)
@RequestMapping("/appDemoTest")
public class AppDemoApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(AppDemoApplication.class);
    public static void main(String[] args) {
        MDC.put("ServiceName", "AppDemo");
        LOGGER.info("AppDemoApplication|start");
        SpringApplication.run(AppDemoApplication.class, args);
    }

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public void test(@RequestBody JSONObject paramJson){
        for (int i = 0; i < 100000; i ++) {
            LOGGER.info("AppDemoApplication|test|start. {}", i);
        }
        LOGGER.info("AppDemoApplication|test|end. paramJson = {}", paramJson);
    }
}
