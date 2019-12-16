//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.cool.wendao.community.model;

import com.cool.wendao.community.core.BaseModel;
import lombok.Data;

import javax.persistence.Table;

@Data
@Table(name = "renwu")
public class Renwu extends BaseModel {
    private String uncontent;
    private String npcName;
    private String currentTask;
    private String showName;
    private String taskPrompt;
    private String reward;


    public Renwu() {
    }


}
