package com.cool.wendao.admin.params;

import java.io.Serializable;
import java.util.Date;

public class SysResource implements Serializable {

    private String resId;//资源id
    private Integer orgType;//机构类型  0-运维 1-运营商  2-分销商 3-商户 4-子商户 100-待审核商户
    private String pId;//父资源id
    private String pName;//父资源名称
    private String resName;//资源名称
    private Integer orderNum;//资源顺序
    private String resUrl;//资源地址
    private String resIcon;//资源图标
    private Integer resType;//资源类型   0 菜单 1 按钮
    private String perms;//权限
    private Date createTime;//创建时间

    public String getResId() {
        return resId;
    }
    public void setResId(String resId) {
        this.resId = resId;
    }
    public String getpId() {
        return pId;
    }
    public void setpId(String pId) {
        this.pId = pId;
    }
    public String getpName() {
        return pName;
    }
    public void setpName(String pName) {
        this.pName = pName;
    }
    public String getResName() {
        return resName;
    }
    public void setResName(String resName) {
        this.resName = resName;
    }
    public Integer getOrderNum() {
        return orderNum;
    }
    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }
    public String getResUrl() {
        return resUrl;
    }
    public void setResUrl(String resUrl) {
        this.resUrl = resUrl;
    }
    public Integer getResType() {
        return resType;
    }
    public void setResType(Integer resType) {
        this.resType = resType;
    }
    public String getPerms() {
        return perms;
    }
    public void setPerms(String perms) {
        this.perms = perms;
    }
    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public String getResIcon() {
        return resIcon;
    }
    public void setResIcon(String resIcon) {
        this.resIcon = resIcon;
    }

    public Integer getOrgType() {
        return orgType;
    }

    public void setOrgType(Integer orgType) {
        this.orgType = orgType;
    }
}
