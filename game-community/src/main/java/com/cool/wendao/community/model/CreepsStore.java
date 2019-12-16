//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.cool.wendao.community.model;

import com.cool.wendao.community.core.BaseModel;
import lombok.Data;

import javax.persistence.Table;

@Data
@Table(name = "creeps_store")
public class CreepsStore extends BaseModel {

    private String name;
    private Integer price;


    public CreepsStore() {
    }


}
