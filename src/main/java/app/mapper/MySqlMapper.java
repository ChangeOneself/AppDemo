package app.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MySqlMapper {
    void creatDatabase(@Param("databaseName") String databaseName);

    void createAppTable();

    void insertDataForPeople();

    void updateDataForPeople();

    String selectOne();
}
