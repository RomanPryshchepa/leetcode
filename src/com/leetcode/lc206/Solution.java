package com.leetcode.lc206;

import com.leetcode.tools.ListNode;
import static com.leetcode.tools.ListNodeHelper.*;

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
206. Reverse Linked List

Given the head of a singly linked list, reverse the list, and return the reversed list.



Example 1:

Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]

Example 2:

Input: head = [1,2]
Output: [2,1]

Example 3:

Input: head = []
Output: []



Constraints:

    The number of nodes in the list is the range [0, 5000].
    -5000 <= Node.val <= 5000



Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both?

 */
public class Solution {

  public static void main(String[] args) {
    ListNode head;

    head = createList(1, 2, 3, 4, 5);
    printList(head, " > ");
    printList(reverseList(head), " > ");

    head = createList(1, 2);
    printList(head, " > ");
    printList(reverseList(head), " > ");

    head = createList(1);
    printList(head, " > ");
    printList(reverseList(head), " > ");

    head = createList();
    printList(head, " > ");
    printList(reverseList(head), " > ");
  }

  public static ListNode reverseList(ListNode head) {
    ListNode newHead = null;
    var current = head;
    ListNode next;
    while (current != null) {
      next = current.next;
      current.next = newHead;
      newHead = current;
      current = next;
    }
    return newHead;
  }

  public static ListNode reverseList2(ListNode head) {
    ListNode newHead = null;
    ListNode current = head;
    while (current != null) {
      newHead = new ListNode(current.val, newHead);
      current = current.next;
    }

    return newHead;
  }
}
