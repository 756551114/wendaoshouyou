//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.cool.wendao.community.model;

import com.cool.wendao.community.core.BaseModel;
import lombok.Data;

import javax.persistence.Table;


@Data
@Table(name = "reports")
public class Reports  extends BaseModel {

    private String zhanghao;
    private Integer yuanbaoshu;
    private String shifouchongzhi;


    public Reports() {
    }




}
