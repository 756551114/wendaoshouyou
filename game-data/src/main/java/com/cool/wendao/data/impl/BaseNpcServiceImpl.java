package com.cool.wendao.data.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.cool.wendao.community.core.Deleted;
import com.cool.wendao.community.model.Npc;
import com.cool.wendao.community.server.BaseNpcService;
import com.cool.wendao.data.dao.NpcMapeer;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class BaseNpcServiceImpl implements BaseNpcService {

    @Autowired
    private NpcMapeer npcMapeer;

    @Override
    public List<Npc> findByMapId(Integer id) {
        Example example = new Example(Npc.class);
        example.createCriteria().andCondition("deleted=", Deleted.NOT_DELETED.value()).andCondition("map_id=", id);
        return npcMapeer.selectByExample(example);
    }

    @Override
    public Npc findById(Integer id) {
        return npcMapeer.selectByPrimaryKey(id);
    }

    @Override
    public Npc findOneByName(String name) {
        Example example = new Example(Npc.class);
        example.createCriteria().andCondition("deleted=", Deleted.NOT_DELETED.value()).andCondition("name=", name);
        return npcMapeer.selectOneByExample(example);
    }
}
