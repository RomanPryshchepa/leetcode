package com.leetcode.lc203;

import com.leetcode.tools.ListNode;
import static com.leetcode.tools.ListNodeHelper.*;

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
    var list1 = createList(6, 1, 2, 3, 6, 4, 5);
    printList(list1, " > ");
    var list = solution.removeElements(list1, 6);
    printList(list, " > ");

    list1 = createList(1, 2, 6, 3, 4, 5, 6);
    printList(list1, " > ");
    list = solution.removeElements(list1, 6);
    printList(list, " > ");

    list1 = createList();
    printList(list1, " > ");
    list = solution.removeElements(list1, 1);
    printList(list, " > ");

    list1 = createList(7, 7, 7, 7);
    printList(list1, " > ");
    list = solution.removeElements(list1, 7);
    printList(list, " > ");

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
}
