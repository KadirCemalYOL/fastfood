package com.kcy.cashier.service;

public interface CacheService {
    void putToCache(String key, Object value);

    Object getFromCache(String key);

    boolean removeFromCache(String key);
}
