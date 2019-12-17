package com.cool.wendao.data.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.cool.wendao.community.core.Deleted;
import com.cool.wendao.community.model.Choujiang;
import com.cool.wendao.community.server.BaseChoujiangService;
import com.cool.wendao.data.dao.ChoujiangMapper;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

@Service
public class BaseChoujiangServiceImpl implements BaseChoujiangService {

    @Autowired
    private ChoujiangMapper choujiangMapper;


    @Override
    public Choujiang findOneByName(String name) {
        Example example = new Example(Choujiang.class);
        example.createCriteria().andCondition("deleted=", Deleted.NOT_DELETED.value()).andCondition("name=", name);
        return choujiangMapper.selectOneByExample(example);
    }
}
