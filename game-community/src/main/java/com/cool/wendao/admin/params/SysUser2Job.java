package com.cool.wendao.admin.params;

import java.io.Serializable;

public class SysUser2Job implements Serializable {

    private String sysUserId;
    private String jobId;

    public String getSysUserId() {
        return sysUserId;
    }
    public void setSysUserId(String sysUserId) {
        this.sysUserId = sysUserId;
    }
    public String getJobId() {
        return jobId;
    }
    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

}
