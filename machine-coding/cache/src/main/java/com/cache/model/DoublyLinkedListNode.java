package com.cache.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class DoublyLinkedListNode<T> {
    DoublyLinkedListNode<T> prev;
    DoublyLinkedListNode<T> next;
    T value;

    public DoublyLinkedListNode(T value) {
        this.value = value;
        this.prev = null;
        this.next = null;
    }

}
