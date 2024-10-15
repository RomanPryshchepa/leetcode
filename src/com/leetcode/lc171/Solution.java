package com.leetcode.lc171;

/*
171. Excel Sheet Column Number

Given a string columnTitle that represents the column title as appears in an Excel sheet, return its corresponding column number.

For example:

A -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28
...



Example 1:

Input: columnTitle = "A"
Output: 1

Example 2:

Input: columnTitle = "AB"
Output: 28

Example 3:

Input: columnTitle = "ZY"
Output: 701



Constraints:

    1 <= columnTitle.length <= 7
    columnTitle consists only of uppercase English letters.
    columnTitle is in the range ["A", "FXSHRXW"].
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.titleToNumber("A"));
    System.out.println(solution.titleToNumber("B"));
    System.out.println(solution.titleToNumber("C"));
    System.out.println(solution.titleToNumber("Z"));
    System.out.println(solution.titleToNumber("AA"));
    System.out.println(solution.titleToNumber("AB"));
    System.out.println(solution.titleToNumber("ZY"));
  }

  public int titleToNumber(String columnTitle) {
    int result = 0;
    for (int i = 0; i < columnTitle.length(); i++) {
      result += (columnTitle.charAt(i) - 'A' + 1) * Math.pow(26, columnTitle.length() - i - 1);
    }
    return result;
  }
}
