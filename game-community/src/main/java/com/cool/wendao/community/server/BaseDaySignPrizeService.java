package com.cool.wendao.community.server;

import com.cool.wendao.community.model.DaySignPrize;

public interface BaseDaySignPrizeService {
    DaySignPrize findOneByIndex(Integer index);
}
