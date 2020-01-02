package com.cool.wendao.data.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.cool.wendao.community.core.Deleted;
import com.cool.wendao.community.model.SkillMonster;
import com.cool.wendao.community.server.BaseSkillMonsterService;
import com.cool.wendao.data.dao.SkillMonsterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class BaseSkillMonsterServiceImpl implements BaseSkillMonsterService {

    @Autowired
    private SkillMonsterMapper skillMonsterMapper;


    @Override
    public List<SkillMonster> findByName(String name) {
        Example example = new Example(SkillMonster.class);
        example.createCriteria().andCondition("deleted=", Deleted.NOT_DELETED.value()).andCondition("name like ","%"+name + "%");
        return skillMonsterMapper.selectByExample(example);
    }
}
