//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.cool.wendao.community.model;

import com.cool.wendao.community.core.BaseModel;
import lombok.Data;

import javax.persistence.Table;
import java.math.BigInteger;

@Data
@Table(name = "charge")
public class Charge extends BaseModel {

    private String accountName;

    private BigInteger coin;

    private Integer state;


    private BigInteger money;
    private String code;

    public Charge() {
    }


}
