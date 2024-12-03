package com.leetcode.lc2816;

import com.leetcode.tools.ListNode;
import static com.leetcode.tools.ListNodeHelper.*;
import java.util.LinkedList;

/*
2816. Double a Number Represented as a Linked List

You are given the head of a non-empty linked list representing a non-negative integer without leading zeroes.

Return the head of the linked list after doubling it.



Example 1:

Input: head = [1,8,9]
Output: [3,7,8]
Explanation: The figure above corresponds to the given linked list which represents the number 189. Hence, the returned linked list represents the number 189 * 2 = 378.

Example 2:

Input: head = [9,9,9]
Output: [1,9,9,8]
Explanation: The figure above corresponds to the given linked list which represents the number 999. Hence, the returned linked list reprersents the number 999 * 2 = 1998.



Constraints:

    The number of nodes in the list is in the range [1, 104]
    0 <= Node.val <= 9
    The input is generated such that the list represents a number that does not have leading zeros, except the number 0 itself.
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
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    ListNode head;

    head = createList(1, 8, 9);
    printList(head);
    printList(solution.doubleIt(head));

    head = createList(9, 9, 9);
    printList(head);
    printList(solution.doubleIt(head));
  }

  public ListNode doubleIt(ListNode head) {
    ListNode stack = null;
    ListNode cur = head;
    while (cur != null) {
      stack = new ListNode(cur.val, stack);
      cur = cur.next;
    }
    boolean isMore10 = false;
    ListNode result = null;
    while (stack != null) {
      int valueX2 = stack.val * 2;
      stack = stack.next;
      if (isMore10) {
        result = new ListNode(1 + valueX2 % 10, result);
      } else {
        result = new ListNode(valueX2 % 10, result);
      }
      isMore10 = valueX2 >= 10;
    }
    if (isMore10) {
      result = new ListNode(1, result);
    }
    return result;
  }

  public ListNode doubleIt2(ListNode head) {
    var stack = new LinkedList<Integer>();
    ListNode cur = head;
    while (cur != null) {
      stack.push(cur.val);
      cur = cur.next;
    }
    boolean isMore10 = false;
    ListNode result = null;
    while (!stack.isEmpty()) {
      int valueX2 = stack.pop() * 2;
      if (isMore10) {
        result = new ListNode(1 + valueX2 % 10, result);
      } else {
        result = new ListNode(valueX2 % 10, result);
      }
      isMore10 = valueX2 >= 10;
    }
    if (isMore10) {
      result = new ListNode(1, result);
    }
    return result;
  }
}
