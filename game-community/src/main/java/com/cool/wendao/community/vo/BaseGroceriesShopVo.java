//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.cool.wendao.community.vo;

import com.cool.wendao.community.model.GroceriesShop;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BaseGroceriesShopVo {
    public Integer id;
    public Integer goodsNo;
    public Integer payType;
    public String name;
    public Integer value;
    public Integer level;
    public Integer type;
    public Integer itemcount;

    public BaseGroceriesShopVo() {
    }

    public BaseGroceriesShopVo(GroceriesShop vo) {
        if (vo != null) {
            this.id = vo.getId();
            this.goodsNo = vo.getGoodsNo();
            this.payType = vo.getPayType();
            this.name = vo.getName();
            this.value = vo.getValue();
            this.level = vo.getLevel();
            this.type = vo.getType();
            this.itemcount = vo.getItemCount();
        }
    }

    public static BaseGroceriesShopVo t(GroceriesShop vo) {
        return new BaseGroceriesShopVo(vo);
    }

    public static List<BaseGroceriesShopVo> t(List<GroceriesShop> list) {
        List<BaseGroceriesShopVo> listVo = new ArrayList();
        if (list != null && list.size() > 0) {
            for (GroceriesShop groceriesShop : list) {
                listVo.add(t(groceriesShop));
            }
        }

        return listVo;
    }
}
