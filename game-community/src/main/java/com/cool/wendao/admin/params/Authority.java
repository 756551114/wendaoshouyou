package com.cool.wendao.admin.params;

import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority {

    private static final long serialVersionUID = 1L;

    private String authority;
    private String isManager;//是否经理角色 Y是 N否

    public Authority() {}
    public Authority(String authority ) {
        this.authority = authority;
    }
    public Authority(String authority,String isManager) {
        this.authority = authority;
        this.isManager=isManager;
    }

    public String getIsManager() {
        return isManager;
    }
    public void setIsManager(String isManager) {
        this.isManager = isManager;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority;
    }
}

