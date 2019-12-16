//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.cool.wendao.community.model;

import com.cool.wendao.community.core.BaseModel;
import lombok.Data;

import javax.persistence.Table;


@Data
@Table(name = "maps")
public class Maps extends BaseModel {

    private String name;
    private Integer type;
    private Integer map;
    private Float dir;
    private Float x;
    private Float y;

    public Maps() {
    }


}
