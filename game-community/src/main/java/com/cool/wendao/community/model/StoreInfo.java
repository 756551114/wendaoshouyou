//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.cool.wendao.community.model;

import com.cool.wendao.community.core.BaseModel;
import lombok.Data;

import javax.persistence.Table;

@Data
@Table(name = "store_info")
public class StoreInfo  extends BaseModel {
    private String quality;
    private Integer value;
    private Integer type;
    private String name;

    private Integer totalScore;
    private Integer recognizeRecognized;
    private Integer rebuildLevel;
    private Integer silverCoin;

    public StoreInfo() {
    }




}
