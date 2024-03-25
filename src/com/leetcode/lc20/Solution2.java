package com.leetcode.lc20;

import java.util.Stack;

public class Solution2 {

  public static void main(String[] args) {
    System.out.println(isValid(")"));
    System.out.println(isValid("()"));
    System.out.println(isValid("()[]{}"));
    System.out.println(isValid("(]{}"));
    System.out.println(isValid("()}"));
  }

  public static boolean isValid(String s) {
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

  public static boolean isValid1(String s) {
    char[] charArray = s.toCharArray();
    Stack<Character> stack = new Stack<>();
    for (char c : charArray) {
      stack.push(c);
    }
    while (!stack.isEmpty()) {
      if (stack.pop() == ')' && stack.pop() != '(') {
        return false;
      } else if (stack.pop() == '}' && stack.pop() != '{') {
        return false;
      } else if (stack.pop() == ']' && stack.pop() != '[') {
        return false;
      }
    }
    return true;
  }
}
