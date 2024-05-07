package com.leetcode.lc389;

/*
389. Find the Difference

You are given two strings s and t.

String t is generated by random shuffling string s and then add one more letter at a random position.

Return the letter that was added to t.



Example 1:

Input: s = "abcd", t = "abcde"
Output: "e"
Explanation: 'e' is the letter that was added.

Example 2:

Input: s = "", t = "y"
Output: "y"



Constraints:

    0 <= s.length <= 1000
    t.length == s.length + 1
    s and t consist of lowercase English letters.
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    String s;
    String t;

    s = "abcd";
    t = "abcde";
    System.out.println(solution.findTheDifference(s, t)); //e

    s = "";
    t = "y";
    System.out.println(solution.findTheDifference(s, t)); //y

    s = "qpslvmfyrcsxpg";
    t = "lvxspgfyqpmcssr";
    System.out.println(solution.findTheDifference(s, t)); //s
  }

  public char findTheDifference(String s, String t) {
    if (s.isEmpty()) {
      return t.charAt(0);
    }
    char result = s.charAt(0);
    for (int i = 1; i < s.length(); i++) {
      result ^= s.charAt(i);
    }
    for (int i = 0; i < t.length(); i++) {
      result ^= t.charAt(i);
    }
    return result;
  }
}
