package app.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;


import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Configuration
public class CsvPropertiesConf {

    public Properties getZhPro() throws IOException {
        InputStream inputStream = new ClassPathResource("conf/zh_CN.properties").getInputStream();
        Properties properties = new Properties();
        properties.load(inputStream);
        return properties;
    }

    public Properties getEnPro() throws IOException {
        InputStream inputStream = new ClassPathResource("conf/en_US.properties").getInputStream();
        Properties properties = new Properties();
        properties.load(inputStream);
        return properties;
    }

    @Bean
    public Map<String,Properties> getInterlationa() throws IOException {
        Map<String,Properties> propertiesMap = new HashMap<>();
        propertiesMap.put("zh",getZhPro());
        propertiesMap.put("en",getEnPro());
        return propertiesMap;
    }
}
