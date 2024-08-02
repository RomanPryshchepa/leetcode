package com.leetcode.lc168;

/*
168. Excel Sheet Column Title

Given an integer columnNumber, return its corresponding column title as it appears in an Excel sheet.

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

Input: columnNumber = 1
Output: "A"

Example 2:

Input: columnNumber = 28
Output: "AB"

Example 3:

Input: columnNumber = 701
Output: "ZY"



Constraints:

    1 <= columnNumber <= 231 - 1
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.convertToTitle(1)); // A
    System.out.println(solution.convertToTitle(26)); // Z
    System.out.println(solution.convertToTitle(28)); // AB
    System.out.println(solution.convertToTitle(52)); // AZ
    System.out.println(solution.convertToTitle(701)); // ZY
    System.out.println(solution.convertToTitle(Integer.MAX_VALUE)); // FXSHRXW
  }

  public String convertToTitle(int columnNumber) {
    String result = "";
    while (columnNumber > 0) {

      if (columnNumber % 26 == 0) {
        result = 'Z' + result;
        columnNumber = columnNumber / 26 - 1;
      } else {

        result = (char) (64 + columnNumber % 26) + result;
        columnNumber = columnNumber / 26;
      }
    }
    return result;
  }
}
