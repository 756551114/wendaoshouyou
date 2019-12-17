package com.cool.wendao.data.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.cool.wendao.community.core.Deleted;
import com.cool.wendao.community.model.Daili;
import com.cool.wendao.community.server.BaseDailiService;
import com.cool.wendao.data.dao.DailiMapper;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;

@Service
public class BaseDailiServiceImpl implements BaseDailiService {

    @Autowired
    private DailiMapper dailiMapper;

    @Override
    public Daili findOneByAccount(String username) {
        Example example = new Example(Daili.class);
        example.createCriteria().andCondition("deleted=", Deleted.NOT_DELETED.value()).andCondition("account=", username);
        return dailiMapper.selectOneByExample(example);
    }

    @Override
    public int updateById(Daili daili) {
        daili.setUpdateTime(new Date());
        return dailiMapper.updateByPrimaryKeySelective(daili);
    }

    @Override
    public Daili findOneByToken(String token) {
        Example example = new Example(Daili.class);
        example.createCriteria().andCondition("deleted=", Deleted.NOT_DELETED.value()).andCondition("token=", token);
        return dailiMapper.selectOneByExample(example);
    }
}
