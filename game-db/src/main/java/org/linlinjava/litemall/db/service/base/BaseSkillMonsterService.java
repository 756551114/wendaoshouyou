//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.service.base;

import com.github.pagehelper.PageHelper;
import java.time.LocalDateTime;
import java.util.List;
import org.linlinjava.litemall.db.dao.SkillMonsterMapper;
import org.linlinjava.litemall.db.domain.SkillMonster;
import org.linlinjava.litemall.db.domain.example.SkillMonsterExample;
import org.linlinjava.litemall.db.domain.example.SkillMonsterExample.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class BaseSkillMonsterService {
    @Autowired
    protected SkillMonsterMapper mapper;

    public BaseSkillMonsterService() {
    }

    @Cacheable(
            cacheNames = {"SkillMonster"},
            key = "#id"
    )
    public SkillMonster findById(int id) {
        return this.mapper.selectByPrimaryKeyWithLogicalDelete(id, false);
    }

    @Cacheable(
            cacheNames = {"SkillMonster"},
            key = "#id",
            condition = "#result.deleted == 0"
    )
    public SkillMonster findByIdContainsDelete(int id) {
        return this.mapper.selectByPrimaryKey(id);
    }

    public void add(SkillMonster skillMonster) {
        skillMonster.setAddTime(LocalDateTime.now());
        skillMonster.setUpdateTime(LocalDateTime.now());
        this.mapper.insertSelective(skillMonster);
    }

    @CachePut(
            cacheNames = {"SkillMonster"},
            key = "#skillMonster.id"
    )
    public int updateById(SkillMonster skillMonster) {
        skillMonster.setUpdateTime(LocalDateTime.now());
        return this.mapper.updateByPrimaryKeySelective(skillMonster);
    }

    @CacheEvict(
            cacheNames = {"SkillMonster"},
            key = "#id"
    )
    public void deleteById(int id) {
        this.mapper.logicalDeleteByPrimaryKey(id);
    }

    public List<SkillMonster> findByName(String name) {
        SkillMonsterExample example = new SkillMonsterExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andNameEqualTo(name);
        return this.mapper.selectByExample(example);
    }

    public List<SkillMonster> findBySkills(String skills) {
        SkillMonsterExample example = new SkillMonsterExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andSkillsEqualTo(skills);
        return this.mapper.selectByExample(example);
    }

    public List<SkillMonster> findByType(Integer type) {
        SkillMonsterExample example = new SkillMonsterExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andTypeEqualTo(type);
        return this.mapper.selectByExample(example);
    }

    public SkillMonster findOneByName(String name) {
        SkillMonsterExample example = new SkillMonsterExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andNameEqualTo(name);
        return this.mapper.selectOneByExample(example);
    }

    public SkillMonster findOneBySkills(String skills) {
        SkillMonsterExample example = new SkillMonsterExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andSkillsEqualTo(skills);
        return this.mapper.selectOneByExample(example);
    }

    public SkillMonster findOneByType(Integer type) {
        SkillMonsterExample example = new SkillMonsterExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andTypeEqualTo(type);
        return this.mapper.selectOneByExample(example);
    }

    public List<SkillMonster> findAll(int page, int size, String sort, String order) {
        SkillMonsterExample example = new SkillMonsterExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, size);
        return this.mapper.selectByExample(example);
    }

    public List<SkillMonster> findAll() {
        SkillMonsterExample example = new SkillMonsterExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        return this.mapper.selectByExample(example);
    }
}
