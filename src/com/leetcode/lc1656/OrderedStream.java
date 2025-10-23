package com.leetcode.lc1656;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class OrderedStream {

  private int index = 1;
  private final Map<Integer, String> map = new HashMap<>();

  public OrderedStream(int n) {
    for (int i = 1; i <= n; i++) {
      map.put(i, null);
    }
  }

  public List<String> insert(int idKey, String value) {
    map.put(idKey, value);
    var result = new ArrayList<String>();
    while (map.get(index) != null) {
      result.add(map.get(index));
      index++;
    }
    return result;
  }
}

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(idKey,value);
 */
