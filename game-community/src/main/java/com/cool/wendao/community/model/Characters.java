//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.cool.wendao.community.model;

import com.cool.wendao.community.core.BaseModel;
import lombok.Data;

import javax.persistence.Table;

/**
 * 用户数据
 * @author cool QQ756551114
 */
@Data
@Table(name = "characters")
public class Characters extends BaseModel {

    private Integer menpai;

    private String name;

    private Integer accountId;


    private String gid;

    private String data;

    public Characters() {
    }


}
