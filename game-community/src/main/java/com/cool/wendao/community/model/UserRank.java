package com.cool.wendao.community.model;


import com.cool.wendao.community.core.BaseModel;
import lombok.Data;

import javax.persistence.Table;

@Data
@Table(name = "user_rank")
public class UserRank extends BaseModel {
    private Integer no;
    private String name;
    private String source;
    private Integer change;
}
