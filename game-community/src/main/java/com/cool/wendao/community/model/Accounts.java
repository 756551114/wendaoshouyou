//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.cool.wendao.community.model;

import com.cool.wendao.community.core.BaseModel;
import lombok.Data;

import javax.persistence.Table;

@Data
@Table(name = "accounts")
public class Accounts extends BaseModel {


    private String name;
    private String keyword;
    private String password;
    private String token;

    /**
     * 1 是管理员
     * 0 不是
     */
    private Integer isAdmin = 0;
    private Integer chongzhijifen;
    private Integer chongzhiyuanbao;
    private String yaoqingma;

    /**
     * 封号
     */
    private Integer block;

    /**
     * vip等级
     */
    private Integer vip;

    private String code;

    public Accounts() {
    }


}
