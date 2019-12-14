//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.domain.vo.base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import lombok.Data;
import org.linlinjava.litemall.db.domain.Experience;
@Data
public class BaseExperienceVo {
    public Integer attrib;
    public Integer maxLevel;

    public BaseExperienceVo() {
    }

    public BaseExperienceVo(Experience vo) {
        if (vo != null) {
            this.attrib = vo.getAttrib();
            this.maxLevel = vo.getMaxLevel();
        }
    }

    public static final BaseExperienceVo t(Experience vo) {
        return new BaseExperienceVo(vo);
    }

    public static final List<BaseExperienceVo> t(List<Experience> list) {
        List<BaseExperienceVo> listVo = new ArrayList();
        Iterator var2 = list.iterator();

        while(var2.hasNext()) {
            Experience temp = (Experience)var2.next();
            listVo.add(new BaseExperienceVo(temp));
        }

        return listVo;
    }
}
