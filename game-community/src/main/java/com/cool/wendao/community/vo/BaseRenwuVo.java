//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.cool.wendao.community.vo;

import com.cool.wendao.community.model.Renwu;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
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

    public static BaseRenwuVo t(Renwu vo) {
        return new BaseRenwuVo(vo);
    }

    public static List<BaseRenwuVo> t(List<Renwu> list) {
        List<BaseRenwuVo> listVo = new ArrayList();
        if (list != null && list.size() > 0) {
            for (Renwu renwu : list) {
                listVo.add(t(renwu));
            }
        }

        return listVo;
    }
}
