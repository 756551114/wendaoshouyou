package com.cool.wendao.community.server;

import com.cool.wendao.community.model.StoreGoods;

import java.util.List;

public interface BaseStoreGoodsService {
    StoreGoods findOneByBarcode(String barcode);

    List<StoreGoods> findAll();

}
