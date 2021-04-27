package com.cache.evictionpolicies;

import com.cache.model.DoublyLinkedList;
import com.cache.model.DoublyLinkedListNode;

import java.util.Map;

public class LRUEvictionPolicy<Key, Value> implements EvictionPolicy<Key, Value> {

    private final Map<Key, DoublyLinkedListNode> hashMap;
    private final DoublyLinkedList<Key> dll;

    public LRUEvictionPolicy(Map<Key, DoublyLinkedListNode> hashMap, DoublyLinkedList<Key> dll) {
        this.hashMap = hashMap;
        this.dll = dll;
    }

    //private
    @Override
    public void keyAccessed(Key key) {
        if (hashMap.containsKey(key)) {
            dll.detachNode(hashMap.get(key));
            dll.attachNodeAtLast(hashMap.get(key));
        } else {
            DoublyLinkedListNode<Key> doublyLinkedListNode = new DoublyLinkedListNode<>(key);
            dll.attachNodeAtLast(doublyLinkedListNode);
            hashMap.put(key, doublyLinkedListNode);
        }


    }

    @Override
    public Key evictKey() {
        DoublyLinkedListNode<Key> doublyLinkedListNode = dll.detachNodeAtFirst();
        if (doublyLinkedListNode != null) {
            hashMap.remove(doublyLinkedListNode.getValue());
            return doublyLinkedListNode.getValue();
        }
        return null;
    }
}
