//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.cool.wendao.community.model;

import com.cool.wendao.community.core.BaseModel;
import lombok.Data;

import javax.persistence.Table;


@Data
@Table(name = "choujiang")
public class Choujiang extends BaseModel {

    private Integer no;
    private String name;
    private String desc;
    private Integer level;




}
