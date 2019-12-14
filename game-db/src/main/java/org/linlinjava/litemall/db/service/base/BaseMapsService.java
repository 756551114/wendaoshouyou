//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.service.base;

import com.github.pagehelper.PageHelper;
import java.time.LocalDateTime;
import java.util.List;
import org.linlinjava.litemall.db.dao.MapsMapper;
import org.linlinjava.litemall.db.domain.Maps;
import org.linlinjava.litemall.db.domain.example.MapsExample;
import org.linlinjava.litemall.db.domain.example.MapsExample.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class BaseMapsService {
    @Autowired
    protected MapsMapper mapper;

    public BaseMapsService() {
    }

    @Cacheable(
            cacheNames = {"Maps"},
            key = "#id"
    )
    public Maps findById(int id) {
        return this.mapper.selectByPrimaryKeyWithLogicalDelete(id, false);
    }

    @Cacheable(
            cacheNames = {"Maps"},
            key = "#id",
            condition = "#result.deleted == 0"
    )
    public Maps findByIdContainsDelete(int id) {
        return this.mapper.selectByPrimaryKey(id);
    }

    public void add(Maps maps) {
        maps.setAddTime(LocalDateTime.now());
        maps.setUpdateTime(LocalDateTime.now());
        this.mapper.insertSelective(maps);
    }

    @CachePut(
            cacheNames = {"Maps"},
            key = "#maps.id"
    )
    public int updateById(Maps maps) {
        maps.setUpdateTime(LocalDateTime.now());
        return this.mapper.updateByPrimaryKeySelective(maps);
    }

    @CacheEvict(
            cacheNames = {"Maps"},
            key = "#id"
    )
    public void deleteById(int id) {
        this.mapper.logicalDeleteByPrimaryKey(id);
    }

    public List<Maps> findByName(String name) {
        MapsExample example = new MapsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andNameEqualTo(name);
        return this.mapper.selectByExample(example);
    }

    public List<Maps> findByType(Integer type) {
        MapsExample example = new MapsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andTypeEqualTo(type);
        return this.mapper.selectByExample(example);
    }

    public List<Maps> findByMap(Integer map) {
        MapsExample example = new MapsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andMapEqualTo(map);
        return this.mapper.selectByExample(example);
    }

    public List<Maps> findByDir(Float dir) {
        MapsExample example = new MapsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andDirEqualTo(dir);
        return this.mapper.selectByExample(example);
    }

    public List<Maps> findByX(Float x) {
        MapsExample example = new MapsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andXEqualTo(x);
        return this.mapper.selectByExample(example);
    }

    public List<Maps> findByY(Float y) {
        MapsExample example = new MapsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andYEqualTo(y);
        return this.mapper.selectByExample(example);
    }

    public Maps findOneByName(String name) {
        MapsExample example = new MapsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andNameEqualTo(name);
        return this.mapper.selectOneByExample(example);
    }

    public Maps findOneByType(Integer type) {
        MapsExample example = new MapsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andTypeEqualTo(type);
        return this.mapper.selectOneByExample(example);
    }

    public Maps findOneByMap(Integer map) {
        MapsExample example = new MapsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andMapEqualTo(map);
        return this.mapper.selectOneByExample(example);
    }

    public Maps findOneByDir(Float dir) {
        MapsExample example = new MapsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andDirEqualTo(dir);
        return this.mapper.selectOneByExample(example);
    }

    public Maps findOneByX(Float x) {
        MapsExample example = new MapsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andXEqualTo(x);
        return this.mapper.selectOneByExample(example);
    }

    public Maps findOneByY(Float y) {
        MapsExample example = new MapsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andYEqualTo(y);
        return this.mapper.selectOneByExample(example);
    }

    public List<Maps> findAll(int page, int size, String sort, String order) {
        MapsExample example = new MapsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, size);
        return this.mapper.selectByExample(example);
    }

    public List<Maps> findAll() {
        MapsExample example = new MapsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        return this.mapper.selectByExample(example);
    }
}
