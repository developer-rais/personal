package com.cache.factories;

import com.cache.CacheManager;
import com.cache.evictionpolicies.EvictionPolicy;
import com.cache.evictionpolicies.LRUEvictionPolicy;
import com.cache.model.DoublyLinkedList;
import com.cache.storage.MapBasedStorage;

import java.util.HashMap;

public class CacheFactory<Key, Value> {

    public CacheManager<Key, Value> getLRUCacheManager(long capacity) {

        EvictionPolicy evictionPolicy = new LRUEvictionPolicy(new HashMap(), new DoublyLinkedList(capacity));
        return new CacheManager<Key, Value>(evictionPolicy, new MapBasedStorage());
    }
}
