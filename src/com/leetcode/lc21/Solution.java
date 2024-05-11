package com.leetcode.lc21;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

/*
21. Merge Two Sorted Lists

You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.



Example 1:

Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]

Example 2:

Input: list1 = [], list2 = []
Output: []

Example 3:

Input: list1 = [], list2 = [0]
Output: [0]



Constraints:

    The number of nodes in both lists is in the range [0, 50].
    -100 <= Node.val <= 100
    Both list1 and list2 are sorted in non-decreasing order.
 */
public class Solution {

  public static void main(String[] args) {
    ListNode head1;
    ListNode head2;

    head1 = createList(1, 2, 4);
    head2 = createList(1, 3, 4);
    printList(head1);
    printList(head2);
    printList(mergeTwoLists(head1, head2));

    head1 = createList();
    head2 = createList();
    printList(head1);
    printList(head2);
    printList(mergeTwoLists(head1, head2));

    head1 = createList(1);
    head2 = createList(0);
    printList(head1);
    printList(head2);
    printList(mergeTwoLists(head1, head2));

  }

  public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode current = null;
    if (list1 != null && list2 != null) {
      if (list1.val < list2.val) {
        current = new ListNode(list1.val);
        list1 = list1.next;
      } else {
        current = new ListNode(list2.val);
        list2 = list2.next;
      }
    } else if (list1 != null) {
      current = new ListNode(list1.val);
      list1 = list1.next;
    } else if (list2 != null) {
      current = new ListNode(list2.val);
      list2 = list2.next;
    }

    ListNode head = current;
    while (list1 != null && list2 != null) {
      if (list1.val < list2.val) {
        current.next = new ListNode(list1.val);
        current = current.next;
        list1 = list1.next;
      } else {
        current.next = new ListNode(list2.val);
        current = current.next;
        list2 = list2.next;
      }
    }
    while (list1 != null) {
      current.next = new ListNode(list1.val);
      current = current.next;
      list1 = list1.next;
    }
    while (list2 != null) {
      current.next = new ListNode(list2.val);
      current = current.next;
      list2 = list2.next;
    }
    return head;
  }

  public static ListNode createList(int... elements) {
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

  public static void printList(ListNode head) {
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
