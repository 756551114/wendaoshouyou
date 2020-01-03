package com.cool.wendao.data.dao;

import com.cool.wendao.admin.core.MgtPageBean;
import com.cool.wendao.community.model.Notice;
import org.apache.ibatis.annotations.CacheNamespace;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface NoticeMapper extends Mapper<Notice> {

    List<Notice> findByPageBean(MgtPageBean<Notice> pageBean);
}
