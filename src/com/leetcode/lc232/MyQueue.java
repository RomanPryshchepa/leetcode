package com.leetcode.lc232;

import java.util.Stack;

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
class MyQueue {

  private Stack<Integer> stack;
  private Stack<Integer> temp;

  public MyQueue() {
    stack = new Stack<>();
    temp = new Stack<>();
  }

  public void push(int x) {
    while (!stack.isEmpty()) {
      temp.push(stack.pop());
    }
    stack.push(x);
    while (!temp.isEmpty()) {
      stack.push(temp.pop());
    }
  }

  public int pop() {
    return stack.pop();
  }

  public int peek() {
    return stack.peek();
  }

  public boolean empty() {
    return stack.isEmpty();
  }
}