package com.cool.wendao.admin.params;

import java.io.Serializable;

public class Job2Resource implements Serializable {

    private String jobId;//岗位id
    private String resId;//资源id
    private String resUrl;//资源url

    public Job2Resource() {}

    public Job2Resource(String jobId,String resId) {
        this.jobId = jobId;
        this.resId = resId;
    }

    public String getJobId() {
        return jobId;
    }
    public void setJobId(String jobId) {
        this.jobId = jobId;
    }
    public String getResId() {
        return resId;
    }
    public void setResId(String resId) {
        this.resId = resId;
    }
    public String getResUrl() {
        return resUrl;
    }
    public void setResUrl(String resUrl) {
        this.resUrl = resUrl;
    }

}

