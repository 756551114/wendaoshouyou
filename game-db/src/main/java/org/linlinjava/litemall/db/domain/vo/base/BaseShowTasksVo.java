//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.domain.vo.base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.linlinjava.litemall.db.domain.ShowTasks;

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

    public static final BaseShowTasksVo t(ShowTasks vo) {
        return new BaseShowTasksVo(vo);
    }

    public static final List<BaseShowTasksVo> t(List<ShowTasks> list) {
        List<BaseShowTasksVo> listVo = new ArrayList();
        Iterator var2 = list.iterator();

        while(var2.hasNext()) {
            ShowTasks temp = (ShowTasks)var2.next();
            listVo.add(new BaseShowTasksVo(temp));
        }

        return listVo;
    }
}
