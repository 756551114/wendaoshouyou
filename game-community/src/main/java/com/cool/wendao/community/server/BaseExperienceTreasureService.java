package com.cool.wendao.community.server;

import com.cool.wendao.community.model.Experience;

public interface BaseExperienceTreasureService {
    Experience findOneByAttrib(Integer skill);
}
