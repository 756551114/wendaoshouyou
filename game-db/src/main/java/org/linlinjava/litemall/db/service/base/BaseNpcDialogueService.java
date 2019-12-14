//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.service.base;

import com.github.pagehelper.PageHelper;
import java.time.LocalDateTime;
import java.util.List;
import org.linlinjava.litemall.db.dao.NpcDialogueMapper;
import org.linlinjava.litemall.db.domain.NpcDialogue;
import org.linlinjava.litemall.db.domain.example.NpcDialogueExample;
import org.linlinjava.litemall.db.domain.example.NpcDialogueExample.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class BaseNpcDialogueService {
    @Autowired
    protected NpcDialogueMapper mapper;

    public BaseNpcDialogueService() {
    }

    @Cacheable(
            cacheNames = {"NpcDialogue"},
            key = "#id"
    )
    public NpcDialogue findById(int id) {
        return this.mapper.selectByPrimaryKeyWithLogicalDelete(id, false);
    }

    @Cacheable(
            cacheNames = {"NpcDialogue"},
            key = "#id",
            condition = "#result.deleted == 0"
    )
    public NpcDialogue findByIdContainsDelete(int id) {
        return this.mapper.selectByPrimaryKey(id);
    }

    public void add(NpcDialogue npcDialogue) {
        npcDialogue.setAddTime(LocalDateTime.now());
        npcDialogue.setUpdateTime(LocalDateTime.now());
        this.mapper.insertSelective(npcDialogue);
    }

    @CachePut(
            cacheNames = {"NpcDialogue"},
            key = "#npcDialogue.id"
    )
    public int updateById(NpcDialogue npcDialogue) {
        npcDialogue.setUpdateTime(LocalDateTime.now());
        return this.mapper.updateByPrimaryKeySelective(npcDialogue);
    }

    @CacheEvict(
            cacheNames = {"NpcDialogue"},
            key = "#id"
    )
    public void deleteById(int id) {
        this.mapper.logicalDeleteByPrimaryKey(id);
    }

    public List<NpcDialogue> findByName(String name) {
        NpcDialogueExample example = new NpcDialogueExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andNameEqualTo(name);
        return this.mapper.selectByExample(example);
    }

    public List<NpcDialogue> findByPortranit(Integer portranit) {
        NpcDialogueExample example = new NpcDialogueExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andPortranitEqualTo(portranit);
        return this.mapper.selectByExample(example);
    }

    public List<NpcDialogue> findByPicNo(Integer picNo) {
        NpcDialogueExample example = new NpcDialogueExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andPicNoEqualTo(picNo);
        return this.mapper.selectByExample(example);
    }

    public List<NpcDialogue> findByContent(String content) {
        NpcDialogueExample example = new NpcDialogueExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andContentEqualTo(content);
        return this.mapper.selectByExample(example);
    }

    public List<NpcDialogue> findByIsconmlete(Integer isconmlete) {
        NpcDialogueExample example = new NpcDialogueExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andIsconmleteEqualTo(isconmlete);
        return this.mapper.selectByExample(example);
    }

    public List<NpcDialogue> findByIsincombat(Integer isincombat) {
        NpcDialogueExample example = new NpcDialogueExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andIsincombatEqualTo(isincombat);
        return this.mapper.selectByExample(example);
    }

    public List<NpcDialogue> findByPalytime(Integer palytime) {
        NpcDialogueExample example = new NpcDialogueExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andPalytimeEqualTo(palytime);
        return this.mapper.selectByExample(example);
    }

    public List<NpcDialogue> findByTaskType(String taskType) {
        NpcDialogueExample example = new NpcDialogueExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andTaskTypeEqualTo(taskType);
        return this.mapper.selectByExample(example);
    }

    public List<NpcDialogue> findByIdname(String idname) {
        NpcDialogueExample example = new NpcDialogueExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andIdnameEqualTo(idname);
        return this.mapper.selectByExample(example);
    }

    public NpcDialogue findOneByName(String name) {
        NpcDialogueExample example = new NpcDialogueExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andNameEqualTo(name);
        return this.mapper.selectOneByExample(example);
    }

    public NpcDialogue findOneByPortranit(Integer portranit) {
        NpcDialogueExample example = new NpcDialogueExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andPortranitEqualTo(portranit);
        return this.mapper.selectOneByExample(example);
    }

    public NpcDialogue findOneByPicNo(Integer picNo) {
        NpcDialogueExample example = new NpcDialogueExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andPicNoEqualTo(picNo);
        return this.mapper.selectOneByExample(example);
    }

    public NpcDialogue findOneByContent(String content) {
        NpcDialogueExample example = new NpcDialogueExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andContentEqualTo(content);
        return this.mapper.selectOneByExample(example);
    }

    public NpcDialogue findOneByIsconmlete(Integer isconmlete) {
        NpcDialogueExample example = new NpcDialogueExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andIsconmleteEqualTo(isconmlete);
        return this.mapper.selectOneByExample(example);
    }

    public NpcDialogue findOneByIsincombat(Integer isincombat) {
        NpcDialogueExample example = new NpcDialogueExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andIsincombatEqualTo(isincombat);
        return this.mapper.selectOneByExample(example);
    }

    public NpcDialogue findOneByPalytime(Integer palytime) {
        NpcDialogueExample example = new NpcDialogueExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andPalytimeEqualTo(palytime);
        return this.mapper.selectOneByExample(example);
    }

    public NpcDialogue findOneByTaskType(String taskType) {
        NpcDialogueExample example = new NpcDialogueExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andTaskTypeEqualTo(taskType);
        return this.mapper.selectOneByExample(example);
    }

    public NpcDialogue findOneByIdname(String idname) {
        NpcDialogueExample example = new NpcDialogueExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andIdnameEqualTo(idname);
        return this.mapper.selectOneByExample(example);
    }

    public List<NpcDialogue> findAll(int page, int size, String sort, String order) {
        NpcDialogueExample example = new NpcDialogueExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, size);
        return this.mapper.selectByExample(example);
    }

    public List<NpcDialogue> findAll() {
        NpcDialogueExample example = new NpcDialogueExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        return this.mapper.selectByExample(example);
    }
}
