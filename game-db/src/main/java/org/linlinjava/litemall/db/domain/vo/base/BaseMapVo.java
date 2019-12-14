//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.domain.vo.base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import lombok.Data;
import org.linlinjava.litemall.db.domain.Map;
@Data
public class BaseMapVo {
    public Integer id;
    public String name;
    public Integer mapId;
    public Integer x;
    public Integer y;
    public String icon;
    public Integer monsterLevel;

    public BaseMapVo() {
    }

    public BaseMapVo(Map vo) {
        if (vo != null) {
            this.id = vo.getId();
            this.name = vo.getName();
            this.mapId = vo.getMapId();
            this.x = vo.getX();
            this.y = vo.getY();
            this.icon = vo.getIcon();
            this.monsterLevel = vo.getMonsterLevel();
        }
    }

    public static final BaseMapVo t(Map vo) {
        return new BaseMapVo(vo);
    }

    public static final List<BaseMapVo> t(List<Map> list) {
        List<BaseMapVo> listVo = new ArrayList();
        Iterator var2 = list.iterator();

        while(var2.hasNext()) {
            Map temp = (Map)var2.next();
            listVo.add(new BaseMapVo(temp));
        }

        return listVo;
    }
}
