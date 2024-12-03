package com.leetcode.lc23;

import com.leetcode.tools.ListNode;
import static com.leetcode.tools.ListNodeHelper.*;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {}
 * ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val;
 * this.next = next; } }
 */

/*
23. Merge k Sorted Lists

You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.



Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6

Example 2:

Input: lists = []
Output: []

Example 3:

Input: lists = [[]]
Output: []



Constraints:

    k == lists.length
    0 <= k <= 104
    0 <= lists[i].length <= 500
    -104 <= lists[i][j] <= 104
    lists[i] is sorted in ascending order.
    The sum of lists[i].length will not exceed 104.

 */
class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();

    ListNode list1 = createList(1, 4, 5);
    ListNode list2 = createList(1, 3, 4);
    ListNode list3 = createList(2, 6);
    ListNode[] lists = {list1, list2, list3};
    ListNode list = solution.mergeKLists(lists);
    printList(list, " > ");


    lists = new ListNode[]{null};
    list = solution.mergeKLists(lists);
    printList(list, " > ");
  }

  public ListNode mergeKLists(ListNode[] lists) {
    int k = lists.length;
    ListNode res = null;
    ListNode tail = null;
    if (k == 0) {
      return res;
    }
    ListNode[] cur = new ListNode[k];
    System.arraycopy(lists, 0, cur, 0, k);
    while (true) {
      ListNode min = null;
      var minIdx = 0;
      for (int i = 0; i < k; i++) {
        if (cur[i] != null && (min == null || cur[i].val < min.val)) {
          min = cur[i];
          minIdx = i;
        }
      }

      if (min == null) {
        break;
      }
      if (res == null) {
        res = min;
        tail = res;
      } else {
        tail.next = min;
        tail = tail.next;
      }
      cur[minIdx] = cur[minIdx].next;
    }
    return res;
  }
}