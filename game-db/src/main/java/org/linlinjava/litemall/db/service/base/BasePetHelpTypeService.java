//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.service.base;

import com.github.pagehelper.PageHelper;
import java.time.LocalDateTime;
import java.util.List;
import org.linlinjava.litemall.db.dao.PetHelpTypeMapper;
import org.linlinjava.litemall.db.domain.PetHelpType;
import org.linlinjava.litemall.db.domain.example.PetHelpTypeExample;
import org.linlinjava.litemall.db.domain.example.PetHelpTypeExample.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class BasePetHelpTypeService {
    @Autowired
    protected PetHelpTypeMapper mapper;

    public BasePetHelpTypeService() {
    }

    @Cacheable(
            cacheNames = {"PetHelpType"},
            key = "#id"
    )
    public PetHelpType findById(int id) {
        return this.mapper.selectByPrimaryKeyWithLogicalDelete(id, false);
    }

    @Cacheable(
            cacheNames = {"PetHelpType"},
            key = "#id",
            condition = "#result.deleted == 0"
    )
    public PetHelpType findByIdContainsDelete(int id) {
        return this.mapper.selectByPrimaryKey(id);
    }

    public void add(PetHelpType petHelpType) {
        petHelpType.setAddTime(LocalDateTime.now());
        petHelpType.setUpdateTime(LocalDateTime.now());
        this.mapper.insertSelective(petHelpType);
    }

    @CachePut(
            cacheNames = {"PetHelpType"},
            key = "#petHelpType.id"
    )
    public int updateById(PetHelpType petHelpType) {
        petHelpType.setUpdateTime(LocalDateTime.now());
        return this.mapper.updateByPrimaryKeySelective(petHelpType);
    }

    @CacheEvict(
            cacheNames = {"PetHelpType"},
            key = "#id"
    )
    public void deleteById(int id) {
        this.mapper.logicalDeleteByPrimaryKey(id);
    }

    public List<PetHelpType> findByType(Integer type) {
        PetHelpTypeExample example = new PetHelpTypeExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andTypeEqualTo(type);
        return this.mapper.selectByExample(example);
    }

    public List<PetHelpType> findByName(String name) {
        PetHelpTypeExample example = new PetHelpTypeExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andNameEqualTo(name);
        return this.mapper.selectByExample(example);
    }

    public List<PetHelpType> findByQuality(Integer quality) {
        PetHelpTypeExample example = new PetHelpTypeExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andQualityEqualTo(quality);
        return this.mapper.selectByExample(example);
    }

    public List<PetHelpType> findByMoney(Integer money) {
        PetHelpTypeExample example = new PetHelpTypeExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andMoneyEqualTo(money);
        return this.mapper.selectByExample(example);
    }

    public List<PetHelpType> findByPolar(Integer polar) {
        PetHelpTypeExample example = new PetHelpTypeExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andPolarEqualTo(polar);
        return this.mapper.selectByExample(example);
    }

    public PetHelpType findOneByType(Integer type) {
        PetHelpTypeExample example = new PetHelpTypeExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andTypeEqualTo(type);
        return this.mapper.selectOneByExample(example);
    }

    public PetHelpType findOneByName(String name) {
        PetHelpTypeExample example = new PetHelpTypeExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andNameEqualTo(name);
        return this.mapper.selectOneByExample(example);
    }

    public PetHelpType findOneByQuality(Integer quality) {
        PetHelpTypeExample example = new PetHelpTypeExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andQualityEqualTo(quality);
        return this.mapper.selectOneByExample(example);
    }

    public PetHelpType findOneByMoney(Integer money) {
        PetHelpTypeExample example = new PetHelpTypeExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andMoneyEqualTo(money);
        return this.mapper.selectOneByExample(example);
    }

    public PetHelpType findOneByPolar(Integer polar) {
        PetHelpTypeExample example = new PetHelpTypeExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andPolarEqualTo(polar);
        return this.mapper.selectOneByExample(example);
    }

    public List<PetHelpType> findAll(int page, int size, String sort, String order) {
        PetHelpTypeExample example = new PetHelpTypeExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, size);
        return this.mapper.selectByExample(example);
    }

    public List<PetHelpType> findAll() {
        PetHelpTypeExample example = new PetHelpTypeExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        return this.mapper.selectByExample(example);
    }
}
