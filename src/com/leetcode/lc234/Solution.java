package com.leetcode.lc234;

import static com.leetcode.tools.ListNodeHelper.*;

import com.leetcode.tools.ListNode;
import java.util.Deque;
import java.util.LinkedList;

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

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {}
 * ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val;
 * this.next = next; } }
 */
class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();


    var head = createList(1, 2, 2, 1);
    printList(head);
    System.out.println(solution.isPalindrome(head)); // true
    System.out.println(solution.isPalindrome2(head)); // true

    head = createList(1, 2);
    printList(head);
    System.out.println(solution.isPalindrome(head)); // false
    System.out.println(solution.isPalindrome2(head)); // false

    head = createList(1, 2, 1);
    printList(head);
    System.out.println(solution.isPalindrome(head)); // true
    System.out.println(solution.isPalindrome2(head)); // true

    head = createList(1, 2, 3, 4, 5);
    printList(head);
    System.out.println(solution.isPalindrome(head)); // false
    System.out.println(solution.isPalindrome2(head)); // false

    head = createList(1);
    printList(head);
    System.out.println(solution.isPalindrome(head)); // false
    System.out.println(solution.isPalindrome2(head)); // false
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

  public boolean isPalindrome2(ListNode head) {
    if (head.next == null)
      return true;
    var slow = head;
    var fast = head;
    var prev = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    var curr = prev.next;
    var next = curr.next;
    prev.next = null;
    while (curr != slow) {
      curr.next = prev;
      prev = curr;
      curr = next;
      next = curr.next;
    }
    if (fast != null)
      curr = curr.next;
    while (curr != null && prev != null) {
      if (prev.val != curr.val)
        return false;
      curr = curr.next;
      prev = prev.next;
    }
    return true;
  }
}