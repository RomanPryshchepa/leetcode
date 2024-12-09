package com.leetcode.lc504;

/*
504. Base 7

Given an integer num, return a string of its base 7 representation.



Example 1:

Input: num = 100
Output: "202"

Example 2:

Input: num = -7
Output: "-10"



Constraints:

    -107 <= num <= 107
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.convertToBase7(0));
    System.out.println(solution.convertToBase7(100));
    System.out.println(solution.convertToBase7(-7));
  }

  public String convertToBase7(int num) {
    if (num == 0) {
      return "0";
    }
    var sb = new StringBuilder();
    var isNegative = num < 0;
    if (isNegative) {
      num = -num;
    }
    while (num > 0) {
      sb.append(num % 7);
      num /= 7;
    }
    if (isNegative) {
      sb.append("-");
    }
    return sb.reverse().toString();
  }
}
