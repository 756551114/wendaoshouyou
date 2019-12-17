package com.cool.wendao.data.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.cool.wendao.community.core.Deleted;
import com.cool.wendao.community.model.Characters;
import com.cool.wendao.community.server.BaseCharactersService;
import com.cool.wendao.data.dao.CharactersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;

@Service
public class BaseCharactersServiceImpl implements BaseCharactersService {


    @Autowired
    private CharactersMapper charactersMapper;

    @Override
    public int updateById(Characters characters) {
        characters.setUpdateTime(new Date());
        return charactersMapper.updateByPrimaryKeySelective(characters);
    }

    @Override
    public Characters findById(Integer id) {
        return charactersMapper.selectByPrimaryKey(id);
    }

    @Override
    public Characters findOneByName(String name) {
        Example example = new Example(Characters.class);
        example.createCriteria().andCondition("deleted=", Deleted.NOT_DELETED.value()).andCondition("name=", name);
        return charactersMapper.selectOneByExample(example);
    }
}
