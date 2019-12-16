//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.cool.wendao.community.model;

import com.cool.wendao.community.core.BaseModel;
import lombok.Data;

import javax.persistence.Table;

@Data
@Table(name = "sale_good")
public class SaleGood extends BaseModel implements Comparable<SaleGood> {
    /**
     * 物品id
     */
    private String goodsId;
    /**
     * 物品名字
     */
    private String name;
    /**
     * 开始时间
     */
    private Integer startTime;
    /**
     * 结束时间
     */
    private Integer endTime;
    private Integer price;
    private Integer reqLevel;
    private String ownerUuid;

    /**
     * 装备摆摊位置的名字
     */
    private String str;

    /**
     * 宠物
     */
    private String pet;
    private Integer pos;
    private Integer ispet;
    private Integer level;

    /**
     * 具体属性
     */
    private String goods;

    public SaleGood() {
    }


    @Override
    public int compareTo(SaleGood o) {
        return this.getPrice().compareTo(o.getPrice());
    }


}
