package com.cool.wendao.community.core;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;


/**
 * 数据表公共字段处理
 * @author cool QQ756551114
 */
@Setter
@Getter
public class BaseModel implements Cloneable, Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键自定义主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 添加时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd  HH:mm:ss",timezone = "GMT+8")
    private Date addTime;


    /**
     * 最后更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd  HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;

    /**
     * 逻辑删除
     */
    private Integer deleted;


    /**
     * 删除信息配置
     * @param deleted 是否删除
     */
    public void andLogicalDeleted(boolean deleted) {
        this.setDeleted(deleted ? Deleted.IS_DELETED.value() : Deleted.NOT_DELETED.value());
    }
}
