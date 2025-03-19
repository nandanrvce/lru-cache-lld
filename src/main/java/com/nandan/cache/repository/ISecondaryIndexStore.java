package com.nandan.cache.repository;

import java.util.List;

public interface ISecondaryIndexStore<Key, Value> {
    void index(Key key, Value value);
    List<Key> findMatchingKeys(Value value);
}
