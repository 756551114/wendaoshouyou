package com.cool.wendao.community.server;

import com.cool.wendao.community.model.Pet;

import java.util.List;

public interface BasePetService {
    Pet findOneByName(String name);

    List<Pet> findByZoon(String zoon);

}
