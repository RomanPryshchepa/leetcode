package com.leetcode.lc203;

/*
203. Remove Linked List Elements

Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.



Example 1:

Input: head = [1,2,6,3,4,5,6], val = 6
Output: [1,2,3,4,5]

Example 2:

Input: head = [], val = 1
Output: []

Example 3:

Input: head = [7,7,7,7], val = 7
Output: []



Constraints:

    The number of nodes in the list is in the range [0, 104].
    1 <= Node.val <= 50
    0 <= val <= 50
 */

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {}
 * ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val;
 * this.next = next; } }
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    var list1 = solution.createList(6, 1, 2, 3, 6, 4, 5);
    solution.printList(list1, " > ");
    var list = solution.removeElements(list1, 6);
    solution.printList(list, " > ");

    list1 = solution.createList(1, 2, 6, 3, 4, 5, 6);
    solution.printList(list1, " > ");
    list = solution.removeElements(list1, 6);
    solution.printList(list, " > ");

    list1 = solution.createList();
    solution.printList(list1, " > ");
    list = solution.removeElements(list1, 1);
    solution.printList(list, " > ");

    list1 = solution.createList(7, 7, 7, 7);
    solution.printList(list1, " > ");
    list = solution.removeElements(list1, 7);
    solution.printList(list, " > ");

  }

  public ListNode removeElements(ListNode head, int val) {
    while (head != null && head.val == val) {
      head = head.next;
    }
    if (head == null) {
      return head;
    }
    var current = head.next;
    var prev = head;
    while (current != null) {
      if (current.val == val) {
        prev.next = current.next;
      } else {
        prev = prev.next;
      }
      current = current.next;
    }
    return head;
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

  public void printList(ListNode head, String delimiter) {
    if (head == null) {
      System.out.println();
      return;
    }
    ListNode current = head;
    var delim = "";
    while (current != null) {
      System.out.print(delim + current.val);
      delim = delimiter == null ? "->" : delimiter;
      current = current.next;
    }
    System.out.println();
  }
}
