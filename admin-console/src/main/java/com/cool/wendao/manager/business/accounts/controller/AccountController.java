package com.cool.wendao.manager.business.accounts.controller;


import com.cool.wendao.admin.core.MgtPageBean;
import com.cool.wendao.admin.core.ResultBean;
import com.cool.wendao.community.model.Accounts;
import com.cool.wendao.community.server.BaseAccountsService;
import com.reger.dubbo.annotation.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@Controller
@RequestMapping("business/accounts")
public class AccountController {

    @Inject
    private BaseAccountsService baseAccountsService;


    @GetMapping("accounts_index")
    public void index(HttpServletRequest request) {
    }

    @GetMapping("accounts_data")
    @ResponseBody
    public MgtPageBean<Accounts> noticeData(String name, MgtPageBean<Accounts> pageBean) {
        pageBean.setWhere(new HashMap<>(1));
        pageBean.getWhere().put("name", name);
        return baseAccountsService.findByPageBean(pageBean);
    }

    @GetMapping("accounts_delete")
    @ResponseBody
    public ResultBean accountsDelete(int id) {
        Accounts accounts = new Accounts();
        accounts.setId(id);
        accounts.setDeleted(1);
        baseAccountsService.updateById(accounts);
        return ResultBean.SUCCESS();
    }


    @GetMapping("accounts_block")
    @ResponseBody
    public ResultBean accountsBlock(int id,int block) {
        Accounts accounts = new Accounts();
        accounts.setId(id);
        accounts.setBlock(block);
        baseAccountsService.updateById(accounts);
        return ResultBean.SUCCESS();
    }

}
