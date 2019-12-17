package com.cool.wendao.data.impl;

import cn.hutool.cache.CacheUtil;
import cn.hutool.cache.impl.TimedCache;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cool.wendao.community.server.CacheService;
import org.apache.commons.lang3.StringUtils;

import java.util.LinkedList;
import java.util.List;

@Service
public class CacheServiceImpl implements CacheService {

    private TimedCache<String, String> timedCache;

    //默认失效实现  60分钟
    private long timeout = 60 * 60 * 1000;


    public CacheServiceImpl() {
        timedCache = CacheUtil.newTimedCache(timeout);
        timedCache.schedulePrune(1000);
    }

    @Override
    public <T> T getCache(String code, Class<T> clazz) {
        try {
            String data = timedCache.get(code);
            if(StringUtils.isNotBlank(data)){
                return JSONObject.parseObject(data,clazz);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public <T> List<T> getCacheList(String code, Class<?> clazz) {
        try {
            String data = timedCache.get(code);
            if(StringUtils.isNotBlank(data)){
                return (List<T>)JSONArray.parseArray(data, clazz);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public <T> List<T> getCacheList(List<String> codes, Class<?> clazz) {
        try {
            List<String> values = new LinkedList<>();
            codes.forEach(key ->{
                values.add(timedCache.get(key));
            });
            JSONArray jsonArray = new JSONArray();
            for (String value : values) {
                if (value!=null) {
                    jsonArray.add(JSONObject.parseObject(value));
                }
            }
            return (List<T>) JSONArray.parseArray(jsonArray.toJSONString(), clazz);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void setCache(String code, Object data) {
        setCache(code, null, data);
    }

    @Override
    public void setCache(String code, Long seconds, Object data) {
        timedCache.put(code, JSONObject.toJSONString(data),seconds);
    }

    @Override
    public void batchSetCache(String code, Long seconds, List data) {
        timedCache.put(code, JSONObject.toJSONString(data),seconds);
    }

    @Override
    public void batchSetCache(List<String> code, List data) {
        for (String s : code) {
            setCache(s, null, data);
        }
    }

    @Override
    public void deleteCache(String code) {
        timedCache.remove(code);
    }

    @Override
    public void deleteCache(List<String> codes) {
        for (String code : codes) {
            timedCache.remove(code);
        }
    }
}
