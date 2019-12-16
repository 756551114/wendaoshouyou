//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.cool.wendao.community.vo;

import com.cool.wendao.community.model.Skilljineng;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
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
        if (list != null && list.size() > 0) {
            for (Skilljineng skilljineng : list) {
                listVo.add(t(skilljineng));
            }
        }

        return listVo;
    }
}
