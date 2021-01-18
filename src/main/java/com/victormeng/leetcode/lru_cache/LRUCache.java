package com.victormeng.leetcode.lru_cache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    Node head;
    Node tail;
    Map<Integer, Node> map;
    int capacity;
    int count;

    public LRUCache(int capacity) {
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.pre = head;
        map = new HashMap<>();
        this.capacity = capacity;
        this.count = 0;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        delete(node);
        addToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            delete(node);
            addToHead(node);
        } else {
            Node node = new Node(key, value);
            count++;
            if (count > capacity) {
                map.remove(tail.pre.key);
                delete(tail.pre);
                count--;
            }
            map.put(key, node);
            addToHead(node);
        }
    }

    public void delete(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public void addToHead(Node node) {
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
        node.pre = head;
    }

}

class Node {
    Node pre;
    Node next;
    int val;
    int key;

    Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}


