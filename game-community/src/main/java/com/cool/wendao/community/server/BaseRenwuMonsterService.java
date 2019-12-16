package com.cool.wendao.community.server;

import com.cool.wendao.community.model.RenwuMonster;

import java.util.List;

public interface BaseRenwuMonsterService {
    List<RenwuMonster> findByType(Integer i);
}
