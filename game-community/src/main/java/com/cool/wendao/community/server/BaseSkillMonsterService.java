package com.cool.wendao.community.server;

import com.cool.wendao.community.model.SkillMonster;

import java.util.List;

public interface BaseSkillMonsterService {
    List<SkillMonster> findByName(String str);
}
