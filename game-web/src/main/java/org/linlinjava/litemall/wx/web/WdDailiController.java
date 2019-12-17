//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.wx.web;

import com.alibaba.fastjson.JSONObject;
import com.cool.wendao.community.model.Daili;
import com.cool.wendao.community.model.Notice;
import com.cool.wendao.community.server.BaseDailiService;
import com.cool.wendao.community.server.BaseNoticeService;
import com.cool.wendao.community.server.CustomDailiService;
import com.reger.dubbo.annotation.Inject;
import org.linlinjava.litemall.core.util.JacksonUtil;
import org.linlinjava.litemall.core.util.ResponseUtil;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController
@RequestMapping
@Validated
public class WdDailiController {
    private static final String ADMIN_TOKEN = "tasdjbaqwuibzxcvnbibasouwerka";
    public static final List<String> zimu = new CopyOnWriteArrayList();

    static {
        zimu.add("A");
        zimu.add("B");
        zimu.add("C");
        zimu.add("D");
        zimu.add("E");
        zimu.add("F");
        zimu.add("G");
        zimu.add("H");
        zimu.add("I");
        zimu.add("J");
        zimu.add("K");
        zimu.add("L");
        zimu.add("M");
        zimu.add("N");
        zimu.add("O");
        zimu.add("P");
        zimu.add("Q");
        zimu.add("R");
        zimu.add("S");
        zimu.add("T");
        zimu.add("U");
        zimu.add("V");
        zimu.add("W");
        zimu.add("X");
        zimu.add("Y");
        zimu.add("Z");
    }

    @Inject
    private BaseNoticeService baseNoticeService;

    @Inject
    private BaseDailiService baseDailiService;

    @Inject
    private CustomDailiService customDailiService;


    private static boolean charge;

    public WdDailiController() {
    }

    @PostMapping({"login"})
    public Object login(@RequestBody String body, HttpServletRequest request) {
        String username = JacksonUtil.parseString(body, "account");
        String password = JacksonUtil.parseString(body, "password");
        if (username != null && password != null) {
            HashMap<Object, Object> data = new HashMap();
            ArrayList<Map> list = new ArrayList();
            List<Map> maps;
            if (username.equals("QWERASDF1234") && password.equals("123QWEASD")) {
                for (String zm : zimu) {
                    maps =  this.customDailiService.selectAccount(zm);
                    maps.forEach(map ->{
                        JSONObject jsonObject = new JSONObject(map);
                        HashMap hashMap = new HashMap();
                        hashMap.put("code", jsonObject.get("code"));
                        hashMap.put("number", jsonObject.getIntValue("num"));
                        list.add(hashMap);
                    });
                }
                data.put("name", username);
                data.put("list", list);
                data.put("token", "tasdjbaqwuibzxcvnbibasouwerka");
                data.put("isAdmin", true);
                data.put("number", 0);
                data.put("canGiveCount", 0);
            } else {
                Daili daili = this.baseDailiService.findOneByAccount(username);
                if (daili == null || !daili.getPasswd().equals(password)) {
                    return ResponseUtil.fail();
                }
                String uuid = UUID.randomUUID().toString();
                daili.setToken(uuid);
                this.baseDailiService.updateById(daili);
                HashMap hashMap = new HashMap();
                maps = this.customDailiService.selectAccount(username);
                for (Map map : maps) {
                    hashMap.put("code", map.get("code"));
                    hashMap.put("number", map.get("num"));
                    list.add(hashMap);
                }
                data.put("name", username);
                data.put("list", list);
                data.put("token", uuid);
                data.put("isAdmin", false);
                data.put("code", username);
                data.put("canGiveCount", 0);
            }

            return ResponseUtil.ok(data);
        } else {
            return ResponseUtil.badArgument();
        }
    }

    @PostMapping({"message"})
    public Object message(@RequestBody String body, HttpServletRequest request) {
        String message = JacksonUtil.parseString(body, "message");
        String token = JacksonUtil.parseString(body, "token");
        if (!token.equals("tasdjbaqwuibzxcvnbibasouwerka")) {
            return ResponseUtil.fail();
        } else {
            int time = JacksonUtil.parseInteger(body, "time");
            Notice notice = this.baseNoticeService.findById(1);
            notice.setTime(time);
            notice.setMessage(message);
            this.baseNoticeService.updateById(notice);
            return ResponseUtil.ok();
        }
    }

    @PostMapping({"append1"})
    public Object append(@RequestBody String body, HttpServletRequest request) {
        String count = JacksonUtil.parseString(body, "count");
        String appendName = JacksonUtil.parseString(body, "appendName");
        String token = JacksonUtil.parseString(body, "token");
        if (!token.equals("tasdjbaqwuibzxcvnbibasouwerka")) {
            return ResponseUtil.fail();
        } else {
            HashMap<Object, Object> data = new HashMap();
            data.put("canGiveCount", 0);
            return ResponseUtil.ok(data);
        }
    }

    @PostMapping({"select"})
    public Object select(@RequestBody String body, HttpServletRequest request) {
        String count = JacksonUtil.parseString(body, "count");
        int day = JacksonUtil.parseInteger(body, "day");
        if (day == 3) {
            day = 2;
        }

        String token = JacksonUtil.parseString(body, "token");
        ArrayList<Map> list = new ArrayList();
        HashMap zidaihashMap;
        if (token.equals("tasdjbaqwuibzxcvnbibasouwerka")) {
            HashMap hashMap = new HashMap();
            hashMap.put("countTotal", 1);
            hashMap.put("code", "管理员");
            ArrayList<Map> listin = new ArrayList();
            hashMap.put("list", listin);
            list.add(hashMap);
            int alltotal = 0;
            for (String zm : zimu) {
                List<Map> maps = this.customDailiService.selectMoney(zm, day - 1);
                int total = 0;
                int num;
                for(Iterator var14 = maps.iterator(); var14.hasNext(); alltotal += num) {
                    Map map = (Map)var14.next();
                    Object numobj = map.get("num");
                    num = Integer.valueOf(numobj.toString());
                    total += num;
                }
                zidaihashMap = new HashMap();
                listin.add(zidaihashMap);
                zidaihashMap.put("code", zm);
                zidaihashMap.put("count", total);
            }
            hashMap.put("countTotal", alltotal);
        } else {
            Daili daili = this.baseDailiService.findOneByToken(token);
            HashMap hashMap = new HashMap();
            hashMap.put("code", daili.getAccount());
            ArrayList<Map> listin = new ArrayList();
            hashMap.put("list", listin);
            list.add(hashMap);
            List<Map> maps = this.customDailiService.selectMoney(daili.getAccount(), day - 1);
            int total = 0;
            Iterator var23 = maps.iterator();

            while(var23.hasNext()) {
                Map map = (Map)var23.next();
                zidaihashMap = new HashMap();
                listin.add(zidaihashMap);
                zidaihashMap.put("code", map.get("code"));
                Object numobj = map.get("num");
                int num = Integer.valueOf(numobj.toString());
                total += num;
                zidaihashMap.put("count", num);
            }

            hashMap.put("countTotal", total);
        }

        return ResponseUtil.ok(list);
    }

    @PostMapping({"search"})
    public Object search(@RequestBody String body, HttpServletRequest request) {
        String token = JacksonUtil.parseString(body, "token");
        HashMap<Object, Object> data = new HashMap();
        data.put("popen", charge ? 1 : 0);
        return ResponseUtil.ok(data);
    }

    @PostMapping({"/popen"})
    public Object popen(@RequestBody String body, HttpServletRequest request) {
        String token = JacksonUtil.parseString(body, "token");
        if (!token.equals("tasdjbaqwuibzxcvnbibasouwerka")) {
            return ResponseUtil.ok();
        } else {
            String popen = JacksonUtil.parseString(body, "popen");
            if (popen.equals("0")) {
                charge = false;
            } else {
                charge = true;
            }

            HashMap<Object, Object> data = new HashMap();
            data.put("popen", popen);
            return ResponseUtil.ok();
        }
    }

    @PostMapping({"appendCount"})
    public Object appendCount(@RequestBody String body, HttpServletRequest request) {
        String token = JacksonUtil.parseString(body, "token");
        String count = JacksonUtil.parseString(body, "count");
        String code = JacksonUtil.parseString(body, "code");
        return ResponseUtil.ok();
    }

    public static String getUUID() {
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
