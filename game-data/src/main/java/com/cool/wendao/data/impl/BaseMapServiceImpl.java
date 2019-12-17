package com.cool.wendao.data.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.cool.wendao.community.core.Deleted;
import com.cool.wendao.community.model.Map;
import com.cool.wendao.community.server.BaseMapService;
import com.cool.wendao.data.dao.MapMapper;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class BaseMapServiceImpl implements BaseMapService {

    @Autowired
    private MapMapper mapMapper;

    @Override
    public List<Map> findAll() {
        Example example = new Example(Map.class);
        example.createCriteria().andCondition("deleted=", Deleted.NOT_DELETED.value());
        return mapMapper.selectByExample(example);
    }

    @Override
    public Map findOneByName(String mapName) {
        Example example = new Example(Map.class);
        example.createCriteria().andCondition("deleted=", Deleted.NOT_DELETED.value()).andCondition("name=", mapName);
        return mapMapper.selectOneByExample(example);
    }

    @Override
    public Map findOneByMapId(int mapid) {
        Example example = new Example(Map.class);
        example.createCriteria().andCondition("deleted=", Deleted.NOT_DELETED.value()).andCondition("map_id=", mapid);
        return mapMapper.selectOneByExample(example);
    }
}
