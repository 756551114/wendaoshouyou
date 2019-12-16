package com.cool.wendao.community.server;

import com.cool.wendao.community.model.Notice;

import java.util.List;

public interface BaseNoticeService {
    Notice findById(Integer id);

    int updateById(Notice notice);

    List<Notice> findAll();

}
