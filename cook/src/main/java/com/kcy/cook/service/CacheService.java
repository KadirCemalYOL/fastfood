package com.kcy.cook.service;

public interface CacheService {
    void putToCache(String key, Object value);

    Object getFromCache(String key);
}
