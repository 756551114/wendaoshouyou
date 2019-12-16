//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.cool.wendao.community.model;

import com.cool.wendao.community.core.BaseModel;
import lombok.Data;

import javax.persistence.Table;

@Data
@Table(name = "skilljineng")
public class Skilljineng  extends BaseModel {
    private Integer rid;
    private String pid;
    private String skillName;
    private Integer skillLevel;
    private Integer skillMubiao;
    private Integer skillMp;


    public Skilljineng() {
    }




}
