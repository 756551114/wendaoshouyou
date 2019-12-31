//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.cool.wendao.community.model;

import com.cool.wendao.community.core.BaseModel;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;


/**
 * 宠物信息
 */
@Data
@Table(name = "pet")
public class Pet extends BaseModel {

    /**
     * 对应图鉴的位置
     */
    @Column(name="t_index")
    private Integer index;

    /**
     * 携带等级
     */
    private Integer levelReq;

    /**
     * 血气成长
     */
    private Integer life;

    /**
     * 法力成长
     */
    private Integer mana;

    /**
     * 速度成长
     */
    private Integer speed;

    /**
     * 物攻成长
     */
    private Integer phyAttack;

    /**
     * 法功成长
     */
    private Integer magAttack;

    /**
     * 金木水火土 无
     */
    private String polar;

    /**
     * 拥有天生技能
     */
    private String skiils;

    /**
     * 所在地图
     */
    private String zoon;

    /**
     * 外观
     */
    private Integer icon;

    /**
     * 名字
     */
    private String name;

    public Pet() {
    }




}
