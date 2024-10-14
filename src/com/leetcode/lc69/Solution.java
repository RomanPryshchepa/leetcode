package com.leetcode.lc69;

/*
69. Sqrt(x)

Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.

You must not use any built-in exponent function or operator.

    For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.



Example 1:

Input: x = 4
Output: 2
Explanation: The square root of 4 is 2, so we return 2.

Example 2:

Input: x = 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.



Constraints:

    0 <= x <= 231 - 1
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.mySqrt(4)); // 2
    System.out.println(solution.mySqrt(8)); // 2
    System.out.println(solution.mySqrt(100)); // 2
    System.out.println(solution.mySqrt(99)); // 2
    System.out.println(solution.mySqrt(0)); // 2
    System.out.println(solution.mySqrt(1)); // 2
    System.out.println(solution.mySqrt(2)); // 2
    System.out.println(solution.mySqrt(3)); // 2
    System.out.println(solution.mySqrt(9)); // 2
    System.out.println(solution.mySqrt(2147395599)); // 2
  }

  public int mySqrt(int x) {
    int left = 0;
    int right = x / 2;
    int result = left + (right - left) / 2;
    while (!(1l * result * result == x || 1l * result * result < x && 1l * (result + 1) * (result + 1) > x)) {
      if (1l * result * result > x) {
        right = result - 1;
      } else {
        left = result + 1;
      }
      result = left + (right - left) / 2;
    }
    return result;
  }

}
