//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.cool.wendao.community.vo;

import com.cool.wendao.community.model.Srenwu;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
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
        if (list != null && list.size() > 0) {
            for (Srenwu srenwu : list) {
                listVo.add(t(srenwu));
            }
        }

        return listVo;
    }
}
