//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.cool.wendao.community.vo;

import com.cool.wendao.community.model.Maps;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BaseMapsVo {
    public Integer id;
    public String name;
    public Integer type;
    public Integer map;
    public Float dir;
    public Float x;
    public Float y;

    public BaseMapsVo() {
    }

    public BaseMapsVo(Maps vo) {
        if (vo != null) {
            this.id = vo.getId();
            this.name = vo.getName();
            this.type = vo.getType();
            this.map = vo.getMap();
            this.dir = vo.getDir();
            this.x = vo.getX();
            this.y = vo.getY();
        }
    }

    public static BaseMapsVo t(Maps vo) {
        return new BaseMapsVo(vo);
    }

    public static List<BaseMapsVo> t(List<Maps> list) {
        List<BaseMapsVo> listVo = new ArrayList();
        if (list != null && list.size() > 0) {
            for (Maps maps : list) {
                listVo.add(t(maps));
            }
        }

        return listVo;
    }
}
