package com.cool.wendao.data.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.cool.wendao.community.server.BaseVipAddService;
import com.cool.wendao.data.dao.VipAddMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;



@Service
public class BaseVipAddServiceImpl implements BaseVipAddService {


    @Autowired
    private VipAddMapper vipAddMapper;


    @Override
    public BigDecimal getUserAdd(Integer userId) {
        return vipAddMapper.getUserAdd(userId);
    }
}
