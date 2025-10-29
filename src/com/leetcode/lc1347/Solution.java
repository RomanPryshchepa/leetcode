package com.leetcode.lc1347;

import java.util.HashMap;

/*
1347. Minimum Number of Steps to Make Two Strings Anagram

You are given two strings of the same length s and t. In one step you can choose any character of t and replace it with another character.

Return the minimum number of steps to make t an anagram of s.

An Anagram of a string is a string that contains the same characters with a different (or the same) ordering.



Example 1:

Input: s = "bab", t = "aba"
Output: 1
Explanation: Replace the first 'a' in t with b, t = "bba" which is anagram of s.

Example 2:

Input: s = "leetcode", t = "practice"
Output: 5
Explanation: Replace 'p', 'r', 'a', 'i' and 'c' from t with proper characters to make t anagram of s.

Example 3:

Input: s = "anagram", t = "mangaar"
Output: 0
Explanation: "anagram" and "mangaar" are anagrams.



Constraints:

    1 <= s.length <= 5 * 104
    s.length == t.length
    s and t consist of lowercase English letters only.
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.minSteps("bab", "aba"));
    System.out.println(solution.minSteps("leetcode", "practice"));
    System.out.println(solution.minSteps("anagram", "mangaar"));
  }

  public int minSteps(String s, String t) {
    var map = new HashMap<Character, Integer>();
    for (var c : s.toCharArray()) {
      if (!map.containsKey(c))
        map.put(c, 1);
      else
        map.put(c, map.get(c) + 1);
    }
    for (var c : t.toCharArray()) {
      if (map.containsKey(c) && map.get(c) > 0)
        map.put(c, map.get(c) - 1);
    }
    var result = 0;
    for (var value : map.values()) {
      result += value;
    }
    return result;
  }
}
