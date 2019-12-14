//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

@Component
public class RedisUtils {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    public static final long DEFAULT_EXPIRE = 86400L;
    public static final long NOT_EXPIRE = -1L;

    public RedisUtils() {
    }

    public void set(String key, Object object) throws JsonProcessingException {
        this.set(key, object, 86400L);
    }

    public void set(String key, Object object, long expire) throws JsonProcessingException {
        ValueOperations<String, String> opsForValue = this.redisTemplate.opsForValue();
        if (expire == -1L) {
            opsForValue.set(key, this.toJson(object));
        } else {
            opsForValue.set(key, this.toJson(object), expire, TimeUnit.SECONDS);
        }

    }

    public <T> T get(String key, Class<T> clazz, long expire) {
        ValueOperations<String, String> opsForValue = this.redisTemplate.opsForValue();
        String value = (String)opsForValue.get(key);
        if (expire != -1L) {
            this.redisTemplate.expire(key, expire, TimeUnit.SECONDS);
        }

        return value == null ? null : this.fromJson(value, clazz);
    }

    public <T> T get(String key, Class<T> clazz) {
        return this.get(key, clazz, -1L);
    }

    public String get(String key, long expire) {
        ValueOperations<String, String> opsForValue = this.redisTemplate.opsForValue();
        String value = (String)opsForValue.get(key);
        if (expire != -1L) {
            this.redisTemplate.expire(key, expire, TimeUnit.SECONDS);
        }

        return value;
    }

    public String get(String key) {
        return this.get(key, -1L);
    }

    public void delete(String key) {
        this.redisTemplate.delete(key);
    }

    private String toJson(Object object) throws JsonProcessingException {
        return !(object instanceof Integer) && !(object instanceof Long) && !(object instanceof Float) && !(object instanceof Double) && !(object instanceof Boolean) && !(object instanceof String) ? JSONUtils.toJSONString(object) : String.valueOf(object);
    }

    private <T> T fromJson(String json, Class<T> clazz) {
        return JSONUtils.parseObject(json, clazz);
    }
}
