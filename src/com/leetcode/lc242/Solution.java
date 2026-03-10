package com.leetcode.lc242;

import java.util.Arrays;

/*
242. Valid Anagram

Given two strings s and t, return true if t is an anagram of s, and false otherwise.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.



Example 1:

Input: s = "anagram", t = "nagaram"
Output: true

Example 2:

Input: s = "rat", t = "car"
Output: false



Constraints:

    1 <= s.length, t.length <= 5 * 104
    s and t consist of lowercase English letters.



Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    String s, t;

    s = "anagram";
    t = "nagaram";
    System.out.println(solution.isAnagram(s, t)); // true
    System.out.println(solution.isAnagram2(s, t)); // true

    s = "rat";
    t = "car";
    System.out.println(solution.isAnagram(s, t)); // false
    System.out.println(solution.isAnagram2(s, t)); // false
  }

  public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    char[] sCharArray = s.toCharArray();
    char[] tCharArray = t.toCharArray();
    Arrays.sort(sCharArray);
    Arrays.sort(tCharArray);
    return Arrays.equals(sCharArray, tCharArray);
  }

  public boolean isAnagram2(String s, String t) {
    if (s.length() != t.length())
      return false;
    var letterCnt = new int[26];
    for (var ch : s.toCharArray())
      letterCnt[ch - 'a']++;
    for (var ch : t.toCharArray())
      letterCnt[ch - 'a']--;
    for (var cnt : letterCnt)
      if (cnt != 0)
        return false;
    return true;
  }
}
