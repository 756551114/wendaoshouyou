package com.cool.wendao.admin.dao;

import com.cool.wendao.admin.core.MgtPageBean;
import com.cool.wendao.admin.params.SysResource;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaseResourceDao {

    /**
     * 获取系统资源总数
     * @param pageBean
     * @return
     */
    int getResourcesCount(MgtPageBean<SysResource> pageBean);

    /**
     * 分页获取系统资源
     * @param pageBean
     * @return
     */
    List<SysResource> getResourcesByPage(MgtPageBean<SysResource> pageBean);

    /**
     * 根据资源id获取资源
     * @param resId
     * @return
     */
    SysResource getResourcesById(String resId);

    /**
     * 根据资源类型获取所有资源
     * @param resType
     * @param orgType
     * @return
     */
    List<SysResource> getAllResourcesByType(@Param("resType") int resType, @Param("orgType") int orgType);

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
     * 查询所有资源树
     * @return
     */
    List<SysResource> getAllResourcesTree();

    /**
     * 查询我的资源树
     * @param userId
     * @return
     */
    List<SysResource> getMyResourcesTree(String userId);

    /**
     * 获取指定资源下的按钮资源信息
     * @param parentId
     * @return
     */
    List<SysResource> getBtnResources(String parentId);
}
