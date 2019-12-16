//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.cool.wendao.community.model;

import com.cool.wendao.community.core.BaseModel;
import lombok.Data;

import javax.persistence.Table;


/**
 * 药材
 */
@Data
@Table(name = "medicine_shop")
public class MedicineShop extends BaseModel {




    private Integer goodsNo;

    private Integer payType;

    private String name;

    private Integer value;

    private Integer level;

    private Integer type;

    private Integer itemCount;



    public MedicineShop() {
    }


}
