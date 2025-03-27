package com.leetcode.lc2807;

import static com.leetcode.tools.ListNodeHelper.printList;
import com.leetcode.tools.ListNode;

/*
2807. Insert Greatest Common Divisors in Linked List

Given the head of a linked list head, in which each node contains an integer value.

Between every pair of adjacent nodes, insert a new node with a value equal to the greatest common divisor of them.

Return the linked list after insertion.

The greatest common divisor of two numbers is the largest positive integer that evenly divides both numbers.



Example 1:

Input: head = [18,6,10,3]
Output: [18,6,6,2,10,1,3]
Explanation: The 1st diagram denotes the initial linked list and the 2nd diagram denotes the linked list after inserting the new nodes (nodes in blue are the inserted nodes).
- We insert the greatest common divisor of 18 and 6 = 6 between the 1st and the 2nd nodes.
- We insert the greatest common divisor of 6 and 10 = 2 between the 2nd and the 3rd nodes.
- We insert the greatest common divisor of 10 and 3 = 1 between the 3rd and the 4th nodes.
There are no more adjacent nodes, so we return the linked list.

Example 2:

Input: head = [7]
Output: [7]
Explanation: The 1st diagram denotes the initial linked list and the 2nd diagram denotes the linked list after inserting the new nodes.
There are no pairs of adjacent nodes, so we return the initial linked list.



Constraints:

    The number of nodes in the list is in the range [1, 5000].
    1 <= Node.val <= 1000
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
    var solution = new Solution();
    var head = new ListNode(3);
    head = new ListNode(10, head);
    head = new ListNode(6, head);
    head = new ListNode(18, head);
    printList(head);
    head = solution.insertGreatestCommonDivisors(head);
    printList(head);

    head = new ListNode(7);
    printList(head);
    head = solution.insertGreatestCommonDivisors(head);
    printList(head);
  }

  public ListNode insertGreatestCommonDivisors(ListNode head) {
    var curr = head;
    while (curr.next != null) {
      curr.next = new ListNode(gcdByEuclidsAlgorithm(curr.val, curr.next.val), curr.next);
      curr = curr.next.next;
    }
    return head;
  }

  private int gcdByEuclidsAlgorithm(int n1, int n2) {
    if (n2 == 0) {
      return n1;
    }
    return gcdByEuclidsAlgorithm(n2, n1 % n2);
  }

}
