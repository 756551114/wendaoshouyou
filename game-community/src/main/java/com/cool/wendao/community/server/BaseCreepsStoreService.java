package com.cool.wendao.community.server;

import com.cool.wendao.community.model.CreepsStore;

import java.util.List;

public interface BaseCreepsStoreService {
    List<CreepsStore> findAll();

    CreepsStore findOneByName(String name);
}
