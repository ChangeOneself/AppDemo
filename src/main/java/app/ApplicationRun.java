package app;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@MapperScan("app.mapper.AppMapper")
@RestController
public class ApplicationRun {
    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationRun.class);
    @RequestMapping("/hello")
    public String helloWorld(){
        LOGGER.info(System.getProperty("user.dir"));
        LOGGER.info("This is a test from appDemo'project.");
        return "Hello world!";
    }
    public static void main(String[] args)
    {
        SpringApplication.run(ApplicationRun.class,args);
    }
}
