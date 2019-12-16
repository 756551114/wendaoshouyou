package com.cool.wendao.community.server;

import com.cool.wendao.community.model.Charge;

import java.util.List;

public interface BaseChargeService {
    List<Charge> findByAccountname(String name);

    int updateById(Charge charge);
}
