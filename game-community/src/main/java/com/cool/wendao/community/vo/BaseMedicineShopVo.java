//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.cool.wendao.community.vo;

import com.cool.wendao.community.model.MedicineShop;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BaseMedicineShopVo {
    public Integer id;
    public Integer goodsNo;
    public Integer payType;
    public String name;
    public Integer value;
    public Integer level;
    public Integer type;
    public Integer itemcount;

    public BaseMedicineShopVo() {
    }

    public BaseMedicineShopVo(MedicineShop vo) {
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

    public static BaseMedicineShopVo t(MedicineShop vo) {
        return new BaseMedicineShopVo(vo);
    }

    public static List<BaseMedicineShopVo> t(List<MedicineShop> list) {
        List<BaseMedicineShopVo> listVo = new ArrayList();
        if (list != null && list.size() > 0) {
            for (MedicineShop medicineShop : list) {
                listVo.add(t(medicineShop));
            }
        }
        return listVo;
    }
}
