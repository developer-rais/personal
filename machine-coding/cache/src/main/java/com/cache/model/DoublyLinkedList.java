package com.cache.model;

public class DoublyLinkedList<T> {

    DoublyLinkedListNode<T> first;
    DoublyLinkedListNode<T> last;
    private final long CAPACITY;
    private long size;

    public DoublyLinkedList(long capacity) {
        this.first = null;
        this.last = null;
        this.CAPACITY = capacity;
        this.size = 0;
    }

    public void detachNode(DoublyLinkedListNode<T> node) {
        if (node == null) {
            return;
        }

        if (node.equals(first)) {
            first = first.next;
            if (first != null) {
                first.prev = null;
            }
        } else if (node.equals(last)) {
            last = last.prev;
            if (last != null) {
                last.next = null;
            }
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        this.size--;

    }

    public DoublyLinkedListNode<T> detachNodeAtFirst() {
        if (first == null) {
            return null;
        }
        DoublyLinkedListNode<T> node = first;
        first = first.next;
        if (first != null) {
            first.prev = null;
        }
        this.size--;
        return node;
    }

    public void attachNodeAtLast(DoublyLinkedListNode<T> node) {
        if (node == null) {
            return;
        }
        if (last == null) {
            last = node;
            first = node;
        } else {
            last.next = node;
            node.prev = last;
            last = node;
        }
        this.size++;
    }


}
