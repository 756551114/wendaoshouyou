//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.service.base;

import com.github.pagehelper.PageHelper;
import java.time.LocalDateTime;
import java.util.List;
import org.linlinjava.litemall.db.dao.SkilljinengMapper;
import org.linlinjava.litemall.db.domain.Skilljineng;
import org.linlinjava.litemall.db.domain.example.SkilljinengExample;
import org.linlinjava.litemall.db.domain.example.SkilljinengExample.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class BaseSkilljinengService {
    @Autowired
    protected SkilljinengMapper mapper;

    public BaseSkilljinengService() {
    }

    @Cacheable(
            cacheNames = {"Skilljineng"},
            key = "#id"
    )
    public Skilljineng findById(int id) {
        return this.mapper.selectByPrimaryKeyWithLogicalDelete(id, false);
    }

    @Cacheable(
            cacheNames = {"Skilljineng"},
            key = "#id",
            condition = "#result.deleted == 0"
    )
    public Skilljineng findByIdContainsDelete(int id) {
        return this.mapper.selectByPrimaryKey(id);
    }

    public void add(Skilljineng skilljineng) {
        skilljineng.setAddTime(LocalDateTime.now());
        skilljineng.setUpdateTime(LocalDateTime.now());
        this.mapper.insertSelective(skilljineng);
    }

    @CachePut(
            cacheNames = {"Skilljineng"},
            key = "#skilljineng.id"
    )
    public int updateById(Skilljineng skilljineng) {
        skilljineng.setUpdateTime(LocalDateTime.now());
        return this.mapper.updateByPrimaryKeySelective(skilljineng);
    }

    @CacheEvict(
            cacheNames = {"Skilljineng"},
            key = "#id"
    )
    public void deleteById(int id) {
        this.mapper.logicalDeleteByPrimaryKey(id);
    }

    public List<Skilljineng> findByRid(Integer rid) {
        SkilljinengExample example = new SkilljinengExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andRidEqualTo(rid);
        return this.mapper.selectByExample(example);
    }

    public List<Skilljineng> findByPid(String pid) {
        SkilljinengExample example = new SkilljinengExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andPidEqualTo(pid);
        return this.mapper.selectByExample(example);
    }

    public List<Skilljineng> findBySkillName(String skillName) {
        SkilljinengExample example = new SkilljinengExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andSkillNameEqualTo(skillName);
        return this.mapper.selectByExample(example);
    }

    public List<Skilljineng> findBySkillLevel(Integer skillLevel) {
        SkilljinengExample example = new SkilljinengExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andSkillLevelEqualTo(skillLevel);
        return this.mapper.selectByExample(example);
    }

    public List<Skilljineng> findBySkillMubiao(Integer skillMubiao) {
        SkilljinengExample example = new SkilljinengExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andSkillMubiaoEqualTo(skillMubiao);
        return this.mapper.selectByExample(example);
    }

    public List<Skilljineng> findBySkillMp(Integer skillMp) {
        SkilljinengExample example = new SkilljinengExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andSkillMpEqualTo(skillMp);
        return this.mapper.selectByExample(example);
    }

    public Skilljineng findOneByRid(Integer rid) {
        SkilljinengExample example = new SkilljinengExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andRidEqualTo(rid);
        return this.mapper.selectOneByExample(example);
    }

    public Skilljineng findOneByPid(String pid) {
        SkilljinengExample example = new SkilljinengExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andPidEqualTo(pid);
        return this.mapper.selectOneByExample(example);
    }

    public Skilljineng findOneBySkillName(String skillName) {
        SkilljinengExample example = new SkilljinengExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andSkillNameEqualTo(skillName);
        return this.mapper.selectOneByExample(example);
    }

    public Skilljineng findOneBySkillLevel(Integer skillLevel) {
        SkilljinengExample example = new SkilljinengExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andSkillLevelEqualTo(skillLevel);
        return this.mapper.selectOneByExample(example);
    }

    public Skilljineng findOneBySkillMubiao(Integer skillMubiao) {
        SkilljinengExample example = new SkilljinengExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andSkillMubiaoEqualTo(skillMubiao);
        return this.mapper.selectOneByExample(example);
    }

    public Skilljineng findOneBySkillMp(Integer skillMp) {
        SkilljinengExample example = new SkilljinengExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andSkillMpEqualTo(skillMp);
        return this.mapper.selectOneByExample(example);
    }

    public List<Skilljineng> findAll(int page, int size, String sort, String order) {
        SkilljinengExample example = new SkilljinengExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, size);
        return this.mapper.selectByExample(example);
    }

    public List<Skilljineng> findAll() {
        SkilljinengExample example = new SkilljinengExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        return this.mapper.selectByExample(example);
    }
}
