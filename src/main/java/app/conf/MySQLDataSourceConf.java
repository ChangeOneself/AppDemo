package app.conf;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = {"app.mapper"}, sqlSessionTemplateRef = "mySqlSessionTemplate")
public class MySQLDataSourceConf {
    // 未指明bean的名称时，优先使用该bean
    @Primary
    @Bean(name = "mySqlDataSource")
    // 设置数据库属性来源
    @ConfigurationProperties(prefix = "spring.datasource.mysql")
    public DataSource mySqlDataSource(){
        // 默认是Hikari
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "mySqlSessionFactory")
    public SqlSessionFactory mySqlSessionFactory(@Qualifier("mySqlDataSource")DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        // 设置Mapper.xml文件的扫描处
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mysqlmap/*.xml"));
        // mybatis相关设置
//        bean.setConfigLocation(new ClassPathResource("mysqlone.xml"));
        return bean.getObject();
    }

    @Primary
    @Bean(name = "mySqlSessionTemplate")
        public SqlSessionTemplate mySqlSessionTemplate(@Qualifier("mySqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
