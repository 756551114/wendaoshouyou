//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.cool.wendao.community.vo;

import com.cool.wendao.community.model.PetHelpType;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BasePetHelpTypeVo {
    public Integer id;
    public Integer type;
    public String name;
    public Integer quality;
    public Integer money;
    public Integer polar;

    public BasePetHelpTypeVo() {
    }

    public BasePetHelpTypeVo(PetHelpType vo) {
        if (vo != null) {
            this.id = vo.getId();
            this.type = vo.getType();
            this.name = vo.getName();
            this.quality = vo.getQuality();
            this.money = vo.getMoney();
            this.polar = vo.getPolar();
        }
    }

    public static BasePetHelpTypeVo t(PetHelpType vo) {
        return new BasePetHelpTypeVo(vo);
    }

    public static List<BasePetHelpTypeVo> t(List<PetHelpType> list) {
        List<BasePetHelpTypeVo> listVo = new ArrayList();
        if (list != null && list.size() > 0) {
            for (PetHelpType petHelpType : list) {
                listVo.add(t(petHelpType));
            }
        }

        return listVo;
    }
}
