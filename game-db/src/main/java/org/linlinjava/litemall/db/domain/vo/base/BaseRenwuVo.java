//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.domain.vo.base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.linlinjava.litemall.db.domain.Renwu;

public class BaseRenwuVo {
    public Integer id;
    public String uncontent;
    public String npcName;
    public String currentTask;
    public String showName;
    public String taskPrompt;
    public String reward;

    public BaseRenwuVo() {
    }

    public BaseRenwuVo(Renwu vo) {
        if (vo != null) {
            this.id = vo.getId();
            this.uncontent = vo.getUncontent();
            this.npcName = vo.getNpcName();
            this.currentTask = vo.getCurrentTask();
            this.showName = vo.getShowName();
            this.taskPrompt = vo.getTaskPrompt();
            this.reward = vo.getReward();
        }
    }

    public static final BaseRenwuVo t(Renwu vo) {
        return new BaseRenwuVo(vo);
    }

    public static final List<BaseRenwuVo> t(List<Renwu> list) {
        List<BaseRenwuVo> listVo = new ArrayList();
        Iterator var2 = list.iterator();

        while(var2.hasNext()) {
            Renwu temp = (Renwu)var2.next();
            listVo.add(new BaseRenwuVo(temp));
        }

        return listVo;
    }
}
