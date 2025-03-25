package com.leetcode.lc705;

import java.util.LinkedList;

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
public class MyHashSet2 {

  private final LinkedList<Integer>[] storage;
  private final int hashSize = 1001;

  public MyHashSet2() {
    storage = new LinkedList[hashSize];
  }

  public void add(int key) {
    if (storage[getHash(key)] == null) {
      storage[getHash(key)] = new LinkedList<>();
    }

    if (!storage[getHash(key)].contains(key)) {
      storage[getHash(key)].add(key);
    }
  }

  public void remove(int key) {
    if (storage[getHash(key)] != null) {
      storage[getHash(key)].remove(key);
    }
  }

  public boolean contains(int key) {
    if (storage[getHash(key)] != null) {
      return storage[getHash(key)].contains(key);
    }
    return false;
  }

  private int getHash(int key) {
    return key % hashSize;
  }
}