//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.domain.vo.base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.linlinjava.litemall.db.domain.Srenwu;

public class BaseSrenwuVo {
    public Integer id;
    public String pid;
    public Integer rid;
    public String skillName;
    public String skillJieshao;
    public String skillDqti;
    public String skillXck;

    public BaseSrenwuVo() {
    }

    public BaseSrenwuVo(Srenwu vo) {
        if (vo != null) {
            this.id = vo.getId();
            this.pid = vo.getPid();
            this.rid = vo.getRid();
            this.skillName = vo.getSkillName();
            this.skillJieshao = vo.getSkillJieshao();
            this.skillDqti = vo.getSkillDqti();
            this.skillXck = vo.getSkillXck();
        }
    }

    public static final BaseSrenwuVo t(Srenwu vo) {
        return new BaseSrenwuVo(vo);
    }

    public static final List<BaseSrenwuVo> t(List<Srenwu> list) {
        List<BaseSrenwuVo> listVo = new ArrayList();
        Iterator var2 = list.iterator();

        while(var2.hasNext()) {
            Srenwu temp = (Srenwu)var2.next();
            listVo.add(new BaseSrenwuVo(temp));
        }

        return listVo;
    }
}
