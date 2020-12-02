package app.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
public interface AppMapper {
    void creatDatabase(String databaseName);
    String selectOne();
}
