package com.leetcode.lc1249;

import java.util.Stack;

/*
1249. Minimum Remove to Make Valid Parentheses
Medium
Topics
Companies
Hint

Given a string s of '(' , ')' and lowercase English characters.

Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.

Formally, a parentheses string is valid if and only if:

    It is the empty string, contains only lowercase characters, or
    It can be written as AB (A concatenated with B), where A and B are valid strings, or
    It can be written as (A), where A is a valid string.



Example 1:

Input: s = "lee(t(c)o)de)"
Output: "lee(t(c)o)de"
Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.

Example 2:

Input: s = "a)b(c)d"
Output: "ab(c)d"

Example 3:

Input: s = "))(("
Output: ""
Explanation: An empty string is also valid.



Constraints:

    1 <= s.length <= 105
    s[i] is either'(' , ')', or lowercase English letter.
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    String s;

    s = "lee(t(c)o)de)";
    System.out.println(solution.minRemoveToMakeValid(s));

    s = "a)b(c)d";
    System.out.println(solution.minRemoveToMakeValid(s));

    s = "))((";
    System.out.println(solution.minRemoveToMakeValid(s));
  }

  public String minRemoveToMakeValid(String s) {
    Stack<Character> stack = new Stack<>();
    Stack<Integer> stackIdx = new Stack<>();
    char[] charArray = s.toCharArray();
    for (int i = 0; i < charArray.length; i++) {
      if (charArray[i] == '(') {
        stack.push(charArray[i]);
        stackIdx.push(i);
      } else if (charArray[i] == ')') {
        if (stack.isEmpty()) {
          charArray[i] = '_';
        } else {
          stack.pop();
          stackIdx.pop();
        }
      }
    }
    for (Integer idx : stackIdx) {
      charArray[idx] = '_';
    }
    String res = "";
    for (int i = 0; i < charArray.length; i++) {
      if (charArray[i] != '_') {
        res += charArray[i];
      }
    }
    return res;
  }
}
