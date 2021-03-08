package app.pgmapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PgSqlMapper {

    void createTable(@Param("schemaName") String schemaName, @Param("tableName") String tableName);

}
