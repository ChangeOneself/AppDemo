package cn.jwc.app;

import org.slf4j.MDC;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;

/**
 * @program: AppDemo
 * @description: 启动初始化类
 * @author: Mr.Jiang
 * @create: 2022-06-18 14:30
 **/
public class StarterConf implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {

        MDC.put("ServiceName", "AppDemo");
    }
}
