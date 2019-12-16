//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.wx.web;

import com.cool.wendao.community.model.Accounts;
import com.cool.wendao.community.server.BaseAccountsService;
import com.reger.dubbo.annotation.Inject;
import org.linlinjava.litemall.core.util.DesUtil;
import org.linlinjava.litemall.core.util.JSONUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

@RestController
@RequestMapping
@Validated
public class WdAuthController {

    @Inject
    private BaseAccountsService baseAccountsService;

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
        list.add("url");
        list.add("url");
        list.add("url");
        data.put("host", "url");
        data.put("ips", list);
        data.put("ttl", 17);
        data.put("origin_ttl", 100);
        return data;
    }

    @GetMapping({"/vip4/atm/g-bits//version.php"})
    public Object android() {
        String s = "20290209.38";
        return s;
    }

    @GetMapping({"/vip4/atm/g-bits/get_patch.php"})
    public Object get_patch() {
        ModelAndView modelAndView = new ModelAndView("redirect:/vip4/atm/g-bits/patch.zip");
        return modelAndView;
    }

    @GetMapping({"/vip4/mobile/sdk/register.php"})
    public Object bindPhone(String account, String pwd, String safe, String check) {
        Map<String, Object> data = new HashMap();
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
            String uuid = utest();
            accounts.setToken(uuid);
            this.baseAccountsService.add(accounts);
        }

        return data;
    }

    public static String json(String body, String arr) {
        String[] strs = body.split("&");
        Map<String, String> map = new HashMap();

        for(int i = 0; i < strs.length; ++i) {
            String[] strss = strs[i].split("=");
            map.put(strss[0], strss[1]);
        }

        return (String)map.get(arr);
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
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    public static String md5(String plainText) {
        Object var1 = null;

        byte[] secretBytes;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plainText.getBytes());
            secretBytes = md.digest();
        } catch (NoSuchAlgorithmException var4) {
            throw new RuntimeException("没有md5这个算法！");
        }

        String md5code = (new BigInteger(1, secretBytes)).toString(16);

        for(int i = 0; i < 32 - md5code.length(); ++i) {
            md5code = "0" + md5code;
        }

        return md5code;
    }
}
