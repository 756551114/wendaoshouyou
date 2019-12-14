//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.service.base;

import com.github.pagehelper.PageHelper;
import java.time.LocalDateTime;
import java.util.List;
import org.linlinjava.litemall.db.dao.SaleGoodMapper;
import org.linlinjava.litemall.db.domain.SaleGood;
import org.linlinjava.litemall.db.domain.example.SaleGoodExample;
import org.linlinjava.litemall.db.domain.example.SaleGoodExample.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class BaseSaleGoodService {
    @Autowired
    protected SaleGoodMapper mapper;

    public BaseSaleGoodService() {
    }

    @Cacheable(
            cacheNames = {"SaleGood"},
            key = "#id"
    )
    public SaleGood findById(int id) {
        return this.mapper.selectByPrimaryKeyWithLogicalDelete(id, false);
    }

    @Cacheable(
            cacheNames = {"SaleGood"},
            key = "#id",
            condition = "#result.deleted == 0"
    )
    public SaleGood findByIdContainsDelete(int id) {
        return this.mapper.selectByPrimaryKey(id);
    }

    public void add(SaleGood saleGood) {
        saleGood.setAddTime(LocalDateTime.now());
        saleGood.setUpdateTime(LocalDateTime.now());
        this.mapper.insertSelective(saleGood);
    }

    @CachePut(
            cacheNames = {"SaleGood"},
            key = "#saleGood.id"
    )
    public int updateById(SaleGood saleGood) {
        saleGood.setUpdateTime(LocalDateTime.now());
        return this.mapper.updateByPrimaryKeySelective(saleGood);
    }

    @CacheEvict(
            cacheNames = {"SaleGood"},
            key = "#id"
    )
    public void deleteById(int id) {
        this.mapper.logicalDeleteByPrimaryKey(id);
    }

    public List<SaleGood> findByGoodsId(String goodsId) {
        SaleGoodExample example = new SaleGoodExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andGoodsIdEqualTo(goodsId);
        return this.mapper.selectByExample(example);
    }

    public List<SaleGood> findByName(String name) {
        SaleGoodExample example = new SaleGoodExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andNameEqualTo(name);
        return this.mapper.selectByExample(example);
    }

    public List<SaleGood> findByStartTime(Integer startTime) {
        SaleGoodExample example = new SaleGoodExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andStartTimeEqualTo(startTime);
        return this.mapper.selectByExample(example);
    }

    public List<SaleGood> findByEndTime(Integer endTime) {
        SaleGoodExample example = new SaleGoodExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andEndTimeEqualTo(endTime);
        return this.mapper.selectByExample(example);
    }

    public List<SaleGood> findByPrice(Integer price) {
        SaleGoodExample example = new SaleGoodExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andPriceEqualTo(price);
        return this.mapper.selectByExample(example);
    }

    public List<SaleGood> findByReqLevel(Integer reqLevel) {
        SaleGoodExample example = new SaleGoodExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andReqLevelEqualTo(reqLevel);
        return this.mapper.selectByExample(example);
    }

    public List<SaleGood> findByOwnerUuid(String ownerUuid) {
        SaleGoodExample example = new SaleGoodExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andOwnerUuidEqualTo(ownerUuid);
        return this.mapper.selectByExample(example);
    }

    public List<SaleGood> findByStr(String str) {
        SaleGoodExample example = new SaleGoodExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andStrEqualTo(str);
        return this.mapper.selectByExample(example);
    }

    public List<SaleGood> findByPet(String pet) {
        SaleGoodExample example = new SaleGoodExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andPetEqualTo(pet);
        return this.mapper.selectByExample(example);
    }

    public List<SaleGood> findByPos(Integer pos) {
        SaleGoodExample example = new SaleGoodExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andPosEqualTo(pos);
        return this.mapper.selectByExample(example);
    }

    public List<SaleGood> findByIspet(Integer ispet) {
        SaleGoodExample example = new SaleGoodExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andIspetEqualTo(ispet);
        return this.mapper.selectByExample(example);
    }

    public List<SaleGood> findByLevel(Integer level) {
        SaleGoodExample example = new SaleGoodExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andLevelEqualTo(level);
        return this.mapper.selectByExample(example);
    }

    public SaleGood findOneByGoodsId(String goodsId) {
        SaleGoodExample example = new SaleGoodExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andGoodsIdEqualTo(goodsId);
        return this.mapper.selectOneByExample(example);
    }

    public SaleGood findOneByName(String name) {
        SaleGoodExample example = new SaleGoodExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andNameEqualTo(name);
        return this.mapper.selectOneByExample(example);
    }

    public SaleGood findOneByStartTime(Integer startTime) {
        SaleGoodExample example = new SaleGoodExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andStartTimeEqualTo(startTime);
        return this.mapper.selectOneByExample(example);
    }

    public SaleGood findOneByEndTime(Integer endTime) {
        SaleGoodExample example = new SaleGoodExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andEndTimeEqualTo(endTime);
        return this.mapper.selectOneByExample(example);
    }

    public SaleGood findOneByPrice(Integer price) {
        SaleGoodExample example = new SaleGoodExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andPriceEqualTo(price);
        return this.mapper.selectOneByExample(example);
    }

    public SaleGood findOneByReqLevel(Integer reqLevel) {
        SaleGoodExample example = new SaleGoodExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andReqLevelEqualTo(reqLevel);
        return this.mapper.selectOneByExample(example);
    }

    public SaleGood findOneByOwnerUuid(String ownerUuid) {
        SaleGoodExample example = new SaleGoodExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andOwnerUuidEqualTo(ownerUuid);
        return this.mapper.selectOneByExample(example);
    }

    public SaleGood findOneByStr(String str) {
        SaleGoodExample example = new SaleGoodExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andStrEqualTo(str);
        return this.mapper.selectOneByExample(example);
    }

    public SaleGood findOneByPet(String pet) {
        SaleGoodExample example = new SaleGoodExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andPetEqualTo(pet);
        return this.mapper.selectOneByExample(example);
    }

    public SaleGood findOneByPos(Integer pos) {
        SaleGoodExample example = new SaleGoodExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andPosEqualTo(pos);
        return this.mapper.selectOneByExample(example);
    }

    public SaleGood findOneByIspet(Integer ispet) {
        SaleGoodExample example = new SaleGoodExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andIspetEqualTo(ispet);
        return this.mapper.selectOneByExample(example);
    }

    public SaleGood findOneByLevel(Integer level) {
        SaleGoodExample example = new SaleGoodExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andLevelEqualTo(level);
        return this.mapper.selectOneByExample(example);
    }

    public List<SaleGood> findAll(int page, int size, String sort, String order) {
        SaleGoodExample example = new SaleGoodExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, size);
        return this.mapper.selectByExample(example);
    }

    public List<SaleGood> findAll() {
        SaleGoodExample example = new SaleGoodExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        return this.mapper.selectByExample(example);
    }
}
