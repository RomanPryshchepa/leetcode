package com.leetcode.lc394;

import java.util.Deque;
import java.util.LinkedList;

/*
394. Decode String

Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].

The test cases are generated so that the length of the output will never exceed 105.



Example 1:

Input: s = "3[a]2[bc]"
Output: "aaabcbc"

Example 2:

Input: s = "3[a2[c]]"
Output: "accaccacc"

Example 3:

Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"



Constraints:

    1 <= s.length <= 30
    s consists of lowercase English letters, digits, and square brackets '[]'.
    s is guaranteed to be a valid input.
    All the integers in s are in the range [1, 300].
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.decodeString("3[a]2[bc]")); // aaabcbc            3 * (a) + 1 * (bc)
    System.out.println(solution.decodeString("3[a2[c]]")); // accaccacc           3 * (a + 2 * (c))
    System.out.println(
        solution.decodeString("2[abc]3[cd]ef")); // abcabccdcdcdef 2 * (abc) + 3 * (cd) + ef
    System.out.println(solution.decodeString(
        "4[ab2[abc]3[cd]]ef")); // ababcabccdcdcdababcabccdcdcdababcabccdcdcdababcabccdcdcdef 4 * (ab + 2 * (abc) + 3 * (cd)) + ef
  }

  public String decodeString(String s) {
    Deque<Character> stack = new LinkedList<>();
    var sb = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == ']') {
        while (!stack.isEmpty() && stack.peek() != '[') {
          sb.insert(0, stack.pop());
        }
        var str = sb.toString();
        sb = new StringBuilder();
        stack.pop();
        while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
          sb.insert(0, stack.pop());
        }
        var mult = Integer.parseInt(sb.toString());
        sb = new StringBuilder();
        str = str.repeat(mult);
        for (int j = 0; j < str.length(); j++) {
          stack.push(str.charAt(j));
        }
      } else {
        stack.push(s.charAt(i));
      }
    }
    while (!stack.isEmpty()) {
      sb.insert(0, stack.pop());
    }

    return sb.toString();
  }
}
