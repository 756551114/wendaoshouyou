package com.cool.wendao.data.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.cool.wendao.admin.core.MgtPageBean;
import com.cool.wendao.admin.core.ResultBean;
import com.cool.wendao.community.core.Deleted;
import com.cool.wendao.community.model.Pet;
import com.cool.wendao.community.server.BasePetService;
import com.cool.wendao.data.dao.PetMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

@Service
public class BasePetServiceImpl implements BasePetService {

    @Autowired
    private PetMapper petMapper;

    @Override
    public Pet findOneByName(String name) {
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

    @Override
    public Pet findById(Integer id) {
        return petMapper.selectByPrimaryKey(id);
    }

    @Override
    public MgtPageBean<Pet> findByPageBean(MgtPageBean<Pet> pageBean) {
        Page<Object> objects = PageHelper.startPage(pageBean.getPage(), pageBean.getPageSize());
        List<Pet> list = petMapper.findByPageBean(pageBean);
        pageBean.setData(list);
        pageBean.setCount(objects.getTotal());
        pageBean.setResultEnumSUCCESS();
        return pageBean;
    }

    @Override
    public ResultBean petAdd(Pet pet) {
        pet.setUpdateTime(new Date());
        pet.setAddTime(new Date());
        pet.andLogicalDeleted(false);
        petMapper.insertSelective(pet);
        return ResultBean.SUCCESS();
    }

    @Override
    public Pet updateById(Pet pet) {
        pet.setUpdateTime(new Date());
        petMapper.updateByPrimaryKeySelective(pet);
        return pet;
    }
}
