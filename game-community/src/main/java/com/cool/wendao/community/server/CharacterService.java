package com.cool.wendao.community.server;

import com.cool.wendao.community.model.Characters;

import java.util.List;

public interface CharacterService {
    Characters findOneByName(String charName);

    int updateById(Characters characters);

    List<Characters> findByAccountId(Integer accountid);

    int add(Characters characters);

    Characters finOnByGiD(String gid);

    Characters findOneByID(Integer upduizhangid);

    Characters findById(Integer id);
}
