//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.cool.wendao.community.model;

import com.cool.wendao.community.core.BaseModel;
import lombok.Data;

import javax.persistence.Table;

@Data
@Table(name = "npc_dialogue")
public class NpcDialogue extends BaseModel {

    private String name;
    private Integer portranit;
    private Integer picNo;
    private String content;
    private Integer isconmlete;
    private Integer isincombat;
    private Integer palytime;
    private String taskType;
    private String idname;

    public NpcDialogue() {
    }



}
