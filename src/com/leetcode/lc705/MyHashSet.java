package com.leetcode.lc705;

import java.util.LinkedList;
import java.util.List;

/**
 * Your MyHashSet object will be instantiated and called as such: MyHashSet obj = new MyHashSet();
 * obj.add(key); obj.remove(key); boolean param_3 = obj.contains(key);
 */
class MyHashSet {

  private static int hashSize = 101;
  private List<Integer>[] storage = new LinkedList[hashSize];

  public MyHashSet() {

  }

  public void add(int key) {
    int hash = key % hashSize;
    if (storage[hash] == null) {
      storage[hash] = new LinkedList<>();
    }
    if (!storage[hash].contains(key)) {
      storage[hash].add(key);
    }
  }

  public void remove(int key) {
    int hash = key % hashSize;
    if (storage[hash] == null) {
      return;
    }
    for (Integer i : storage[hash]) {
      if (i == key) {
        storage[hash].remove(i);
        return;
      }
    }
  }

  public boolean contains(int key) {
    int hash = key % hashSize;
    if (storage[hash] == null) {
      return false;
    }
    return storage[hash].contains(key);
  }
}