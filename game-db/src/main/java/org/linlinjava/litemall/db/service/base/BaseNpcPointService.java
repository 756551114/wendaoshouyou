//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.service.base;

import com.github.pagehelper.PageHelper;
import java.time.LocalDateTime;
import java.util.List;
import org.linlinjava.litemall.db.dao.NpcPointMapper;
import org.linlinjava.litemall.db.domain.NpcPoint;
import org.linlinjava.litemall.db.domain.example.NpcPointExample;
import org.linlinjava.litemall.db.domain.example.NpcPointExample.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class BaseNpcPointService {
    @Autowired
    protected NpcPointMapper mapper;

    public BaseNpcPointService() {
    }

    @Cacheable(
            cacheNames = {"NpcPoint"},
            key = "#id"
    )
    public NpcPoint findById(int id) {
        return this.mapper.selectByPrimaryKeyWithLogicalDelete(id, false);
    }

    @Cacheable(
            cacheNames = {"NpcPoint"},
            key = "#id",
            condition = "#result.deleted == 0"
    )
    public NpcPoint findByIdContainsDelete(int id) {
        return this.mapper.selectByPrimaryKey(id);
    }

    public void add(NpcPoint npcPoint) {
        npcPoint.setAddTime(LocalDateTime.now());
        npcPoint.setUpdateTime(LocalDateTime.now());
        this.mapper.insertSelective(npcPoint);
    }

    @CachePut(
            cacheNames = {"NpcPoint"},
            key = "#npcPoint.id"
    )
    public int updateById(NpcPoint npcPoint) {
        npcPoint.setUpdateTime(LocalDateTime.now());
        return this.mapper.updateByPrimaryKeySelective(npcPoint);
    }

    @CacheEvict(
            cacheNames = {"NpcPoint"},
            key = "#id"
    )
    public void deleteById(int id) {
        this.mapper.logicalDeleteByPrimaryKey(id);
    }

    public List<NpcPoint> findByMapname(String mapname) {
        NpcPointExample example = new NpcPointExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andMapnameEqualTo(mapname);
        return this.mapper.selectByExample(example);
    }

    public List<NpcPoint> findByDoorname(String doorname) {
        NpcPointExample example = new NpcPointExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andDoornameEqualTo(doorname);
        return this.mapper.selectByExample(example);
    }

    public List<NpcPoint> findByX(Integer x) {
        NpcPointExample example = new NpcPointExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andXEqualTo(x);
        return this.mapper.selectByExample(example);
    }

    public List<NpcPoint> findByY(Integer y) {
        NpcPointExample example = new NpcPointExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andYEqualTo(y);
        return this.mapper.selectByExample(example);
    }

    public List<NpcPoint> findByZ(Integer z) {
        NpcPointExample example = new NpcPointExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andZEqualTo(z);
        return this.mapper.selectByExample(example);
    }

    public List<NpcPoint> findByInx(Integer inx) {
        NpcPointExample example = new NpcPointExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andInxEqualTo(inx);
        return this.mapper.selectByExample(example);
    }

    public List<NpcPoint> findByIny(Integer iny) {
        NpcPointExample example = new NpcPointExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andInyEqualTo(iny);
        return this.mapper.selectByExample(example);
    }

    public NpcPoint findOneByMapname(String mapname) {
        NpcPointExample example = new NpcPointExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andMapnameEqualTo(mapname);
        return this.mapper.selectOneByExample(example);
    }

    public NpcPoint findOneByDoorname(String doorname) {
        NpcPointExample example = new NpcPointExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andDoornameEqualTo(doorname);
        return this.mapper.selectOneByExample(example);
    }

    public NpcPoint findOneByX(Integer x) {
        NpcPointExample example = new NpcPointExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andXEqualTo(x);
        return this.mapper.selectOneByExample(example);
    }

    public NpcPoint findOneByY(Integer y) {
        NpcPointExample example = new NpcPointExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andYEqualTo(y);
        return this.mapper.selectOneByExample(example);
    }

    public NpcPoint findOneByZ(Integer z) {
        NpcPointExample example = new NpcPointExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andZEqualTo(z);
        return this.mapper.selectOneByExample(example);
    }

    public NpcPoint findOneByInx(Integer inx) {
        NpcPointExample example = new NpcPointExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andInxEqualTo(inx);
        return this.mapper.selectOneByExample(example);
    }

    public NpcPoint findOneByIny(Integer iny) {
        NpcPointExample example = new NpcPointExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andInyEqualTo(iny);
        return this.mapper.selectOneByExample(example);
    }

    public List<NpcPoint> findAll(int page, int size, String sort, String order) {
        NpcPointExample example = new NpcPointExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, size);
        return this.mapper.selectByExample(example);
    }

    public List<NpcPoint> findAll() {
        NpcPointExample example = new NpcPointExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        return this.mapper.selectByExample(example);
    }
}
