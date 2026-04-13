package com.leetcode.lc225;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack1 {
    private final Queue<Integer> queue;

    public MyStack1() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.add(x);
        for (int i = 0; i < queue.size() - 1; i++)
            queue.add(queue.poll());
    }

    public int pop() {
        return queue.remove();
    }

    public int top() {
        return queue.element();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
