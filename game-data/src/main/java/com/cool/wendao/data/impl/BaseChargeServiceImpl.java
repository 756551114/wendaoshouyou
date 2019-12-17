package com.cool.wendao.data.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.cool.wendao.community.core.Deleted;
import com.cool.wendao.community.model.Charge;
import com.cool.wendao.community.server.BaseChargeService;
import com.cool.wendao.data.dao.ChargeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

@Service
public class BaseChargeServiceImpl implements BaseChargeService {

    @Autowired
    private ChargeMapper chargeMapper;

    @Override
    public List<Charge> findByAccountname(String name) {
        Example example = new Example(Charge.class);
        example.createCriteria().andCondition("deleted=", Deleted.NOT_DELETED.value()).andCondition("accountName=", name);
        return chargeMapper.selectByExample(example);
    }

    @Override
    public int updateById(Charge charge) {
        charge.setUpdateTime(new Date());
        return chargeMapper.updateByPrimaryKeySelective(charge);
    }
}
