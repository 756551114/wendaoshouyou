//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.service.base;

import com.github.pagehelper.PageHelper;
import java.time.LocalDateTime;
import java.util.List;
import org.linlinjava.litemall.db.dao.StoreGoodsMapper;
import org.linlinjava.litemall.db.domain.StoreGoods;
import org.linlinjava.litemall.db.domain.example.StoreGoodsExample;
import org.linlinjava.litemall.db.domain.example.StoreGoodsExample.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class BaseStoreGoodsService {
    @Autowired
    protected StoreGoodsMapper mapper;

    public BaseStoreGoodsService() {
    }

    @Cacheable(
            cacheNames = {"StoreGoods"},
            key = "#id"
    )
    public StoreGoods findById(int id) {
        return this.mapper.selectByPrimaryKeyWithLogicalDelete(id, false);
    }

    @Cacheable(
            cacheNames = {"StoreGoods"},
            key = "#id",
            condition = "#result.deleted == 0"
    )
    public StoreGoods findByIdContainsDelete(int id) {
        return this.mapper.selectByPrimaryKey(id);
    }

    public void add(StoreGoods storeGoods) {
        storeGoods.setAddTime(LocalDateTime.now());
        storeGoods.setUpdateTime(LocalDateTime.now());
        this.mapper.insertSelective(storeGoods);
    }

    @CachePut(
            cacheNames = {"StoreGoods"},
            key = "#storeGoods.id"
    )
    public int updateById(StoreGoods storeGoods) {
        storeGoods.setUpdateTime(LocalDateTime.now());
        return this.mapper.updateByPrimaryKeySelective(storeGoods);
    }

    @CacheEvict(
            cacheNames = {"StoreGoods"},
            key = "#id"
    )
    public void deleteById(int id) {
        this.mapper.logicalDeleteByPrimaryKey(id);
    }

    public List<StoreGoods> findByName(String name) {
        StoreGoodsExample example = new StoreGoodsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andNameEqualTo(name);
        return this.mapper.selectByExample(example);
    }

    public List<StoreGoods> findByBarcode(String barcode) {
        StoreGoodsExample example = new StoreGoodsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andBarcodeEqualTo(barcode);
        return this.mapper.selectByExample(example);
    }

    public List<StoreGoods> findByForSale(Integer forSale) {
        StoreGoodsExample example = new StoreGoodsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andForSaleEqualTo(forSale);
        return this.mapper.selectByExample(example);
    }

    public List<StoreGoods> findByShowPos(Integer showPos) {
        StoreGoodsExample example = new StoreGoodsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andShowPosEqualTo(showPos);
        return this.mapper.selectByExample(example);
    }

    public List<StoreGoods> findByRpos(Integer rpos) {
        StoreGoodsExample example = new StoreGoodsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andRposEqualTo(rpos);
        return this.mapper.selectByExample(example);
    }

    public List<StoreGoods> findBySaleQuota(Integer saleQuota) {
        StoreGoodsExample example = new StoreGoodsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andSaleQuotaEqualTo(saleQuota);
        return this.mapper.selectByExample(example);
    }

    public List<StoreGoods> findByRecommend(Integer recommend) {
        StoreGoodsExample example = new StoreGoodsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andRecommendEqualTo(recommend);
        return this.mapper.selectByExample(example);
    }

    public List<StoreGoods> findByCoin(Integer coin) {
        StoreGoodsExample example = new StoreGoodsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andCoinEqualTo(coin);
        return this.mapper.selectByExample(example);
    }

    public List<StoreGoods> findByDiscount(Integer discount) {
        StoreGoodsExample example = new StoreGoodsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andDiscountEqualTo(discount);
        return this.mapper.selectByExample(example);
    }

    public List<StoreGoods> findByType(Integer type) {
        StoreGoodsExample example = new StoreGoodsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andTypeEqualTo(type);
        return this.mapper.selectByExample(example);
    }

    public List<StoreGoods> findByQuotaLimit(Integer quotaLimit) {
        StoreGoodsExample example = new StoreGoodsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andQuotaLimitEqualTo(quotaLimit);
        return this.mapper.selectByExample(example);
    }

    public List<StoreGoods> findByMustVip(Integer mustVip) {
        StoreGoodsExample example = new StoreGoodsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andMustVipEqualTo(mustVip);
        return this.mapper.selectByExample(example);
    }

    public List<StoreGoods> findByIsGift(Integer isGift) {
        StoreGoodsExample example = new StoreGoodsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andIsGiftEqualTo(isGift);
        return this.mapper.selectByExample(example);
    }

    public List<StoreGoods> findByFollowPetType(Integer followPetType) {
        StoreGoodsExample example = new StoreGoodsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andFollowPetTypeEqualTo(followPetType);
        return this.mapper.selectByExample(example);
    }

    public StoreGoods findOneByName(String name) {
        StoreGoodsExample example = new StoreGoodsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andNameEqualTo(name);
        return this.mapper.selectOneByExample(example);
    }

    public StoreGoods findOneByBarcode(String barcode) {
        StoreGoodsExample example = new StoreGoodsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andBarcodeEqualTo(barcode);
        return this.mapper.selectOneByExample(example);
    }

    public StoreGoods findOneByForSale(Integer forSale) {
        StoreGoodsExample example = new StoreGoodsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andForSaleEqualTo(forSale);
        return this.mapper.selectOneByExample(example);
    }

    public StoreGoods findOneByShowPos(Integer showPos) {
        StoreGoodsExample example = new StoreGoodsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andShowPosEqualTo(showPos);
        return this.mapper.selectOneByExample(example);
    }

    public StoreGoods findOneByRpos(Integer rpos) {
        StoreGoodsExample example = new StoreGoodsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andRposEqualTo(rpos);
        return this.mapper.selectOneByExample(example);
    }

    public StoreGoods findOneBySaleQuota(Integer saleQuota) {
        StoreGoodsExample example = new StoreGoodsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andSaleQuotaEqualTo(saleQuota);
        return this.mapper.selectOneByExample(example);
    }

    public StoreGoods findOneByRecommend(Integer recommend) {
        StoreGoodsExample example = new StoreGoodsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andRecommendEqualTo(recommend);
        return this.mapper.selectOneByExample(example);
    }

    public StoreGoods findOneByCoin(Integer coin) {
        StoreGoodsExample example = new StoreGoodsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andCoinEqualTo(coin);
        return this.mapper.selectOneByExample(example);
    }

    public StoreGoods findOneByDiscount(Integer discount) {
        StoreGoodsExample example = new StoreGoodsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andDiscountEqualTo(discount);
        return this.mapper.selectOneByExample(example);
    }

    public StoreGoods findOneByType(Integer type) {
        StoreGoodsExample example = new StoreGoodsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andTypeEqualTo(type);
        return this.mapper.selectOneByExample(example);
    }

    public StoreGoods findOneByQuotaLimit(Integer quotaLimit) {
        StoreGoodsExample example = new StoreGoodsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andQuotaLimitEqualTo(quotaLimit);
        return this.mapper.selectOneByExample(example);
    }

    public StoreGoods findOneByMustVip(Integer mustVip) {
        StoreGoodsExample example = new StoreGoodsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andMustVipEqualTo(mustVip);
        return this.mapper.selectOneByExample(example);
    }

    public StoreGoods findOneByIsGift(Integer isGift) {
        StoreGoodsExample example = new StoreGoodsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andIsGiftEqualTo(isGift);
        return this.mapper.selectOneByExample(example);
    }

    public StoreGoods findOneByFollowPetType(Integer followPetType) {
        StoreGoodsExample example = new StoreGoodsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andFollowPetTypeEqualTo(followPetType);
        return this.mapper.selectOneByExample(example);
    }

    public List<StoreGoods> findAll(int page, int size, String sort, String order) {
        StoreGoodsExample example = new StoreGoodsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, size);
        return this.mapper.selectByExample(example);
    }

    public List<StoreGoods> findAll() {
        StoreGoodsExample example = new StoreGoodsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        return this.mapper.selectByExample(example);
    }
}
