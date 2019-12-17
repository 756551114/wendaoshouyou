package com.cool.wendao.data.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.cool.wendao.community.core.Deleted;
import com.cool.wendao.community.model.PackModification;
import com.cool.wendao.community.server.BasePackModificationService;
import com.cool.wendao.data.dao.PackModificationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

@Service
public class BasePackModificationServiceImpl implements BasePackModificationService {
    @Autowired
    private PackModificationMapper packModificationMapper;

    @Override
    public PackModification findOneByAlias(String alias) {
        Example example = new Example(PackModification.class);
        example.createCriteria().andCondition("deleted=", Deleted.NOT_DELETED.value()).andCondition("alias=",alias);
        return packModificationMapper.selectOneByExample(example);
    }

    @Override
    public PackModification findOneByStr(String str) {
        Example example = new Example(PackModification.class);
        example.createCriteria().andCondition("deleted=", Deleted.NOT_DELETED.value()).andCondition("str=",str);
        return packModificationMapper.selectOneByExample(example);
    }
}
