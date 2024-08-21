package com.leetcode.lc706;

import java.util.ArrayList;
import java.util.List;

/**
 * Your MyHashMap object will be instantiated and called as such: MyHashMap obj = new MyHashMap();
 * obj.put(key,value); int param_2 = obj.get(key); obj.remove(key);
 */
class MyHashMap {

  private static final int DEFAULT_CAPACITY = 101;
  private List<Pair>[] buckets = new List[DEFAULT_CAPACITY];

  public MyHashMap() {

  }

  public void put(int key, int value) {
    int hash = key % buckets.length;
    if (buckets[hash] == null) {
      buckets[hash] = new ArrayList<>();
    }
    if (get(key) != -1) {
      remove(key);
    }
    buckets[hash].add(new Pair(key, value));
  }

  public int get(int key) {
    int hash = key % buckets.length;
    if (buckets[hash] == null) {
      return -1;
    }
    for (Pair pair : buckets[hash]) {
      if (pair.key == key) {
        return pair.value;
      }
    }
    return -1;
  }

  public void remove(int key) {
    int hash = key % buckets.length;
    if (buckets[hash] == null) {
      return;
    }
    for (Pair pair : buckets[hash]) {
      if (pair.key == key) {
        buckets[hash].remove(pair);
        return;
      }
    }
  }

  private static class Pair {

    int key;
    int value;

    public Pair(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }
}