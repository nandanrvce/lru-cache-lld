package com.nandan.cache.service;

import com.nandan.cache.repository.ICacheStore;

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
