package com.cool.wendao.community.server;

import com.cool.wendao.community.model.Accounts;

public interface BaseAccountsService {
    Accounts findOneByName(String account);

    int add(Accounts accounts);

    Accounts findById(Integer accountId);

    int updateById(Accounts accounts);

    Accounts findOneByToken(String token);
}
