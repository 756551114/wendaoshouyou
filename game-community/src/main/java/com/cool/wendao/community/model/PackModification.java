//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.cool.wendao.community.model;

import com.cool.wendao.community.core.BaseModel;
import lombok.Data;

import javax.persistence.Table;

@Data
@Table(name = "pack_modification")
public class PackModification extends BaseModel {

    //PackClassifyGoods
    private String alias;
    private String fasionType;
    private String str;
    private String type;
    private Integer foodNum;
    private Integer goodsPrice;
    private Integer sex;
    private Integer position;
    private Integer category;


    public PackModification() {
    }




}

