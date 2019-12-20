package org.linlinjava.litemall.core.util;


import com.alibaba.fastjson.JSONObject;


public class JSONUtils {
    /**
     * 将对象转成json字符串
     */
    public static String toJSONString(Object data) {
        return JSONObject.toJSONString(data);
    }

    public static <T> T parseObject(String jsonData, Class<T> beanType) {
        return JSONObject.parseObject(jsonData,beanType);
    }
}
