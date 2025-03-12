package com.leetcode.lc1381;

import java.util.Stack;

class CustomStack {

  private Stack<Integer> stack;
  private int maxSize;

  public CustomStack(int maxSize) {
    stack = new Stack<Integer>();
    this.maxSize = maxSize;
  }

  public void push(int x) {
    if (stack.size() < maxSize) {
      stack.push(x);
    }
  }

  public int pop() {
    if (stack.isEmpty()) {
      return -1;
    } else {
      return stack.pop();
    }
  }

  public void increment(int k, int val) {
    if (k > stack.size()) {
      k = stack.size();
    }
    var cnt = stack.size();
    var tmp = new Stack<Integer>();
    for (var i = 0; i < cnt; i++) {
      if (i < cnt - k) {
        tmp.push(stack.pop());
      } else {
        tmp.push(stack.pop() + val);
      }
    }

    while (!tmp.isEmpty()) {
      stack.push(tmp.pop());
    }
  }
}

/**
 * Your CustomStack object will be instantiated and called as such: CustomStack obj = new
 * CustomStack(maxSize); obj.push(x); int param_2 = obj.pop(); obj.increment(k,val);
 */