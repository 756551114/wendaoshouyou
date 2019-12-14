//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.domain.vo.base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import lombok.Data;
import org.linlinjava.litemall.db.domain.PackModification;

@Data
public class BasePackModificationVo {
    public Integer id;
    public String alias;
    public String fasionType;
    public String str;
    public String type;
    public Integer foodNum;
    public Integer goodsPrice;
    public Integer sex;
    public Integer position;
    public Integer category;

    public BasePackModificationVo() {
    }

    public BasePackModificationVo(PackModification vo) {
        if (vo != null) {
            this.id = vo.getId();
            this.alias = vo.getAlias();
            this.fasionType = vo.getFasionType();
            this.str = vo.getStr();
            this.type = vo.getType();
            this.foodNum = vo.getFoodNum();
            this.goodsPrice = vo.getGoodsPrice();
            this.sex = vo.getSex();
            this.position = vo.getPosition();
            this.category = vo.getCategory();
        }
    }

    public static final BasePackModificationVo t(PackModification vo) {
        return new BasePackModificationVo(vo);
    }

    public static final List<BasePackModificationVo> t(List<PackModification> list) {
        List<BasePackModificationVo> listVo = new ArrayList();
        Iterator var2 = list.iterator();

        while(var2.hasNext()) {
            PackModification temp = (PackModification)var2.next();
            listVo.add(new BasePackModificationVo(temp));
        }

        return listVo;
    }
}
