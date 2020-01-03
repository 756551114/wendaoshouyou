package com.cool.wendao.data.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.cool.wendao.admin.core.MgtPageBean;
import com.cool.wendao.admin.core.ResultBean;
import com.cool.wendao.community.model.Notice;
import com.cool.wendao.community.server.BaseNoticeService;
import com.cool.wendao.data.dao.NoticeMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;

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
//        Example example = new Example(Notice.class);
//        example.createCriteria().andCondition("deleted=", Deleted.NOT_DELETED.value());
//        return noticeMapper.selectByExample(example);
        return noticeMapper.findByPageBean(null);
    }

    @Override
    public MgtPageBean<Notice> findByPageBean(MgtPageBean<Notice> pageBean) {
        Page<Object> objects = PageHelper.startPage(pageBean.getPage(), pageBean.getPageSize());
        List<Notice> list = noticeMapper.findByPageBean(pageBean);
        pageBean.setData(list);
        pageBean.setCount(objects.getTotal());
        pageBean.setResultEnumSUCCESS();
        return pageBean;
    }

    @Override
    public ResultBean noticeAdd(Notice notice) {
        notice.setUpdateTime(new Date());
        notice.setAddTime(new Date());
        notice.andLogicalDeleted(false);
        noticeMapper.insertSelective(notice);
        return ResultBean.SUCCESS();
    }
}
