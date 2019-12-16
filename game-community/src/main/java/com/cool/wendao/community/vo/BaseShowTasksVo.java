//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.cool.wendao.community.vo;

import com.cool.wendao.community.model.ShowTasks;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BaseShowTasksVo {
    public Integer id;
    public String taskType;
    public String taskDesc;
    public String taskPrompt;
    public Integer refresh;
    public Integer taskEndTime;
    public Integer attrib;
    public String reward;
    public String showName;
    public String tasktaskExtraPara;
    public Integer tasktaskState;

    public BaseShowTasksVo() {
    }

    public BaseShowTasksVo(ShowTasks vo) {
        if (vo != null) {
            this.id = vo.getId();
            this.taskType = vo.getTaskType();
            this.taskDesc = vo.getTaskDesc();
            this.taskPrompt = vo.getTaskPrompt();
            this.refresh = vo.getRefresh();
            this.taskEndTime = vo.getTaskEndTime();
            this.attrib = vo.getAttrib();
            this.reward = vo.getReward();
            this.showName = vo.getShowName();
            this.tasktaskExtraPara = vo.getTasktaskExtraPara();
            this.tasktaskState = vo.getTasktaskState();
        }
    }

    public static BaseShowTasksVo t(ShowTasks vo) {
        return new BaseShowTasksVo(vo);
    }

    public static List<BaseShowTasksVo> t(List<ShowTasks> list) {
        List<BaseShowTasksVo> listVo = new ArrayList();
        if (list != null && list.size() > 0) {
            for (ShowTasks showTasks : list) {
                listVo.add(t(showTasks));
            }
        }
        return listVo;
    }
}
