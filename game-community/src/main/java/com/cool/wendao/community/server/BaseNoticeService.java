package com.cool.wendao.community.server;

import com.cool.wendao.admin.core.MgtPageBean;
import com.cool.wendao.admin.core.ResultBean;
import com.cool.wendao.community.model.Notice;

import java.util.List;

/**
 * 消息公告
 * @author cool
 */
public interface BaseNoticeService {
    Notice findById(Integer id);

    int updateById(Notice notice);

    List<Notice> findAll();

    MgtPageBean<Notice> findByPageBean(MgtPageBean<Notice> pageBean);

    ResultBean noticeAdd(Notice notice);
}
