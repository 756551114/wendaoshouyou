package com.cool.wendao.data.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.cool.wendao.community.core.Deleted;
import com.cool.wendao.community.model.DaySignPrize;
import com.cool.wendao.community.server.BaseDaySignPrizeService;
import com.cool.wendao.data.dao.DaySignPrizeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

@Service
public class BaseDaySignPrizeServiceImpl implements BaseDaySignPrizeService {

    @Autowired
    private DaySignPrizeMapper daySignPrizeMapper;

    @Override
    public DaySignPrize findOneByIndex(Integer index) {
        Example example = new Example(DaySignPrize.class);
        example.createCriteria().andCondition("deleted=", Deleted.NOT_DELETED.value()).andCondition("index=", index);
        return daySignPrizeMapper.selectOneByExample(example);
    }
}
