package com.cool.wendao.manager.business.notice.controller;


import com.alibaba.fastjson.JSONObject;
import com.cool.wendao.admin.core.MgtPageBean;
import com.cool.wendao.admin.core.ResultBean;
import com.cool.wendao.community.model.Notice;
import com.cool.wendao.community.server.BaseNoticeService;
import com.reger.dubbo.annotation.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@Controller
@RequestMapping("business/notice")
public class NoticeController {


    @Inject
    private BaseNoticeService baseNoticeService;

    @GetMapping("notice_index")
    public void index(HttpServletRequest request) {
    }

    @GetMapping("notice_add")
    public void noticeAdd(HttpServletRequest request, Integer id) {
        if (id != null) {
            Notice notice = baseNoticeService.findById(id);
            if (notice != null) {
                request.setAttribute("notice", notice);
            }
        }

    }

    @GetMapping("notice_data")
    @ResponseBody
    public MgtPageBean<Notice> noticeData(String message, MgtPageBean<Notice> pageBean) {
        pageBean.setWhere(new HashMap<>(1));
        pageBean.getWhere().put("message", message);
        return baseNoticeService.findByPageBean(pageBean);
    }

    @PostMapping("notice_save")
    @ResponseBody
    public ResultBean noticeAddPost(@RequestBody JSONObject jsonObject) {
        Notice notice = jsonObject.toJavaObject(Notice.class);
        if (notice.getTime() == null || notice.getTime() <= 0) {
            notice.setTime(5);
        }

        if (notice.getId() == null) {
            return baseNoticeService.noticeAdd(notice);
        } else {
            baseNoticeService.updateById(notice);
            return ResultBean.SUCCESS();
        }
    }

    @GetMapping("notice_delete")
    @ResponseBody
    public ResultBean noticeDelete(int id) {
        Notice notice = new Notice();
        notice.setId(id);
        notice.setDeleted(1);
        baseNoticeService.updateById(notice);
        return ResultBean.SUCCESS();
    }


}
