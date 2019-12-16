//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.cool.wendao.community.model;

import com.cool.wendao.community.core.BaseModel;
import lombok.Data;

import javax.persistence.Table;

@Data
@Table(name = "experience_treasure")
public class ExperienceTreasure extends BaseModel {

    private Integer maxLevel;



    public ExperienceTreasure() {
    }

    public Integer getAttrib() {
        return getId();
    }
}
