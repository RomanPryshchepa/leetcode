package com.leetcode.lc14;

/*
14. Longest Common Prefix

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".



Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"

Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.



Constraints:

    1 <= strs.length <= 200
    0 <= strs[i].length <= 200
    strs[i] consists of only lowercase English letters.
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    String[] strs;

    strs = new String[]{"flower", "flow", "flight"};
    System.out.println(solution.longestCommonPrefix(strs)); // "fl"

    strs = new String[]{"dog", "racecar", "car"};
    System.out.println(solution.longestCommonPrefix(strs)); // ""

    strs = new String[]{"d1og", "d2og1", "d3og2", "d4og3", "d5og4"};
    System.out.println(solution.longestCommonPrefix(strs)); // ""
  }

  public String longestCommonPrefix(String[] strs) {
    if (strs.length == 1) {
      return strs[0];
    }
    int minLength = Integer.MAX_VALUE;
    for (int i = 0; i < strs.length; i++) {
      if (strs[i].length() < minLength) {
        minLength = strs[i].length();
      }
    }
    for (int i = 0; i < minLength; i++) {
      char c = strs[0].charAt(i);
      for (int j = 1; j < strs.length; j++) {
        if (strs[j].charAt(i) != c) {
          return strs[j].substring(0, i);
        }
      }
    }
    return strs[0].substring(0, minLength);
  }
}
