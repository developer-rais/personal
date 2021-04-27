package com.cache.storage;

import com.cache.exception.StorageFullException;

public interface Storage<Key, Value> {
    public void add(Key key, Value value) throws StorageFullException;

    public Value get(Key key);

    public void remove(Key key);


}
