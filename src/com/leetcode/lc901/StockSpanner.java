package com.leetcode.lc901;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
class StockSpanner {

  private final Deque<int[]> stack;

  public StockSpanner() {
    stack = new LinkedList<>();
  }

  public int next(int price) {
    int count = 1;
    while (!stack.isEmpty() && stack.peek()[0] <= price) {
      count += stack.pop()[1];
    }
    stack.push(new int[] {price, count});
    return count;
  }
}