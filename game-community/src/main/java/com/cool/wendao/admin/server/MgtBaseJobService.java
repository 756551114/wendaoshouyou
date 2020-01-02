package com.cool.wendao.admin.server;


import com.cool.wendao.admin.core.MgtPageBean;
import com.cool.wendao.admin.core.ResultBean;
import com.cool.wendao.admin.params.Job2Resource;
import com.cool.wendao.admin.params.SysJob;
import com.cool.wendao.admin.params.SysUser;

import java.util.List;

/**
 * 管理平台权限岗位接口
 * @author Fangbb
 * 2019-04-01
 */
public interface MgtBaseJobService {

    /**
     * 新增岗位
     * @param sysUser
     * @param sysJob
     */
    void addJob(SysUser sysUser, SysJob sysJob);

    /**
     * 更新岗位
     * @param sysJob
     */
    void updateJob(SysJob sysJob);

    /**
     * 删除岗位
     * @param jobId
     */
    String delJob(String jobId);

    /**
     * 分页查询岗位
     * @param sysUser
     * @param pageBean
     * @return
     */
    MgtPageBean<SysJob> getJobsByPage(SysUser sysUser, MgtPageBean<SysJob> pageBean);

    /**
     * 根据jobId查询岗位对应资源关系
     * @param sysUser
     * @param jobId
     * @param disabled 是否禁用，即是否可以点击。不能点击用于展示用 true/false
     * @return
     */
    ResultBean getJob2ResByJobId(SysUser sysUser, String jobId, boolean disabled);

    /**
     * 根据jobId获取岗位信息
     * @param jobId
     * @return
     */
    SysJob getJobByJobId(String jobId);

    /**
     * 检查岗位名是否存在
     * @param jobName
     * @param jobId
     * @return
     */
    int checkJobName(String jobId,String jobName);

    /**
     * 获取所有角色的资源权限
     * @return
     */
    List<Job2Resource> getAllJob2Res();
}

