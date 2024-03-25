package com.leetcode.lc155;

public class MinStack {
  private Node root;
  private Node min;

  public MinStack() {

  }

  //pushes the element val onto the stack.
  public void push(int val) {
    root = new Node(val, root);
    if (min == null || val <= min.val) {
      min = new Node(val, min);
    }
  }

  //removes the element on the top of the stack.
  public void pop() {
    if (root.val == min.val) {
      min = min.next;
    }
    root = root.next;
  }

  //gets the top element of the stack.
  public int top() {
    return root.val;
  }

  //retrieves the minimum element in the stack.
  public int getMin() {
    return min.val;
  }

  class Node {
    Node next;
    int val;

    public Node(int val, Node next) {
      this.next = next;
      this.val = val;
    }
  }

}
