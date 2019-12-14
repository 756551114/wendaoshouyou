//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.service.base;

import com.github.pagehelper.PageHelper;
import java.time.LocalDateTime;
import java.util.List;
import org.linlinjava.litemall.db.dao.DaySignPrizeMapper;
import org.linlinjava.litemall.db.domain.DaySignPrize;
import org.linlinjava.litemall.db.domain.example.DaySignPrizeExample;
import org.linlinjava.litemall.db.domain.example.DaySignPrizeExample.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class BaseDaySignPrizeService {
    @Autowired
    protected DaySignPrizeMapper mapper;

    public BaseDaySignPrizeService() {
    }

    @Cacheable(
            cacheNames = {"DaySignPrize"},
            key = "#id"
    )
    public DaySignPrize findById(int id) {
        return this.mapper.selectByPrimaryKeyWithLogicalDelete(id, false);
    }

    @Cacheable(
            cacheNames = {"DaySignPrize"},
            key = "#id",
            condition = "#result.deleted == 0"
    )
    public DaySignPrize findByIdContainsDelete(int id) {
        return this.mapper.selectByPrimaryKey(id);
    }

    public void add(DaySignPrize daySignPrize) {
        daySignPrize.setAddTime(LocalDateTime.now());
        daySignPrize.setUpdateTime(LocalDateTime.now());
        this.mapper.insertSelective(daySignPrize);
    }

    @CachePut(
            cacheNames = {"DaySignPrize"},
            key = "#daySignPrize.id"
    )
    public int updateById(DaySignPrize daySignPrize) {
        daySignPrize.setUpdateTime(LocalDateTime.now());
        return this.mapper.updateByPrimaryKeySelective(daySignPrize);
    }

    @CacheEvict(
            cacheNames = {"DaySignPrize"},
            key = "#id"
    )
    public void deleteById(int id) {
        this.mapper.logicalDeleteByPrimaryKey(id);
    }

    public List<DaySignPrize> findByName(String name) {
        DaySignPrizeExample example = new DaySignPrizeExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andNameEqualTo(name);
        return this.mapper.selectByExample(example);
    }

    public List<DaySignPrize> findByIndex(Integer index) {
        DaySignPrizeExample example = new DaySignPrizeExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andIndexEqualTo(index);
        return this.mapper.selectByExample(example);
    }

    public DaySignPrize findOneByName(String name) {
        DaySignPrizeExample example = new DaySignPrizeExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andNameEqualTo(name);
        return this.mapper.selectOneByExample(example);
    }

    public DaySignPrize findOneByIndex(Integer index) {
        DaySignPrizeExample example = new DaySignPrizeExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andIndexEqualTo(index);
        return this.mapper.selectOneByExample(example);
    }

    public List<DaySignPrize> findAll(int page, int size, String sort, String order) {
        DaySignPrizeExample example = new DaySignPrizeExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, size);
        return this.mapper.selectByExample(example);
    }

    public List<DaySignPrize> findAll() {
        DaySignPrizeExample example = new DaySignPrizeExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        return this.mapper.selectByExample(example);
    }
}
