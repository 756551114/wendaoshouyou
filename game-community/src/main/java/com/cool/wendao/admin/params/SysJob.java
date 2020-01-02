package com.cool.wendao.admin.params;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class SysJob implements Serializable {

    private String jobId;//岗位id
    private String orgId;//机构id
    private String jobName;//岗位名称
    private Date createTime;//创建时间
    List<Node> nodeList;//资源节点
    private String[] authids;//权限id集合
    private String hasDefault;//N 非默认  Y 默认
    private String isManager;//是否经理角色 N否 Y是

    public String getIsManager() {
        return isManager;
    }
    public void setIsManager(String isManager) {
        this.isManager = isManager;
    }

    public String getJobId() {
        return jobId;
    }
    public void setJobId(String jobId) {
        this.jobId = jobId;
    }
    public String getOrgId() {
        return orgId;
    }
    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }
    public String getJobName() {
        return jobName;
    }
    public void setJobName(String jobName) {
        this.jobName = jobName;
    }
    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public String[] getAuthids() {
        return authids;
    }
    public void setAuthids(String[] authids) {
        this.authids = authids;
    }
    public List<Node> getNodeList() {
        return nodeList;
    }
    public void setNodeList(List<Node> nodeList) {
        this.nodeList = nodeList;
    }
    public String getHasDefault() {
        return hasDefault;
    }
    public void setHasDefault(String hasDefault) {
        this.hasDefault = hasDefault;
    }

}
