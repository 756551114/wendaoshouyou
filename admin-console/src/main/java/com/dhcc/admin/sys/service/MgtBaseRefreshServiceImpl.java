package com.dhcc.admin.sys.service;

import com.cool.wendao.admin.server.MgtBaseRefreshService;
import com.dhcc.admin.sys.security.SecurityMetadataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 刷新资源菜单接口实现
 * @author Fangbb
 * 2019-04-22
 */
@Service("mgtBaseRefreshService")
public class MgtBaseRefreshServiceImpl implements MgtBaseRefreshService {

    @Autowired
    private SecurityMetadataSource securityMetadataSource;

    @Override
    public void refreshResource() {
        securityMetadataSource.refreshResourceDefine();
    }
}
