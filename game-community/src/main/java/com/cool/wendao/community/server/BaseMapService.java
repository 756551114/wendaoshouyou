package com.cool.wendao.community.server;

import com.cool.wendao.community.model.Map;

import java.util.List;

public interface BaseMapService {
    List<Map> findAll();

    Map findOneByName(String mapName);

    Map findOneByMapId(int mapid);
}
