package com.cache.storage;

import com.cache.exception.StorageFullException;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class MapBasedStorage<Key, Value> implements Storage<Key, Value> {

    Map<Key, Value> hashMap;

    public MapBasedStorage() {
        this.hashMap = new HashMap<>();
    }

    @Override
    public void add(Key key, Value value) throws StorageFullException {
        hashMap.put(key, value);

    }

    @Override
    public Value get(Key key) {
        return hashMap.get(key);
    }

    @Override
    public void remove(Key key) {
        hashMap.remove(key);
    }
}
