package com.cool.wendao.admin.params;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class SysUser implements UserDetails{

    private static final long serialVersionUID = 1L;

    private String userId;//系统用户id
    private String orgId;//机构id
    private String loginName;//登录名
    private String loginPwd;//登录密码
    private String nickname;//昵称
    private String contactPhone;//联系电话
    private int sex;//0 女  1 男
    private String email;//邮箱
    private Date createTime;//创建时间
    private String jobIds;//岗位id字符串集合
    private List<String> ownerJobIdList;//岗位id集合
    private String hasEnabled;//N 禁用    Y 启用
    private String hasDefault;//N 非默认  Y 默认
    private String orgHasEnabled;//归属机构是否禁用 N 禁用    Y 启用
    private List<SysResource> resList;//我的资源菜单
    private List<Authority> authorityList = new ArrayList<Authority>();//用户岗位权限
    private String jobNames;
    private String orgName;//归属的机构名称

    /**
     * 重写比较方法,SpringSecurity根据用户名来比较是否同一个用户
     */
    @Override
    public boolean equals(Object o){
        if(o.toString().equals(this.loginName))
            return true;
        return false;
    }

    @Override
    public int hashCode(){
        return loginName.hashCode();
    }


    @Override
    public String toString() {
        return this.loginName;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorityList;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getPassword() {
        return loginPwd;
    }

    @Override
    public String getUsername() {
        return loginName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        if("Y".equals(hasEnabled)) {
            return true;
        }else {
            return false;
        }
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getJobIds() {
        return jobIds;
    }

    public void setJobIds(String jobIds) {
        this.jobIds = jobIds;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public List<String> getOwnerJobIdList() {
        return ownerJobIdList;
    }

    public void setOwnerJobIdList(List<String> ownerJobIdList) {
        this.ownerJobIdList = ownerJobIdList;
    }

    public String getHasEnabled() {
        return hasEnabled;
    }

    public void setHasEnabled(String hasEnabled) {
        this.hasEnabled = hasEnabled;
    }

    public String getHasDefault() {
        return hasDefault;
    }

    public void setHasDefault(String hasDefault) {
        this.hasDefault = hasDefault;
    }

    public List<SysResource> getResList() {
        return resList;
    }

    public void setResList(List<SysResource> resList) {
        this.resList = resList;
    }

    public void setAuthorityList(List<Authority> authorityList) {
        this.authorityList = authorityList;
    }

    public List<Authority> getAuthorityList() {
        return authorityList;
    }

    public String getOrgHasEnabled() {
        return orgHasEnabled;
    }

    public void setOrgHasEnabled(String orgHasEnabled) {
        this.orgHasEnabled = orgHasEnabled;
    }

    public String getJobNames() {
        return jobNames;
    }

    public void setJobNames(String jobNames) {
        this.jobNames = jobNames;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }
}

