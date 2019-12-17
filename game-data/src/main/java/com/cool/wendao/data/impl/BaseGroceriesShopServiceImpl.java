package com.cool.wendao.data.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.cool.wendao.community.core.Deleted;
import com.cool.wendao.community.model.GroceriesShop;
import com.cool.wendao.community.server.BaseGroceriesShopService;
import com.cool.wendao.data.dao.GroceriesShopMapper;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class BaseGroceriesShopServiceImpl implements BaseGroceriesShopService {

    @Autowired
    private GroceriesShopMapper groceriesShopMapper;

    @Override
    public List<GroceriesShop> findAll() {
        Example example = new Example(GroceriesShop.class);
        example.createCriteria().andCondition("deleted=", Deleted.NOT_DELETED.value());
        return groceriesShopMapper.selectByExample(example);
    }

    @Override
    public GroceriesShop findOneByGoodsNo(Integer goodsNo) {
        Example example = new Example(GroceriesShop.class);
        example.createCriteria().andCondition("deleted=", Deleted.NOT_DELETED.value()).andCondition("goods_no=", goodsNo);
        return groceriesShopMapper.selectOneByExample(example);
    }
}
