package com.cool.wendao.admin.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.cool.wendao.admin.core.MgtPageBean;
import com.cool.wendao.admin.dao.BaseResourceDao;
import com.cool.wendao.admin.params.SysResource;
import com.cool.wendao.admin.server.MgtBaseResourceService;
import com.cool.wendao.admin.util.UuidUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;

@Service
public class MgtBaseResourceServiceImpl implements MgtBaseResourceService {
    private static Logger logger = LoggerFactory.getLogger(MgtBaseResourceServiceImpl.class);

    @Autowired
    private BaseResourceDao baseResourceDao;

    /**
     * 分页获取系统资源
     * @param pageBean
     * @return pageBean
     */
    @Override
    public MgtPageBean<SysResource> getResourcesByPage(String resName, Integer orgType, MgtPageBean<SysResource> pageBean){
        pageBean.setWhere(new HashMap<String, Object>(2));
        pageBean.getWhere().put("orgType",orgType);
        pageBean.getWhere().put("resName",resName);
        try {
            Page<Object> objects = PageHelper.startPage(pageBean.getPage(), pageBean.getPageSize());
            pageBean.setData(baseResourceDao.getResourcesByPage(pageBean));
            pageBean.setCount((int)objects.getTotal());
            pageBean.setCode(200);//正常返回
        }catch(Exception ex) {
            logger.error("分页获取系统资源出错：",ex);
            pageBean.setCode(0);//错误返回
            pageBean.setMsg("系统繁忙，请稍后再试!");
        }
        return pageBean;
    }

    /**
     * 根据资源id获取资源
     * @param resId
     * @return
     */
    @Override
    public SysResource getResourcesById(String resId) {
        try {
            return baseResourceDao.getResourcesById(resId);
        }catch(Exception ex) {
            logger.error("根据资源id获取资源出错：",ex);
        }
        return null;
    }

    /**
     * 根据资源类型获取所有资源
     * @param resType
     * @return
     */
    @Override
    public List<SysResource> getAllResourcesByType(int resType, int orgType){
        try {
            return baseResourceDao.getAllResourcesByType(resType,orgType);
        }catch(Exception ex) {
            logger.error("根据资源类型获取所有资源出错：",ex);
        }
        return null;
    }

    /**
     * 更新资源
     * @param sysResource
     */
    @Override
    public void updateSysResource(SysResource sysResource) {

        String[] pNode = sysResource.getpName().split(",");
        if(pNode[0].equals("0")) {
            sysResource.setpName(null);
        }else {
            sysResource.setpId(pNode[0]);
            sysResource.setpName(pNode[1]);
        }
        baseResourceDao.updateSysResource(sysResource);
    }

    /**
     * 根据资源id删除资源
     * @param resId
     */
    @Override
    public void delSysResourceByResId(String resId) {
        baseResourceDao.delSysResourceByResId(resId);
    }

    /**
     * 新增资源
     * @param sysResource
     */
    @Override
    public void addSysResource(SysResource sysResource) {
        sysResource.setResId(UuidUtil.uuid());
        String[] pNode = sysResource.getpName().split(",");
        if(pNode[0].equals("0")) {
            sysResource.setpName(null);
        }else {
            sysResource.setpId(pNode[0]);
            sysResource.setpName(pNode[1]);
        }
        if(sysResource.getResType() == 0) {//菜单没有权限
            sysResource.setPerms(null);
        }
        baseResourceDao.addSysResource(sysResource);
    }

    /**
     *  获取所有的资源树
     * @return
     */
    @Override
    public List<SysResource> getAllResourcesTree(){
        return baseResourceDao.getAllResourcesTree();
    }

    /**
     * 获取用户的资源树
     * @param userId
     * @return
     */
    @Override
    public List<SysResource> getMyResourcesTree(String userId){
        return baseResourceDao.getMyResourcesTree(userId);
    }
}
