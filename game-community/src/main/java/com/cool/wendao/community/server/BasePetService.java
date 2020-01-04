package com.cool.wendao.community.server;

import com.cool.wendao.admin.core.MgtPageBean;
import com.cool.wendao.admin.core.ResultBean;
import com.cool.wendao.community.model.Pet;

import java.util.List;

public interface BasePetService {
    Pet findOneByName(String name);

    List<Pet> findByZoon(String zoon);

    Pet findById(Integer id);

    MgtPageBean<Pet> findByPageBean(MgtPageBean<Pet> pageBean);

    ResultBean petAdd(Pet pet);

    Pet updateById(Pet pet);
}
