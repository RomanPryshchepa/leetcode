package com.leetcode.lc146;

import java.util.*;

public class LRUCache2 {
    private final Map<Integer, Integer> cache;
    private final int capacity;
    private final List<Integer> keyList;

    public LRUCache2(int capacity) {
        cache = new HashMap<>(capacity);
        this.capacity = capacity;
        keyList = new LinkedList<>();
    }

    public int get(int key) {
        if (!cache.containsKey(key))
            return -1;
        for (var keyFromList : keyList) {
            if (keyFromList == key) {
                keyList.remove(keyFromList);
                keyList.addFirst(key);
                break;
            }
        }
        return cache.get(key);
    }

    public void put(int key, int value) {
        if (!cache.containsKey(key) && cache.size() == capacity)
            cache.remove(keyList.removeLast());
        else if (cache.containsKey(key)) {
            for (var keyFromList : keyList) {
                if (keyFromList == key) {
                    keyList.remove(keyFromList);
                    break;
                }
            }
        }
        cache.put(key, value);
        keyList.addFirst(key);
    }
}
