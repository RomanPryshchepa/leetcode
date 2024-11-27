package com.leetcode.lc876;

/*
876. Middle of the Linked List

Given the head of a singly linked list, return the middle node of the linked list.

If there are two middle nodes, return the second middle node.



Example 1:

Input: head = [1,2,3,4,5]
Output: [3,4,5]
Explanation: The middle node of the list is node 3.

Example 2:

Input: head = [1,2,3,4,5,6]
Output: [4,5,6]
Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.



Constraints:

    The number of nodes in the list is in the range [1, 100].
    1 <= Node.val <= 100
 */
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {}
 * ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val;
 * this.next = next; } }
 */
class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    ListNode head;

    head = solution.createList(1, 2, 3, 4, 5);
    solution.printList(head);
    solution.printList(solution.middleNode(head));

    head = solution.createList(1, 2, 3, 4, 5, 6);
    solution.printList(head);
    solution.printList(solution.middleNode(head));

    head = solution.createList(1);
    solution.printList(head);
    solution.printList(solution.middleNode(head));

    head = solution.createList(1, 2);
    solution.printList(head);
    solution.printList(solution.middleNode(head));

    head = solution.createList();
    solution.printList(head);
    solution.printList(solution.middleNode(head));
  }

  public ListNode middleNode(ListNode head) {
    var current = head;
    var length = 0;
    while (current != null) {
      current = current.next;
      length++;
    }
    current = head;
    for (var i = 0; i < length / 2; i++) {
      current = current.next;
    }
    return current;
  }

  public ListNode createList(int... elements) {
    ListNode head = null;
    if (elements.length > 0) {
      head = new ListNode(elements[0]);
    }
    ListNode current = head;
    for (int i = 1; i < elements.length; i++) {
      current.next = new ListNode(elements[i]);
      current = current.next;
    }

    return head;
  }

  public void printList(ListNode head) {
    if (head == null) {
      System.out.println();
      return;
    }
    ListNode current = head;
    String delimiter = "";
    while (current != null) {
      System.out.print(delimiter + current.val);
      delimiter = " -> ";
      current = current.next;
    }
    System.out.println();
  }
}