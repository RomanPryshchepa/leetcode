package com.leetcode.lc83;

/*
83. Remove Duplicates from Sorted List

Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.



Example 1:

Input: head = [1,1,2]
Output: [1,2]

Example 2:

Input: head = [1,1,2,3,3]
Output: [1,2,3]



Constraints:

    The number of nodes in the list is in the range [0, 300].
    -100 <= Node.val <= 100
    The list is guaranteed to be sorted in ascending order.
 */

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {}
 * ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val;
 * this.next = next; } }
 */
class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    var list1 = solution.createList(1, 2, 2, 3, 3, 4, 5, 5);
    solution.printList(list1, " > ");
    var list = solution.deleteDuplicates(list1);
    solution.printList(list, " > ");

    list1 = solution.createList(1, 2, 3, 3, 4, 5, 6);
    solution.printList(list1, " > ");
    list = solution.deleteDuplicates(list1);
    solution.printList(list, " > ");

    list1 = solution.createList();
    solution.printList(list1, " > ");
    list = solution.deleteDuplicates(list1);
    solution.printList(list, " > ");

    list1 = solution.createList(7, 7, 7, 7);
    solution.printList(list1, " > ");
    list = solution.deleteDuplicates(list1);
    solution.printList(list, " > ");
  }

  public ListNode deleteDuplicates(ListNode head) {
    var current = head;
    var currVal = 0;
    while (current != null) {
      currVal = current.val;
      while (current.next != null && current.next.val == currVal) {
        current.next = current.next.next;
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