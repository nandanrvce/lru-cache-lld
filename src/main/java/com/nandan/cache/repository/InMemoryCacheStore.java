package com.nandan.cache.repository;

import java.util.Map;

public class InMemoryCacheStore<Key, Value> implements ICacheStore<Key, Value> {
    Map<Key, Value> data;

    @Override
    public void store(Key key, Value value) {
        data.put(key, value);
    }

    public Value get(Key key) {
        return data.get(key);
    }

    public void delete(Key key) {
        data.remove(key);
    }
}
