package com.leetcode.lc19;

import com.leetcode.tools.ListNode;

import static com.leetcode.tools.ListNodeHelper.printList;

/*
19. Remove Nth Node From End of List

Given the head of a linked list, remove the nth node from the end of the list and return its head.

Example 1:

Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]

Example 2:

Input: head = [1], n = 1
Output: []

Example 3:

Input: head = [1,2], n = 1
Output: [1]



Constraints:

    The number of nodes in the list is sz.
    1 <= sz <= 30
    0 <= Node.val <= 100
    1 <= n <= sz



Follow up: Could you do this in one pass?
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
        var head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        printList(head, " > ");
        printList(solution.removeNthFromEnd(head, 2));
        System.out.println();

        head = new ListNode(1);
        printList(head, " > ");
        printList(solution.removeNthFromEnd(head, 1));
        System.out.println();

        head = new ListNode(1, new ListNode(2));
        printList(head, " > ");
        printList(solution.removeNthFromEnd(head, 1));
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null)
            return null;
        var curr = head;
        var currN = head;
        var cnt = 0;
        while (curr != null) {
            if (cnt > n)
                currN = currN.next;
            curr = curr.next;
            cnt++;
        }
        if (currN == head && cnt == n)
            return head.next;
        currN.next = currN.next.next;
        return head;
    }
}