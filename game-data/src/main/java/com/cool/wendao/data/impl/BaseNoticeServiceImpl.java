package com.cool.wendao.data.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.cool.wendao.community.core.Deleted;
import com.cool.wendao.community.model.Notice;
import com.cool.wendao.community.server.BaseNoticeService;
import com.cool.wendao.data.dao.NoticeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

@Service
public class BaseNoticeServiceImpl implements BaseNoticeService {

    @Autowired
    private NoticeMapper noticeMapper;

    @Override
    public Notice findById(Integer id) {
        return noticeMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateById(Notice notice) {
        notice.setUpdateTime(new Date());
        return noticeMapper.updateByPrimaryKeySelective(notice);
    }

    @Override
    public List<Notice> findAll() {
        Example example = new Example(Notice.class);
        example.createCriteria().andCondition("deleted=", Deleted.NOT_DELETED.value());
        return noticeMapper.selectByExample(example);
    }
}
