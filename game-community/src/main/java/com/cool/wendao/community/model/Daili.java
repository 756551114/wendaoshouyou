//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.cool.wendao.community.model;

import com.cool.wendao.community.core.BaseModel;
import lombok.Data;

import javax.persistence.Table;

@Data
@Table(name = "daili")
public class Daili extends BaseModel {

    private String account;
    private String passwd;
    private String code;
    private String token;


    public Daili() {
    }



}
