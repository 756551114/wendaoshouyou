package com.cool.wendao.data.dao;

import com.cool.wendao.admin.core.MgtPageBean;
import com.cool.wendao.community.model.Accounts;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface AccountsMapper extends Mapper<Accounts> {
    List<Accounts> findByPageBean(MgtPageBean<Accounts> pageBean);
}
