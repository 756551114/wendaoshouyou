package com.cool.wendao.community.server;

import com.cool.wendao.community.model.Npc;

import java.util.List;

public interface BaseNpcService {
    List<Npc> findByMapId(Integer id);

    Npc findById(Integer id);

    Npc findOneByName(String name);
}
