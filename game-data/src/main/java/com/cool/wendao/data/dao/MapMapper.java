package com.cool.wendao.data.dao;

import com.cool.wendao.community.model.Map;
import org.apache.ibatis.annotations.CacheNamespace;
import tk.mybatis.mapper.common.Mapper;


@CacheNamespace
public interface MapMapper extends Mapper<Map> {
}
