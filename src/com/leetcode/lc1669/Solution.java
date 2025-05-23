package com.leetcode.lc1669;

import com.leetcode.tools.ListNode;
import static com.leetcode.tools.ListNodeHelper.*;

/*
1669. Merge In Between Linked Lists

You are given two linked lists: list1 and list2 of sizes n and m respectively.

Remove list1's nodes from the ath node to the bth node, and put list2 in their place.

The blue edges and nodes in the following figure indicate the result:

Build the result list and return its head.



Example 1:

Input: list1 = [10,1,13,6,9,5], a = 3, b = 4, list2 = [1000000,1000001,1000002]
Output: [10,1,13,1000000,1000001,1000002,5]
Explanation: We remove the nodes 3 and 4 and put the entire list2 in their place. The blue edges and nodes in the above figure indicate the result.

Example 2:

Input: list1 = [0,1,2,3,4,5,6], a = 2, b = 5, list2 = [1000000,1000001,1000002,1000003,1000004]
Output: [0,1,1000000,1000001,1000002,1000003,1000004,6]
Explanation: The blue edges and nodes in the above figure indicate the result.



Constraints:

    3 <= list1.length <= 104
    1 <= a <= b < list1.length - 1
    1 <= list2.length <= 104
 */

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {}
 * ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val;
 * this.next = next; } }
 */
class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    var list1 = createList(10,1,13,6,9,5);
    printList(list1);
    var list2 = createList(1000000,1000001,10000020);
    printList(list2);
    var list0 = solution.mergeInBetween(list1, 3, 4, list2);
    printList(list0);

    list1 = createList(0,1,2,3,4,5,6);
    printList(list1);
    list2 = createList(1000000,1000001,1000002,1000003,1000004);
    printList(list2);
    list0 = solution.mergeInBetween(list1, 2, 5, list2);
    printList(list0);
  }

  public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
    ListNode result = new ListNode(list1.val);
    ListNode resCur = result;
    ListNode pointerA = list1.next;
    int ind = 0;
    while (pointerA != null && ind < a - 1) {
      resCur.next = new ListNode(pointerA.val);
      resCur = resCur.next;
      pointerA = pointerA.next;
      ind++;
    }

    ListNode pointerB = pointerA;
    while (pointerB != null && ind < b) {
      pointerB = pointerB.next;
      ind++;
    }

    ListNode pointerList2 = list2;
    while (pointerList2 != null) {
      resCur.next = new ListNode(pointerList2.val);
      resCur = resCur.next;
      pointerList2 = pointerList2.next;
    }

    while (pointerB != null) {
      resCur.next = new ListNode(pointerB.val);
      resCur = resCur.next;
      pointerB = pointerB.next;
    }

    return result;
  }
}