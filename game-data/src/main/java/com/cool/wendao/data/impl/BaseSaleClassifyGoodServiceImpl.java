package com.cool.wendao.data.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.cool.wendao.community.core.Deleted;
import com.cool.wendao.community.model.SaleClassifyGood;
import com.cool.wendao.community.server.BaseSaleClassifyGoodService;
import com.cool.wendao.data.dao.SaleClassifyGoodMapper;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class BaseSaleClassifyGoodServiceImpl implements BaseSaleClassifyGoodService {
    @Autowired
    private SaleClassifyGoodMapper saleClassifyGoodMapper;

    @Override
    public SaleClassifyGood findOneByCompose(String key) {
        Example example = new Example(SaleClassifyGood.class);
        example.createCriteria().andCondition("deleted=", Deleted.NOT_DELETED.value()).andCondition("compose=",key);
        return saleClassifyGoodMapper.selectOneByExample(example);
    }

    @Override
    public SaleClassifyGood findOneByStr(String str) {
        Example example = new Example(SaleClassifyGood.class);
        example.createCriteria().andCondition("deleted=", Deleted.NOT_DELETED.value()).andCondition("str=",str);
        return saleClassifyGoodMapper.selectOneByExample(example);
    }

    @Override
    public List<SaleClassifyGood> findByStr(String str) {
        Example example = new Example(SaleClassifyGood.class);
        example.createCriteria().andCondition("deleted=", Deleted.NOT_DELETED.value()).andCondition("str=",str);
        return saleClassifyGoodMapper.selectByExample(example);
    }

    @Override
    public SaleClassifyGood findOneByIcon(Integer type) {
        Example example = new Example(SaleClassifyGood.class);
        example.createCriteria().andCondition("deleted=", Deleted.NOT_DELETED.value()).andCondition("icon=",type);
        return saleClassifyGoodMapper.selectOneByExample(example);
    }
}
