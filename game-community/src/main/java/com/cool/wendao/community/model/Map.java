//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.cool.wendao.community.model;

import com.cool.wendao.community.core.BaseModel;
import lombok.Data;

import javax.persistence.Table;

@Data
@Table(name = "map")
public class Map extends BaseModel {

    private String name;
    private Integer mapId;
    private Integer x;
    private Integer y;
    private String icon;
    private Integer monsterLevel;


    public Map() {
    }



}
