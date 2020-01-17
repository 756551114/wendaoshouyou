package com.cool.wendao.community.model;

import com.cool.wendao.community.core.BaseModel;
import lombok.Data;

import javax.persistence.Table;


@Data
@Table(name = "black_list")
public class BlackList extends BaseModel {


    /**
     * ip黑名单
     */
    private String ip;
}
