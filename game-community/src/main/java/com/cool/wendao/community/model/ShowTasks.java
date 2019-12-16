//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.cool.wendao.community.model;

import com.cool.wendao.community.core.BaseModel;
import lombok.Data;

import javax.persistence.Table;

@Data
@Table(name = "show_tasks")
public class ShowTasks  extends BaseModel {

    private String taskType;
    private String taskDesc;
    private String taskPrompt;
    private Integer refresh;
    private Integer taskEndTime;
    private Integer attrib;
    private String reward;
    private String showName;
    private String tasktaskExtraPara;
    private Integer tasktaskState;


    public ShowTasks() {
    }




}
