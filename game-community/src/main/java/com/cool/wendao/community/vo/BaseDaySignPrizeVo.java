//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.cool.wendao.community.vo;

import com.cool.wendao.community.model.DaySignPrize;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

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

    public static BaseDaySignPrizeVo t(DaySignPrize vo) {
        return new BaseDaySignPrizeVo(vo);
    }

    public static List<BaseDaySignPrizeVo> t(List<DaySignPrize> list) {
        List<BaseDaySignPrizeVo> listVo = new ArrayList();
        if (list != null && list.size() > 0) {
            for (DaySignPrize daySignPrize : list) {
                listVo.add(t(daySignPrize));
            }
        }
        return listVo;
    }
}
