package com.cache;

import com.cache.evictionpolicies.EvictionPolicy;
import com.cache.exception.StorageFullException;
import com.cache.storage.Storage;

public class CacheManager<Key, Value> {

    private final EvictionPolicy<Key, Value> evictionPolicy;
    private final  Storage<Key, Value> storage;

    public CacheManager(EvictionPolicy<Key, Value> evictionPolicy, Storage<Key, Value> storage) {
        this.evictionPolicy = evictionPolicy;
        this.storage = storage;
    }

    public void put(Key key, Value value) {
        try {
            this.storage.add(key, value);
            evictionPolicy.keyAccessed(key);
        } catch (StorageFullException e) {
            e.printStackTrace();
            Key keyToRemove = evictionPolicy.evictKey();
            if (keyToRemove == null) {
                throw new RuntimeException("runtime exception");
            }
            this.storage.remove(keyToRemove);
            put(key, value);
        }
    }

    public Value get(Key key) {
        Value value = this.storage.get(key);
        evictionPolicy.keyAccessed(key);
        return value;
    }

}
