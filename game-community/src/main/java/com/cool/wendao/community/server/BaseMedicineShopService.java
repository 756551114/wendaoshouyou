package com.cool.wendao.community.server;

import com.cool.wendao.community.model.MedicineShop;

import java.util.List;

public interface BaseMedicineShopService {
    List<MedicineShop> findAll();

    MedicineShop findOneByGoodsNo(Integer pos);
}
