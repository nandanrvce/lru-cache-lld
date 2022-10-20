package com.uditagarwal.cache.service;

import com.uditagarwal.cache.model.AttributeValue;
import com.uditagarwal.cache.repository.ICacheStore;

import java.util.List;

public class SingleKeyValueCacheService {
    private ICacheStore<String, String> cacheStore;

    public void store(String key, String value)  {
        cacheStore.store(key, value);
    }

    public String get(String key) {
        return cacheStore.get(key);
    }

    public void delete(String key) {
        cacheStore.delete(key);
    }

}
