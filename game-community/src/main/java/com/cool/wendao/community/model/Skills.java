//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.cool.wendao.community.model;

import com.cool.wendao.community.core.BaseModel;
import lombok.Data;

import javax.persistence.Table;

@Data
@Table(name = "skills")
public class Skills  extends BaseModel {
    private String skillIdHex;
    private String skillName;
    private Integer skillReqMenpai;
    private Integer skillType;
    private Integer skillTypeLevel;
    private Integer skillMagic;
    private Integer skillReqLevel;
    private String skillContext;


    public Skills() {
    }



}
