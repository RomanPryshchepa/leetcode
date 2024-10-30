package com.leetcode.lc1209;

import java.util.Deque;
import java.util.LinkedList;

/*
1209. Remove All Adjacent Duplicates in String II

You are given a string s and an integer k, a k duplicate removal consists of choosing k adjacent and equal letters from s and removing them, causing the left and the right side of the deleted substring to concatenate together.

We repeatedly make k duplicate removals on s until we no longer can.

Return the final string after all such duplicate removals have been made. It is guaranteed that the answer is unique.



Example 1:

Input: s = "abcd", k = 2
Output: "abcd"
Explanation: There's nothing to delete.

Example 2:

Input: s = "deeedbbcccbdaa", k = 3
Output: "aa"
Explanation:
First delete "eee" and "ccc", get "ddbbbdaa"
Then delete "bbb", get "dddaa"
Finally delete "ddd", get "aa"

Example 3:

Input: s = "pbbcggttciiippooaais", k = 2
Output: "ps"



Constraints:

    1 <= s.length <= 105
    2 <= k <= 104
    s only contains lowercase English letters.
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.removeDuplicates("abcd", 2)); //"abcd"
    System.out.println(solution.removeDuplicates("deeedbbcccbdaa", 3)); //"aa"
    System.out.println(solution.removeDuplicates("pbbcggttciiippooaais", 2)); //"ps"
  }

  public String removeDuplicates(String s, int k) {
    Deque<Character> stack = new LinkedList<>();
    Deque<Character> tempStack = new LinkedList<>();
    for (int i = 0; i < s.length(); i++) {
      var c = s.charAt(i);
      if (tempStack.isEmpty() || tempStack.contains(c)) {
        tempStack.push(c);
        if (tempStack.size() == k) {
          tempStack.clear();
        }
        while (!stack.isEmpty() && stack.peek() == c) {
          tempStack.push(stack.pop());
          if (tempStack.size() == k) {
            tempStack.clear();
          }
        }
      } else {
        while (!tempStack.isEmpty()) {
          stack.push(tempStack.pop());
        }

        tempStack.push(c);
      }
    }
    while (!tempStack.isEmpty()) {
      stack.push(tempStack.pop());
    }

    var sb = new StringBuilder();
    while (!stack.isEmpty()) {
      sb.insert(0, stack.pop());
    }
    return sb.toString();
  }
}
