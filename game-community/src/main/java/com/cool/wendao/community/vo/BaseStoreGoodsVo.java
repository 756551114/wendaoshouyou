//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.cool.wendao.community.vo;

import com.cool.wendao.community.model.StoreGoods;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BaseStoreGoodsVo {
    public Integer id;
    public String name;
    public String barcode;
    public Integer forSale;
    public Integer showPos;
    public Integer rpos;
    public Integer saleQuota;
    public Integer recommend;
    public Integer coin;
    public Integer discount;
    public Integer type;
    public Integer quotaLimit;
    public Integer mustVip;
    public Integer isGift;
    public Integer followPetType;

    public BaseStoreGoodsVo() {
    }

    public BaseStoreGoodsVo(StoreGoods vo) {
        if (vo != null) {
            this.id = vo.getId();
            this.name = vo.getName();
            this.barcode = vo.getBarcode();
            this.forSale = vo.getForSale();
            this.showPos = vo.getShowPos();
            this.rpos = vo.getRpos();
            this.saleQuota = vo.getSaleQuota();
            this.recommend = vo.getRecommend();
            this.coin = vo.getCoin();
            this.discount = vo.getDiscount();
            this.type = vo.getType();
            this.quotaLimit = vo.getQuotaLimit();
            this.mustVip = vo.getMustVip();
            this.isGift = vo.getIsGift();
            this.followPetType = vo.getFollowPetType();
        }
    }

    public static BaseStoreGoodsVo t(StoreGoods vo) {
        return new BaseStoreGoodsVo(vo);
    }

    public static List<BaseStoreGoodsVo> t(List<StoreGoods> list) {
        List<BaseStoreGoodsVo> listVo = new ArrayList();
        if (list != null && list.size() > 0) {
            for (StoreGoods storeGoods : list) {
                listVo.add(t(storeGoods));
            }
        }
        return listVo;
    }
}
