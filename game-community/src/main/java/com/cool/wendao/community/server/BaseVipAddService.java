package com.cool.wendao.community.server;

import java.math.BigDecimal;

public interface BaseVipAddService {

    /**
     * 获取用户的vip加成
     */
    BigDecimal getUserAdd(Integer userId);
}
