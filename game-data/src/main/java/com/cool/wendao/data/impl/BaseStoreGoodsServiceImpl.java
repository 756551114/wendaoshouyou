package com.cool.wendao.data.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.cool.wendao.community.core.Deleted;
import com.cool.wendao.community.model.StoreGoods;
import com.cool.wendao.community.server.BaseStoreGoodsService;
import com.cool.wendao.data.dao.StoreGoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class BaseStoreGoodsServiceImpl implements BaseStoreGoodsService {

    @Autowired
    private StoreGoodsMapper storeGoodsMapper;

    @Override
    public StoreGoods findOneByBarcode(String barcode) {
        Example example = new Example(StoreGoods.class);
        example.createCriteria().andCondition("deleted=", Deleted.NOT_DELETED.value()).andCondition("barcode=",barcode);
        return storeGoodsMapper.selectOneByExample(example);
    }

    @Override
    public List<StoreGoods> findAll() {
        Example example = new Example(StoreGoods.class);
        example.createCriteria().andCondition("deleted=", Deleted.NOT_DELETED.value());
        return storeGoodsMapper.selectByExample(example);
    }
}
