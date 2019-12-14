//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.domain.vo.base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import lombok.Data;
import org.linlinjava.litemall.db.domain.PetHelpType;

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

    public static final BasePetHelpTypeVo t(PetHelpType vo) {
        return new BasePetHelpTypeVo(vo);
    }

    public static final List<BasePetHelpTypeVo> t(List<PetHelpType> list) {
        List<BasePetHelpTypeVo> listVo = new ArrayList();
        Iterator var2 = list.iterator();

        while(var2.hasNext()) {
            PetHelpType temp = (PetHelpType)var2.next();
            listVo.add(new BasePetHelpTypeVo(temp));
        }

        return listVo;
    }
}
