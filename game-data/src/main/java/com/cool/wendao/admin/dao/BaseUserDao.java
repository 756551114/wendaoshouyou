package com.cool.wendao.admin.dao;

import com.cool.wendao.admin.core.MgtPageBean;
import com.cool.wendao.admin.params.SysJob;
import com.cool.wendao.admin.params.SysUser;
import com.cool.wendao.admin.params.SysUser2Job;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BaseUserDao {
    /**
     * 系统用户登录
     *
     * @param loginName
     * @return SysUser
     */
    SysUser doLogin(@Param("loginName") String loginName, @Param("pt") Integer pt);

    /**
     * 根据机构id获取系统用户总数
     *
     * @param pageBean
     * @return
     */
    int getSysUsersCount(MgtPageBean<SysUser> pageBean);

    /**
     * 分页查询系统用户
     *
     * @param pageBean
     * @return
     */
    List<SysUser> getSysUsersByPage(MgtPageBean<SysUser> pageBean);

    /**
     * 根据userId查询系统用户信息
     *
     * @param userId
     * @return
     */
    SysUser getSysUserById(String userId);

    /**
     * 批量添加系统用户对应岗位
     *
     * @param sysUser2JobList
     */
    void addSysUser2Jobs(List<SysUser2Job> sysUser2JobList);

    /**
     * 新增系统用户
     *
     * @param sysUser
     */
    void addSysUser(SysUser sysUser);

    /**
     * 修改系统用户
     *
     * @param sysUser
     */
    void updateSysUser(SysUser sysUser);

    /**
     * 检查登录名是否存在
     *
     * @param loginName
     * @return
     */
    int checkLoginName(@Param("loginName") String loginName, @Param("pt") Integer pt);

    /**
     * 根据id删除系统用户
     *
     * @param userId
     */
    void delSysUserById(String userId);

    /**
     * 修改系统用户启用状态
     *
     * @param params
     */
    void updateSysUserEnabled(Map<String, Object> params);

    /**
     * 根据系统用户id查询对应的岗位id集合
     *
     * @param userId
     * @return
     */
    List<String> getJobIdsByUserId(String userId);

    /**
     * 根据系统用户id查询对应的岗位集合
     *
     * @param userId
     * @return
     */
    List<SysJob> getJobByUserId(String userId);

    /**
     * 根据岗位id查询对应的用户集合
     *
     * @param jobId
     * @return
     */
    List<String> getUserIdsByJobId(String jobId);

    /**
     * 根据系统用户id删除系统用户对应岗位信息
     *
     * @param userId
     */
    void delSysUser2JobsByUserId(String userId);

    /**
     * 修改系统用户密码
     *
     * @param sysUser
     */
    void updatePwd(SysUser sysUser);

    /**
     * 修改系统用户密码
     *
     * @param sysUser
     */
    int updateUserPwd(SysUser sysUser);

    /**
     * 查询商户经理用户
     *
     * @return
     */
    List<SysUser> findManagerUserList();


    /**
     * 查询所有商户账号
     *
     * @return
     */
    List<SysUser> findAllSellerUser();

    /**
     * 新增修改个人信息的接口
     */
    int updateSysUserNew(SysUser sysUser);
}
