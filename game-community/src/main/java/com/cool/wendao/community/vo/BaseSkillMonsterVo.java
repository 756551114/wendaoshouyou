//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.cool.wendao.community.vo;

import com.cool.wendao.community.model.SkillMonster;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
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
        if (list != null && list.size() > 0) {
            for (SkillMonster skillMonster : list) {
                listVo.add(t(skillMonster));
            }
        }

        return listVo;
    }
}
