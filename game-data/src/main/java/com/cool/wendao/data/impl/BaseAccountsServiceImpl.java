package com.cool.wendao.data.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.cool.wendao.community.core.Deleted;
import com.cool.wendao.community.enums.CacheEnum;
import com.cool.wendao.community.model.Accounts;
import com.cool.wendao.community.server.BaseAccountsService;
import com.cool.wendao.community.server.CacheService;
import com.cool.wendao.data.dao.AccountsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;

@Service
public class BaseAccountsServiceImpl implements BaseAccountsService {

    @Autowired
    private AccountsMapper accountsMapper;

    @Autowired
    private CacheService cacheService;

    @Override
    public Accounts findOneByName(String account) {
        Example example = new Example(Accounts.class);
        example.createCriteria().andCondition("deleted=", Deleted.NOT_DELETED.value()).andCondition("name=", account);
        return accountsMapper.selectOneByExample(example);
    }

    @Override
    public int add(Accounts accounts) {
        accounts.setAddTime(new Date());
        accounts.setUpdateTime(new Date());
        return accountsMapper.insertSelective(accounts);
    }

    @Override
    public Accounts findById(Integer accountId) {
        return accountsMapper.selectByPrimaryKey(accountId);
    }

    @Override
    public int updateById(Accounts accounts) {
        accounts.setUpdateTime(new Date());
        return accountsMapper.updateByPrimaryKeySelective(accounts);
    }

    @Override
    public Accounts findOneByToken(String token) {
        Accounts cache = cacheService.getCache(CacheEnum.USER_TOKEN.getName() + token, Accounts.class);
        if (cache == null) {
            return null;
        }
        return accountsMapper.selectByPrimaryKey(cache.getId());
    }
}
