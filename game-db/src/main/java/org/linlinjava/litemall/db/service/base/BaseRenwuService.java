//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.service.base;

import com.github.pagehelper.PageHelper;
import java.time.LocalDateTime;
import java.util.List;
import org.linlinjava.litemall.db.dao.RenwuMapper;
import org.linlinjava.litemall.db.domain.Renwu;
import org.linlinjava.litemall.db.domain.example.RenwuExample;
import org.linlinjava.litemall.db.domain.example.RenwuExample.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class BaseRenwuService {
    @Autowired
    protected RenwuMapper mapper;

    public BaseRenwuService() {
    }

    @Cacheable(
            cacheNames = {"Renwu"},
            key = "#id"
    )
    public Renwu findById(int id) {
        return this.mapper.selectByPrimaryKeyWithLogicalDelete(id, false);
    }

    @Cacheable(
            cacheNames = {"Renwu"},
            key = "#id",
            condition = "#result.deleted == 0"
    )
    public Renwu findByIdContainsDelete(int id) {
        return this.mapper.selectByPrimaryKey(id);
    }

    public void add(Renwu renwu) {
        renwu.setAddTime(LocalDateTime.now());
        renwu.setUpdateTime(LocalDateTime.now());
        this.mapper.insertSelective(renwu);
    }

    @CachePut(
            cacheNames = {"Renwu"},
            key = "#renwu.id"
    )
    public int updateById(Renwu renwu) {
        renwu.setUpdateTime(LocalDateTime.now());
        return this.mapper.updateByPrimaryKeySelective(renwu);
    }

    @CacheEvict(
            cacheNames = {"Renwu"},
            key = "#id"
    )
    public void deleteById(int id) {
        this.mapper.logicalDeleteByPrimaryKey(id);
    }

    public List<Renwu> findByUncontent(String uncontent) {
        RenwuExample example = new RenwuExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andUncontentEqualTo(uncontent);
        return this.mapper.selectByExample(example);
    }

    public List<Renwu> findByNpcName(String npcName) {
        RenwuExample example = new RenwuExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andNpcNameEqualTo(npcName);
        return this.mapper.selectByExample(example);
    }

    public List<Renwu> findByCurrentTask(String currentTask) {
        RenwuExample example = new RenwuExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andCurrentTaskEqualTo(currentTask);
        return this.mapper.selectByExample(example);
    }

    public List<Renwu> findByShowName(String showName) {
        RenwuExample example = new RenwuExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andShowNameEqualTo(showName);
        return this.mapper.selectByExample(example);
    }

    public List<Renwu> findByTaskPrompt(String taskPrompt) {
        RenwuExample example = new RenwuExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andTaskPromptEqualTo(taskPrompt);
        return this.mapper.selectByExample(example);
    }

    public List<Renwu> findByReward(String reward) {
        RenwuExample example = new RenwuExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andRewardEqualTo(reward);
        return this.mapper.selectByExample(example);
    }

    public Renwu findOneByUncontent(String uncontent) {
        RenwuExample example = new RenwuExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andUncontentEqualTo(uncontent);
        return this.mapper.selectOneByExample(example);
    }

    public Renwu findOneByNpcName(String npcName) {
        RenwuExample example = new RenwuExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andNpcNameEqualTo(npcName);
        return this.mapper.selectOneByExample(example);
    }

    public Renwu findOneByCurrentTask(String currentTask) {
        RenwuExample example = new RenwuExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andCurrentTaskEqualTo(currentTask);
        return this.mapper.selectOneByExample(example);
    }

    public Renwu findOneByShowName(String showName) {
        RenwuExample example = new RenwuExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andShowNameEqualTo(showName);
        return this.mapper.selectOneByExample(example);
    }

    public Renwu findOneByTaskPrompt(String taskPrompt) {
        RenwuExample example = new RenwuExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andTaskPromptEqualTo(taskPrompt);
        return this.mapper.selectOneByExample(example);
    }

    public Renwu findOneByReward(String reward) {
        RenwuExample example = new RenwuExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andRewardEqualTo(reward);
        return this.mapper.selectOneByExample(example);
    }

    public List<Renwu> findAll(int page, int size, String sort, String order) {
        RenwuExample example = new RenwuExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, size);
        return this.mapper.selectByExample(example);
    }

    public List<Renwu> findAll() {
        RenwuExample example = new RenwuExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        return this.mapper.selectByExample(example);
    }
}
