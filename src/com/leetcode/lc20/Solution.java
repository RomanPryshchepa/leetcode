package com.leetcode.lc20;

import java.util.LinkedList;
import java.util.Stack;

/*
20. Valid Parentheses

Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.
    Every close bracket has a corresponding open bracket of the same type.



Example 1:

Input: s = "()"
Output: true

Example 2:

Input: s = "()[]{}"
Output: true

Example 3:

Input: s = "(]"
Output: false



Constraints:

    1 <= s.length <= 104
    s consists of parentheses only '()[]{}'.

 */
public class Solution {
  public static void main(String[] args) {
    var solution = new Solution();
    String s;

    s = "()";
    System.out.println(solution.isValid(s));
    System.out.println(solution.isValid2(s));
    System.out.println(solution.isValid3(s));
    System.out.println();

    s = "()[]{}";
    System.out.println(solution.isValid(s));
    System.out.println(solution.isValid2(s));
    System.out.println(solution.isValid3(s));
    System.out.println();

    s = "(]";
    System.out.println(solution.isValid(s));
    System.out.println(solution.isValid2(s));
    System.out.println(solution.isValid3(s));
    System.out.println();

    s = "]}])";
    System.out.println(solution.isValid(s));
    System.out.println(solution.isValid2(s));
    System.out.println(solution.isValid3(s));
    System.out.println();

    s = "((()))([])[()]({()})";
    System.out.println(solution.isValid(s));
    System.out.println(solution.isValid2(s));
    System.out.println(solution.isValid3(s));
    System.out.println();

    s = ")";
    System.out.println(solution.isValid(s));
    System.out.println(solution.isValid2(s));
    System.out.println(solution.isValid3(s));
    System.out.println();

    s = "(]{}";
    System.out.println(solution.isValid(s));
    System.out.println(solution.isValid2(s));
    System.out.println(solution.isValid3(s));
    System.out.println();

    s = "()}";
    System.out.println(solution.isValid(s));
    System.out.println(solution.isValid2(s));
    System.out.println(solution.isValid3(s));
    System.out.println();

    s = "(})";
    System.out.println(solution.isValid(s));
    System.out.println(solution.isValid2(s));
    System.out.println(solution.isValid3(s));
  }

  public boolean isValid(String s) {
    LinkedList<Character> stack = new LinkedList<>();
    char[] charArray = s.toCharArray();
    for (char c : charArray) {
      if (c == '(' || c == '{' || c == '[') {
        stack.addFirst(c);
      } else if (c == ')' || c == '}' || c == ']') {
        if (stack.isEmpty()) {
          return false;
        }
        Character first = stack.getFirst();
        stack.removeFirst();
        if (!(first == '(' && c == ')' || first == '{' && c == '}' || first == '[' && c == ']')) {
          return false;
        }
      } else {
        return false;
      }
    }
    return stack.isEmpty();
  }

  public boolean isValid2(String s) {
    char[] charArray = s.toCharArray();
    Stack<Character> stack = new Stack<>();
    for (char c : charArray) {
      if (c == ')') {
        if (stack.empty() || stack.pop() != '(') {
          return false;
        }
      } else if (c == '}') {
        if (stack.empty() || stack.pop() != '{') {
          return false;
        }
      } else if (c == ']') {
        if (stack.empty() || stack.pop() != '[') {
          return false;
        }
      } else {
        stack.push(c);
      }
    }
    return stack.empty();
  }

  public boolean isValid3(String s) {
    var stack = new Stack<Character>();
    for (var ch : s.toCharArray()) {
      if (stack.empty() && ")]}".indexOf(ch) >= 0)
        return false;
      else if (!stack.empty() && (stack.peek() == '(' && ch == ')' || stack.peek() == '[' && ch == ']' || stack.peek() == '{' && ch == '}'))
        stack.pop();
      else
        stack.push(ch);
    }
    return stack.empty();
  }
}
