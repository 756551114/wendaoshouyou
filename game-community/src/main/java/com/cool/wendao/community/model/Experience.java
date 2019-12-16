//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.cool.wendao.community.model;

import com.cool.wendao.community.core.BaseModel;
import lombok.Data;

import javax.persistence.Table;

/**
 * 升级所需经验
 * @author cool Q756551114
 */
@Data
@Table(name = "experience")
public class Experience extends BaseModel {

    private Integer maxLevel;


    public Experience() {
    }

    /**
     * 向下兼容  attrib字段
     * @return
     */
    public Integer getAttrib() {
        return getId();
    }
}
