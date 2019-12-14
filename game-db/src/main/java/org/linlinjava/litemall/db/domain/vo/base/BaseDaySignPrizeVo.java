//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.domain.vo.base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import lombok.Data;
import org.linlinjava.litemall.db.domain.DaySignPrize;
@Data
public class BaseDaySignPrizeVo {
    public Integer id;
    public String name;
    public Integer index;

    public BaseDaySignPrizeVo() {
    }

    public BaseDaySignPrizeVo(DaySignPrize vo) {
        if (vo != null) {
            this.id = vo.getId();
            this.name = vo.getName();
            this.index = vo.getIndex();
        }
    }

    public static final BaseDaySignPrizeVo t(DaySignPrize vo) {
        return new BaseDaySignPrizeVo(vo);
    }

    public static final List<BaseDaySignPrizeVo> t(List<DaySignPrize> list) {
        List<BaseDaySignPrizeVo> listVo = new ArrayList();
        Iterator var2 = list.iterator();

        while(var2.hasNext()) {
            DaySignPrize temp = (DaySignPrize)var2.next();
            listVo.add(new BaseDaySignPrizeVo(temp));
        }

        return listVo;
    }
}
