package com.kcy.cook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class CacheService {
    @Autowired
    RedisTemplate redisTemplate;

    public void putToCache(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public Object getFromCache(String key) {
        return redisTemplate.opsForValue().get(key);
    }
}
