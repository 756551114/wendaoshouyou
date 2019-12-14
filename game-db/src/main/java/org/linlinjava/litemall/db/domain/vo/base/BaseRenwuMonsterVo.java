//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.domain.vo.base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.linlinjava.litemall.db.domain.RenwuMonster;

public class BaseRenwuMonsterVo {
    public Integer id;
    public String mapName;
    public Integer x;
    public Integer y;
    public String name;
    public Integer icon;
    public String skills;
    public Integer type;

    public BaseRenwuMonsterVo() {
    }

    public BaseRenwuMonsterVo(RenwuMonster vo) {
        if (vo != null) {
            this.id = vo.getId();
            this.mapName = vo.getMapName();
            this.x = vo.getX();
            this.y = vo.getY();
            this.name = vo.getName();
            this.icon = vo.getIcon();
            this.skills = vo.getSkills();
            this.type = vo.getType();
        }
    }

    public static final BaseRenwuMonsterVo t(RenwuMonster vo) {
        return new BaseRenwuMonsterVo(vo);
    }

    public static final List<BaseRenwuMonsterVo> t(List<RenwuMonster> list) {
        List<BaseRenwuMonsterVo> listVo = new ArrayList();
        Iterator var2 = list.iterator();

        while(var2.hasNext()) {
            RenwuMonster temp = (RenwuMonster)var2.next();
            listVo.add(new BaseRenwuMonsterVo(temp));
        }

        return listVo;
    }
}
