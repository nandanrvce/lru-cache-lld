package com.uditagarwal.cache.repository;

import com.uditagarwal.cache.model.AttributeValue;

import java.util.List;

public interface ICacheStore<Key, Value> {
    void store(Key key, Value value);

    Value get(Key key);

    void delete(Key key);
}
