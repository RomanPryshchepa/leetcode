package com.leetcode.lc876;

import com.leetcode.tools.ListNode;

import static com.leetcode.tools.ListNodeHelper.*;

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

    head = createList(1, 2, 3, 4, 5);
    printList(head);
    printList(solution.middleNode(head));
    printList(solution.middleNode2(head));
    System.out.println();

    head = createList(1, 2, 3, 4, 5, 6);
    printList(head);
    printList(solution.middleNode(head));
    printList(solution.middleNode2(head));
    System.out.println();

    head = createList(1);
    printList(head);
    printList(solution.middleNode(head));
    printList(solution.middleNode2(head));
    System.out.println();

    head = createList(1, 2);
    printList(head);
    printList(solution.middleNode(head));
    printList(solution.middleNode2(head));
    System.out.println();

    head = createList();
    printList(head);
    printList(solution.middleNode(head));
    printList(solution.middleNode2(head));
  }

  public ListNode middleNode2(ListNode head) { // SlowFast
    var curr = head;
    var curr2x = head;
    while (curr2x != null) {
      if (curr2x.next != null) {
        curr2x = curr2x.next.next;
      } else {
        break;
      }
      curr = curr.next;
    }
    return curr;
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
}