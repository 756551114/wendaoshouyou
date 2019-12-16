//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.cool.wendao.community.vo;

import com.cool.wendao.community.model.NpcPoint;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BaseNpcPointVo {
    public Integer id;
    public String mapname;
    public String doorname;
    public Integer x;
    public Integer y;
    public Integer z;
    public Integer inx;
    public Integer iny;

    public BaseNpcPointVo() {
    }

    public BaseNpcPointVo(NpcPoint vo) {
        if (vo != null) {
            this.id = vo.getId();
            this.mapname = vo.getMapname();
            this.doorname = vo.getDoorname();
            this.x = vo.getX();
            this.y = vo.getY();
            this.z = vo.getZ();
            this.inx = vo.getInx();
            this.iny = vo.getIny();
        }
    }

    public static BaseNpcPointVo t(NpcPoint vo) {
        return new BaseNpcPointVo(vo);
    }

    public static List<BaseNpcPointVo> t(List<NpcPoint> list) {
        List<BaseNpcPointVo> listVo = new ArrayList();
        if (list != null && list.size() > 0) {
            for (NpcPoint npcPoint : list) {
                listVo.add(t(npcPoint));
            }
        }
        return listVo;
    }
}
