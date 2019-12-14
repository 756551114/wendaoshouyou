//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.service.base;

import com.github.pagehelper.PageHelper;
import java.time.LocalDateTime;
import java.util.List;
import org.linlinjava.litemall.db.dao.ReportsMapper;
import org.linlinjava.litemall.db.domain.Reports;
import org.linlinjava.litemall.db.domain.example.ReportsExample;
import org.linlinjava.litemall.db.domain.example.ReportsExample.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class BaseReportsService {
    @Autowired
    protected ReportsMapper mapper;

    public BaseReportsService() {
    }

    @Cacheable(
            cacheNames = {"Reports"},
            key = "#id"
    )
    public Reports findById(int id) {
        return this.mapper.selectByPrimaryKeyWithLogicalDelete(id, false);
    }

    @Cacheable(
            cacheNames = {"Reports"},
            key = "#id",
            condition = "#result.deleted == 0"
    )
    public Reports findByIdContainsDelete(int id) {
        return this.mapper.selectByPrimaryKey(id);
    }

    public void add(Reports reports) {
        reports.setAddTime(LocalDateTime.now());
        reports.setUpdateTime(LocalDateTime.now());
        this.mapper.insertSelective(reports);
    }

    @CachePut(
            cacheNames = {"Reports"},
            key = "#reports.id"
    )
    public int updateById(Reports reports) {
        reports.setUpdateTime(LocalDateTime.now());
        return this.mapper.updateByPrimaryKeySelective(reports);
    }

    @CacheEvict(
            cacheNames = {"Reports"},
            key = "#id"
    )
    public void deleteById(int id) {
        this.mapper.logicalDeleteByPrimaryKey(id);
    }

    public List<Reports> findByZhanghao(String zhanghao) {
        ReportsExample example = new ReportsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andZhanghaoEqualTo(zhanghao);
        return this.mapper.selectByExample(example);
    }

    public List<Reports> findByYuanbaoshu(Integer yuanbaoshu) {
        ReportsExample example = new ReportsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andYuanbaoshuEqualTo(yuanbaoshu);
        return this.mapper.selectByExample(example);
    }

    public List<Reports> findByShifouchongzhi(String shifouchongzhi) {
        ReportsExample example = new ReportsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andShifouchongzhiEqualTo(shifouchongzhi);
        return this.mapper.selectByExample(example);
    }

    public Reports findOneByZhanghao(String zhanghao) {
        ReportsExample example = new ReportsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andZhanghaoEqualTo(zhanghao);
        return this.mapper.selectOneByExample(example);
    }

    public Reports findOneByYuanbaoshu(Integer yuanbaoshu) {
        ReportsExample example = new ReportsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andYuanbaoshuEqualTo(yuanbaoshu);
        return this.mapper.selectOneByExample(example);
    }

    public Reports findOneByShifouchongzhi(String shifouchongzhi) {
        ReportsExample example = new ReportsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andShifouchongzhiEqualTo(shifouchongzhi);
        return this.mapper.selectOneByExample(example);
    }

    public List<Reports> findAll(int page, int size, String sort, String order) {
        ReportsExample example = new ReportsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, size);
        return this.mapper.selectByExample(example);
    }

    public List<Reports> findAll() {
        ReportsExample example = new ReportsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        return this.mapper.selectByExample(example);
    }
}
