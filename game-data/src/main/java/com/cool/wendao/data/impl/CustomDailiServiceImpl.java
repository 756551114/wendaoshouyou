package com.cool.wendao.data.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.cool.wendao.community.server.CustomDailiService;
import com.cool.wendao.data.dao.CustomDailiMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

@Service
public class CustomDailiServiceImpl implements CustomDailiService {

    @Autowired
    private CustomDailiMapper customDailiMapper;


    @Override
    public List<Map> selectCount(String name) {
        return customDailiMapper.selectCount(name);
    }

    @Override
    public List<Map> selectMoney(String name, int day) {
        return customDailiMapper.selectMoney(name, day);
    }

    @Override
    public List<Map> selectAccount(String name) {
        return customDailiMapper.selectAccount(name);
    }
}
