//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.service.base;

import com.github.pagehelper.PageHelper;
import java.time.LocalDateTime;
import java.util.List;
import org.linlinjava.litemall.db.dao.SaleClassifyGoodMapper;
import org.linlinjava.litemall.db.domain.SaleClassifyGood;
import org.linlinjava.litemall.db.domain.example.SaleClassifyGoodExample;
import org.linlinjava.litemall.db.domain.example.SaleClassifyGoodExample.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class BaseSaleClassifyGoodService {
    @Autowired
    protected SaleClassifyGoodMapper mapper;

    public BaseSaleClassifyGoodService() {
    }

    @Cacheable(
            cacheNames = {"SaleClassifyGood"},
            key = "#id"
    )
    public SaleClassifyGood findById(int id) {
        return this.mapper.selectByPrimaryKeyWithLogicalDelete(id, false);
    }

    @Cacheable(
            cacheNames = {"SaleClassifyGood"},
            key = "#id",
            condition = "#result.deleted == 0"
    )
    public SaleClassifyGood findByIdContainsDelete(int id) {
        return this.mapper.selectByPrimaryKey(id);
    }

    public void add(SaleClassifyGood saleClassifyGood) {
        saleClassifyGood.setAddTime(LocalDateTime.now());
        saleClassifyGood.setUpdateTime(LocalDateTime.now());
        this.mapper.insertSelective(saleClassifyGood);
    }

    @CachePut(
            cacheNames = {"SaleClassifyGood"},
            key = "#saleClassifyGood.id"
    )
    public int updateById(SaleClassifyGood saleClassifyGood) {
        saleClassifyGood.setUpdateTime(LocalDateTime.now());
        return this.mapper.updateByPrimaryKeySelective(saleClassifyGood);
    }

    @CacheEvict(
            cacheNames = {"SaleClassifyGood"},
            key = "#id"
    )
    public void deleteById(int id) {
        this.mapper.logicalDeleteByPrimaryKey(id);
    }

    public List<SaleClassifyGood> findByPname(String pname) {
        SaleClassifyGoodExample example = new SaleClassifyGoodExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andPnameEqualTo(pname);
        return this.mapper.selectByExample(example);
    }

    public List<SaleClassifyGood> findByCname(String cname) {
        SaleClassifyGoodExample example = new SaleClassifyGoodExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andCnameEqualTo(cname);
        return this.mapper.selectByExample(example);
    }

    public List<SaleClassifyGood> findByAttrib(String attrib) {
        SaleClassifyGoodExample example = new SaleClassifyGoodExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andAttribEqualTo(attrib);
        return this.mapper.selectByExample(example);
    }

    public List<SaleClassifyGood> findByIcon(Integer icon) {
        SaleClassifyGoodExample example = new SaleClassifyGoodExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andIconEqualTo(icon);
        return this.mapper.selectByExample(example);
    }

    public List<SaleClassifyGood> findByStr(String str) {
        SaleClassifyGoodExample example = new SaleClassifyGoodExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andStrEqualTo(str);
        return this.mapper.selectByExample(example);
    }

    public List<SaleClassifyGood> findByPrice(Integer price) {
        SaleClassifyGoodExample example = new SaleClassifyGoodExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andPriceEqualTo(price);
        return this.mapper.selectByExample(example);
    }

    public List<SaleClassifyGood> findByCompose(String compose) {
        SaleClassifyGoodExample example = new SaleClassifyGoodExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andComposeEqualTo(compose);
        return this.mapper.selectByExample(example);
    }

    public SaleClassifyGood findOneByPname(String pname) {
        SaleClassifyGoodExample example = new SaleClassifyGoodExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andPnameEqualTo(pname);
        return this.mapper.selectOneByExample(example);
    }

    public SaleClassifyGood findOneByCname(String cname) {
        SaleClassifyGoodExample example = new SaleClassifyGoodExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andCnameEqualTo(cname);
        return this.mapper.selectOneByExample(example);
    }

    public SaleClassifyGood findOneByAttrib(String attrib) {
        SaleClassifyGoodExample example = new SaleClassifyGoodExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andAttribEqualTo(attrib);
        return this.mapper.selectOneByExample(example);
    }

    public SaleClassifyGood findOneByIcon(Integer icon) {
        SaleClassifyGoodExample example = new SaleClassifyGoodExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andIconEqualTo(icon);
        return this.mapper.selectOneByExample(example);
    }

    public SaleClassifyGood findOneByStr(String str) {
        SaleClassifyGoodExample example = new SaleClassifyGoodExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andStrEqualTo(str);
        return this.mapper.selectOneByExample(example);
    }

    public SaleClassifyGood findOneByPrice(Integer price) {
        SaleClassifyGoodExample example = new SaleClassifyGoodExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andPriceEqualTo(price);
        return this.mapper.selectOneByExample(example);
    }

    public SaleClassifyGood findOneByCompose(String compose) {
        SaleClassifyGoodExample example = new SaleClassifyGoodExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andComposeEqualTo(compose);
        return this.mapper.selectOneByExample(example);
    }

    public List<SaleClassifyGood> findAll(int page, int size, String sort, String order) {
        SaleClassifyGoodExample example = new SaleClassifyGoodExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, size);
        return this.mapper.selectByExample(example);
    }

    public List<SaleClassifyGood> findAll() {
        SaleClassifyGoodExample example = new SaleClassifyGoodExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        return this.mapper.selectByExample(example);
    }
}
