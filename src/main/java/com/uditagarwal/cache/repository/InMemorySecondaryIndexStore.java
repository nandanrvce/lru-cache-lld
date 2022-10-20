package com.uditagarwal.cache.repository;

import com.uditagarwal.cache.model.AttributeValue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class InMemorySecondaryIndexStore {
    Map<AttributeValue, List<String>> secondaryIndex;

    public void index(String key, List<AttributeValue> attributeValues) {
        for (AttributeValue attributeValue: attributeValues) {
            List<String> currentKeys = secondaryIndex.get(attributeValue);
            if (currentKeys == null) {
                currentKeys = new ArrayList<>();
            }
            currentKeys.add(key);
        }
    }

    public List<String> findMatchingKeys(AttributeValue attributeValue) {
        return secondaryIndex.get(attributeValue);
    }
}
