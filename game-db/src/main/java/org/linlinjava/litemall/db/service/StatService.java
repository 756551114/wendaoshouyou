//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.service;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.linlinjava.litemall.db.dao.StatMapper;
import org.springframework.stereotype.Service;

@Service
public class StatService {
    @Resource
    private StatMapper statMapper;

    public StatService() {
    }

    public List<Map> statUser() {
        return this.statMapper.statUser();
    }

    public List<Map> statOrder() {
        return this.statMapper.statOrder();
    }

    public List<Map> statGoods() {
        return this.statMapper.statGoods();
    }
}
