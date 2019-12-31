package com.cool.wendao.data.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.cool.wendao.community.core.Deleted;
import com.cool.wendao.community.model.Pet;
import com.cool.wendao.community.server.BasePetService;
import com.cool.wendao.data.dao.PetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class BasePetServiceImpl implements BasePetService {

    @Autowired
    private PetMapper petMapper;

    @Override
    public Pet findOneByName(String name) {
        System.out.println("-name------------>" + name);

        Example example = new Example(Pet.class);
        example.createCriteria().andCondition("deleted=", Deleted.NOT_DELETED.value()).andCondition("name=",name);
        return petMapper.selectOneByExample(example);
    }

    @Override
    public List<Pet> findByZoon(String zoon) {
        Example example = new Example(Pet.class);
        example.createCriteria().andCondition("deleted=", Deleted.NOT_DELETED.value()).andCondition("zoon=",zoon);
        return petMapper.selectByExample(example);
    }
}
