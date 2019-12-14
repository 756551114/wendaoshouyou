//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.service.base;

import com.github.pagehelper.PageHelper;
import java.time.LocalDateTime;
import java.util.List;
import org.linlinjava.litemall.db.dao.ExperienceTreasureMapper;
import org.linlinjava.litemall.db.domain.ExperienceTreasure;
import org.linlinjava.litemall.db.domain.example.ExperienceTreasureExample;
import org.linlinjava.litemall.db.domain.example.ExperienceTreasureExample.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class BaseExperienceTreasureService {
    @Autowired
    protected ExperienceTreasureMapper mapper;

    public BaseExperienceTreasureService() {
    }

    @Cacheable(
            cacheNames = {"ExperienceTreasure"},
            key = "#id"
    )
    public ExperienceTreasure findById(int id) {
        return this.mapper.selectByPrimaryKeyWithLogicalDelete(id, false);
    }

    @Cacheable(
            cacheNames = {"ExperienceTreasure"},
            key = "#id",
            condition = "#result.deleted == 0"
    )
    public ExperienceTreasure findByIdContainsDelete(int id) {
        return this.mapper.selectByPrimaryKey(id);
    }

    public void add(ExperienceTreasure experienceTreasure) {
        experienceTreasure.setAddTime(LocalDateTime.now());
        experienceTreasure.setUpdateTime(LocalDateTime.now());
        this.mapper.insertSelective(experienceTreasure);
    }

    @CachePut(
            cacheNames = {"ExperienceTreasure"},
            key = "#experienceTreasure.id"
    )
    public int updateById(ExperienceTreasure experienceTreasure) {
        experienceTreasure.setUpdateTime(LocalDateTime.now());
        return this.mapper.updateByPrimaryKeySelective(experienceTreasure);
    }

    @CacheEvict(
            cacheNames = {"ExperienceTreasure"},
            key = "#id"
    )
    public void deleteById(int id) {
        this.mapper.logicalDeleteByPrimaryKey(id);
    }

    public List<ExperienceTreasure> findByAttrib(Integer attrib) {
        ExperienceTreasureExample example = new ExperienceTreasureExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andAttribEqualTo(attrib);
        return this.mapper.selectByExample(example);
    }

    public List<ExperienceTreasure> findByMaxLevel(Integer maxLevel) {
        ExperienceTreasureExample example = new ExperienceTreasureExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andMaxLevelEqualTo(maxLevel);
        return this.mapper.selectByExample(example);
    }

    public ExperienceTreasure findOneByAttrib(Integer attrib) {
        ExperienceTreasureExample example = new ExperienceTreasureExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andAttribEqualTo(attrib);
        return this.mapper.selectOneByExample(example);
    }

    public ExperienceTreasure findOneByMaxLevel(Integer maxLevel) {
        ExperienceTreasureExample example = new ExperienceTreasureExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andMaxLevelEqualTo(maxLevel);
        return this.mapper.selectOneByExample(example);
    }

    public List<ExperienceTreasure> findAll(int page, int size, String sort, String order) {
        ExperienceTreasureExample example = new ExperienceTreasureExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, size);
        return this.mapper.selectByExample(example);
    }

    public List<ExperienceTreasure> findAll() {
        ExperienceTreasureExample example = new ExperienceTreasureExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        return this.mapper.selectByExample(example);
    }
}
