//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.service.base;

import com.github.pagehelper.PageHelper;
import java.time.LocalDateTime;
import java.util.List;
import org.linlinjava.litemall.db.dao.ExperienceMapper;
import org.linlinjava.litemall.db.domain.Experience;
import org.linlinjava.litemall.db.domain.example.ExperienceExample;
import org.linlinjava.litemall.db.domain.example.ExperienceExample.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class BaseExperienceService {
    @Autowired
    protected ExperienceMapper mapper;

    public BaseExperienceService() {
    }

    @Cacheable(
            cacheNames = {"Experience"},
            key = "#id"
    )
    public Experience findById(int id) {
        return this.mapper.selectByPrimaryKeyWithLogicalDelete(id, false);
    }

    @Cacheable(
            cacheNames = {"Experience"},
            key = "#id",
            condition = "#result.deleted == 0"
    )
    public Experience findByIdContainsDelete(int id) {
        return this.mapper.selectByPrimaryKey(id);
    }

    public void add(Experience experience) {
        experience.setAddTime(LocalDateTime.now());
        experience.setUpdateTime(LocalDateTime.now());
        this.mapper.insertSelective(experience);
    }

    @CachePut(
            cacheNames = {"Experience"},
            key = "#experience.id"
    )
    public int updateById(Experience experience) {
        experience.setUpdateTime(LocalDateTime.now());
        return this.mapper.updateByPrimaryKeySelective(experience);
    }

    @CacheEvict(
            cacheNames = {"Experience"},
            key = "#id"
    )
    public void deleteById(int id) {
        this.mapper.logicalDeleteByPrimaryKey(id);
    }

    public List<Experience> findByAttrib(Integer attrib) {
        ExperienceExample example = new ExperienceExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andAttribEqualTo(attrib);
        return this.mapper.selectByExample(example);
    }

    public List<Experience> findByMaxLevel(Integer maxLevel) {
        ExperienceExample example = new ExperienceExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andMaxLevelEqualTo(maxLevel);
        return this.mapper.selectByExample(example);
    }

    public Experience findOneByAttrib(Integer attrib) {
        ExperienceExample example = new ExperienceExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andAttribEqualTo(attrib);
        return this.mapper.selectOneByExample(example);
    }

    public Experience findOneByMaxLevel(Integer maxLevel) {
        ExperienceExample example = new ExperienceExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andMaxLevelEqualTo(maxLevel);
        return this.mapper.selectOneByExample(example);
    }

    public List<Experience> findAll(int page, int size, String sort, String order) {
        ExperienceExample example = new ExperienceExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, size);
        return this.mapper.selectByExample(example);
    }

    public List<Experience> findAll() {
        ExperienceExample example = new ExperienceExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        return this.mapper.selectByExample(example);
    }
}
