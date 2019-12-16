package com.cool.wendao.community.server;

import com.cool.wendao.community.model.Daili;

public interface BaseDailiService {

    Daili findOneByAccount(String username);

    int updateById(Daili daili);

    Daili findOneByToken(String token);
}
