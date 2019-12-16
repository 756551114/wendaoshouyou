//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.cool.wendao.community.model;

import com.cool.wendao.community.core.BaseModel;
import lombok.Data;

import javax.persistence.Table;

@Data
@Table(name = "sale_classify_good")
public class SaleClassifyGood  extends BaseModel {
    private String pname;
    private String cname;
    private String attrib;
    private Integer icon;
    private String str;
    private Integer price;
    private String compose;

    public SaleClassifyGood() {
    }




}
