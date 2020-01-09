//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.wx.web;

import cn.hutool.core.util.IdUtil;
import com.cool.wendao.community.model.Accounts;
import com.cool.wendao.community.server.BaseAccountsService;
import com.cool.wendao.community.server.CacheService;
import com.reger.dubbo.annotation.Inject;
import org.linlinjava.litemall.core.util.DesUtil;
import org.linlinjava.litemall.core.util.JSONUtils;
import org.linlinjava.litemall.wx.util.PathZip;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping
@Validated
public class WdAuthController {

    @Inject
    private BaseAccountsService baseAccountsService;

    @Inject
    private CacheService cacheService;

    @Value("${netty.ip}")
    private String ip;

    @Value("${netty.url}")
    private String url;

    public WdAuthController() {
    }

    @GetMapping({"/vip4/192111/d"})
    public Object d() {
        Map<String, Object> data = new HashMap();
        List list = new ArrayList();
        list.add(url);
        list.add(url);
        list.add(url);
        data.put("host", url);
        data.put("ips", list);
        data.put("ttl", 17);
        data.put("origin_ttl", 100);
        return data;
    }

    @GetMapping({"/vip4/atm/g-bits//version.php"})
    public Object android1() {
        return "20290209.38";
    }

    @GetMapping({"/vip4/atm/g-bits/version.php"})
    public Object android2() {
        return "20290209.38";
    }

    @GetMapping({"/vip4/atm/g-bits/get_patch.php"})
    public void get_patch(HttpServletRequest request, HttpServletResponse response) throws Exception {
        PathZip.patch(request, response);
    }

    @GetMapping({"/vip4/mobile/sdk/register.php"})
    public Object bindPhone(String account, String pwd, String safe, String check, HttpSession session) {
        Map<String, Object> data = new HashMap();
        Object verifyCode = session.getAttribute("verifyCode");
        if (verifyCode == null || !verifyCode.toString().equals(check)) {
            data.put("IsSuccess", false);
            data.put("Msg", "验证码异常");
            return data;
        }

        Accounts accounts = this.baseAccountsService.findOneByName(account);
        if (accounts != null) {
            data.put("IsSuccess", false);
            data.put("Msg", "账号已经存在！");
        } else {
            data.put("IsSuccess", true);
            data.put("Msg", "账号注册成功，请返回界面登录。！");
            accounts = new Accounts();
            accounts.setName(account);
            accounts.setPassword(pwd);
            accounts.setKeyword(safe);
            accounts.setCode(check.toUpperCase());
            accounts.setToken(utest());
            this.baseAccountsService.add(accounts);
//            accounts = this.baseAccountsService.findById(accounts.getId());
//            cacheService.setCache(CacheEnum.USER_TOKEN.getName() + uuid,CacheEnum.USER_TOKEN.getTime(), accounts);
        }

        return data;
    }

    public static String json(String body, String arr) {
        String[] strs = body.split("&");
        for (String str : strs) {
            String[] strss = str.split("=");
            if (arr.equals(strss[0])) {
                try {
                    return strss[1];
                } catch (Exception e) {
                    return "";
                }
            }
        }

        return "";
    }


    @PostMapping({"/vip4/login/login.php"})
    public Object login(@RequestBody String body) {
        String account = json(body, "username");
        String pwd = json(body, "userpwd");
        pwd = DesUtil.decrypt(pwd, "leiting");
        Map<String, Object> data = new HashMap();
        Accounts accounts = this.baseAccountsService.findOneByName(account);
        if (accounts == null) {
            data.put("message", "账号不存在!");
            data.put("status", "fail");
            data.put("type", "10001");
        } else if (!accounts.getPassword().equals(pwd)) {
            data.put("message", "密码错误!!");
            data.put("status", "fail");
            data.put("type", "10001");
        } else {

//            String uuid = utest();
            accounts = this.baseAccountsService.findById(accounts.getId());
//            cacheService.setCache(CacheEnum.USER_TOKEN.getName() + uuid, CacheEnum.USER_TOKEN.getTime(),accounts);

            Map<String, Object> message = new HashMap();
            message.put("token", accounts.getToken());
            message.put("realNameAuth", "1");
            message.put("sid", accounts.getToken());
            message.put("adult", "1");
            message.put("age", 32);
            message.put("bind", "1");
            message.put("registTime", "1558317799000");
            message.put("timestamp", System.currentTimeMillis() + "");
            data.put("message", JSONUtils.toJSONString(message));
            data.put("status", "success");
            data.put("type", "1");
        }

        return data;
    }

    @PostMapping({"/vip4/login/mobile!mobileCheckLoginV3.php"})
    public Object motionLogin(@RequestBody String body) {
        String account = json(body, "username");
        String pwd = json(body, "token");
        Map<String, Object> data = new HashMap();
        Accounts accounts = this.baseAccountsService.findOneByName(account);
        if (accounts == null) {
            data.put("message", "账号不存在!");
            data.put("status", "fail");
            data.put("type", "10001");
        } else if (!accounts.getToken().equals(pwd)) {
            data.put("message", "密码错误!!");
            data.put("status", "fail");
            data.put("type", "10001");
        } else {

//            String uuid = utest();
            accounts = this.baseAccountsService.findById(accounts.getId());
//            cacheService.setCache(CacheEnum.USER_TOKEN.getName() + uuid, CacheEnum.USER_TOKEN.getTime(),accounts);

            Map<String, Object> message = new HashMap();
            message.put("token", accounts.getToken());
            message.put("realNameAuth", "1");
            message.put("sid", accounts.getToken());
            message.put("adult", "1");
            message.put("age", 32);
            message.put("bind", "1");
            message.put("registTime", "1558317799000");
            message.put("timestamp", System.currentTimeMillis() + "");
            data.put("message", JSONUtils.toJSONString(message));
            data.put("status", "success");
            data.put("type", "1");
        }

        return data;
    }

    public static String utest() {
        return IdUtil.fastSimpleUUID();
    }


}
