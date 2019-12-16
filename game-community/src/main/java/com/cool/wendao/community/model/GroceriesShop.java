//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.cool.wendao.community.model;

import com.cool.wendao.community.core.BaseModel;
import lombok.Data;

import javax.persistence.Table;


@Data
@Table(name = "groceries_shop")
public class GroceriesShop extends BaseModel {

    private Integer goodsNo;
    private Integer payType;
    private String name;
    private Integer value;
    private Integer level;
    private Integer type;
    private Integer itemCount;


    public GroceriesShop() {

    }



}
