package com.leetcode.lc2487;

import com.leetcode.tools.ListNode;
import static com.leetcode.tools.ListNodeHelper.*;
import java.util.LinkedList;

/*
2487. Remove Nodes From Linked List

You are given the head of a linked list.

Remove every node which has a node with a greater value anywhere to the right side of it.

Return the head of the modified linked list.



Example 1:

Input: head = [5,2,13,3,8]
Output: [13,8]
Explanation: The nodes that should be removed are 5, 2 and 3.
- Node 13 is to the right of node 5.
- Node 13 is to the right of node 2.
- Node 8 is to the right of node 3.

Example 2:

Input: head = [1,1,1,1]
Output: [1,1,1,1]
Explanation: Every node has value 1, so no nodes are removed.



Constraints:

    The number of the nodes in the given list is in the range [1, 105].
    1 <= Node.val <= 105
 */

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {}
 * ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val;
 * this.next = next; } }
 */
class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    var list1 = createList(5, 2, 13, 3, 8);
    printList(list1, " > ");
    var list2 = solution.removeNodes(list1);
    printList(list2, " > ");

    list1 = createList(1, 1, 1, 1);
    printList(list1, " > ");
    list2 = solution.removeNodes(list1);
    printList(list2, " > ");

    list1 = createList(10, 1, 1, 11);
    printList(list1, " > ");
    list2 = solution.removeNodes(list1);
    printList(list2, " > ");
  }

  public ListNode removeNodes(ListNode head) {
    var stack = new LinkedList<ListNode>();
    while (head != null) {
      stack.push(head);
      head = head.next;
    }
    head = stack.pop();
    var max = head.val;
    while (!stack.isEmpty()) {
      var node = stack.pop();
      if (node.val >= max) {
        max = node.val;
        head = new ListNode(node.val, head);
      }
    }
    return head;
  }
}