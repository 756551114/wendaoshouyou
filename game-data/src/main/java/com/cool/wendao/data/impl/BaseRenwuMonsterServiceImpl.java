package com.cool.wendao.data.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.cool.wendao.community.core.Deleted;
import com.cool.wendao.community.model.RenwuMonster;
import com.cool.wendao.community.server.BaseRenwuMonsterService;
import com.cool.wendao.data.dao.RenwuMonsterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class BaseRenwuMonsterServiceImpl implements BaseRenwuMonsterService {

    @Autowired
    private RenwuMonsterMapper renwuMonsterMapper;

    @Override
    public List<RenwuMonster> findByType(Integer type) {
        Example example = new Example(RenwuMonster.class);
        example.createCriteria().andCondition("deleted=", Deleted.NOT_DELETED.value()).andCondition("type=",type);
        return renwuMonsterMapper.selectByExample(example);
    }
}
