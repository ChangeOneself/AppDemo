package cn.jwc.app.config;

import org.slf4j.MDC;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @program: AppDemo
 * @description: 启动初始化类
 * @author: Mr.Jiang
 * @create: 2022-06-18 14:30
 **/
@Component
public class StarterConf implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        MDC.put("ServiceName", "AppDemo");
    }
}
