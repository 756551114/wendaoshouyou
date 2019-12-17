package com.cool.wendao.data.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.cool.wendao.community.core.Deleted;
import com.cool.wendao.community.model.ZhuangbeiInfo;
import com.cool.wendao.community.server.BaseZhuangbeiInfoService;
import com.cool.wendao.data.dao.ZhuangbeiInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class BaseZhuangbeiInfoServiceImpl implements BaseZhuangbeiInfoService {


    @Autowired
    private ZhuangbeiInfoMapper zhuangbeiInfoMapper;


    @Override
    public List<ZhuangbeiInfo> findByAttrib(Integer attrib) {
        Example example = new Example(ZhuangbeiInfo.class);
        example.createCriteria().andCondition("deleted=", Deleted.NOT_DELETED.value()).andCondition("attrib=",attrib);
        return zhuangbeiInfoMapper.selectByExample(example);
    }

    @Override
    public ZhuangbeiInfo findOneByStr(String zhuangbname) {
        Example example = new Example(ZhuangbeiInfo.class);
        example.createCriteria().andCondition("deleted=", Deleted.NOT_DELETED.value()).andCondition("str=",zhuangbname);
        return zhuangbeiInfoMapper.selectOneByExample(example);
    }

    @Override
    public ZhuangbeiInfo findOneByType(Integer type) {
        Example example = new Example(ZhuangbeiInfo.class);
        example.createCriteria().andCondition("deleted=", Deleted.NOT_DELETED.value()).andCondition("type=",type);
        return zhuangbeiInfoMapper.selectOneByExample(example);
    }
}
