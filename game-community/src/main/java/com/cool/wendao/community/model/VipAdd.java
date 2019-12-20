package com.cool.wendao.community.model;


import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@Table(name = "vip_add")
public class VipAdd implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键自定义主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private BigDecimal add;
}
