//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.cool.wendao.community.model;

import com.cool.wendao.community.core.BaseModel;
import lombok.Data;

import javax.persistence.Table;

@Data
@Table(name = "npc_point")
public class NpcPoint extends BaseModel {
    private String mapname;
    private String doorname;
    private Integer x;
    private Integer y;
    private Integer z;
    private Integer inx;
    private Integer iny;


    public NpcPoint() {
    }




}
