//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.cool.wendao.community.vo;

import com.cool.wendao.community.model.PackModification;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

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

    public static BasePackModificationVo t(PackModification vo) {
        return new BasePackModificationVo(vo);
    }

    public static List<BasePackModificationVo> t(List<PackModification> list) {
        List<BasePackModificationVo> listVo = new ArrayList();
        if (list != null && list.size() > 0) {
            for (PackModification packModification : list) {
                listVo.add(t(packModification));
            }
        }
        return listVo;
    }
}
