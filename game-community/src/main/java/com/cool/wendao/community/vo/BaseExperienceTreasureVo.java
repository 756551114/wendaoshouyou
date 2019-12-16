//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.cool.wendao.community.vo;

import com.cool.wendao.community.model.ExperienceTreasure;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BaseExperienceTreasureVo {
    public Integer attrib;
    public Integer maxLevel;

    public BaseExperienceTreasureVo() {
    }

    public BaseExperienceTreasureVo(ExperienceTreasure vo) {
        if (vo != null) {
            this.attrib = vo.getAttrib();
            this.maxLevel = vo.getMaxLevel();
        }
    }

    public static BaseExperienceTreasureVo t(ExperienceTreasure vo) {
        return new BaseExperienceTreasureVo(vo);
    }

    public static List<BaseExperienceTreasureVo> t(List<ExperienceTreasure> list) {
        List<BaseExperienceTreasureVo> listVo = new ArrayList();
        if (list != null && list.size() > 0) {
            for (ExperienceTreasure experienceTreasure : list) {
                listVo.add(t(experienceTreasure));
            }
        }
        return listVo;
    }
}
