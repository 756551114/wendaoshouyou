//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.cool.wendao.community.model;

import com.cool.wendao.community.core.BaseModel;
import lombok.Data;

import javax.persistence.Table;


/**
 * 守护
 */
@Data
@Table(name = "pet_help_type")
public class PetHelpType extends BaseModel {

    /**
     * 外观
     */
    private Integer type;

    /**
     * 名称
     */
    private String name;

    /**
     * 购买类型
     */
    private Integer quality;

    /**
     * 价值 金币  元宝
     */
    private Integer money;

    /**
     * 类型
     */
    private Integer polar;

    public PetHelpType() {
    }



}
