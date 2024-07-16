package com.leetcode.lc703;

import java.util.ArrayList;
import java.util.List;

class KthLargest {

  private List<Integer> list;
  private int k;

  public KthLargest(int k, int[] nums) {
    this.k = k;
    this.list = new ArrayList<>();
    for (int item : nums) {
      this.list.add(item);
    }
    this.list.sort(Integer::compare);
  }

  public int add(int val) {
    int start = 0;
    int end = this.list.size() - 1;
    int pos = 0;
    int mid;
    while (start <= end) {
      mid = start + (end - start) / 2;
      if (this.list.get(mid) == val) {
        pos = mid;
        break;
      } else if (this.list.get(mid) < val) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
      pos = start;
    }
    this.list.add(pos, val);
    return this.list.get(this.list.size() - this.k);
  }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */