//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.domain.vo.base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import lombok.Data;
import org.linlinjava.litemall.db.domain.NpcPoint;

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

    public static final BaseNpcPointVo t(NpcPoint vo) {
        return new BaseNpcPointVo(vo);
    }

    public static final List<BaseNpcPointVo> t(List<NpcPoint> list) {
        List<BaseNpcPointVo> listVo = new ArrayList();
        Iterator var2 = list.iterator();

        while(var2.hasNext()) {
            NpcPoint temp = (NpcPoint)var2.next();
            listVo.add(new BaseNpcPointVo(temp));
        }

        return listVo;
    }
}
