//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.cool.wendao.community.model;

import com.cool.wendao.community.core.BaseModel;
import lombok.Data;

import javax.persistence.Table;

@Data
@Table(name = "srenwu")
public class Srenwu  extends BaseModel {

    private String pid;
    private Integer rid;
    private String skillName;
    private String skillJieshao;
    private String skillDqti;
    private String skillXck;


    public Srenwu() {
    }


}
