package com.leetcode.lc1689;

/*
1689. Partitioning Into Minimum Number Of Deci-Binary Numbers

A decimal number is called deci-binary if each of its digits is either 0 or 1 without any leading zeros. For example, 101 and 1100 are deci-binary, while 112 and 3001 are not.

Given a string n that represents a positive decimal integer, return the minimum number of positive deci-binary numbers needed so that they sum up to n.



Example 1:

Input: n = "32"
Output: 3
Explanation: 10 + 11 + 11 = 32

Example 2:

Input: n = "82734"
Output: 8

Example 3:

Input: n = "27346209830709182346"
Output: 9



Constraints:

    1 <= n.length <= 105
    n consists of only digits.
    n does not contain any leading zeros and represents a positive integer.
 */
public class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.minPartitions("32"));
    System.out.println(solution.minPartitions("82734"));
    System.out.println(solution.minPartitions("27346209830709182346"));
  }

  public int minPartitions(String n) {
    var result = 0;
    for (var s : n.toCharArray())
      if (Integer.parseInt(String.valueOf(s)) > result)
        result = Integer.parseInt(String.valueOf(s));
    return result;
  }
}
