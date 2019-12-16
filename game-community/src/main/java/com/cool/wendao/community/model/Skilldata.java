//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.cool.wendao.community.model;

import com.cool.wendao.community.core.BaseModel;
import lombok.Data;

import javax.persistence.Table;

@Data
@Table(name = "skilldata")
public class Skilldata  extends BaseModel {

    private String pid;
    private String skillName;
    private Integer skillLevel;
    private Integer skillMubiao;


    public Skilldata() {
    }


}
