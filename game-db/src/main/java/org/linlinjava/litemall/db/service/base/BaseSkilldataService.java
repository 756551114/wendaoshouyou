//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.service.base;

import com.github.pagehelper.PageHelper;
import java.time.LocalDateTime;
import java.util.List;
import org.linlinjava.litemall.db.dao.SkilldataMapper;
import org.linlinjava.litemall.db.domain.Skilldata;
import org.linlinjava.litemall.db.domain.example.SkilldataExample;
import org.linlinjava.litemall.db.domain.example.SkilldataExample.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class BaseSkilldataService {
    @Autowired
    protected SkilldataMapper mapper;

    public BaseSkilldataService() {
    }

    @Cacheable(
            cacheNames = {"Skilldata"},
            key = "#id"
    )
    public Skilldata findById(int id) {
        return this.mapper.selectByPrimaryKeyWithLogicalDelete(id, false);
    }

    @Cacheable(
            cacheNames = {"Skilldata"},
            key = "#id",
            condition = "#result.deleted == 0"
    )
    public Skilldata findByIdContainsDelete(int id) {
        return this.mapper.selectByPrimaryKey(id);
    }

    public void add(Skilldata skilldata) {
        skilldata.setAddTime(LocalDateTime.now());
        skilldata.setUpdateTime(LocalDateTime.now());
        this.mapper.insertSelective(skilldata);
    }

    @CachePut(
            cacheNames = {"Skilldata"},
            key = "#skilldata.id"
    )
    public int updateById(Skilldata skilldata) {
        skilldata.setUpdateTime(LocalDateTime.now());
        return this.mapper.updateByPrimaryKeySelective(skilldata);
    }

    @CacheEvict(
            cacheNames = {"Skilldata"},
            key = "#id"
    )
    public void deleteById(int id) {
        this.mapper.logicalDeleteByPrimaryKey(id);
    }

    public List<Skilldata> findByPid(String pid) {
        SkilldataExample example = new SkilldataExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andPidEqualTo(pid);
        return this.mapper.selectByExample(example);
    }

    public List<Skilldata> findBySkillName(String skillName) {
        SkilldataExample example = new SkilldataExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andSkillNameEqualTo(skillName);
        return this.mapper.selectByExample(example);
    }

    public List<Skilldata> findBySkillLevel(Integer skillLevel) {
        SkilldataExample example = new SkilldataExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andSkillLevelEqualTo(skillLevel);
        return this.mapper.selectByExample(example);
    }

    public List<Skilldata> findBySkillMubiao(Integer skillMubiao) {
        SkilldataExample example = new SkilldataExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andSkillMubiaoEqualTo(skillMubiao);
        return this.mapper.selectByExample(example);
    }

    public Skilldata findOneByPid(String pid) {
        SkilldataExample example = new SkilldataExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andPidEqualTo(pid);
        return this.mapper.selectOneByExample(example);
    }

    public Skilldata findOneBySkillName(String skillName) {
        SkilldataExample example = new SkilldataExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andSkillNameEqualTo(skillName);
        return this.mapper.selectOneByExample(example);
    }

    public Skilldata findOneBySkillLevel(Integer skillLevel) {
        SkilldataExample example = new SkilldataExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andSkillLevelEqualTo(skillLevel);
        return this.mapper.selectOneByExample(example);
    }

    public Skilldata findOneBySkillMubiao(Integer skillMubiao) {
        SkilldataExample example = new SkilldataExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andSkillMubiaoEqualTo(skillMubiao);
        return this.mapper.selectOneByExample(example);
    }

    public List<Skilldata> findAll(int page, int size, String sort, String order) {
        SkilldataExample example = new SkilldataExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, size);
        return this.mapper.selectByExample(example);
    }

    public List<Skilldata> findAll() {
        SkilldataExample example = new SkilldataExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        return this.mapper.selectByExample(example);
    }
}
