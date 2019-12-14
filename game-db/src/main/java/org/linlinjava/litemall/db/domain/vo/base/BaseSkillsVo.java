//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.domain.vo.base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.linlinjava.litemall.db.domain.Skills;

public class BaseSkillsVo {
    public Integer id;
    public String skillIdHex;
    public String skillName;
    public Integer skillReqMenpai;
    public Integer skillType;
    public Integer skillTypeLevel;
    public Integer skillMagic;
    public Integer skillReqLevel;
    public String skillContext;

    public BaseSkillsVo() {
    }

    public BaseSkillsVo(Skills vo) {
        if (vo != null) {
            this.id = vo.getId();
            this.skillIdHex = vo.getSkillIdHex();
            this.skillName = vo.getSkillName();
            this.skillReqMenpai = vo.getSkillReqMenpai();
            this.skillType = vo.getSkillType();
            this.skillTypeLevel = vo.getSkillTypeLevel();
            this.skillMagic = vo.getSkillMagic();
            this.skillReqLevel = vo.getSkillReqLevel();
            this.skillContext = vo.getSkillContext();
        }
    }

    public static final BaseSkillsVo t(Skills vo) {
        return new BaseSkillsVo(vo);
    }

    public static final List<BaseSkillsVo> t(List<Skills> list) {
        List<BaseSkillsVo> listVo = new ArrayList();
        Iterator var2 = list.iterator();

        while(var2.hasNext()) {
            Skills temp = (Skills)var2.next();
            listVo.add(new BaseSkillsVo(temp));
        }

        return listVo;
    }
}
