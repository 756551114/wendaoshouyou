package com.cool.wendao.admin.impl;

import cn.hutool.core.util.IdUtil;
import com.alibaba.dubbo.config.annotation.Service;
import com.cool.wendao.admin.core.ResultBean;
import com.cool.wendao.admin.core.ResultEnum;
import com.cool.wendao.admin.dao.BaseOrganizationDao;
import com.cool.wendao.admin.model.BaseOrganization;
import com.cool.wendao.admin.server.MgtOrgService;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class MgtOrgServiceImpl implements MgtOrgService {

    @Autowired
    private BaseOrganizationDao baseOrganizationDao;

    @Override
    public ResultBean initOrg(BaseOrganization organization) {
        organization.setOrgType(3);
        organization.setIsCheck(0);
        organization.setIsPerfect(0);
        organization.setCurStatus(1);
        organization.setIsSpecialty(0);
        organization.setIsExistChild(0);
        organization.setOrgCode(IdUtil.fastSimpleUUID());
        baseOrganizationDao.insertSelective(organization);
        return new ResultBean<>(ResultEnum.SUCCESS);
    }


}
