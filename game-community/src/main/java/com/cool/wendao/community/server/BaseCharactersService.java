package com.cool.wendao.community.server;

import com.cool.wendao.community.model.Characters;

public interface BaseCharactersService {
    int updateById(Characters characters);

    Characters findById(Integer id);

    Characters findOneByName(String name);
}
