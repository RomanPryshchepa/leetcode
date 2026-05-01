package com.leetcode.lc1472;

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
class BrowserHistory2 {
    private Node curr;

    public BrowserHistory2(String homepage) {
        curr = new Node(homepage);
    }

    public void visit(String url) {
        curr.next = new Node(url);
        curr.next.prev = curr;
        curr = curr.next;
    }

    public String back(int steps) {
        while (curr.prev != null && steps != 0) {
            curr = curr.prev;
            steps--;
        }
        return curr.val;
    }

    public String forward(int steps) {
        while (curr.next != null && steps != 0) {
            curr = curr.next;
            steps--;
        }
        return curr.val;
    }

    private static class Node {
        String val;
        Node prev;
        Node next;

        public Node (String val) {
            this.val = val;
        }
    }
}