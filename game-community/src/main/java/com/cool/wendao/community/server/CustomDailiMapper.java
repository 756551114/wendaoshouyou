package com.cool.wendao.community.server;

import java.util.List;
import java.util.Map;

public interface CustomDailiMapper {
    List<Map> selectAccount(String zm);

    List<Map> selectMoney(String zm, Integer i);
}
