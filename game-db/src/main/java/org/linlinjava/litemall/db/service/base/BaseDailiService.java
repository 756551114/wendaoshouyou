//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.service.base;

import com.github.pagehelper.PageHelper;
import java.time.LocalDateTime;
import java.util.List;
import org.linlinjava.litemall.db.dao.DailiMapper;
import org.linlinjava.litemall.db.domain.Daili;
import org.linlinjava.litemall.db.domain.example.DailiExample;
import org.linlinjava.litemall.db.domain.example.DailiExample.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class BaseDailiService {
    @Autowired
    protected DailiMapper mapper;

    public BaseDailiService() {
    }

    @Cacheable(
            cacheNames = {"Daili"},
            key = "#id"
    )
    public Daili findById(int id) {
        return this.mapper.selectByPrimaryKeyWithLogicalDelete(id, false);
    }

    @Cacheable(
            cacheNames = {"Daili"},
            key = "#id",
            condition = "#result.deleted == 0"
    )
    public Daili findByIdContainsDelete(int id) {
        return this.mapper.selectByPrimaryKey(id);
    }

    public void add(Daili daili) {
        daili.setAddTime(LocalDateTime.now());
        daili.setUpdateTime(LocalDateTime.now());
        this.mapper.insertSelective(daili);
    }

    @CachePut(
            cacheNames = {"Daili"},
            key = "#daili.id"
    )
    public int updateById(Daili daili) {
        daili.setUpdateTime(LocalDateTime.now());
        return this.mapper.updateByPrimaryKeySelective(daili);
    }

    @CacheEvict(
            cacheNames = {"Daili"},
            key = "#id"
    )
    public void deleteById(int id) {
        this.mapper.logicalDeleteByPrimaryKey(id);
    }

    public List<Daili> findByAccount(String account) {
        DailiExample example = new DailiExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andAccountEqualTo(account);
        return this.mapper.selectByExample(example);
    }

    public List<Daili> findByPasswd(String passwd) {
        DailiExample example = new DailiExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andPasswdEqualTo(passwd);
        return this.mapper.selectByExample(example);
    }

    public List<Daili> findByCode(String code) {
        DailiExample example = new DailiExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andCodeEqualTo(code);
        return this.mapper.selectByExample(example);
    }

    public List<Daili> findByToken(String token) {
        DailiExample example = new DailiExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andTokenEqualTo(token);
        return this.mapper.selectByExample(example);
    }

    public Daili findOneByAccount(String account) {
        DailiExample example = new DailiExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andAccountEqualTo(account);
        return this.mapper.selectOneByExample(example);
    }

    public Daili findOneByPasswd(String passwd) {
        DailiExample example = new DailiExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andPasswdEqualTo(passwd);
        return this.mapper.selectOneByExample(example);
    }

    public Daili findOneByCode(String code) {
        DailiExample example = new DailiExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andCodeEqualTo(code);
        return this.mapper.selectOneByExample(example);
    }

    public Daili findOneByToken(String token) {
        DailiExample example = new DailiExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andTokenEqualTo(token);
        return this.mapper.selectOneByExample(example);
    }

    public List<Daili> findAll(int page, int size, String sort, String order) {
        DailiExample example = new DailiExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, size);
        return this.mapper.selectByExample(example);
    }

    public List<Daili> findAll() {
        DailiExample example = new DailiExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        return this.mapper.selectByExample(example);
    }
}
