package com.cool.wendao.data.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.cool.wendao.community.core.Deleted;
import com.cool.wendao.community.model.Characters;
import com.cool.wendao.community.server.CharacterService;
import com.cool.wendao.data.dao.CharactersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

@Service
public class CharacterServiceImpl implements CharacterService {

    @Autowired
    private CharactersMapper charactersMapper;

    @Override
    public Characters findOneByName(String charName) {
        Example example = new Example(Characters.class);
        example.createCriteria().andCondition("deleted=", Deleted.NOT_DELETED.value()).andCondition("name=", charName);
        return charactersMapper.selectOneByExample(example);
    }

    @Override
    public int updateById(Characters characters) {
        characters.setUpdateTime(new Date());
        return charactersMapper.updateByPrimaryKeySelective(characters);
    }

    @Override
    public List<Characters> findByAccountId(Integer accountid) {
        Example example = new Example(Characters.class);
        example.createCriteria().andCondition("deleted=", Deleted.NOT_DELETED.value()).andCondition("account_id=", accountid);
        return charactersMapper.selectByExample(example);
    }

    @Override
    public int add(Characters characters) {
        characters.setUpdateTime(new Date());
        characters.setAddTime(new Date());
        return charactersMapper.insertSelective(characters);
    }

    @Override
    public Characters finOnByGiD(String gid) {
        Example example = new Example(Characters.class);
        example.createCriteria().andCondition("deleted=", Deleted.NOT_DELETED.value()).andCondition("gid=", gid);
        return charactersMapper.selectOneByExample(example);
    }

    @Override
    public Characters findOneByID(Integer id) {
        return charactersMapper.selectByPrimaryKey(id);
    }

    @Override
    public Characters findById(Integer id) {
        return charactersMapper.selectByPrimaryKey(id);
    }
}
