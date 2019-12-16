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
public class Accounts  extends BaseModel {


    private String name;
    private String keyword;
    private String password;
    private String token;

    private Integer chongzhijifen;
    private Integer chongzhiyuanbao;
    private String yaoqingma;

    /**
     * 封号
     */
    private Integer block;

    private String code;

    public Accounts() {
    }





}
