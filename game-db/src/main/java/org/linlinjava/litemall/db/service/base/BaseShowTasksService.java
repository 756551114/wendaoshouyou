//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.service.base;

import com.github.pagehelper.PageHelper;
import java.time.LocalDateTime;
import java.util.List;
import org.linlinjava.litemall.db.dao.ShowTasksMapper;
import org.linlinjava.litemall.db.domain.ShowTasks;
import org.linlinjava.litemall.db.domain.example.ShowTasksExample;
import org.linlinjava.litemall.db.domain.example.ShowTasksExample.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class BaseShowTasksService {
    @Autowired
    protected ShowTasksMapper mapper;

    public BaseShowTasksService() {
    }

    @Cacheable(
            cacheNames = {"ShowTasks"},
            key = "#id"
    )
    public ShowTasks findById(int id) {
        return this.mapper.selectByPrimaryKeyWithLogicalDelete(id, false);
    }

    @Cacheable(
            cacheNames = {"ShowTasks"},
            key = "#id",
            condition = "#result.deleted == 0"
    )
    public ShowTasks findByIdContainsDelete(int id) {
        return this.mapper.selectByPrimaryKey(id);
    }

    public void add(ShowTasks showTasks) {
        showTasks.setAddTime(LocalDateTime.now());
        showTasks.setUpdateTime(LocalDateTime.now());
        this.mapper.insertSelective(showTasks);
    }

    @CachePut(
            cacheNames = {"ShowTasks"},
            key = "#showTasks.id"
    )
    public int updateById(ShowTasks showTasks) {
        showTasks.setUpdateTime(LocalDateTime.now());
        return this.mapper.updateByPrimaryKeySelective(showTasks);
    }

    @CacheEvict(
            cacheNames = {"ShowTasks"},
            key = "#id"
    )
    public void deleteById(int id) {
        this.mapper.logicalDeleteByPrimaryKey(id);
    }

    public List<ShowTasks> findByTaskType(String taskType) {
        ShowTasksExample example = new ShowTasksExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andTaskTypeEqualTo(taskType);
        return this.mapper.selectByExample(example);
    }

    public List<ShowTasks> findByTaskDesc(String taskDesc) {
        ShowTasksExample example = new ShowTasksExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andTaskDescEqualTo(taskDesc);
        return this.mapper.selectByExample(example);
    }

    public List<ShowTasks> findByTaskPrompt(String taskPrompt) {
        ShowTasksExample example = new ShowTasksExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andTaskPromptEqualTo(taskPrompt);
        return this.mapper.selectByExample(example);
    }

    public List<ShowTasks> findByRefresh(Integer refresh) {
        ShowTasksExample example = new ShowTasksExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andRefreshEqualTo(refresh);
        return this.mapper.selectByExample(example);
    }

    public List<ShowTasks> findByTaskEndTime(Integer taskEndTime) {
        ShowTasksExample example = new ShowTasksExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andTaskEndTimeEqualTo(taskEndTime);
        return this.mapper.selectByExample(example);
    }

    public List<ShowTasks> findByAttrib(Integer attrib) {
        ShowTasksExample example = new ShowTasksExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andAttribEqualTo(attrib);
        return this.mapper.selectByExample(example);
    }

    public List<ShowTasks> findByReward(String reward) {
        ShowTasksExample example = new ShowTasksExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andRewardEqualTo(reward);
        return this.mapper.selectByExample(example);
    }

    public List<ShowTasks> findByShowName(String showName) {
        ShowTasksExample example = new ShowTasksExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andShowNameEqualTo(showName);
        return this.mapper.selectByExample(example);
    }

    public List<ShowTasks> findByTasktaskExtraPara(String tasktaskExtraPara) {
        ShowTasksExample example = new ShowTasksExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andTasktaskExtraParaEqualTo(tasktaskExtraPara);
        return this.mapper.selectByExample(example);
    }

    public List<ShowTasks> findByTasktaskState(Integer tasktaskState) {
        ShowTasksExample example = new ShowTasksExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andTasktaskStateEqualTo(tasktaskState);
        return this.mapper.selectByExample(example);
    }

    public ShowTasks findOneByTaskType(String taskType) {
        ShowTasksExample example = new ShowTasksExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andTaskTypeEqualTo(taskType);
        return this.mapper.selectOneByExample(example);
    }

    public ShowTasks findOneByTaskDesc(String taskDesc) {
        ShowTasksExample example = new ShowTasksExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andTaskDescEqualTo(taskDesc);
        return this.mapper.selectOneByExample(example);
    }

    public ShowTasks findOneByTaskPrompt(String taskPrompt) {
        ShowTasksExample example = new ShowTasksExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andTaskPromptEqualTo(taskPrompt);
        return this.mapper.selectOneByExample(example);
    }

    public ShowTasks findOneByRefresh(Integer refresh) {
        ShowTasksExample example = new ShowTasksExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andRefreshEqualTo(refresh);
        return this.mapper.selectOneByExample(example);
    }

    public ShowTasks findOneByTaskEndTime(Integer taskEndTime) {
        ShowTasksExample example = new ShowTasksExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andTaskEndTimeEqualTo(taskEndTime);
        return this.mapper.selectOneByExample(example);
    }

    public ShowTasks findOneByAttrib(Integer attrib) {
        ShowTasksExample example = new ShowTasksExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andAttribEqualTo(attrib);
        return this.mapper.selectOneByExample(example);
    }

    public ShowTasks findOneByReward(String reward) {
        ShowTasksExample example = new ShowTasksExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andRewardEqualTo(reward);
        return this.mapper.selectOneByExample(example);
    }

    public ShowTasks findOneByShowName(String showName) {
        ShowTasksExample example = new ShowTasksExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andShowNameEqualTo(showName);
        return this.mapper.selectOneByExample(example);
    }

    public ShowTasks findOneByTasktaskExtraPara(String tasktaskExtraPara) {
        ShowTasksExample example = new ShowTasksExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andTasktaskExtraParaEqualTo(tasktaskExtraPara);
        return this.mapper.selectOneByExample(example);
    }

    public ShowTasks findOneByTasktaskState(Integer tasktaskState) {
        ShowTasksExample example = new ShowTasksExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andTasktaskStateEqualTo(tasktaskState);
        return this.mapper.selectOneByExample(example);
    }

    public List<ShowTasks> findAll(int page, int size, String sort, String order) {
        ShowTasksExample example = new ShowTasksExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, size);
        return this.mapper.selectByExample(example);
    }

    public List<ShowTasks> findAll() {
        ShowTasksExample example = new ShowTasksExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        return this.mapper.selectByExample(example);
    }
}
