package com.cool.wendao.data.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.cool.wendao.community.core.Deleted;
import com.cool.wendao.community.model.Shuxingduiying;
import com.cool.wendao.community.server.BaseShuxingduiyingService;
import com.cool.wendao.data.dao.ShuxingduiyingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

@Service
public class BaseShuxingduiyingServiceImpl implements BaseShuxingduiyingService {
    @Autowired
    private ShuxingduiyingMapper shuxingduiyingMapper;


    @Override
    public Shuxingduiying findOneByYingwen(String yingwen) {
        Example example = new Example(Shuxingduiying.class);
        example.createCriteria().andCondition("deleted=", Deleted.NOT_DELETED.value()).andCondition("yingwen=",yingwen);
        return shuxingduiyingMapper.selectOneByExample(example);
    }
}
