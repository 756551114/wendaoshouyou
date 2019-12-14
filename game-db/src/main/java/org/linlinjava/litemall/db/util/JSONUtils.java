//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JSONUtils {
    private static final ObjectMapper mapper = new ObjectMapper();
    private static Logger log = LoggerFactory.getLogger(JSONUtils.class);

    public JSONUtils() {
    }

    public static String toJSONString(Object data) {
        String str = null;

        try {
            str = mapper.writeValueAsString(data);
        } catch (Exception var3) {
            log.error("data: " + data, var3);
        }

        return str;
    }

    public static <T> T parseObject(String jsonData, Class<T> beanType) {
        try {
            T t = mapper.readValue(jsonData, beanType);
            return t;
        } catch (Exception var3) {
            log.error("data: " + jsonData, var3);
            return null;
        }
    }
}
