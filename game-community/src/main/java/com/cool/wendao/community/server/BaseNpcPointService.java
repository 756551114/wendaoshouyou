package com.cool.wendao.community.server;

import com.cool.wendao.community.model.NpcPoint;

import java.util.List;

public interface BaseNpcPointService {
    List<NpcPoint> findByMapname(String name);
}
