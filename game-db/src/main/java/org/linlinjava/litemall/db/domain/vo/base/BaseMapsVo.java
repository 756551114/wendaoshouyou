//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.domain.vo.base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import lombok.Data;
import org.linlinjava.litemall.db.domain.Maps;

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

    public static final BaseMapsVo t(Maps vo) {
        return new BaseMapsVo(vo);
    }

    public static final List<BaseMapsVo> t(List<Maps> list) {
        List<BaseMapsVo> listVo = new ArrayList();
        Iterator var2 = list.iterator();

        while(var2.hasNext()) {
            Maps temp = (Maps)var2.next();
            listVo.add(new BaseMapsVo(temp));
        }

        return listVo;
    }
}
