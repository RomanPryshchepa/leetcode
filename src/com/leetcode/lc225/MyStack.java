package com.leetcode.lc225;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

class MyStack {
    private final Queue<Integer> queue1;
    private final Queue<Integer> queue2;

    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        if (!queue2.isEmpty())
            queue2.add(x);
        else
            queue1.add(x);
    }

    public int pop() {
        if (!queue1.isEmpty()) {
            while (queue1.size() > 1)
                queue2.add(queue1.poll());
            return queue1.remove();
        } else {
            while (queue2.size() > 1)
                queue1.add(queue2.poll());
            return queue2.remove();
        }
    }

    public int top() {
        int last;
        if (!queue1.isEmpty()) {
            while (queue1.size() > 1)
                queue2.add(queue1.poll());
            last = queue1.remove();
            queue2.add(last);
            return last;
        } else {
            while (queue2.size() > 1)
                queue1.add(queue2.poll());
            last = queue2.remove();
            queue1.add(last);
            return last;
        }
    }

    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }
}