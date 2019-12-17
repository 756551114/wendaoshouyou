package com.cool.wendao.data.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.cool.wendao.community.core.Deleted;
import com.cool.wendao.community.model.SaleGood;
import com.cool.wendao.community.server.SaleGoodService;
import com.cool.wendao.data.dao.SaleGoodMapper;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

@Service
public class SaleGoodServiceImpl implements SaleGoodService {

    @Autowired
    private SaleGoodMapper saleGoodMapper;


    @Override
    public List<SaleGood> findByOwnerUuid(String uuid) {
        Example example = new Example(SaleGood.class);
        example.createCriteria().andCondition("deleted=", Deleted.NOT_DELETED.value()).andCondition("owner_uuid=", uuid);
        return saleGoodMapper.selectByExample(example);
    }

    @Override
    public SaleGood findOneByGoodsId(String goodsId) {
        Example example = new Example(SaleGood.class);
        example.createCriteria().andCondition("deleted=", Deleted.NOT_DELETED.value()).andCondition("goods_id=", goodsId);
        return saleGoodMapper.selectOneByExample(example);
    }

    @Override
    public int updateById(SaleGood saleGood) {
        saleGood.setUpdateTime(new Date());
        return saleGoodMapper.updateByPrimaryKeySelective(saleGood);
    }

    @Override
    public int deleteById(Integer id) {
        SaleGood saleGood = new SaleGood();
        saleGood.setUpdateTime(new Date());
        saleGood.setId(id);
        saleGood.setDeleted(Deleted.IS_DELETED.getValue());
        return saleGoodMapper.updateByPrimaryKeySelective(saleGood);
    }

    @Override
    public List<SaleGood> findByStr(String str) {
        Example example = new Example(SaleGood.class);
        example.createCriteria().andCondition("deleted=", Deleted.NOT_DELETED.value()).andCondition("str=", str);
        return saleGoodMapper.selectByExample(example);
    }
}
