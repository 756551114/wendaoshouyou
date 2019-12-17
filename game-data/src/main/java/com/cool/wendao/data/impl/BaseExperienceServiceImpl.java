package com.cool.wendao.data.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.cool.wendao.community.model.Experience;
import com.cool.wendao.community.server.BaseExperienceService;
import com.cool.wendao.data.dao.ExperienceMapper;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class BaseExperienceServiceImpl implements BaseExperienceService {

    @Autowired
    private ExperienceMapper experienceMapper;

    @Override
    public Experience findOneByAttrib(Integer level) {
        return experienceMapper.selectByPrimaryKey(level);
    }
}
