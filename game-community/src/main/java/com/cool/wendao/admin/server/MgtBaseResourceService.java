package com.cool.wendao.admin.server;

import com.cool.wendao.admin.core.MgtPageBean;
import com.cool.wendao.admin.params.SysResource;

import java.util.List;

/**
 * 管理平台权限模块菜单资源接口
 * @author Fangbb
 * 2019-04-01
 */
public interface MgtBaseResourceService {

    /**
     * 分页获取系统资源
     * @param pageBean
     * @return pageBean
     */
    MgtPageBean<SysResource> getResourcesByPage(String resName, Integer orgType, MgtPageBean<SysResource> pageBean);

    /**
     * 根据资源id获取资源
     * @param resId
     * @return
     */
    SysResource getResourcesById(String resId);

    /**
     * 根据资源类型获取所有资源
     * @param resType 资源类型 0-菜单 1-按钮
     * @param orgType 机构类型 0-管理平台 1-运营商  2-分销商 3-商户
     * @return
     */
    List<SysResource> getAllResourcesByType(int resType, int orgType);

    /**
     * 更新资源
     * @param sysResource
     */
    void updateSysResource(SysResource sysResource);

    /**
     * 根据资源id删除资源
     * @param resId
     */
    void delSysResourceByResId(String resId);

    /**
     * 新增资源
     * @param sysResource
     */
    void addSysResource(SysResource sysResource);

    /**
     *  获取所有的资源树
     * @return
     */
    List<SysResource> getAllResourcesTree();

    /**
     * 获取用户的资源树
     * @param userId
     * @return
     */
    List<SysResource> getMyResourcesTree(String userId);

}

