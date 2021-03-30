package com.kcy.cook.serviceImpl;

import com.kcy.cook.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class CacheServiceImpl implements CacheService {
    @Autowired
    RedisTemplate redisTemplate;

    @Override
    public void putToCache(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    @Override
    public Object getFromCache(String key) {
        return redisTemplate.opsForValue().get(key);
    }
}
