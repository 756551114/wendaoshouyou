package com.cool.wendao.community.server;

import com.cool.wendao.admin.core.MgtPageBean;
import com.cool.wendao.admin.core.ResultBean;
import com.cool.wendao.community.model.BlackList;

/**
 * 黑名单处理
 * @author cool
 */
public interface BlackListService {

    /**
     * 查看ip是否在黑名单种  返回0 则是不在
     */
    int isOnBlackList(String ip);


    MgtPageBean<BlackList> findByPageBean(MgtPageBean<BlackList> pageBean);


    int updateById(BlackList blackList);

    BlackList findById(Integer id);

    ResultBean blackListAdd(BlackList blackList);
}
