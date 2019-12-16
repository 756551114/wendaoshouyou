//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.cool.wendao.community.model;

import lombok.Data;

import javax.persistence.Table;

@Data
@Table(name = "sale_good")
public class SaleGoodWithBLOBs extends SaleGood {
    private String goods;
    private String pet;

    public SaleGoodWithBLOBs() {
    }


}
