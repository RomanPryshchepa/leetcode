package com.leetcode.lc143;

import com.leetcode.tools.ListNode;

import java.util.Stack;

import static com.leetcode.tools.ListNodeHelper.*;

/*
143. Reorder List

You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln

Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …

You may not modify the values in the list's nodes. Only nodes themselves may be changed.



Example 1:

Input: head = [1,2,3,4]
Output: [1,4,2,3]

Example 2:

Input: head = [1,2,3,4,5]
Output: [1,5,2,4,3]



Constraints:

    The number of nodes in the list is in the range [1, 5 * 104].
    1 <= Node.val <= 1000
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();

    ListNode head = createList(1, 2, 3, 4, 5);
    printList(head, " > ");
    solution.reorderList(head);
    printList(head, " > ");
    System.out.println();

    head = createList(1, 2, 3, 4, 5);
    printList(head, " > ");
    solution.reorderList2(head);
    printList(head, " > ");
  }

  public void reorderList(ListNode head) {
    ListNode slow = head;
    ListNode fast = head.next;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    ListNode secondList = slow.next;
    slow.next = null;

    ListNode prev = null;
    while (secondList != null) {
      ListNode tmp = secondList.next;
      secondList.next = prev;
      prev = secondList;
      secondList = tmp;
    }

    ListNode firstList = head;
    secondList = prev;
    while (secondList != null) {
      ListNode tmp1 = firstList.next;
      ListNode tmp2 = secondList.next;
      firstList.next = secondList;
      secondList.next = tmp1;
      firstList = tmp1;
      secondList = tmp2;
    }
  }

  public void reorderList2(ListNode head) {
    if (head.next == null || head.next.next == null)
      return;
    var slow = head;
    var fast = head.next;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    var curr = slow.next;
    slow.next = null;
    var stack = new Stack<ListNode>();
    while (curr != null) {
      stack.push(curr);
      curr = curr.next;
    }
    curr = head;
    while (!stack.empty()) {
      var next = curr.next;
      curr.next = stack.pop();
      curr.next.next = next;
      curr = next;
    }
  }
}
