//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.domain.vo.base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import lombok.Data;
import org.linlinjava.litemall.db.domain.GroceriesShop;

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
            this.itemcount = vo.getItemcount();
        }
    }

    public static final BaseGroceriesShopVo t(GroceriesShop vo) {
        return new BaseGroceriesShopVo(vo);
    }

    public static final List<BaseGroceriesShopVo> t(List<GroceriesShop> list) {
        List<BaseGroceriesShopVo> listVo = new ArrayList();
        Iterator var2 = list.iterator();

        while(var2.hasNext()) {
            GroceriesShop temp = (GroceriesShop)var2.next();
            listVo.add(new BaseGroceriesShopVo(temp));
        }

        return listVo;
    }
}
