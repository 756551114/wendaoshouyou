package com.cool.wendao.community.server;

import com.cool.wendao.community.model.Choujiang;

public interface BaseChoujiangService {
    Choujiang findOneByName(String name);
}
