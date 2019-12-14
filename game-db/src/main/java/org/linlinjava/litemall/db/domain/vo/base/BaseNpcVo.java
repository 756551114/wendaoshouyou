//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.domain.vo.base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import lombok.Data;
import org.linlinjava.litemall.db.domain.Npc;

@Data
public class BaseNpcVo {
    public Integer id;
    public Integer icon;
    public Integer x;
    public Integer y;
    public String name;
    public Integer mapId;

    public BaseNpcVo() {
    }

    public BaseNpcVo(Npc vo) {
        if (vo != null) {
            this.id = vo.getId();
            this.icon = vo.getIcon();
            this.x = vo.getX();
            this.y = vo.getY();
            this.name = vo.getName();
            this.mapId = vo.getMapId();
        }
    }

    public static final BaseNpcVo t(Npc vo) {
        return new BaseNpcVo(vo);
    }

    public static final List<BaseNpcVo> t(List<Npc> list) {
        List<BaseNpcVo> listVo = new ArrayList();
        Iterator var2 = list.iterator();

        while(var2.hasNext()) {
            Npc temp = (Npc)var2.next();
            listVo.add(new BaseNpcVo(temp));
        }

        return listVo;
    }
}
