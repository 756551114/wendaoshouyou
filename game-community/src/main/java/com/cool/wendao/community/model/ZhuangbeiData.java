package com.cool.wendao.community.model;

import com.cool.wendao.community.core.BaseModel;
import lombok.Data;

import javax.persistence.Table;

@Data
@Table(name = "zhuangbei_data")
public class ZhuangbeiData extends BaseModel {


    private Integer amount;
    private Integer type;
    private String str;
    private String quality;
    private Integer master;
    private Integer matal;
    private Integer mana;
    private Integer accurate;
    private Integer def;
    private Integer dex;
    private Integer wiz;
    private Integer parry;
    private Integer ownerId;
    private Integer ownerUserId;
    private String autoFight;


}
