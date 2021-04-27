package com.cache.evictionpolicies;

public interface EvictionPolicy<Key, Value> {

    void keyAccessed(Key key);

    Key evictKey();
}
