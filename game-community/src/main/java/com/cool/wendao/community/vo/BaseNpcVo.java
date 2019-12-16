//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.cool.wendao.community.vo;

import com.cool.wendao.community.model.Npc;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

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

    public static BaseNpcVo t(Npc vo) {
        return new BaseNpcVo(vo);
    }

    public static List<BaseNpcVo> t(List<Npc> list) {
        List<BaseNpcVo> listVo = new ArrayList();
        if (list != null && list.size() > 0) {
            for (Npc npc : list) {
                listVo.add(t(npc));
            }
        }

        return listVo;
    }
}
