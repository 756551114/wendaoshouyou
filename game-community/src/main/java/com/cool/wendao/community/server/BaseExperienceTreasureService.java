package com.cool.wendao.community.server;

import com.cool.wendao.community.model.ExperienceTreasure;

public interface BaseExperienceTreasureService {
    ExperienceTreasure findOneByAttrib(Integer skill);
}
