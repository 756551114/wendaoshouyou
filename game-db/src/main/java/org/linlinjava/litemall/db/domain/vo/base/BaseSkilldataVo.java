//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.domain.vo.base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.linlinjava.litemall.db.domain.Skilldata;

public class BaseSkilldataVo {
    public Integer id;
    public String pid;
    public String skillName;
    public Integer skillLevel;
    public Integer skillMubiao;

    public BaseSkilldataVo() {
    }

    public BaseSkilldataVo(Skilldata vo) {
        if (vo != null) {
            this.id = vo.getId();
            this.pid = vo.getPid();
            this.skillName = vo.getSkillName();
            this.skillLevel = vo.getSkillLevel();
            this.skillMubiao = vo.getSkillMubiao();
        }
    }

    public static final BaseSkilldataVo t(Skilldata vo) {
        return new BaseSkilldataVo(vo);
    }

    public static final List<BaseSkilldataVo> t(List<Skilldata> list) {
        List<BaseSkilldataVo> listVo = new ArrayList();
        Iterator var2 = list.iterator();

        while(var2.hasNext()) {
            Skilldata temp = (Skilldata)var2.next();
            listVo.add(new BaseSkilldataVo(temp));
        }

        return listVo;
    }
}
