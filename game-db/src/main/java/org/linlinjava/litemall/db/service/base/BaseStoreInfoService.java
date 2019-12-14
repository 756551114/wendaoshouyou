//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.service.base;

import com.github.pagehelper.PageHelper;
import java.time.LocalDateTime;
import java.util.List;
import org.linlinjava.litemall.db.dao.StoreInfoMapper;
import org.linlinjava.litemall.db.domain.StoreInfo;
import org.linlinjava.litemall.db.domain.example.StoreInfoExample;
import org.linlinjava.litemall.db.domain.example.StoreInfoExample.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class BaseStoreInfoService {
    @Autowired
    protected StoreInfoMapper mapper;

    public BaseStoreInfoService() {
    }

    @Cacheable(
            cacheNames = {"StoreInfo"},
            key = "#id"
    )
    public StoreInfo findById(int id) {
        return this.mapper.selectByPrimaryKeyWithLogicalDelete(id, false);
    }

    @Cacheable(
            cacheNames = {"StoreInfo"},
            key = "#id",
            condition = "#result.deleted == 0"
    )
    public StoreInfo findByIdContainsDelete(int id) {
        return this.mapper.selectByPrimaryKey(id);
    }

    public void add(StoreInfo storeInfo) {
        storeInfo.setAddTime(LocalDateTime.now());
        storeInfo.setUpdateTime(LocalDateTime.now());
        this.mapper.insertSelective(storeInfo);
    }

    @CachePut(
            cacheNames = {"StoreInfo"},
            key = "#storeInfo.id"
    )
    public int updateById(StoreInfo storeInfo) {
        storeInfo.setUpdateTime(LocalDateTime.now());
        return this.mapper.updateByPrimaryKeySelective(storeInfo);
    }

    @CacheEvict(
            cacheNames = {"StoreInfo"},
            key = "#id"
    )
    public void deleteById(int id) {
        this.mapper.logicalDeleteByPrimaryKey(id);
    }

    public List<StoreInfo> findByQuality(String quality) {
        StoreInfoExample example = new StoreInfoExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andQualityEqualTo(quality);
        return this.mapper.selectByExample(example);
    }

    public List<StoreInfo> findByValue(Integer value) {
        StoreInfoExample example = new StoreInfoExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andValueEqualTo(value);
        return this.mapper.selectByExample(example);
    }

    public List<StoreInfo> findByType(Integer type) {
        StoreInfoExample example = new StoreInfoExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andTypeEqualTo(type);
        return this.mapper.selectByExample(example);
    }

    public List<StoreInfo> findByName(String name) {
        StoreInfoExample example = new StoreInfoExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andNameEqualTo(name);
        return this.mapper.selectByExample(example);
    }

    public List<StoreInfo> findByTotalScore(Integer totalScore) {
        StoreInfoExample example = new StoreInfoExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andTotalScoreEqualTo(totalScore);
        return this.mapper.selectByExample(example);
    }

    public List<StoreInfo> findByRecognizeRecognized(Integer recognizeRecognized) {
        StoreInfoExample example = new StoreInfoExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andRecognizeRecognizedEqualTo(recognizeRecognized);
        return this.mapper.selectByExample(example);
    }

    public List<StoreInfo> findByRebuildLevel(Integer rebuildLevel) {
        StoreInfoExample example = new StoreInfoExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andRebuildLevelEqualTo(rebuildLevel);
        return this.mapper.selectByExample(example);
    }

    public List<StoreInfo> findBySilverCoin(Integer silverCoin) {
        StoreInfoExample example = new StoreInfoExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andSilverCoinEqualTo(silverCoin);
        return this.mapper.selectByExample(example);
    }

    public StoreInfo findOneByQuality(String quality) {
        StoreInfoExample example = new StoreInfoExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andQualityEqualTo(quality);
        return this.mapper.selectOneByExample(example);
    }

    public StoreInfo findOneByValue(Integer value) {
        StoreInfoExample example = new StoreInfoExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andValueEqualTo(value);
        return this.mapper.selectOneByExample(example);
    }

    public StoreInfo findOneByType(Integer type) {
        StoreInfoExample example = new StoreInfoExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andTypeEqualTo(type);
        return this.mapper.selectOneByExample(example);
    }

    public StoreInfo findOneByName(String name) {
        StoreInfoExample example = new StoreInfoExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andNameEqualTo(name);
        return this.mapper.selectOneByExample(example);
    }

    public StoreInfo findOneByTotalScore(Integer totalScore) {
        StoreInfoExample example = new StoreInfoExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andTotalScoreEqualTo(totalScore);
        return this.mapper.selectOneByExample(example);
    }

    public StoreInfo findOneByRecognizeRecognized(Integer recognizeRecognized) {
        StoreInfoExample example = new StoreInfoExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andRecognizeRecognizedEqualTo(recognizeRecognized);
        return this.mapper.selectOneByExample(example);
    }

    public StoreInfo findOneByRebuildLevel(Integer rebuildLevel) {
        StoreInfoExample example = new StoreInfoExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andRebuildLevelEqualTo(rebuildLevel);
        return this.mapper.selectOneByExample(example);
    }

    public StoreInfo findOneBySilverCoin(Integer silverCoin) {
        StoreInfoExample example = new StoreInfoExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andSilverCoinEqualTo(silverCoin);
        return this.mapper.selectOneByExample(example);
    }

    public List<StoreInfo> findAll(int page, int size, String sort, String order) {
        StoreInfoExample example = new StoreInfoExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, size);
        return this.mapper.selectByExample(example);
    }

    public List<StoreInfo> findAll() {
        StoreInfoExample example = new StoreInfoExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        return this.mapper.selectByExample(example);
    }
}
