package com.cool.wendao.community.server;

import com.cool.wendao.community.model.SaleGood;

import java.util.List;

public interface SaleGoodService {
    List<SaleGood> findByOwnerUuid(String uuid);

    SaleGood findOneByGoodsId(String goodsGid);

    int updateById(SaleGood saleGood);

    int deleteById(Integer id);

    List<SaleGood> findByStr(String str);
}
