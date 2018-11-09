package com.kmc.producer.redis;

import java.util.List;
import java.util.Set;

/**
 * @author 武海升
 * @date 2018/11/2 13:54
 */
public interface IRedisService {

    /**
     * 验证redis是否存在key
     * @param key
     * @return
     */
    boolean keyExists(String key);

    /**
     * 设置redis值
     * @param key
     * @param value
     * @return
     */
    boolean addToRedis(String key, String value );

    /**
     * 设置redis值并设置存活时间
     * @param key
     * @param value
     * @param expire 秒 key存活时间
     * @return
     */
    boolean addToRedis(String key, String value, Long  expire);

    /**
     * 通过key获取redis值
     * @param key
     * @return
     */
    String getRedisValueByKey(String key);

    /**
     * 通过key删除value
     * @param key
     * @return
     */
    void  deleteRedisValueByKey(String key);
    /**
     * 通过keys删除value
     * @param keys
     * @return
     */
    void  deleteRedisValueByKeys(String... keys);

    /**
     * get
     * @param key
     * @param field
     * @return
     */
    Object hGet(String key ,Object  field);

    /**
     * set
     * @param key
     * @param field
     * @param value
     * @return
     */
    void hSet(String key ,Object  field ,Object  value);

    /**
     * 添加list
     * @param key
     * @param value
     */
    void addListToRedis(String key,String value);

    /**
     * 获取List
     * @param key
     * @param min 角标下限
     * @param max 角标上限
     * @return
     */
    List<String> getListFromRedis(String key, Long min, Long max);

    /**
     * 添加list
     * @param key
     * @param value
     */
    void addSetToRedis(String key,String value);

    /**
     * 获取List
     * @param key
     * @return
     */
    Set<String> getSetFromRedis(String key);

}
