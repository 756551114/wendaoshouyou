package com.cool.wendao.data.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.cool.wendao.community.core.Deleted;
import com.cool.wendao.community.model.PetHelpType;
import com.cool.wendao.community.server.BasePetHelpTypeService;
import com.cool.wendao.data.dao.PetHelpTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

@Service
public class BasePetHelpTypeServiceImpl implements BasePetHelpTypeService {


    @Autowired
    private PetHelpTypeMapper petHelpTypeMapper;


    @Override
    public PetHelpType findOneByName(String name) {
        Example example = new Example(PetHelpType.class);
        example.createCriteria().andCondition("deleted=", Deleted.NOT_DELETED.value()).andCondition("name=",name);
        return petHelpTypeMapper.selectOneByExample(example);
    }
}
