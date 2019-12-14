//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.service.base;

import com.github.pagehelper.PageHelper;
import java.time.LocalDateTime;
import java.util.List;
import org.linlinjava.litemall.db.dao.MapMapper;
import org.linlinjava.litemall.db.domain.Map;
import org.linlinjava.litemall.db.domain.example.MapExample;
import org.linlinjava.litemall.db.domain.example.MapExample.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class BaseMapService {
    @Autowired
    protected MapMapper mapper;

    public BaseMapService() {
    }

    @Cacheable(
            cacheNames = {"Map"},
            key = "#id"
    )
    public Map findById(int id) {
        return this.mapper.selectByPrimaryKeyWithLogicalDelete(id, false);
    }

    @Cacheable(
            cacheNames = {"Map"},
            key = "#id",
            condition = "#result.deleted == 0"
    )
    public Map findByIdContainsDelete(int id) {
        return this.mapper.selectByPrimaryKey(id);
    }

    public void add(Map map) {
        map.setAddTime(LocalDateTime.now());
        map.setUpdateTime(LocalDateTime.now());
        this.mapper.insertSelective(map);
    }

    @CachePut(
            cacheNames = {"Map"},
            key = "#map.id"
    )
    public int updateById(Map map) {
        map.setUpdateTime(LocalDateTime.now());
        return this.mapper.updateByPrimaryKeySelective(map);
    }

    @CacheEvict(
            cacheNames = {"Map"},
            key = "#id"
    )
    public void deleteById(int id) {
        this.mapper.logicalDeleteByPrimaryKey(id);
    }

    public List<Map> findByName(String name) {
        MapExample example = new MapExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andNameEqualTo(name);
        return this.mapper.selectByExample(example);
    }

    public List<Map> findByMapId(Integer mapId) {
        MapExample example = new MapExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andMapIdEqualTo(mapId);
        return this.mapper.selectByExample(example);
    }

    public List<Map> findByX(Integer x) {
        MapExample example = new MapExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andXEqualTo(x);
        return this.mapper.selectByExample(example);
    }

    public List<Map> findByY(Integer y) {
        MapExample example = new MapExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andYEqualTo(y);
        return this.mapper.selectByExample(example);
    }

    public List<Map> findByIcon(String icon) {
        MapExample example = new MapExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andIconEqualTo(icon);
        return this.mapper.selectByExample(example);
    }

    public List<Map> findByMonsterLevel(Integer monsterLevel) {
        MapExample example = new MapExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andMonsterLevelEqualTo(monsterLevel);
        return this.mapper.selectByExample(example);
    }

    public Map findOneByName(String name) {
        MapExample example = new MapExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andNameEqualTo(name);
        return this.mapper.selectOneByExample(example);
    }

    public Map findOneByMapId(Integer mapId) {
        MapExample example = new MapExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andMapIdEqualTo(mapId);
        return this.mapper.selectOneByExample(example);
    }

    public Map findOneByX(Integer x) {
        MapExample example = new MapExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andXEqualTo(x);
        return this.mapper.selectOneByExample(example);
    }

    public Map findOneByY(Integer y) {
        MapExample example = new MapExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andYEqualTo(y);
        return this.mapper.selectOneByExample(example);
    }

    public Map findOneByIcon(String icon) {
        MapExample example = new MapExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andIconEqualTo(icon);
        return this.mapper.selectOneByExample(example);
    }

    public Map findOneByMonsterLevel(Integer monsterLevel) {
        MapExample example = new MapExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andMonsterLevelEqualTo(monsterLevel);
        return this.mapper.selectOneByExample(example);
    }

    public List<Map> findAll(int page, int size, String sort, String order) {
        MapExample example = new MapExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, size);
        return this.mapper.selectByExample(example);
    }

    public List<Map> findAll() {
        MapExample example = new MapExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        return this.mapper.selectByExample(example);
    }
}
