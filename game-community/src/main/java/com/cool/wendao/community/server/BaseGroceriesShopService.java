package com.cool.wendao.community.server;

import com.cool.wendao.community.model.GroceriesShop;

import java.util.List;

public interface BaseGroceriesShopService {
    List<GroceriesShop> findAll();

    GroceriesShop findOneByGoodsNo(Integer pos);
}
