//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.cool.wendao.community.vo;

import com.cool.wendao.community.model.SaleGood;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BaseSaleGoodVo {
    public Integer id;
    public String goodsId;
    public String name;
    public Integer startTime;
    public Integer endTime;
    public Integer price;
    public Integer reqLevel;
    public String ownerUuid;
    public String str;
    public String pet;
    public Integer pos;
    public Integer ispet;
    public Integer level;
    public String goods;

    public BaseSaleGoodVo() {
    }

    public BaseSaleGoodVo(SaleGood vo) {
        if (vo != null) {
            this.id = vo.getId();
            this.goodsId = vo.getGoodsId();
            this.name = vo.getName();
            this.startTime = vo.getStartTime();
            this.endTime = vo.getEndTime();
            this.price = vo.getPrice();
            this.reqLevel = vo.getReqLevel();
            this.ownerUuid = vo.getOwnerUuid();
            this.str = vo.getStr();
            this.pet = vo.getPet();
            this.pos = vo.getPos();
            this.ispet = vo.getIspet();
            this.level = vo.getLevel();
            this.goods = vo.getGoods();
        }
    }

    public static final BaseSaleGoodVo t(SaleGood vo) {
        return new BaseSaleGoodVo(vo);
    }

    public static final List<BaseSaleGoodVo> t(List<SaleGood> list) {
        List<BaseSaleGoodVo> listVo = new ArrayList();
        if (list != null && list.size() > 0) {
            for (SaleGood saleGood : list) {
                listVo.add(t(saleGood));
            }
        }
        return listVo;
    }
}
