package com.cool.wendao.community.server;

import com.cool.wendao.community.model.StoreInfo;

public interface BaseStoreInfoService {
    StoreInfo findOneByName(String name);
}
