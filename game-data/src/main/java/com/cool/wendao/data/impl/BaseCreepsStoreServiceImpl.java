package com.cool.wendao.data.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.cool.wendao.community.core.Deleted;
import com.cool.wendao.community.model.CreepsStore;
import com.cool.wendao.community.server.BaseCreepsStoreService;
import com.cool.wendao.data.dao.CreepsStoreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class BaseCreepsStoreServiceImpl implements BaseCreepsStoreService {


    @Autowired
    private CreepsStoreMapper creepsStoreMapper;


    @Override
    public List<CreepsStore> findAll() {
        Example example = new Example(CreepsStore.class);
        example.createCriteria().andCondition("deleted=", Deleted.NOT_DELETED.value());
        return creepsStoreMapper.selectByExample(example);
    }

    @Override
    public CreepsStore findOneByName(String name) {
        Example example = new Example(CreepsStore.class);
        example.createCriteria().andCondition("deleted=", Deleted.NOT_DELETED.value()).andCondition("name=", name);
        return creepsStoreMapper.selectOneByExample(example);
    }
}
