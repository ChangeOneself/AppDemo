package app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@MapperScan("app.mapper.AppMapper")
@RestController
public class ApplicationRun {
    @RequestMapping("/hello")
    public String helloWorld(){
        System.out.println("This is a test from appDemo'project.");
        return "Hello world!";
    }

    public static void main(String[] args)
    {
        SpringApplication.run(ApplicationRun.class,args);
    }
}
