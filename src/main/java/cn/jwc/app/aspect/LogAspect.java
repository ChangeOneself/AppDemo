package cn.jwc.app.aspect;

import com.alibaba.fastjson.JSONObject;
import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

/**
 * @program: AppDemo
 * @description: 日志切面类
 * @author: Mr.Jiang
 * @create: 2022-06-21 23:02
 **/
@Aspect
@Component
public class LogAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut(value = "@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void logCutPoint(){

    }

    @Before(value = "logCutPoint()")
    public void before(JoinPoint joinPoint){
        MDC.put("ServiceName", "AppDemo");
        Object[] args = joinPoint.getArgs();
        Object object = args[0];
        if (object instanceof JSONObject) {
            JSONObject paramJson = (JSONObject) object;
            String taskId = paramJson.getString("taskId");
            MDC.put("TaskId", taskId);
            LOGGER.info("paramJson = {}", paramJson);
        }

    }
}
