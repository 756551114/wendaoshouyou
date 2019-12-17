package com.cool.wendao.data.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.cool.wendao.community.core.Deleted;
import com.cool.wendao.community.model.StoreInfo;
import com.cool.wendao.community.server.BaseStoreInfoService;
import com.cool.wendao.data.dao.StoreInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

@Service
public class BaseStoreInfoServiceImpl implements BaseStoreInfoService {
    @Autowired
    private StoreInfoMapper storeInfoMapper;

    @Override
    public StoreInfo findOneByName(String name) {
        Example example = new Example(StoreInfo.class);
        example.createCriteria().andCondition("deleted=", Deleted.NOT_DELETED.value()).andCondition("name=", name);
        return storeInfoMapper.selectOneByExample(example);
    }
}
