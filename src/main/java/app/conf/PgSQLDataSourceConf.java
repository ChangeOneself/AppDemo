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
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "app.pgmapper", sqlSessionTemplateRef  = "pgSqlSessionTemplate")
public class PgSQLDataSourceConf {
    @Bean(name = "pgSqlDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.pgsql")
    public DataSource secondDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "pgSqlSessionFactory")
    public SqlSessionFactory firstSqlSessionFactory(@Qualifier("pgSqlDataSource") DataSource dataSource) throws Exception{
        SqlSessionFactoryBean bean=new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:pgsqlmap/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "pgSqlSessionTemplate")
    public SqlSessionTemplate secondSqlSessionTemplate(@Qualifier("pgSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws  Exception{
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
