package com.cool.wendao.data.dao;

import com.cool.wendao.community.model.VipAdd;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.math.BigDecimal;

@CacheNamespace
public interface VipAddMapper extends Mapper<VipAdd> {
    BigDecimal getUserAdd( @Param("userId") Integer userId);
}
