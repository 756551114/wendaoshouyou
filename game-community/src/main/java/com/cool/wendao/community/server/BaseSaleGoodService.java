package com.cool.wendao.community.server;

import com.cool.wendao.community.model.SaleGood;

import java.util.List;

public interface BaseSaleGoodService {
    int deleteById(Integer id);

    List<SaleGood> findByOwnerUuid(String uuid);

    int add(SaleGood saleGood);
}
