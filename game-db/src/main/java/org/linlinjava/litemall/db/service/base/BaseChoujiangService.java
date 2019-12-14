//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.service.base;

import com.github.pagehelper.PageHelper;
import java.time.LocalDateTime;
import java.util.List;
import org.linlinjava.litemall.db.dao.ChoujiangMapper;
import org.linlinjava.litemall.db.domain.Choujiang;
import org.linlinjava.litemall.db.domain.example.ChoujiangExample;
import org.linlinjava.litemall.db.domain.example.ChoujiangExample.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class BaseChoujiangService {
    @Autowired
    protected ChoujiangMapper mapper;

    public BaseChoujiangService() {
    }

    @Cacheable(
            cacheNames = {"Choujiang"},
            key = "#id"
    )
    public Choujiang findById(int id) {
        return this.mapper.selectByPrimaryKeyWithLogicalDelete(id, false);
    }

    @Cacheable(
            cacheNames = {"Choujiang"},
            key = "#id",
            condition = "#result.deleted == 0"
    )
    public Choujiang findByIdContainsDelete(int id) {
        return this.mapper.selectByPrimaryKey(id);
    }

    public void add(Choujiang choujiang) {
        choujiang.setAddTime(LocalDateTime.now());
        choujiang.setUpdateTime(LocalDateTime.now());
        this.mapper.insertSelective(choujiang);
    }

    @CachePut(
            cacheNames = {"Choujiang"},
            key = "#choujiang.id"
    )
    public int updateById(Choujiang choujiang) {
        choujiang.setUpdateTime(LocalDateTime.now());
        return this.mapper.updateByPrimaryKeySelective(choujiang);
    }

    @CacheEvict(
            cacheNames = {"Choujiang"},
            key = "#id"
    )
    public void deleteById(int id) {
        this.mapper.logicalDeleteByPrimaryKey(id);
    }

    public List<Choujiang> findByNo(Integer no) {
        ChoujiangExample example = new ChoujiangExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andNoEqualTo(no);
        return this.mapper.selectByExample(example);
    }

    public List<Choujiang> findByName(String name) {
        ChoujiangExample example = new ChoujiangExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andNameEqualTo(name);
        return this.mapper.selectByExample(example);
    }

    public List<Choujiang> findByDesc(String desc) {
        ChoujiangExample example = new ChoujiangExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andDescEqualTo(desc);
        return this.mapper.selectByExample(example);
    }

    public List<Choujiang> findByLevel(Integer level) {
        ChoujiangExample example = new ChoujiangExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andLevelEqualTo(level);
        return this.mapper.selectByExample(example);
    }

    public Choujiang findOneByNo(Integer no) {
        ChoujiangExample example = new ChoujiangExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andNoEqualTo(no);
        return this.mapper.selectOneByExample(example);
    }

    public Choujiang findOneByName(String name) {
        ChoujiangExample example = new ChoujiangExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andNameEqualTo(name);
        return this.mapper.selectOneByExample(example);
    }

    public Choujiang findOneByDesc(String desc) {
        ChoujiangExample example = new ChoujiangExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andDescEqualTo(desc);
        return this.mapper.selectOneByExample(example);
    }

    public Choujiang findOneByLevel(Integer level) {
        ChoujiangExample example = new ChoujiangExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andLevelEqualTo(level);
        return this.mapper.selectOneByExample(example);
    }

    public List<Choujiang> findAll(int page, int size, String sort, String order) {
        ChoujiangExample example = new ChoujiangExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, size);
        return this.mapper.selectByExample(example);
    }

    public List<Choujiang> findAll() {
        ChoujiangExample example = new ChoujiangExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        return this.mapper.selectByExample(example);
    }
}
