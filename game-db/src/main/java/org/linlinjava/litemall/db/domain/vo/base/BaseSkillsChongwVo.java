//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.domain.vo.base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.linlinjava.litemall.db.domain.SkillsChongw;

public class BaseSkillsChongwVo {
    public Integer id;
    public String ownerid;
    public String skllCwid;
    public String skillIdHex;
    public String skillName;
    public Integer skillReqMenpai;
    public Integer skillLevel;
    public Integer skillMubiao;
    public String tianshuId;
    public String tianshuName;

    public BaseSkillsChongwVo() {
    }

    public BaseSkillsChongwVo(SkillsChongw vo) {
        if (vo != null) {
            this.id = vo.getId();
            this.ownerid = vo.getOwnerid();
            this.skllCwid = vo.getSkllCwid();
            this.skillIdHex = vo.getSkillIdHex();
            this.skillName = vo.getSkillName();
            this.skillReqMenpai = vo.getSkillReqMenpai();
            this.skillLevel = vo.getSkillLevel();
            this.skillMubiao = vo.getSkillMubiao();
            this.tianshuId = vo.getTianshuId();
            this.tianshuName = vo.getTianshuName();
        }
    }

    public static final BaseSkillsChongwVo t(SkillsChongw vo) {
        return new BaseSkillsChongwVo(vo);
    }

    public static final List<BaseSkillsChongwVo> t(List<SkillsChongw> list) {
        List<BaseSkillsChongwVo> listVo = new ArrayList();
        Iterator var2 = list.iterator();

        while(var2.hasNext()) {
            SkillsChongw temp = (SkillsChongw)var2.next();
            listVo.add(new BaseSkillsChongwVo(temp));
        }

        return listVo;
    }
}
