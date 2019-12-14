//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.domain.vo.base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.linlinjava.litemall.db.domain.SkillMonster;

public class BaseSkillMonsterVo {
    public Integer id;
    public String name;
    public String skills;
    public Integer type;

    public BaseSkillMonsterVo() {
    }

    public BaseSkillMonsterVo(SkillMonster vo) {
        if (vo != null) {
            this.id = vo.getId();
            this.name = vo.getName();
            this.skills = vo.getSkills();
            this.type = vo.getType();
        }
    }

    public static final BaseSkillMonsterVo t(SkillMonster vo) {
        return new BaseSkillMonsterVo(vo);
    }

    public static final List<BaseSkillMonsterVo> t(List<SkillMonster> list) {
        List<BaseSkillMonsterVo> listVo = new ArrayList();
        Iterator var2 = list.iterator();

        while(var2.hasNext()) {
            SkillMonster temp = (SkillMonster)var2.next();
            listVo.add(new BaseSkillMonsterVo(temp));
        }

        return listVo;
    }
}
