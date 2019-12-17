package com.cool.wendao.data.dao;

import com.cool.wendao.community.model.SaleClassifyGood;
import org.apache.ibatis.annotations.CacheNamespace;
import tk.mybatis.mapper.common.Mapper;

@CacheNamespace
public interface SaleClassifyGoodMapper extends Mapper<SaleClassifyGood> {
}
