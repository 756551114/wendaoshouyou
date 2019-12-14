//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.domain.vo.base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.linlinjava.litemall.db.domain.Skilljineng;

public class BaseSkilljinengVo {
    public Integer id;
    public Integer rid;
    public String pid;
    public String skillName;
    public Integer skillLevel;
    public Integer skillMubiao;
    public Integer skillMp;

    public BaseSkilljinengVo() {
    }

    public BaseSkilljinengVo(Skilljineng vo) {
        if (vo != null) {
            this.id = vo.getId();
            this.rid = vo.getRid();
            this.pid = vo.getPid();
            this.skillName = vo.getSkillName();
            this.skillLevel = vo.getSkillLevel();
            this.skillMubiao = vo.getSkillMubiao();
            this.skillMp = vo.getSkillMp();
        }
    }

    public static final BaseSkilljinengVo t(Skilljineng vo) {
        return new BaseSkilljinengVo(vo);
    }

    public static final List<BaseSkilljinengVo> t(List<Skilljineng> list) {
        List<BaseSkilljinengVo> listVo = new ArrayList();
        Iterator var2 = list.iterator();

        while(var2.hasNext()) {
            Skilljineng temp = (Skilljineng)var2.next();
            listVo.add(new BaseSkilljinengVo(temp));
        }

        return listVo;
    }
}
