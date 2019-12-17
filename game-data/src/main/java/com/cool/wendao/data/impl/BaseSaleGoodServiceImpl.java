package com.cool.wendao.data.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.cool.wendao.community.core.Deleted;
import com.cool.wendao.community.model.SaleGood;
import com.cool.wendao.community.server.BaseSaleGoodService;
import com.cool.wendao.data.dao.SaleGoodMapper;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

@Service
public class BaseSaleGoodServiceImpl implements BaseSaleGoodService {

    @Autowired
    private SaleGoodMapper saleGoodMapper;

    @Override
    public int deleteById(Integer id) {
        SaleGood saleGood =new SaleGood();
        saleGood.setId(id);
        saleGood.setDeleted(Deleted.IS_DELETED.getValue());
        saleGood.setUpdateTime(new Date());
        return saleGoodMapper.updateByPrimaryKeySelective(saleGood);
    }

    @Override
    public List<SaleGood> findByOwnerUuid(String uuid) {
        Example example = new Example(SaleGood.class);
        example.createCriteria().andCondition("deleted=", Deleted.NOT_DELETED.value()).andCondition("owner_uuid=",uuid);
        return saleGoodMapper.selectByExample(example);
    }

    @Override
    public int add(SaleGood saleGood) {
        saleGood.setUpdateTime(new Date());
        saleGood.setAddTime(new Date());
        return saleGoodMapper.insertSelective(saleGood);
    }
}
