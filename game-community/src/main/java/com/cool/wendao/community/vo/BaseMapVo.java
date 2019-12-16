//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.cool.wendao.community.vo;

import com.cool.wendao.community.model.Map;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

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

    public static BaseMapVo t(Map vo) {
        return new BaseMapVo(vo);
    }

    public static List<BaseMapVo> t(List<Map> list) {
        List<BaseMapVo> listVo = new ArrayList();
        if (list != null && list.size() > 0) {
            for (Map map : list) {
                listVo.add(t(map));
            }
        }

        return listVo;
    }
}
