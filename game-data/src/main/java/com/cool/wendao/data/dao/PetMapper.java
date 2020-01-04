package com.cool.wendao.data.dao;

import com.cool.wendao.admin.core.MgtPageBean;
import com.cool.wendao.community.model.Pet;
import org.apache.ibatis.annotations.CacheNamespace;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@CacheNamespace
public interface PetMapper extends Mapper<Pet> {
    List<Pet> findByPageBean(MgtPageBean<Pet> pageBean);
}
