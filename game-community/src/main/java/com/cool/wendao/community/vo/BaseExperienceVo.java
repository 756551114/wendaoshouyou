//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.cool.wendao.community.vo;

import com.cool.wendao.community.model.Experience;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

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

    public static BaseExperienceVo t(Experience vo) {
        return new BaseExperienceVo(vo);
    }

    public static List<BaseExperienceVo> t(List<Experience> list) {
        List<BaseExperienceVo> listVo = new ArrayList();
        if (list != null && list.size() > 0) {
            for (Experience experience : list) {
                listVo.add(t(experience));
            }
        }

        return listVo;
    }
}
