package com.leetcode.lc709;

/*
709. To Lower Case

Given a string s, return the string after replacing every uppercase letter with the same lowercase letter.



Example 1:

Input: s = "Hello"
Output: "hello"

Example 2:

Input: s = "here"
Output: "here"

Example 3:

Input: s = "LOVELY"
Output: "lovely"



Constraints:

    1 <= s.length <= 100
    s consists of printable ASCII characters.
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    String s;

    s = "Hello";
    System.out.println(solution.toLowerCase(s)); // hello

    s = "here";
    System.out.println(solution.toLowerCase(s)); // here

    s = "LOVELY";
    System.out.println(solution.toLowerCase(s)); // lovely
  }

  public String toLowerCase(String s) {
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
        stringBuilder.append((char) (s.charAt(i) + 32));
      } else {
        stringBuilder.append(s.charAt(i));
      }
    }
    return stringBuilder.toString();
  }
}
