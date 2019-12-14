//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.service.base;

import com.github.pagehelper.PageHelper;
import java.time.LocalDateTime;
import java.util.List;
import org.linlinjava.litemall.db.dao.ChargeMapper;
import org.linlinjava.litemall.db.domain.Charge;
import org.linlinjava.litemall.db.domain.example.ChargeExample;
import org.linlinjava.litemall.db.domain.example.ChargeExample.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class BaseChargeService {
    @Autowired
    protected ChargeMapper mapper;

    public BaseChargeService() {
    }

    @Cacheable(
            cacheNames = {"Charge"},
            key = "#id"
    )
    public Charge findById(int id) {
        return this.mapper.selectByPrimaryKeyWithLogicalDelete(id, false);
    }

    @Cacheable(
            cacheNames = {"Charge"},
            key = "#id",
            condition = "#result.deleted == 0"
    )
    public Charge findByIdContainsDelete(int id) {
        return this.mapper.selectByPrimaryKey(id);
    }

    public void add(Charge charge) {
        charge.setAddTime(LocalDateTime.now());
        charge.setUpdateTime(LocalDateTime.now());
        this.mapper.insertSelective(charge);
    }

    @CachePut(
            cacheNames = {"Charge"},
            key = "#charge.id"
    )
    public int updateById(Charge charge) {
        charge.setUpdateTime(LocalDateTime.now());
        return this.mapper.updateByPrimaryKeySelective(charge);
    }

    @CacheEvict(
            cacheNames = {"Charge"},
            key = "#id"
    )
    public void deleteById(int id) {
        this.mapper.logicalDeleteByPrimaryKey(id);
    }

    public List<Charge> findByAccountname(String accountname) {
        ChargeExample example = new ChargeExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andAccountnameEqualTo(accountname);
        return this.mapper.selectByExample(example);
    }

    public List<Charge> findByCoin(Integer coin) {
        ChargeExample example = new ChargeExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andCoinEqualTo(coin);
        return this.mapper.selectByExample(example);
    }

    public List<Charge> findByState(Integer state) {
        ChargeExample example = new ChargeExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andStateEqualTo(state);
        return this.mapper.selectByExample(example);
    }

    public List<Charge> findByMoney(Integer money) {
        ChargeExample example = new ChargeExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andMoneyEqualTo(money);
        return this.mapper.selectByExample(example);
    }

    public List<Charge> findByCode(String code) {
        ChargeExample example = new ChargeExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andCodeEqualTo(code);
        return this.mapper.selectByExample(example);
    }

    public Charge findOneByAccountname(String accountname) {
        ChargeExample example = new ChargeExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andAccountnameEqualTo(accountname);
        return this.mapper.selectOneByExample(example);
    }

    public Charge findOneByCoin(Integer coin) {
        ChargeExample example = new ChargeExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andCoinEqualTo(coin);
        return this.mapper.selectOneByExample(example);
    }

    public Charge findOneByState(Integer state) {
        ChargeExample example = new ChargeExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andStateEqualTo(state);
        return this.mapper.selectOneByExample(example);
    }

    public Charge findOneByMoney(Integer money) {
        ChargeExample example = new ChargeExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andMoneyEqualTo(money);
        return this.mapper.selectOneByExample(example);
    }

    public Charge findOneByCode(String code) {
        ChargeExample example = new ChargeExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andCodeEqualTo(code);
        return this.mapper.selectOneByExample(example);
    }

    public List<Charge> findAll(int page, int size, String sort, String order) {
        ChargeExample example = new ChargeExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, size);
        return this.mapper.selectByExample(example);
    }

    public List<Charge> findAll() {
        ChargeExample example = new ChargeExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        return this.mapper.selectByExample(example);
    }
}
