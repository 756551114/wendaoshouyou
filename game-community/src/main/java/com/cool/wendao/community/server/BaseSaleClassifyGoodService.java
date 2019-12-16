package com.cool.wendao.community.server;

import com.cool.wendao.community.model.SaleClassifyGood;

import java.util.List;

public interface BaseSaleClassifyGoodService {
    SaleClassifyGood findOneByCompose(String key);

    SaleClassifyGood findOneByStr(String str);

    List<SaleClassifyGood> findByStr(String str);

    SaleClassifyGood findOneByIcon(Integer type);
}
