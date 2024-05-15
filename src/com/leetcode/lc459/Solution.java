package com.leetcode.lc459;

/*
459. Repeated Substring Pattern

Given a string s, check if it can be constructed by taking a substring of it and appending multiple copies of the substring together.



Example 1:

Input: s = "abab"
Output: true
Explanation: It is the substring "ab" twice.

Example 2:

Input: s = "aba"
Output: false

Example 3:

Input: s = "abcabcabcabc"
Output: true
Explanation: It is the substring "abc" four times or the substring "abcabc" twice.



Constraints:

    1 <= s.length <= 104
    s consists of lowercase English letters.
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    String s;

    s = "abab";
    System.out.println(solution.repeatedSubstringPattern(s)); // true

    s = "aba";
    System.out.println(solution.repeatedSubstringPattern(s)); // false

    s = "abcabcabcabc";
    System.out.println(solution.repeatedSubstringPattern(s)); // true

    s = "abcabcabcabcabc";
    System.out.println(solution.repeatedSubstringPattern(s)); // true

    s = "abcdabcdabcd";
    System.out.println(solution.repeatedSubstringPattern(s)); // true

    s = "ababba";
    System.out.println(solution.repeatedSubstringPattern(s)); // true
  }

  public boolean repeatedSubstringPattern(String s) {
    if (s.length() < 2) {
      return false;
    }
    if (s.length() % 2 == 0 && s.substring(0, s.length() / 2).equals(s.substring(s.length() / 2))) {
      return true;
    }
    for (int i = 1; i <= s.length() / 3; i++) {
      if (s.matches("(%s)+".formatted(s.substring(0, i)))) {
        return true;
      }
    }
    return false;
  }
}
