//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.cool.wendao.community.vo;

import com.cool.wendao.community.model.Skilldata;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
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

    public static BaseSkilldataVo t(Skilldata vo) {
        return new BaseSkilldataVo(vo);
    }

    public static List<BaseSkilldataVo> t(List<Skilldata> list) {
        List<BaseSkilldataVo> listVo = new ArrayList();
        if (list != null && list.size() > 0) {
            for (Skilldata skilldata : list) {
                listVo.add(t(skilldata));
            }
        }

        return listVo;
    }
}
