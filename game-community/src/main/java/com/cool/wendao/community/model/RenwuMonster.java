//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.cool.wendao.community.model;

import com.cool.wendao.community.core.BaseModel;
import lombok.Data;

import javax.persistence.Table;

@Data
@Table(name = "renwu_monster")
public class RenwuMonster extends BaseModel {
    private String mapName;
    private Integer x;
    private Integer y;
    private String name;
    private Integer icon;
    private String skills;
    private Integer type;


    public RenwuMonster() {
    }





}
