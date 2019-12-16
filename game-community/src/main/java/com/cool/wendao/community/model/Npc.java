//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.cool.wendao.community.model;

import com.cool.wendao.community.core.BaseModel;
import lombok.Data;

import javax.persistence.Table;


@Data
@Table(name = "npc")
public class Npc extends BaseModel {

    private Integer icon;
    private Integer x;
    private Integer y;
    private String name;
    private Integer mapId;


    public Npc() {
    }

}
