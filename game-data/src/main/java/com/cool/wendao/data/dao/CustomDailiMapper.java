package com.cool.wendao.data.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CustomDailiMapper {

    List<Map> selectCount(@Param("name") String name);

    List<Map> selectMoney(@Param("name") String name, @Param("day") int day);

    List<Map> selectAccount(@Param("name") String name);

}
