package com.cool.wendao.admin.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.cool.wendao.admin.core.MgtConstants;
import com.cool.wendao.admin.core.MgtPageBean;
import com.cool.wendao.admin.core.ResultBean;
import com.cool.wendao.admin.core.ResultEnum;
import com.cool.wendao.admin.dao.BaseJobDao;
import com.cool.wendao.admin.dao.BaseResourceDao;
import com.cool.wendao.admin.dao.BaseUserDao;
import com.cool.wendao.admin.model.BaseOrganization;
import com.cool.wendao.admin.params.*;
import com.cool.wendao.admin.server.MgtBaseUserService;
import com.cool.wendao.admin.server.MgtOrgService;
import com.cool.wendao.admin.util.UuidUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Service
public class MgtBaseUserServiceImpl implements MgtBaseUserService {

    private static Logger logger = LoggerFactory.getLogger(MgtBaseUserServiceImpl.class);

    @Autowired
    private BaseUserDao baseUserDao;

    @Autowired
    private BaseJobDao baseJobDao;

    @Autowired
    private BaseResourceDao baseResourceDao;

    @Autowired
    private MgtOrgService mgtOrgService;


    /**
     * 分页查询系统用户
     *
     * @param sysUser
     * @param pageBean
     * @return
     */
    @Override
    public MgtPageBean<SysUser> getSysUsersByPage(SysUser sysUser, MgtPageBean<SysUser> pageBean) {
        try {
            pageBean.setWhere(new HashMap<String, Object>());
            pageBean.getWhere().put("orgId", sysUser.getOrgId());
            pageBean.getWhere().put("jobId", sysUser.getJobIds());
            pageBean.getWhere().put("name", sysUser.getNickname());
            pageBean.getWhere().put("tel", sysUser.getContactPhone());
            pageBean.setCount(baseUserDao.getSysUsersCount(pageBean));
            if (pageBean.getCount() > 0) {
                pageBean.setData(baseUserDao.getSysUsersByPage(pageBean));
            }
            pageBean.setCode(200);//正常返回
        } catch (Exception ex) {
            logger.error("分页获取系统用户出错：", ex);
            pageBean.setCode(0);//错误返回
            pageBean.setMsg("系统繁忙，请稍后再试!");
        }
        return pageBean;
    }

    /**
     * 根据userId查询系统用户信息
     *
     * @param userId
     * @return
     */
    @Override
    public SysUser getSysUserById(String userId) {
        SysUser sysUser = baseUserDao.getSysUserById(userId);
        sysUser.setOwnerJobIdList(baseUserDao.getJobIdsByUserId(userId));
        return sysUser;
    }

    @Override
    public ResultBean updataSysUser(SysUser sysUser) {
        return new ResultBean(ResultEnum.SUCCESS, baseUserDao.updateSysUserNew(sysUser));
    }

    /**
     * 根据机构id查询岗位信息
     *
     * @param orgId
     * @return
     */
    @Override
    public List<SysJob> getJobsByOrgId(String orgId) {
        return baseJobDao.getJobsByOrgId(orgId);
    }

    /**
     * 查询所有岗位信息
     *
     * @return
     */
    @Override
    public List<SysJob> getAllJobs() {
        return baseJobDao.getAllJobs();
    }

    /**
     * 新增系统用户
     *
     * @param sysUser
     * @param addSysUser
     */
    @Override
    @Transactional
    public void addSysUser(SysUser sysUser, SysUser addSysUser) {
        addSysUser.setUserId(UuidUtil.uuid());
        addSysUser.setOrgId(sysUser.getOrgId());
        addSysUser.setLoginPwd(new BCryptPasswordEncoder().encode(MgtConstants.RAWPWD));
        addSysUser.setHasDefault(MgtConstants.NO);
        String[] jobIds = addSysUser.getJobIds().split(",");
        List<SysUser2Job> sysUser2JobList = new ArrayList<SysUser2Job>();
        SysUser2Job sysUser2Job = null;
        for (String jobId : jobIds) {
            sysUser2Job = new SysUser2Job();
            sysUser2Job.setSysUserId(addSysUser.getUserId());
            sysUser2Job.setJobId(jobId);
            sysUser2JobList.add(sysUser2Job);
        }
        baseUserDao.addSysUser(addSysUser);
        baseUserDao.addSysUser2Jobs(sysUser2JobList);
    }

    /**
     * 新增系统用户（仅供商户注册使用）
     *
     * @param orgId      机构id
     * @param type       调用者类型（机构类型  0-运维 1-运营商  2-分销商 3-商户 4-子商户 100-待审核商户）
     * @param addSysUser 创建用户信息，loginName(必设)、hasEnabled(必设)、loginPwd(必设)、nickname(选设)、contactPhone(选设)、sex(选设)、email(选设)
     * @param
     */
    @Override
    @Transactional
    public void addSpecialSysUser(String orgId, Integer type, SysUser addSysUser) {
        try {
            orgId = UuidUtil.uuid();
            BaseOrganization organization = new BaseOrganization();
            organization.setId(orgId);
            mgtOrgService.initOrg(organization);
            //新增用户
            addSysUser.setUserId(UuidUtil.uuid());
            addSysUser.setOrgId(orgId);
            addSysUser.setLoginPwd(new BCryptPasswordEncoder().encode(addSysUser.getLoginPwd()));
            addSysUser.setHasDefault(MgtConstants.YES);
            addSysUser.setHasEnabled(addSysUser.getHasEnabled());
            SysJob sysJob = new SysJob();
            sysJob.setJobId(UuidUtil.uuid());
            sysJob.setOrgId(orgId);
            sysJob.setHasDefault(MgtConstants.YES);
            sysJob.setJobName("商户管理员");
            List<Job2Resource> job2ResList = new ArrayList<Job2Resource>();
            List<SysResource> resources = baseResourceDao.getAllResourcesByType(0, type);
            for (SysResource resource : resources) {
                if (!StringUtils.isEmpty(resource.getResId())) {
                    job2ResList.add(new Job2Resource(sysJob.getJobId(), resource.getResId()));
                    List<SysResource> sysResources = baseResourceDao.getBtnResources(resource.getResId());
                    if (sysResources != null && sysResources.size() > 0) {
                        for (SysResource sysResource : sysResources) {
                            job2ResList.add(new Job2Resource(sysJob.getJobId(), sysResource.getResId()));
                        }
                    }
                }
            }
            //新增默认岗位
            baseJobDao.addJob(sysJob);
            //分配默认岗位权限
            baseJobDao.addJob2Resources(job2ResList);
            List<SysUser2Job> sysUser2JobList = new ArrayList<SysUser2Job>();
            SysUser2Job sysUser2Job = new SysUser2Job();
            sysUser2Job.setSysUserId(addSysUser.getUserId());
            sysUser2Job.setJobId(sysJob.getJobId());
            sysUser2JobList.add(sysUser2Job);
            baseUserDao.addSysUser(addSysUser);
            baseUserDao.addSysUser2Jobs(sysUser2JobList);
        } catch (Exception e) {
            logger.error("---------错误------------->", e);
            throw e;
        }
    }

    /**
     * 更新系统用户（仅供商户注册使用）
     *
     * @param orgId      机构id
     * @param type       调用者类型（机构类型  0-运维 1-运营商  2-分销商 3-商户 4-子商户 100-待审核商户）
     * @param excludeRes 排除的资源菜单，不添加排除的资源权限
     * @param
     */
    @Override
    @Transactional
    public void updateSpecialSysUser(String orgId, Integer type, List<String> excludeRes) {
        SysJob sysJob = baseJobDao.getDefJobsByOrgId(orgId);
        baseJobDao.delJob2ResByJobId(sysJob.getJobId());
        List<Job2Resource> job2ResList = new ArrayList<Job2Resource>();
        List<SysResource> resources = baseResourceDao.getAllResourcesByType(0, type);
        for (SysResource resource : resources) {
            if (excludeRes != null && excludeRes.contains(resource.getResId())) {
                continue;
            }
            if (!StringUtils.isEmpty(resource.getResId())) {
                job2ResList.add(new Job2Resource(sysJob.getJobId(), resource.getResId()));
                List<SysResource> sysResources = baseResourceDao.getBtnResources(resource.getResId());
                if (sysResources != null && sysResources.size() > 0) {
                    for (SysResource sysResource : sysResources) {
                        job2ResList.add(new Job2Resource(sysJob.getJobId(), sysResource.getResId()));
                    }
                }
            }
        }
        baseJobDao.addJob2Resources(job2ResList);
    }

    /**
     * 根据id删除系统用户
     *
     * @param userId
     */
    @Override
    public void delSysUser(String userId) {
        baseUserDao.delSysUserById(userId);
    }

    /**
     * 更新系统用户
     *
     * @param sysUser
     */
    @Override
    @Transactional
    public void updateSysUser(SysUser sysUser) {
        String[] jobIds = sysUser.getJobIds().split(",");
        List<SysUser2Job> sysUser2JobList = new ArrayList<SysUser2Job>();
        SysUser2Job sysUser2Job = null;
        for (String jobId : jobIds) {
            sysUser2Job = new SysUser2Job();
            sysUser2Job.setSysUserId(sysUser.getUserId());
            sysUser2Job.setJobId(jobId);
            sysUser2JobList.add(sysUser2Job);
        }
        baseUserDao.updateSysUser(sysUser);
        baseUserDao.delSysUser2JobsByUserId(sysUser.getUserId());
        baseUserDao.addSysUser2Jobs(sysUser2JobList);
    }

    /**
     * 检查登录名是否存在
     *
     * @param loginName
     * @param pt        1.运营平台 2.商户管理平台
     * @return
     */
    @Override
    public Integer checkLoginName(String loginName, Integer pt) {
        return baseUserDao.checkLoginName(loginName, pt);
    }

    /**
     * 根据登录名和机构id修改用户密码
     *
     * @param orgId     机构id
     * @param loginName 登录名
     * @param pwd       新密码
     */
    @Override
    public int updateUserPwd(String orgId, String loginName, String pwd) {
        SysUser sysUser = new SysUser();
        sysUser.setLoginPwd(new BCryptPasswordEncoder().encode(pwd));
        sysUser.setOrgId(orgId);
        sysUser.setLoginName(loginName);
        return baseUserDao.updateUserPwd(sysUser);
    }

    /**
     * 修改用户密码
     *
     * @param sysUser
     */
    @Override
    public void updatePwd(SysUser sysUser) {
        baseUserDao.updatePwd(sysUser);
    }

    /**
     * 查询用户角色信息
     *
     * @param userId
     * @return
     */
    @Override
    public List<String> getJobIdsByUserId(String userId) {
        return baseUserDao.getJobIdsByUserId(userId);
    }

    /**
     * 根据登录名获取用户信息
     *
     * @param loginName
     * @param pt        登录平台 1.运营平台 3.商户平台
     * @return
     */
    @Override
    public SysUser getUserByLoginName(String loginName, Integer pt) {
        return baseUserDao.doLogin(loginName, pt);
    }

    /**
     * 根据用户id查询角色列表
     */
    @Override
    public List<SysJob> getJobByUserId(String userId) {
        return baseUserDao.getJobByUserId(userId);
    }


}
