package com.cool.wendao.admin.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.cool.wendao.admin.core.ResultBean;
import com.cool.wendao.admin.server.MessageSendService;

import java.util.List;

@Service
public class MessageSendServiceImpl implements MessageSendService {
    @Override
    public ResultBean send(String mobile, Integer templateId, List<String> params, String code, Integer seconds) {
        return null;
    }

    @Override
    public ResultBean send(String mobile, Integer templateId, List<String> params) {
        return null;
    }

    @Override
    public ResultBean validate(String mobile, Integer templateId, String code) {
        return null;
    }
}
