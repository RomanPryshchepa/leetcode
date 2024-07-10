package com.leetcode.lc234;

/*
234. Palindrome Linked List

Given the head of a singly linked list, return true if it is a
palindrome
or false otherwise.



Example 1:

Input: head = [1,2,2,1]
Output: true

Example 2:

Input: head = [1,2]
Output: false



Constraints:

    The number of nodes in the list is in the range [1, 105].
    0 <= Node.val <= 9


Follow up: Could you do it in O(n) time and O(1) space?
 */

import java.util.Deque;
import java.util.LinkedList;

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

  }

  public boolean isPalindrome(ListNode head) {
    ListNode curr = head;
    int length = 0;
    while (curr != null) {
      length++;
      curr = curr.next;
    }
    curr = head;
    int counter = 0;
    Deque<Integer> stack = new LinkedList<>();
    while (curr != null) {
      int endIndexOf1stHalf = length / 2;
      int startIndexOf2ndHalf = (length + 1) / 2;
      if (counter < endIndexOf1stHalf) {
        stack.push(curr.val);
      } else if (counter >= startIndexOf2ndHalf) {
        if (stack.pop() != curr.val) {
          return false;
        }
      }

      curr = curr.next;
      counter++;
    }
    return stack.isEmpty();
  }
}