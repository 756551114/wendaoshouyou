package com.cool.wendao.data.dao;

import com.cool.wendao.admin.core.MgtPageBean;
import com.cool.wendao.community.model.BlackList;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface BlackListMapper extends Mapper<BlackList> {

    int isOnBlackList(@Param("ip") String ip);

    List<BlackList> findByPageBean(MgtPageBean<BlackList> pageBean);
}
