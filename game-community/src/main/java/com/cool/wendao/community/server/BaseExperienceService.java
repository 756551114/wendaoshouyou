package com.cool.wendao.community.server;

import com.cool.wendao.community.model.Experience;

public interface BaseExperienceService {
    Experience findOneByAttrib(Integer level);
}
