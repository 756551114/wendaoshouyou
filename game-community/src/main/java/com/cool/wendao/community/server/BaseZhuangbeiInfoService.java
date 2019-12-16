package com.cool.wendao.community.server;

import com.cool.wendao.community.model.ZhuangbeiInfo;

import java.util.List;

public interface BaseZhuangbeiInfoService {
    List<ZhuangbeiInfo> findByAttrib(Integer id);

    ZhuangbeiInfo findOneByStr(String zhuangbname);

    ZhuangbeiInfo findOneByType(Integer pos);
}
