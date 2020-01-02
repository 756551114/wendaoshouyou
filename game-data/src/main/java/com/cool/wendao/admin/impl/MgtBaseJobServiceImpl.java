package com.cool.wendao.admin.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.cool.wendao.admin.core.MgtConstants;
import com.cool.wendao.admin.core.MgtPageBean;
import com.cool.wendao.admin.core.ResultBean;
import com.cool.wendao.admin.dao.BaseJobDao;
import com.cool.wendao.admin.dao.BaseResourceDao;
import com.cool.wendao.admin.dao.BaseUserDao;
import com.cool.wendao.admin.params.*;
import com.cool.wendao.admin.server.MgtBaseJobService;
import com.cool.wendao.admin.util.UuidUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class MgtBaseJobServiceImpl implements MgtBaseJobService {
    private static Logger logger = LoggerFactory.getLogger(MgtBaseJobServiceImpl.class);

    @Autowired
    private BaseJobDao baseJobDao;
    @Autowired
    private BaseResourceDao baseResourceDao;
    @Autowired
    private BaseUserDao baseUserDao;
    /**
     * 新增岗位
     * @param sysUser
     * @param sysJob
     */
    @Transactional
    public void addJob(SysUser sysUser, SysJob sysJob){
        sysJob.setJobId(UuidUtil.uuid());
        sysJob.setOrgId(sysUser.getOrgId());
        sysJob.setHasDefault(MgtConstants.NO);
        List<Job2Resource> job2ResList = new ArrayList<Job2Resource>();
        for(String authid : sysJob.getAuthids()) {
            if(!StringUtils.isEmpty(authid)) {
                job2ResList.add(new Job2Resource(sysJob.getJobId(), authid));
                List<SysResource> sysResources = baseResourceDao.getBtnResources(authid);
                if(sysResources!=null&&sysResources.size()>0){
                    for(SysResource sysResource :sysResources){
                        job2ResList.add(new Job2Resource(sysJob.getJobId(), sysResource.getResId()));
                    }
                }
            }
        }
        baseJobDao.addJob(sysJob);
        baseJobDao.addJob2Resources(job2ResList);
    }

    /**
     * 更新岗位
     * @param sysJob
     */
    @Transactional
    public void updateJob(SysJob sysJob) {
        baseJobDao.updateJobById(sysJob);
        baseJobDao.delJob2ResByJobId(sysJob.getJobId());
        List<Job2Resource> job2ResList = new ArrayList<Job2Resource>();
        for(String authid : sysJob.getAuthids()) {
            if(!StringUtils.isEmpty(authid)) {
                job2ResList.add(new Job2Resource(sysJob.getJobId(), authid));
                List<SysResource> sysResources = baseResourceDao.getBtnResources(authid);
                if(sysResources!=null&&sysResources.size()>0){
                    for(SysResource sysResource :sysResources){
                        job2ResList.add(new Job2Resource(sysJob.getJobId(), sysResource.getResId()));
                    }
                }
            }
        }
        baseJobDao.addJob2Resources(job2ResList);
    }

    /**
     * 删除岗位
     * @param jobId
     */
    @Transactional
    public String delJob(String jobId) {
        String flag = "success";
        List<String> userIds = baseUserDao.getUserIdsByJobId(jobId);
        if(userIds!=null&&userIds.size()>0){
            return "exist";
        }
        baseJobDao.delJobById(jobId);
        baseJobDao.delJob2ResByJobId(jobId);
        return flag;
    }

    /**
     * 分页查询岗位
     * @param sysUser
     * @param pageBean
     * @return
     */
    public MgtPageBean<SysJob> getJobsByPage(SysUser sysUser, MgtPageBean<SysJob> pageBean){
        try {
            pageBean.setWhere(new HashMap<String,Object>());
            pageBean.getWhere().put("orgId", sysUser.getOrgId());
            pageBean.setCount(baseJobDao.getJobsCount(pageBean));
            if(pageBean.getCount() > 0) {
                pageBean.setData(baseJobDao.getJobsByPage(pageBean));
            }
            pageBean.setCode(200);//正常返回
        }catch(Exception ex) {
            logger.error("分页获取岗位出错：",ex);
            pageBean.setCode(0);//错误返回
            pageBean.setMsg("系统繁忙，请稍后再试!");
        }
        return pageBean;
    }

    /**
     * 根据jobId查询岗位对应资源关系
     * @param sysUser
     * @param jobId
     * @param disabled 是否禁用，即是否可以点击。不能点击用于展示用 true/false
     * @return
     */
    public ResultBean getJob2ResByJobId(SysUser sysUser, String jobId, boolean disabled){
        ResultBean resultBean = new ResultBean();
        try {
            List<Node> nodeList = new ArrayList<Node>();
            SysJob sysJob = new SysJob();
            sysJob.setNodeList(nodeList);
            resultBean.setData(sysJob);
            List<SysResource> sysResList = null;
            if(sysUser.getUserId().equals(MgtConstants.SUPER_ADMIN_ID)) {
                sysResList = baseResourceDao.getAllResourcesTree();
            }else {
                sysResList = baseResourceDao.getMyResourcesTree(sysUser.getUserId());
            }
            List<String> checkedResList = null;
            if(!StringUtils.isEmpty(jobId)) {
                checkedResList = baseJobDao.getResByJobId(jobId);
            }
            for(SysResource sysRes : sysResList) {
                if(StringUtils.isEmpty(sysRes.getpId())) {
                    Node node = new Node();
                    node.setName(sysRes.getResName());
                    node.setValue(sysRes.getResId());
                    if(!CollectionUtils.isEmpty(checkedResList) && checkedResList.contains(sysRes.getResId())) {
                        node.setChecked(true);
                    }
                    node.setDisabled(disabled);
                    if(sysRes.getResType()==0){//v1.0版本屏蔽按钮权限
                        nodeList.add(node);
                    }
                    initSubNodes(sysResList,checkedResList,node);
                }
            }
            resultBean.setSta(0);//正常返回
        }catch(Exception ex) {
            logger.error("查询所有岗位出错：",ex);
            resultBean.setSta(200);//错误返回
            resultBean.setMsg("系统繁忙，请稍后再试!");
        }
        return resultBean;
    }

    /**
     * 递归循环子节点
     * @param sysResList
     * @param checkedResList
     * @param pNode
     */
    private void initSubNodes(List<SysResource> sysResList, List<String> checkedResList, Node pNode) {
        for(SysResource sysRes : sysResList) {
            if(pNode.getValue().equals(sysRes.getpId())) {
                Node node = new Node();
                node.setName(sysRes.getResName());
                node.setValue(sysRes.getResId());
                if(!CollectionUtils.isEmpty(checkedResList) && checkedResList.contains(sysRes.getResId())) {
                    node.setChecked(true);
                }
                node.setDisabled(pNode.isDisabled());
                if(sysRes.getResType()==0){//v1.0版本屏蔽按钮权限
                    pNode.getList().add(node);
                }
                initSubNodes(sysResList,checkedResList,node);
            }
        }
    }

    /**
     * 根据jobId获取岗位信息
     * @param jobId
     * @return
     */
    public SysJob getJobByJobId(String jobId){
        try {
            return baseJobDao.getJobById(jobId);
        }catch(Exception ex) {
            logger.error("根据jobId获取岗位信息出错：",ex);
        }
        return null;
    }

    /**
     * 检查岗位名是否存在
     * @param jobName
     * @param jobId
     * @return
     */
    public int checkJobName(String jobId,String jobName) {
        Map<String,Object> map = new HashMap<>();
        map.put("jobId",jobId);
        map.put("jobName",jobName);
        return baseJobDao.checkJobName(map);
    }

    /**
     * 获取所有角色的资源权限
     * @return
     */
    public List<Job2Resource> getAllJob2Res(){
        return baseJobDao.getAllJob2Res();
    }

}
