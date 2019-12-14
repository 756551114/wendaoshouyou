//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.service.base;

import com.github.pagehelper.PageHelper;
import java.time.LocalDateTime;
import java.util.List;
import org.linlinjava.litemall.db.dao.ZhuangbeiInfoMapper;
import org.linlinjava.litemall.db.domain.ZhuangbeiInfo;
import org.linlinjava.litemall.db.domain.example.ZhuangbeiInfoExample;
import org.linlinjava.litemall.db.domain.example.ZhuangbeiInfoExample.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class BaseZhuangbeiInfoService {
    @Autowired
    protected ZhuangbeiInfoMapper mapper;

    public BaseZhuangbeiInfoService() {
    }

    @Cacheable(
            cacheNames = {"ZhuangbeiInfo"},
            key = "#id"
    )
    public ZhuangbeiInfo findById(int id) {
        return this.mapper.selectByPrimaryKeyWithLogicalDelete(id, false);
    }

    @Cacheable(
            cacheNames = {"ZhuangbeiInfo"},
            key = "#id",
            condition = "#result.deleted == 0"
    )
    public ZhuangbeiInfo findByIdContainsDelete(int id) {
        return this.mapper.selectByPrimaryKey(id);
    }

    public void add(ZhuangbeiInfo zhuangbeiInfo) {
        zhuangbeiInfo.setAddTime(LocalDateTime.now());
        zhuangbeiInfo.setUpdateTime(LocalDateTime.now());
        this.mapper.insertSelective(zhuangbeiInfo);
    }

    @CachePut(
            cacheNames = {"ZhuangbeiInfo"},
            key = "#zhuangbeiInfo.id"
    )
    public int updateById(ZhuangbeiInfo zhuangbeiInfo) {
        zhuangbeiInfo.setUpdateTime(LocalDateTime.now());
        return this.mapper.updateByPrimaryKeySelective(zhuangbeiInfo);
    }

    @CacheEvict(
            cacheNames = {"ZhuangbeiInfo"},
            key = "#id"
    )
    public void deleteById(int id) {
        this.mapper.logicalDeleteByPrimaryKey(id);
    }

    public List<ZhuangbeiInfo> findByAttrib(Integer attrib) {
        ZhuangbeiInfoExample example = new ZhuangbeiInfoExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andAttribEqualTo(attrib);
        return this.mapper.selectByExample(example);
    }

    public List<ZhuangbeiInfo> findByAmount(Integer amount) {
        ZhuangbeiInfoExample example = new ZhuangbeiInfoExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andAmountEqualTo(amount);
        return this.mapper.selectByExample(example);
    }

    public List<ZhuangbeiInfo> findByType(Integer type) {
        ZhuangbeiInfoExample example = new ZhuangbeiInfoExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andTypeEqualTo(type);
        return this.mapper.selectByExample(example);
    }

    public List<ZhuangbeiInfo> findByStr(String str) {
        ZhuangbeiInfoExample example = new ZhuangbeiInfoExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andStrEqualTo(str);
        return this.mapper.selectByExample(example);
    }

    public List<ZhuangbeiInfo> findByQuality(String quality) {
        ZhuangbeiInfoExample example = new ZhuangbeiInfoExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andQualityEqualTo(quality);
        return this.mapper.selectByExample(example);
    }

    public List<ZhuangbeiInfo> findByMaster(Integer master) {
        ZhuangbeiInfoExample example = new ZhuangbeiInfoExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andMasterEqualTo(master);
        return this.mapper.selectByExample(example);
    }

    public List<ZhuangbeiInfo> findByMetal(Integer metal) {
        ZhuangbeiInfoExample example = new ZhuangbeiInfoExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andMetalEqualTo(metal);
        return this.mapper.selectByExample(example);
    }

    public List<ZhuangbeiInfo> findByMana(Integer mana) {
        ZhuangbeiInfoExample example = new ZhuangbeiInfoExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andManaEqualTo(mana);
        return this.mapper.selectByExample(example);
    }

    public List<ZhuangbeiInfo> findByAccurate(Integer accurate) {
        ZhuangbeiInfoExample example = new ZhuangbeiInfoExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andAccurateEqualTo(accurate);
        return this.mapper.selectByExample(example);
    }

    public List<ZhuangbeiInfo> findByDef(Integer def) {
        ZhuangbeiInfoExample example = new ZhuangbeiInfoExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andDefEqualTo(def);
        return this.mapper.selectByExample(example);
    }

    public List<ZhuangbeiInfo> findByDex(Integer dex) {
        ZhuangbeiInfoExample example = new ZhuangbeiInfoExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andDexEqualTo(dex);
        return this.mapper.selectByExample(example);
    }

    public List<ZhuangbeiInfo> findByWiz(Integer wiz) {
        ZhuangbeiInfoExample example = new ZhuangbeiInfoExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andWizEqualTo(wiz);
        return this.mapper.selectByExample(example);
    }

    public List<ZhuangbeiInfo> findByParry(Integer parry) {
        ZhuangbeiInfoExample example = new ZhuangbeiInfoExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andParryEqualTo(parry);
        return this.mapper.selectByExample(example);
    }

    public ZhuangbeiInfo findOneByAttrib(Integer attrib) {
        ZhuangbeiInfoExample example = new ZhuangbeiInfoExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andAttribEqualTo(attrib);
        return this.mapper.selectOneByExample(example);
    }

    public ZhuangbeiInfo findOneByAmount(Integer amount) {
        ZhuangbeiInfoExample example = new ZhuangbeiInfoExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andAmountEqualTo(amount);
        return this.mapper.selectOneByExample(example);
    }

    public ZhuangbeiInfo findOneByType(Integer type) {
        ZhuangbeiInfoExample example = new ZhuangbeiInfoExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andTypeEqualTo(type);
        return this.mapper.selectOneByExample(example);
    }

    public ZhuangbeiInfo findOneByStr(String str) {
        ZhuangbeiInfoExample example = new ZhuangbeiInfoExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andStrEqualTo(str);
        return this.mapper.selectOneByExample(example);
    }

    public ZhuangbeiInfo findOneByQuality(String quality) {
        ZhuangbeiInfoExample example = new ZhuangbeiInfoExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andQualityEqualTo(quality);
        return this.mapper.selectOneByExample(example);
    }

    public ZhuangbeiInfo findOneByMaster(Integer master) {
        ZhuangbeiInfoExample example = new ZhuangbeiInfoExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andMasterEqualTo(master);
        return this.mapper.selectOneByExample(example);
    }

    public ZhuangbeiInfo findOneByMetal(Integer metal) {
        ZhuangbeiInfoExample example = new ZhuangbeiInfoExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andMetalEqualTo(metal);
        return this.mapper.selectOneByExample(example);
    }

    public ZhuangbeiInfo findOneByMana(Integer mana) {
        ZhuangbeiInfoExample example = new ZhuangbeiInfoExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andManaEqualTo(mana);
        return this.mapper.selectOneByExample(example);
    }

    public ZhuangbeiInfo findOneByAccurate(Integer accurate) {
        ZhuangbeiInfoExample example = new ZhuangbeiInfoExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andAccurateEqualTo(accurate);
        return this.mapper.selectOneByExample(example);
    }

    public ZhuangbeiInfo findOneByDef(Integer def) {
        ZhuangbeiInfoExample example = new ZhuangbeiInfoExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andDefEqualTo(def);
        return this.mapper.selectOneByExample(example);
    }

    public ZhuangbeiInfo findOneByDex(Integer dex) {
        ZhuangbeiInfoExample example = new ZhuangbeiInfoExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andDexEqualTo(dex);
        return this.mapper.selectOneByExample(example);
    }

    public ZhuangbeiInfo findOneByWiz(Integer wiz) {
        ZhuangbeiInfoExample example = new ZhuangbeiInfoExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andWizEqualTo(wiz);
        return this.mapper.selectOneByExample(example);
    }

    public ZhuangbeiInfo findOneByParry(Integer parry) {
        ZhuangbeiInfoExample example = new ZhuangbeiInfoExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andParryEqualTo(parry);
        return this.mapper.selectOneByExample(example);
    }

    public List<ZhuangbeiInfo> findAll(int page, int size, String sort, String order) {
        ZhuangbeiInfoExample example = new ZhuangbeiInfoExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, size);
        return this.mapper.selectByExample(example);
    }

    public List<ZhuangbeiInfo> findAll() {
        ZhuangbeiInfoExample example = new ZhuangbeiInfoExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        return this.mapper.selectByExample(example);
    }
}
