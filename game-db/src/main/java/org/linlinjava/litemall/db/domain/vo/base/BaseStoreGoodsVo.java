//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.domain.vo.base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.linlinjava.litemall.db.domain.StoreGoods;

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

    public static final BaseStoreGoodsVo t(StoreGoods vo) {
        return new BaseStoreGoodsVo(vo);
    }

    public static final List<BaseStoreGoodsVo> t(List<StoreGoods> list) {
        List<BaseStoreGoodsVo> listVo = new ArrayList();
        Iterator var2 = list.iterator();

        while(var2.hasNext()) {
            StoreGoods temp = (StoreGoods)var2.next();
            listVo.add(new BaseStoreGoodsVo(temp));
        }

        return listVo;
    }
}
