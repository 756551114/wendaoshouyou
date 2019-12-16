//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.cool.wendao.community.vo;

import com.cool.wendao.community.model.RenwuMonster;

import java.util.ArrayList;
import java.util.List;

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

    public static BaseRenwuMonsterVo t(RenwuMonster vo) {
        return new BaseRenwuMonsterVo(vo);
    }

    public static List<BaseRenwuMonsterVo> t(List<RenwuMonster> list) {
        List<BaseRenwuMonsterVo> listVo = new ArrayList();
        if (list != null && list.size() > 0) {
            for (RenwuMonster renwuMonster : list) {
                listVo.add(t(renwuMonster));
            }
        }

        return listVo;
    }
}
