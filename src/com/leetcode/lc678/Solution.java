package com.leetcode.lc678;

import java.util.Stack;

/*
678. Valid Parenthesis String

Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.

The following rules define a valid string:

    Any left parenthesis '(' must have a corresponding right parenthesis ')'.
    Any right parenthesis ')' must have a corresponding left parenthesis '('.
    Left parenthesis '(' must go before the corresponding right parenthesis ')'.
    '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".



Example 1:

Input: s = "()"
Output: true

Example 2:

Input: s = "(*)"
Output: true

Example 3:

Input: s = "(*))"
Output: true



Constraints:

    1 <= s.length <= 100
    s[i] is '(', ')' or '*'.
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    String s;

    s = "()";
    System.out.println(solution.checkValidString(s));

    s = "(*)";
    System.out.println(solution.checkValidString(s));

    s = "(*))";
    System.out.println(solution.checkValidString(s));

    s = ")";
    System.out.println(solution.checkValidString(s));
  }

  public boolean checkValidString(String s) {
    var counter = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) != ')') {
        counter++;
      } else if (counter > 0) {
        counter--;
      } else {
        return false;
      }
    }

    counter = 0;
    for (int i = s.length() - 1; i >= 0; i--) {
      if (s.charAt(i) != '(') {
        counter++;
      } else if (counter > 0) {
        counter--;
      } else {
        return false;
      }
    }
    return true;
  }

  public boolean checkValidString2(String s) {
    Stack<Character> stack = new Stack<>();
    char[] charArray = s.toCharArray();
    for (int i = 0; i < charArray.length; i++) {
      if (charArray[i] == ')' && stack.empty()) {
        return false;
      }
      if (charArray[i] == '(') {
        stack.push(charArray[i]);
      } else if (charArray[i] == ')') {
        Character peek = stack.peek();
        if (peek == '(') {
          stack.pop();
        } else {
          stack.push(charArray[i]);
        }
      } else {
        stack.push(charArray[i]);
      }
    }
    System.out.println(stack);
    return stack.empty();
  }
}
