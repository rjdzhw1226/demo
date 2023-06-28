package com.readexcel.Dao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

  public void load_file(@Param("path") String path);
}
