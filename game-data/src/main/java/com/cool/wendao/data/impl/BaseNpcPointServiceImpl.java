package com.cool.wendao.data.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.cool.wendao.community.core.Deleted;
import com.cool.wendao.community.model.NpcPoint;
import com.cool.wendao.community.server.BaseNpcPointService;
import com.cool.wendao.data.dao.NpcPointMapper;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class BaseNpcPointServiceImpl implements BaseNpcPointService {
    @Autowired
    private NpcPointMapper npcPointMapper;

    @Override
    public List<NpcPoint> findByMapname(String name) {
        Example example = new Example(NpcPoint.class);
        example.createCriteria().andCondition("deleted=", Deleted.NOT_DELETED.value()).andCondition("mapname=",name);
        return npcPointMapper.selectByExample(example);
    }
}
