//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.cool.wendao.community.model;

import com.cool.wendao.community.core.BaseModel;

import lombok.Data;

import javax.persistence.Table;


@Data
@Table(name = "store_goods")
public class StoreGoods  extends BaseModel {
    private String name;
    private String barcode;
    private Integer forSale;
    private Integer showPos;
    private Integer rpos;
    private Integer saleQuota;
    private Integer recommend;
    private Integer coin;
    private Integer discount;
    private Integer type;
    private Integer quotaLimit;
    private Integer mustVip;
    private Integer isGift;
    private Integer followPetType;


    public StoreGoods() {
    }

}
