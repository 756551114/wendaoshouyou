package com.cool.wendao.data.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.cool.wendao.community.core.Deleted;
import com.cool.wendao.community.model.Renwu;
import com.cool.wendao.community.server.BaseRenwuService;
import com.cool.wendao.data.dao.RenwuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

@Service
public class BaseRenwuServiceImpl implements BaseRenwuService {
    @Autowired
    private RenwuMapper renwuMapper;

    @Override
    public Renwu findOneByCurrentTask(String currentTask) {
        Example example = new Example(Renwu.class);
        example.createCriteria().andCondition("deleted=", Deleted.NOT_DELETED.value()).andCondition("current_task=",renwu);
        return renwuMapper.selectOneByExample(example);
    }
}
