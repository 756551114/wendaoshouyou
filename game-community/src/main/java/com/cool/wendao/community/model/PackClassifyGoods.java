//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.cool.wendao.community.model;

import com.cool.wendao.community.core.BaseModel;
import lombok.Data;

import javax.persistence.Table;


/**
 * 包裹在物品栏中得位置
 */
@Data
@Table(name = "pack_classify_goods")
public class PackClassifyGoods extends BaseModel {

    private String cname;
    private String str;
    private String cpos;
    private String count;



    public PackClassifyGoods() {
    }




}

