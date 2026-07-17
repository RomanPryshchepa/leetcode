package com.leetcode.lc138;

/*
138. Copy List with Random Pointer

A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.

Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has its value set to the value of its corresponding original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state. None of the pointers in the new list should point to nodes in the original list.

For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding two nodes x and y in the copied list, x.random --> y.

Return the head of the copied linked list.

The linked list is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:

    val: an integer representing Node.val
    random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does not point to any node.

Your code will only be given the head of the original linked list.



Example 1:

Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]

Example 2:

Input: head = [[1,1],[2,1]]
Output: [[1,1],[2,1]]

Example 3:

Input: head = [[3,null],[3,0],[3,null]]
Output: [[3,null],[3,0],[3,null]]



Constraints:

    0 <= n <= 1000
    -104 <= Node.val <= 104
    Node.random is null or is pointing to some node in the linked list.
 */

import java.util.HashMap;

/**
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public static void main(String[] args) {
        var solution = new Solution();
        var node0 = new Node(7);
        var node1 = new Node(13);
        var node2 = new Node(11);
        var node3 = new Node(10);
        var node4 = new Node(1);
        node0.next = node1;
        node1.next = node2;
        node1.random = node0;
        node2.next = node3;
        node2.random = node4;
        node3.next = node4;
        node3.random = node2;
        node4.random = node0;
        solution.printList(node0);
        var newHead = solution.copyRandomList(node0);
        solution.printList(newHead);
    }

    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        var newHead = new Node(0);
        var curr = head;
        var newCurr = newHead;
        var map = new HashMap<Node, Node>();
        while (curr != null) {
            newCurr.next = new Node(curr.val);
            map.put(curr, newCurr.next);
            curr = curr.next;
            newCurr = newCurr.next;
        }
        newHead = newHead.next;
        curr = head;
        newCurr = newHead;
        while (curr != null) {
            newCurr.random = map.get(curr.random);
            curr = curr.next;
            newCurr = newCurr.next;
        }
        return newHead;
    }

    private void printList(Node head) {
        var curr = head;
        var delim = "";
        System.out.print("[");
        while (curr != null) {
            System.out.print(delim);
            delim = ", ";
            System.out.print("[");
            System.out.print(curr.val);
            System.out.print(delim);
            System.out.print(curr.random == null ? null : curr.random.val);
            System.out.print("]");
            curr = curr.next;
        }
        System.out.println("]");
    }
}