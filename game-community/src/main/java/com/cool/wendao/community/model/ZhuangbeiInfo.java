//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.cool.wendao.community.model;

import com.cool.wendao.community.core.BaseModel;
import lombok.Data;

import javax.persistence.Table;

@Data
@Table(name = "zhuangbei_info")
public class ZhuangbeiInfo  extends BaseModel {
    private Integer attrib;
    private Integer amount;
    private Integer type;
    private String str;
    private String quality;
    private Integer master;
    private Integer metal;
    private Integer mana;
    private Integer accurate;
    private Integer def;
    private Integer dex;
    private Integer wiz;
    private Integer parry;


    public ZhuangbeiInfo() {
    }


}
