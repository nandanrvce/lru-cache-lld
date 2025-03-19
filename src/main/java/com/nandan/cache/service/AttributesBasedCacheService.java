package com.nandan.cache.service;

import com.nandan.cache.repository.ICacheStore;
import com.nandan.cache.repository.ISecondaryIndexStore;
import com.nandan.cache.strategy.IValidator;
import com.nandan.cache.model.AttributeValue;

import java.util.List;

public class AttributesBasedCacheService {
    private ICacheStore<String, List<AttributeValue>> cacheStore;
    private ISecondaryIndexStore<String, AttributeValue> secondaryIndexStore;
    private List<IValidator> validators;

    public void store(String key, List<AttributeValue> values)  {

        cacheStore.store(key, values);

        for (AttributeValue attributeValue: values) {
            secondaryIndexStore.index(key, attributeValue);
        }
    }

    public List<AttributeValue> get(String key) {
        return cacheStore.get(key);
    }

    public void delete(String key) {
        cacheStore.delete(key);
    }

    public List<String> findMatchingKeys(AttributeValue attributeValue) {
        return secondaryIndexStore.findMatchingKeys(attributeValue);
    }
}
