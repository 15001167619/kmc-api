package com.kmc.producer.redis.impl;

import com.kmc.producer.redis.IRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author 武海升
 * @date 2018/11/2 13:56
 */
@SuppressWarnings("unchecked")
@Service
public class RedisServiceImpl implements IRedisService {

    private final StringRedisTemplate redisTemplate;

    @Autowired
    public RedisServiceImpl(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public boolean keyExists(String key) {
        return redisTemplate.hasKey(key);
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean addToRedis(String key, String value) {
        boolean result = false;
        try {
            ValueOperations<String, String> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean addToRedis(String key, String value, Long expire) {
        boolean result = false;
        try {
            ValueOperations<String, String> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            redisTemplate.expire(key, expire, TimeUnit.SECONDS);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String getRedisValueByKey(String key) {
        Object result;
        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        result = operations.get(key);
        return result==null?null:result.toString();
    }

    @Override
    public void deleteRedisValueByKey(String key) {
        Set<String> keys = redisTemplate.keys(key);
        if (keys!=null && keys.size() > 0){
            redisTemplate.delete(keys);
        }
    }

    @Override
    public void deleteRedisValueByKeys(String... keys) {
        for (String key : keys) {
            remove(key);
        }
    }

    @Override
    public Object hGet(String key, Object field) {
        HashOperations<String, Object, Object> hash = redisTemplate.opsForHash();
        return hash.get(key,field);
    }

    @Override
    public void hSet(String key, Object field, Object value) {
        HashOperations<String, Object, Object> hash = redisTemplate.opsForHash();
        hash.put(key,field,value);
    }

    @Override
    public void addListToRedis(String key, String value) {
        ListOperations<String, String> list = redisTemplate.opsForList();
        list.rightPush(key,value);
    }

    @Override
    public List<String> getListFromRedis(String key, Long min, Long max) {
        ListOperations<String, String> list = redisTemplate.opsForList();
        return list.range(key,min,max);
    }

    @Override
    public void addSetToRedis(String key, String value) {
        SetOperations<String, String> set = redisTemplate.opsForSet();
        set.add(key,value);
    }

    @Override
    public Set<String> getSetFromRedis(String key) {
        SetOperations<String, String> set = redisTemplate.opsForSet();
        return set.members(key);
    }

    /**
     * 删除对应的value
     * @param key
     */
    public void remove(final String key) {
        if (exists(key)) {
            redisTemplate.delete(key);
        }
    }

    /**
     * 判断缓存中是否有对应的value
     * @param key
     * @return
     */
    public boolean exists(final String key) {
        return redisTemplate.hasKey(key);
    }
}
