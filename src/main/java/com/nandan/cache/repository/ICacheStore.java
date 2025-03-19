package com.nandan.cache.repository;

public interface ICacheStore<Key, Value> {
    void store(Key key, Value value);

    Value get(Key key);

    void delete(Key key);
}
