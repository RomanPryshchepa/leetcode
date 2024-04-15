package com.leetcode.lc58;

/*
58. Length of Last Word

Given a string s consisting of words and spaces, return the length of the last word in the string.

A word is a maximal
substring
consisting of non-space characters only.



Example 1:

Input: s = "Hello World"
Output: 5
Explanation: The last word is "World" with length 5.

Example 2:

Input: s = "   fly me   to   the moon  "
Output: 4
Explanation: The last word is "moon" with length 4.

Example 3:

Input: s = "luffy is still joyboy"
Output: 6
Explanation: The last word is "joyboy" with length 6.



Constraints:

    1 <= s.length <= 104
    s consists of only English letters and spaces ' '.
    There will be at least one word in s.
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    String s;

    s = "Hello World";
    System.out.println(solution.lengthOfLastWord(s)); // 5

    s = "   fly me   to   the moon  ";
    System.out.println(solution.lengthOfLastWord(s)); // 4

    s = "luffy is still joyboy";
    System.out.println(solution.lengthOfLastWord(s)); // 6
  }

  public int lengthOfLastWord(String s) {
    String[] s1 = s.trim().split(" ");
    return s1[s1.length - 1].length();
  }
}
