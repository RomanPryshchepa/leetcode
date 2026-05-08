package com.leetcode.lc2;

import com.leetcode.tools.ListNode;
import static com.leetcode.tools.ListNodeHelper.printList;

/*
2. Add Two Numbers

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.



Example 1:

Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.

Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]

Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]



Constraints:

    The number of nodes in each linked list is in the range [1, 100].
    0 <= Node.val <= 9
    It is guaranteed that the list represents a number that does not have leading zeros.
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
        var solution = new Solution();
        ListNode l1 = new ListNode(2, new ListNode(4,new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6,new ListNode(4)));
        printList(l1);
        printList(l2);
        printList(solution.addTwoNumbers(l1,l2));

        l1 = new ListNode(0);
        l2 = new ListNode(0);
        printList(l1);
        printList(l2);
        printList(solution.addTwoNumbers(l1,l2));

        l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
        l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        printList(l1);
        printList(l2);
        printList(solution.addTwoNumbers(l1,l2));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        var res = new ListNode();
        var curr1 = l1;
        var curr2 = l2;
        var curr = res;
        var add = 0;
        int curr1val;
        int curr2val;
        while (curr1 != null || curr2 != null) {
            curr1val = curr1 != null ? curr1.val : 0;
            curr2val = curr2 != null ? curr2.val : 0;
            curr.next = new ListNode((curr1val + curr2val + add) % 10);
            add = (curr1val + curr2val + add) / 10;
            curr = curr.next;
            if (curr1 != null)
                curr1 = curr1.next;
            if (curr2 != null)
                curr2 = curr2.next;
        }
        if (add == 1)
            curr.next = new ListNode(1);
        return res.next;
    }
}