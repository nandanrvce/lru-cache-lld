package com.uditagarwal.cache.repository;

import com.uditagarwal.cache.model.AttributeValue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


//t1 -> attr1, v1 ->k1
//t2 -> attr1, v1 ->k2
public class InMemoryGenericSecondaryIndexStore <Key, Value>  implements ISecondaryIndexStore<Key,Value>{
    Map<Value, List<Key>> index;
    public void index(Key key, Value value) {
        synchronized (value) {
            List<Key> storedKeys = index.get(value);
            if (storedKeys == null) {
                storedKeys = new ArrayList<>();
            }

            storedKeys.add(key);
            index.put(value, storedKeys);
        }
    }

    public List<Key> findMatchingKeys(Value value) {
        return index.get(value);
    }

}
