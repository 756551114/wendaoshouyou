//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.service.base;

import com.github.pagehelper.PageHelper;
import java.time.LocalDateTime;
import java.util.List;
import org.linlinjava.litemall.db.dao.CreepsStoreMapper;
import org.linlinjava.litemall.db.domain.CreepsStore;
import org.linlinjava.litemall.db.domain.example.CreepsStoreExample;
import org.linlinjava.litemall.db.domain.example.CreepsStoreExample.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class BaseCreepsStoreService {
    @Autowired
    protected CreepsStoreMapper mapper;

    public BaseCreepsStoreService() {
    }

    @Cacheable(
            cacheNames = {"CreepsStore"},
            key = "#id"
    )
    public CreepsStore findById(int id) {
        return this.mapper.selectByPrimaryKeyWithLogicalDelete(id, false);
    }

    @Cacheable(
            cacheNames = {"CreepsStore"},
            key = "#id",
            condition = "#result.deleted == 0"
    )
    public CreepsStore findByIdContainsDelete(int id) {
        return this.mapper.selectByPrimaryKey(id);
    }

    public void add(CreepsStore creepsStore) {
        creepsStore.setAddTime(LocalDateTime.now());
        creepsStore.setUpdateTime(LocalDateTime.now());
        this.mapper.insertSelective(creepsStore);
    }

    @CachePut(
            cacheNames = {"CreepsStore"},
            key = "#creepsStore.id"
    )
    public int updateById(CreepsStore creepsStore) {
        creepsStore.setUpdateTime(LocalDateTime.now());
        return this.mapper.updateByPrimaryKeySelective(creepsStore);
    }

    @CacheEvict(
            cacheNames = {"CreepsStore"},
            key = "#id"
    )
    public void deleteById(int id) {
        this.mapper.logicalDeleteByPrimaryKey(id);
    }

    public List<CreepsStore> findByName(String name) {
        CreepsStoreExample example = new CreepsStoreExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andNameEqualTo(name);
        return this.mapper.selectByExample(example);
    }

    public List<CreepsStore> findByPrice(Integer price) {
        CreepsStoreExample example = new CreepsStoreExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andPriceEqualTo(price);
        return this.mapper.selectByExample(example);
    }

    public CreepsStore findOneByName(String name) {
        CreepsStoreExample example = new CreepsStoreExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andNameEqualTo(name);
        return this.mapper.selectOneByExample(example);
    }

    public CreepsStore findOneByPrice(Integer price) {
        CreepsStoreExample example = new CreepsStoreExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andPriceEqualTo(price);
        return this.mapper.selectOneByExample(example);
    }

    public List<CreepsStore> findAll(int page, int size, String sort, String order) {
        CreepsStoreExample example = new CreepsStoreExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, size);
        return this.mapper.selectByExample(example);
    }

    public List<CreepsStore> findAll() {
        CreepsStoreExample example = new CreepsStoreExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        return this.mapper.selectByExample(example);
    }
}
