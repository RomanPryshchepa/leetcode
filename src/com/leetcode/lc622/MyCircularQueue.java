package com.leetcode.lc622;

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
class MyCircularQueue {
    private Node head;
    private Node tail;
    private int size;
    private final int maxSize;

    public MyCircularQueue(int k) {
        maxSize = k;
        size = 0;
    }

    public boolean enQueue(int value) {
        if (isFull())
            return false;
        var node = new Node(value);
        if (head == null) {
            head = node;
        }  else {
            tail.next = node;
        }
        tail = node;
        size++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty())
            return false;
        if  (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
        }
        size--;
        return true;
    }

    public int Front() {
        if (isEmpty())
            return -1;
        return head.val;
    }

    public int Rear() {
        if (isEmpty())
            return -1;
        return tail.val;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == maxSize;
    }

    private static class  Node {
        int val;
        Node next;
        Node(int val) {
            this.val = val;
        }
    }
}