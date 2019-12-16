package org.linlinjava.litemall.core.util;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONUtils {

    private static final ObjectMapper mapper = new ObjectMapper();
    private static Logger log = LoggerFactory.getLogger(JSONUtils.class);

    /**
     * 将对象转成json字符串
     */
    public static String toJSONString(Object data) {
        String str = null;
        try {
            str = mapper.writeValueAsString(data);
        }
        catch (Exception e) {
            log.error("data: " + data, e);
        }
        return str;
    }

    public static <T> T parseObject(String jsonData, Class<T> beanType) {
        try {
            T t = mapper.readValue(jsonData, beanType);
            return t;
        }
        catch (Exception e) {
            log.error("data: " + jsonData, e);
        }
        return null;
    }
}
