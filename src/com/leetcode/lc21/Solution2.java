package com.leetcode.lc21;

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
public class Solution2 {

  public static void main(String[] args) {

  }

  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode result = null;
    ListNode current1 = list1;
    ListNode current2 = list2;

    if (list1 != null && list2 != null) {
      if (list1.val < list2.val) {
        result = new ListNode(list1.val);
        current1 = list1.next;
      } else {
        result = new ListNode(list2.val);
        current2 = list2.next;
      }
    } else {
      if (list1 != null) {
        result = new ListNode(list1.val);
        current1 = list1.next;
      }
      if (list2 != null) {
        result = new ListNode(list2.val);
        current2 = list2.next;
      }
    }
    ListNode current = result;
    while (current1 != null || current2 != null) {
      if (current1 != null && current2 != null) {
        if (current1.val < current2.val) {
          current.next = new ListNode(current1.val);
          current1 = current1.next;
        } else {
          current.next = new ListNode(current2.val);
          current2 = current2.next;
        }
      } else {
        if (current1 != null) {
          current.next = new ListNode(current1.val);
          current1 = current1.next;
        }
        if (current2 != null) {
          current.next = new ListNode(current2.val);
          current2 = current2.next;
        }
      }
      current = current.next;
    }
    return result;
  }

}
