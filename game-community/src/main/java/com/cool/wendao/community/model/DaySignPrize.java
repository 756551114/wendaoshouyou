//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.cool.wendao.community.model;

import com.cool.wendao.community.core.BaseModel;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

@Data
@Table(name = "day_sign_prize")
public class DaySignPrize extends BaseModel {

    private String name;
    @Column(name = "t_index")
    private Integer index;


    public DaySignPrize() {
    }



}
