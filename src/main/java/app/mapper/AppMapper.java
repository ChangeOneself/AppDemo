package app.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
public interface AppMapper {
    void creatDatabase(String databaseName);


    void createTable(@Param("schemaName") String schemaName,@Param("tableName") String tableName);

    void createAppTable();

    String selectOne();
}
