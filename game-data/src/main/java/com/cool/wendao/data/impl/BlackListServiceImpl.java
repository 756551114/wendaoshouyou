package com.cool.wendao.data.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.cool.wendao.admin.core.MgtPageBean;
import com.cool.wendao.admin.core.ResultBean;
import com.cool.wendao.community.model.BlackList;
import com.cool.wendao.community.server.BlackListService;
import com.cool.wendao.data.dao.BlackListMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

@Service
public class BlackListServiceImpl implements BlackListService {

    @Autowired
    private BlackListMapper blackListMapper;


    @Override
    public int isOnBlackList(String ip) {
        return blackListMapper.isOnBlackList(ip);
    }

    @Override
    public MgtPageBean<BlackList> findByPageBean(MgtPageBean<BlackList> pageBean) {
        Page<Object> objects = PageHelper.startPage(pageBean.getPage(), pageBean.getPageSize());
        pageBean.setData(blackListMapper.findByPageBean(pageBean));
        pageBean.setCount(objects.getTotal());
        pageBean.setResultEnumSUCCESS();
        return pageBean;
    }

    @Override
    public int updateById(BlackList blackList) {
        blackList.setUpdateTime(new Date());
        return blackListMapper.updateByPrimaryKeySelective(blackList);
    }

    @Override
    public BlackList findById(Integer id) {
        return blackListMapper.selectByPrimaryKey(id);
    }

    @Override
    public ResultBean blackListAdd(BlackList blackList) {
        blackList.setAddTime(new Date());
        blackList.setUpdateTime(new Date());
        blackListMapper.insertSelective(blackList);
        return  ResultBean.SUCCESS();
    }
}
