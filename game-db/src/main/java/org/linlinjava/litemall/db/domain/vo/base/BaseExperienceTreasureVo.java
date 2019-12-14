//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.domain.vo.base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import lombok.Data;
import org.linlinjava.litemall.db.domain.ExperienceTreasure;
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

    public static final BaseExperienceTreasureVo t(ExperienceTreasure vo) {
        return new BaseExperienceTreasureVo(vo);
    }

    public static final List<BaseExperienceTreasureVo> t(List<ExperienceTreasure> list) {
        List<BaseExperienceTreasureVo> listVo = new ArrayList();
        Iterator var2 = list.iterator();

        while(var2.hasNext()) {
            ExperienceTreasure temp = (ExperienceTreasure)var2.next();
            listVo.add(new BaseExperienceTreasureVo(temp));
        }

        return listVo;
    }
}
