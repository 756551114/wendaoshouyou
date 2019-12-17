package com.cool.wendao.data.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.cool.wendao.community.model.ExperienceTreasure;
import com.cool.wendao.community.server.BaseExperienceTreasureService;
import com.cool.wendao.data.dao.ExperienceTreasureMapper;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class BaseExperienceTreasureServiceImpl implements BaseExperienceTreasureService {
    @Autowired
    private ExperienceTreasureMapper experienceTreasureMapper;

    @Override
    public ExperienceTreasure findOneByAttrib(Integer skill) {
        return experienceTreasureMapper.selectByPrimaryKey(skill);
    }
}
