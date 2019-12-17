package com.cool.wendao.community.server;

import java.util.List;
import java.util.Map;

public interface CustomDailiService {

    List<Map> selectCount(String name);

    List<Map> selectMoney(String name, int day);

    List<Map> selectAccount(String name);
}
