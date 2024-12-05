package com.leetcode.lc1721;

import com.leetcode.tools.ListNode;
import static com.leetcode.tools.ListNodeHelper.*;

/*
1721. Swapping Nodes in a Linked List

You are given the head of a linked list, and an integer k.

Return the head of the linked list after swapping the values of the kth node from the beginning and the kth node from the end (the list is 1-indexed).



Example 1:

Input: head = [1,2,3,4,5], k = 2
Output: [1,4,3,2,5]

Example 2:

Input: head = [7,9,6,6,7,8,3,0,9,5], k = 5
Output: [7,9,6,6,8,7,3,0,9,5]



Constraints:

    The number of nodes in the list is n.
    1 <= k <= n <= 105
    0 <= Node.val <= 100
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
class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    var list = createList(1,2,3,4,5);
    printList(list);
    printList(solution.swapNodes(list, 2));

    list = createList(7,9,6,6,7,8,3,0,9,5);
    printList(list);
    printList(solution.swapNodes(list, 5));
  }

  public ListNode swapNodes(ListNode head, int k) {
    var current = head;
    var nodeK = head;
    var idx = 1;
    while (current != null)
    {
      if (idx == k)
        nodeK = current;
      idx++;
      current = current.next;
    }
    var len = idx-1;
    idx = 1;
    current = head;
    while (idx <= len - k)
    {
      current = current.next;
      idx++;
    }
    idx = current.val;
    current.val = nodeK.val;
    nodeK.val = idx;
    return head;
  }
}