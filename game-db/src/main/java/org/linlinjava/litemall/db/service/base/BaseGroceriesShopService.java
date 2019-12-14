//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.service.base;

import com.github.pagehelper.PageHelper;
import java.time.LocalDateTime;
import java.util.List;
import org.linlinjava.litemall.db.dao.GroceriesShopMapper;
import org.linlinjava.litemall.db.domain.GroceriesShop;
import org.linlinjava.litemall.db.domain.example.GroceriesShopExample;
import org.linlinjava.litemall.db.domain.example.GroceriesShopExample.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class BaseGroceriesShopService {
    @Autowired
    protected GroceriesShopMapper mapper;

    public BaseGroceriesShopService() {
    }

    @Cacheable(
            cacheNames = {"GroceriesShop"},
            key = "#id"
    )
    public GroceriesShop findById(int id) {
        return this.mapper.selectByPrimaryKeyWithLogicalDelete(id, false);
    }

    @Cacheable(
            cacheNames = {"GroceriesShop"},
            key = "#id",
            condition = "#result.deleted == 0"
    )
    public GroceriesShop findByIdContainsDelete(int id) {
        return this.mapper.selectByPrimaryKey(id);
    }

    public void add(GroceriesShop groceriesShop) {
        groceriesShop.setAddTime(LocalDateTime.now());
        groceriesShop.setUpdateTime(LocalDateTime.now());
        this.mapper.insertSelective(groceriesShop);
    }

    @CachePut(
            cacheNames = {"GroceriesShop"},
            key = "#groceriesShop.id"
    )
    public int updateById(GroceriesShop groceriesShop) {
        groceriesShop.setUpdateTime(LocalDateTime.now());
        return this.mapper.updateByPrimaryKeySelective(groceriesShop);
    }

    @CacheEvict(
            cacheNames = {"GroceriesShop"},
            key = "#id"
    )
    public void deleteById(int id) {
        this.mapper.logicalDeleteByPrimaryKey(id);
    }

    public List<GroceriesShop> findByGoodsNo(Integer goodsNo) {
        GroceriesShopExample example = new GroceriesShopExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andGoodsNoEqualTo(goodsNo);
        return this.mapper.selectByExample(example);
    }

    public List<GroceriesShop> findByPayType(Integer payType) {
        GroceriesShopExample example = new GroceriesShopExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andPayTypeEqualTo(payType);
        return this.mapper.selectByExample(example);
    }

    public List<GroceriesShop> findByName(String name) {
        GroceriesShopExample example = new GroceriesShopExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andNameEqualTo(name);
        return this.mapper.selectByExample(example);
    }

    public List<GroceriesShop> findByValue(Integer value) {
        GroceriesShopExample example = new GroceriesShopExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andValueEqualTo(value);
        return this.mapper.selectByExample(example);
    }

    public List<GroceriesShop> findByLevel(Integer level) {
        GroceriesShopExample example = new GroceriesShopExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andLevelEqualTo(level);
        return this.mapper.selectByExample(example);
    }

    public List<GroceriesShop> findByType(Integer type) {
        GroceriesShopExample example = new GroceriesShopExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andTypeEqualTo(type);
        return this.mapper.selectByExample(example);
    }

    public List<GroceriesShop> findByItemcount(Integer itemcount) {
        GroceriesShopExample example = new GroceriesShopExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andItemcountEqualTo(itemcount);
        return this.mapper.selectByExample(example);
    }

    public GroceriesShop findOneByGoodsNo(Integer goodsNo) {
        GroceriesShopExample example = new GroceriesShopExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andGoodsNoEqualTo(goodsNo);
        return this.mapper.selectOneByExample(example);
    }

    public GroceriesShop findOneByPayType(Integer payType) {
        GroceriesShopExample example = new GroceriesShopExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andPayTypeEqualTo(payType);
        return this.mapper.selectOneByExample(example);
    }

    public GroceriesShop findOneByName(String name) {
        GroceriesShopExample example = new GroceriesShopExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andNameEqualTo(name);
        return this.mapper.selectOneByExample(example);
    }

    public GroceriesShop findOneByValue(Integer value) {
        GroceriesShopExample example = new GroceriesShopExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andValueEqualTo(value);
        return this.mapper.selectOneByExample(example);
    }

    public GroceriesShop findOneByLevel(Integer level) {
        GroceriesShopExample example = new GroceriesShopExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andLevelEqualTo(level);
        return this.mapper.selectOneByExample(example);
    }

    public GroceriesShop findOneByType(Integer type) {
        GroceriesShopExample example = new GroceriesShopExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andTypeEqualTo(type);
        return this.mapper.selectOneByExample(example);
    }

    public GroceriesShop findOneByItemcount(Integer itemcount) {
        GroceriesShopExample example = new GroceriesShopExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andItemcountEqualTo(itemcount);
        return this.mapper.selectOneByExample(example);
    }

    public List<GroceriesShop> findAll(int page, int size, String sort, String order) {
        GroceriesShopExample example = new GroceriesShopExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, size);
        return this.mapper.selectByExample(example);
    }

    public List<GroceriesShop> findAll() {
        GroceriesShopExample example = new GroceriesShopExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        return this.mapper.selectByExample(example);
    }
}
