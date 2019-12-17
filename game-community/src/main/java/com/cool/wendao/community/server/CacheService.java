package com.cool.wendao.community.server;

import java.util.List;

public interface CacheService {

     <T> T getCache(String code, Class<T> clazz);

    /**
     * 返回集合对象   存储的数据为json
     *
     * @param code
     * @param clazz
     */
    @SuppressWarnings("unchecked")
     <T> List<T> getCacheList(String code, Class<?> clazz);

    /**
     * 返回集合对象   存储的数据为json
     *
     * @param codes
     * @param clazz
     */
    @SuppressWarnings("unchecked")
     <T> List<T> getCacheList(List<String> codes, Class<?> clazz);

    /**
     * 保存数据 以json数据存储
     * 不设置失效时间
     *
     * @param code
     * @param data
     * @return
     */
     void setCache(String code, Object data);

    /**
     * 保存数据 以json数据存储
     * 设置失效时间
     *
     * @param code
     * @param seconds
     * @param data
     * @return
     */
     void setCache(String code, Long seconds, Object data);

    /**
     * 保存数据 以json数据存储
     * 设置失效时间
     *
     * @param code
     * @param seconds
     * @param data
     * @return
     */
     void batchSetCache(String code, Long seconds, List data);

    /**
     * 保存数据 以json数据存储
     *
     * @param code
     * @param data
     * @return
     */
     void batchSetCache(List<String> code, List data);

    /**
     * 删除缓存
     *
     * @param code
     * @return
     */
     void deleteCache(String code);

    /**
     * 批量删除缓存
     *
     * @param codes
     * @return
     */
     void deleteCache(List<String> codes);
}