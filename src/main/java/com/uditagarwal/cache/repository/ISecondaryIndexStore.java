package com.uditagarwal.cache.repository;

import com.uditagarwal.cache.model.AttributeValue;

import java.util.List;

public interface ISecondaryIndexStore<Key, Value> {
    void index(Key key, Value value);
    List<Key> findMatchingKeys(Value value);
}
