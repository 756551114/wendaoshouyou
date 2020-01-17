package com.cool.wendao.manager.business.blackList.controller;

import com.alibaba.fastjson.JSONObject;
import com.cool.wendao.admin.core.MgtPageBean;
import com.cool.wendao.admin.core.ResultBean;
import com.cool.wendao.community.model.BlackList;
import com.cool.wendao.community.server.BlackListService;
import com.reger.dubbo.annotation.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;


/**
 * 黑名单处理
 */
@Controller
@RequestMapping("business/blackList")
public class BlackListController {

    @Inject
    public BlackListService blackListService;

    @GetMapping("blackList_index")
    public void index(HttpServletRequest request) {
    }

    @GetMapping("blackList_add")
    public void blackListAdd(HttpServletRequest request, Integer id) {
        if (id != null) {
            BlackList blackList = blackListService.findById(id);
            if (blackList != null) {
                request.setAttribute("blackList", blackList);
            }
        }
    }

    @GetMapping("blackList_data")
    @ResponseBody
    public MgtPageBean<BlackList> blackListData(String name, MgtPageBean<BlackList> pageBean) {
        pageBean.setWhere(new HashMap<>(1));
        pageBean.getWhere().put("ip", name);
        return blackListService.findByPageBean(pageBean);
    }

    @PostMapping("blackList_save")
    @ResponseBody
    public ResultBean blackListAddPost(@RequestBody JSONObject jsonObject) {
        BlackList blackList = jsonObject.toJavaObject(BlackList.class);
        if (blackList.getId() == null) {
            return blackListService.blackListAdd(blackList);
        } else {
            blackListService.updateById(blackList);
            return ResultBean.SUCCESS();
        }
    }

    @GetMapping("blackList_delete")
    @ResponseBody
    public ResultBean blackListDelete(int id) {
        BlackList blackList = new BlackList();
        blackList.setId(id);
        blackList.setDeleted(1);
        blackListService.updateById(blackList);
        return ResultBean.SUCCESS();
    }


}
