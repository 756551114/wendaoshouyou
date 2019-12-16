//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.cool.wendao.community.model;

import com.cool.wendao.community.core.BaseModel;
import lombok.Data;

import javax.persistence.Table;

@Data
@Table(name = "pets")
public class Pets extends BaseModel {

    private String ownerid;
    private String petid;
    private String nickname;
    private String name;
    private Integer horsetype;
    private Integer type;
    private Integer level;
    private Integer liliang;
    private Integer minjie;
    private Integer lingli;
    private Integer tili;
    private Integer dianhualx;
    private Integer dianhuazd;
    private Integer dianhuazx;
    private Integer yuhualx;
    private Integer yuhuazd;
    private Integer yuhuazx;
    private Integer cwjyzx;
    private Integer cwjyzd;
    private Integer feisheng;
    private Integer fsudu;
    private Integer qhcwWg;
    private Integer qhcwFg;
    private Integer cwXiangxing;
    private Integer cwWuxue;
    private String cwIcon;
    private Integer cwXinfa;
    private Integer cwQinmi;


    public Pets() {
    }




}
