package com.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
@com.crypto.batch.config.db.annotation.DbConnection
public interface testMapper {
    void insertUser();
}
