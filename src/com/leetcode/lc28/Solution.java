package com.leetcode.lc28;

/*
28. Find the Index of the First Occurrence in a String

Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.



Example 1:

Input: haystack = "sadbutsad", needle = "sad"
Output: 0
Explanation: "sad" occurs at index 0 and 6.
The first occurrence is at index 0, so we return 0.

Example 2:

Input: haystack = "leetcode", needle = "leeto"
Output: -1
Explanation: "leeto" did not occur in "leetcode", so we return -1.



Constraints:

    1 <= haystack.length, needle.length <= 104
    haystack and needle consist of only lowercase English characters.
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    String haystack;
    String needle;

    haystack = "sadbutsad";
    needle = "sad";
    System.out.println(solution.strStr(haystack, needle)); // 0

    haystack = "leetcode";
    needle = "leeto";
    System.out.println(solution.strStr(haystack, needle)); // -1

    /*
    Wrong Answer
67 / 83 testcases passed
Input
haystack =
"mississippi"
needle =
"issip"
Use Testcase
Output
-1
Expected
4
     */
    haystack = "mississippi";
    needle = "issip";
    System.out.println(solution.strStr(haystack, needle)); // 4
  }

  public int strStr(String haystack, String needle) {
    if (haystack.length() < needle.length()) {
      return -1;
    }
    if (needle.equals(haystack)) {
      return 0;
    }
    char c = needle.charAt(0);
    int i = 0;
    int j = 0;
    while (i < haystack.length()) {
      if (haystack.charAt(i) == c) {
        if (haystack.length() - i < needle.length()) {
          return -1;
        }
        while (j < needle.length() && haystack.charAt(i) == needle.charAt(j)) {
          i++;
          j++;
        }
        if (j == needle.length()) {
          return i - j;
        }
        i = i - j;
        j = 0;
      }
      i++;
    }
    return -1;
  }

}
