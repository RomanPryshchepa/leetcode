package com.leetcode.lc155;

import java.util.Stack;

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
public class MinStack2 {
    private final Stack<Integer> stack;
    private final Stack<Integer> minStack;

    public MinStack2() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.empty() || val <= minStack.peek())
            minStack.push(val);
    }

    public void pop() {
        if ((int) stack.pop() == minStack.peek())
            minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
