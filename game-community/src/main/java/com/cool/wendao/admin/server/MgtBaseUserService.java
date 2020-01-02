package com.cool.wendao.admin.server;

import com.cool.wendao.admin.core.MgtPageBean;
import com.cool.wendao.admin.core.ResultBean;
import com.cool.wendao.admin.params.SysJob;
import com.cool.wendao.admin.params.SysUser;

import java.util.List;

public interface MgtBaseUserService {

    /**
     * 分页查询系统用户
     *
     * @param sysUser
     * @param pageBean
     * @return
     */
    MgtPageBean<SysUser> getSysUsersByPage(SysUser sysUser, MgtPageBean<SysUser> pageBean);

    /**
     * 根据userId查询系统用户信息
     *
     * @param userId
     * @return
     */
    SysUser getSysUserById(String userId);

    /**
     * 修改个人信息
     */
    ResultBean<?> updataSysUser(SysUser sysUser);

    /**
     * 根据机构id查询岗位信息
     *
     * @param orgId
     * @return
     */
    List<SysJob> getJobsByOrgId(String orgId);

    /**
     * 查询所有岗位信息
     *
     * @return
     */
    List<SysJob> getAllJobs();

    /**
     * 新增系统用户
     *
     * @param sysUser
     * @param addSysUser
     */
    void addSysUser(SysUser sysUser, SysUser addSysUser);

    /**
     * 新增系统用户（仅供商户注册使用）
     *
     * @param orgId      机构id
     * @param type       调用者类型（机构类型 0-运维 1-运营商  2-分销商 3-商户 4-子商户 100-待审核商户）
     * @param addSysUser 创建用户信息，loginName(必设)、hasEnabled(必设)、loginPwd(必设)、nickname(选设)、contactPhone(选设)、sex(选设)、email(选设)
     * @param
     */
    void addSpecialSysUser(String orgId, Integer type, SysUser addSysUser);

    /**
     * 更新系统用户（仅供商户注册使用）
     *
     * @param orgId      机构id
     * @param type       调用者类型（机构类型  0-运维 1-运营商  2-分销商 3-商户 4-子商户 100-待审核商户）
     * @param excludeRes 排除的资源菜单，不添加排除的资源权限
     * @param
     */
    void updateSpecialSysUser(String orgId, Integer type, List<String> excludeRes);

    /**
     * 根据id删除系统用户
     *
     * @param userId
     */
    void delSysUser(String userId);

    /**
     * 更新系统用户
     *
     * @param sysUser
     */
    void updateSysUser(SysUser sysUser);

    /**
     * 检查登录名是否存在
     *
     * @param loginName
     * @param pt        1.运营平台 2.商户管理平台
     * @return
     */
    Integer checkLoginName(String loginName, Integer pt);

    /**
     * 根据登录名和机构id修改用户密码
     *
     * @param orgId     机构id
     * @param loginName 登录名
     * @param pwd       新密码
     */
    int updateUserPwd(String orgId, String loginName, String pwd);

    /**
     * 修改用户密码
     *
     * @param sysUser
     */
    void updatePwd(SysUser sysUser);

    /**
     * 查询用户角色信息
     *
     * @param userId
     * @return
     */
    List<String> getJobIdsByUserId(String userId);

    /**
     * 查询用户角色信息
     *
     * @param userId
     * @return
     */
    List<SysJob> getJobByUserId(String userId);

    /**
     * 根据登录名获取用户信息
     *
     * @param loginName
     * @param pt        1.运营平台 2.商户管理平台
     * @return
     */
    SysUser getUserByLoginName(String loginName, Integer pt);

    /**
     * 查询商户经理角色列表
     *
     * @return
     */
    List<SysUser> findManagerUserList();
}
