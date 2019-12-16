//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.cool.wendao.community.model;

import com.cool.wendao.community.core.BaseModel;
import lombok.Data;

import javax.persistence.Table;


/**
 * 系统公告
 */
@Data
@Table(name = "notice")
public class Notice extends BaseModel {

    /**
     * 公告消息
     */
    private String message;

    /**
     * 分钟  轮询的时间
     */
    private Integer time;


    public Notice() {
    }



}
