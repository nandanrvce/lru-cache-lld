package com.uditagarwal.cache.service;

import com.uditagarwal.cache.model.AttributeValue;
import com.uditagarwal.cache.repository.ICacheStore;
import com.uditagarwal.cache.repository.ISecondaryIndexStore;
import com.uditagarwal.cache.strategy.IValidator;

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
