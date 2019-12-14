//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.service.base;

import com.github.pagehelper.PageHelper;
import java.time.LocalDateTime;
import java.util.List;
import org.linlinjava.litemall.db.dao.AccountsMapper;
import org.linlinjava.litemall.db.domain.Accounts;
import org.linlinjava.litemall.db.domain.example.AccountsExample;
import org.linlinjava.litemall.db.domain.example.AccountsExample.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class BaseAccountsService {
    @Autowired
    protected AccountsMapper mapper;

    public BaseAccountsService() {
    }

    @Cacheable(
            cacheNames = {"Accounts"},
            key = "#id"
    )
    public Accounts findById(int id) {
        return this.mapper.selectByPrimaryKeyWithLogicalDelete(id, false);
    }

    @Cacheable(
            cacheNames = {"Accounts"},
            key = "#id",
            condition = "#result.deleted == 0"
    )
    public Accounts findByIdContainsDelete(int id) {
        return this.mapper.selectByPrimaryKey(id);
    }

    public void add(Accounts accounts) {
        accounts.setAddTime(LocalDateTime.now());
        accounts.setUpdateTime(LocalDateTime.now());
        this.mapper.insertSelective(accounts);
    }

    @CachePut(
            cacheNames = {"Accounts"},
            key = "#accounts.id"
    )
    public int updateById(Accounts accounts) {
        accounts.setUpdateTime(LocalDateTime.now());
        return this.mapper.updateByPrimaryKeySelective(accounts);
    }

    @CacheEvict(
            cacheNames = {"Accounts"},
            key = "#id"
    )
    public void deleteById(int id) {
        this.mapper.logicalDeleteByPrimaryKey(id);
    }

    public List<Accounts> findByName(String name) {
        AccountsExample example = new AccountsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andNameEqualTo(name);
        return this.mapper.selectByExample(example);
    }

    public List<Accounts> findByKeyword(String keyword) {
        AccountsExample example = new AccountsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andKeywordEqualTo(keyword);
        return this.mapper.selectByExample(example);
    }

    public List<Accounts> findByPassword(String password) {
        AccountsExample example = new AccountsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andPasswordEqualTo(password);
        return this.mapper.selectByExample(example);
    }

    public List<Accounts> findByToken(String token) {
        AccountsExample example = new AccountsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andTokenEqualTo(token);
        return this.mapper.selectByExample(example);
    }

    public List<Accounts> findByChongzhijifen(Integer chongzhijifen) {
        AccountsExample example = new AccountsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andChongzhijifenEqualTo(chongzhijifen);
        return this.mapper.selectByExample(example);
    }

    public List<Accounts> findByChongzhiyuanbao(Integer chongzhiyuanbao) {
        AccountsExample example = new AccountsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andChongzhiyuanbaoEqualTo(chongzhiyuanbao);
        return this.mapper.selectByExample(example);
    }

    public List<Accounts> findByYaoqingma(String yaoqingma) {
        AccountsExample example = new AccountsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andYaoqingmaEqualTo(yaoqingma);
        return this.mapper.selectByExample(example);
    }

    public List<Accounts> findByBlock(Integer block) {
        AccountsExample example = new AccountsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andBlockEqualTo(block);
        return this.mapper.selectByExample(example);
    }

    public List<Accounts> findByCode(String code) {
        AccountsExample example = new AccountsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andCodeEqualTo(code);
        return this.mapper.selectByExample(example);
    }

    public Accounts findOneByName(String name) {
        AccountsExample example = new AccountsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andNameEqualTo(name);
        return this.mapper.selectOneByExample(example);
    }

    public Accounts findOneByKeyword(String keyword) {
        AccountsExample example = new AccountsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andKeywordEqualTo(keyword);
        return this.mapper.selectOneByExample(example);
    }

    public Accounts findOneByPassword(String password) {
        AccountsExample example = new AccountsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andPasswordEqualTo(password);
        return this.mapper.selectOneByExample(example);
    }

    public Accounts findOneByToken(String token) {
        AccountsExample example = new AccountsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andTokenEqualTo(token);
        return this.mapper.selectOneByExample(example);
    }

    public Accounts findOneByChongzhijifen(Integer chongzhijifen) {
        AccountsExample example = new AccountsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andChongzhijifenEqualTo(chongzhijifen);
        return this.mapper.selectOneByExample(example);
    }

    public Accounts findOneByChongzhiyuanbao(Integer chongzhiyuanbao) {
        AccountsExample example = new AccountsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andChongzhiyuanbaoEqualTo(chongzhiyuanbao);
        return this.mapper.selectOneByExample(example);
    }

    public Accounts findOneByYaoqingma(String yaoqingma) {
        AccountsExample example = new AccountsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andYaoqingmaEqualTo(yaoqingma);
        return this.mapper.selectOneByExample(example);
    }

    public Accounts findOneByBlock(Integer block) {
        AccountsExample example = new AccountsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andBlockEqualTo(block);
        return this.mapper.selectOneByExample(example);
    }

    public Accounts findOneByCode(String code) {
        AccountsExample example = new AccountsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andCodeEqualTo(code);
        return this.mapper.selectOneByExample(example);
    }

    public List<Accounts> findAll(int page, int size, String sort, String order) {
        AccountsExample example = new AccountsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, size);
        return this.mapper.selectByExample(example);
    }

    public List<Accounts> findAll() {
        AccountsExample example = new AccountsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        return this.mapper.selectByExample(example);
    }
}
