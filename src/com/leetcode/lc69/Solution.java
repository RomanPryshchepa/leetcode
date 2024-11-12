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
    System.out.println(solution.mySqrt(100)); // 10
    System.out.println(solution.mySqrt(99)); // 9
    System.out.println(solution.mySqrt(0)); // 0
    System.out.println(solution.mySqrt(1)); // 1
    System.out.println(solution.mySqrt(2)); // 1
    System.out.println(solution.mySqrt(3)); // 1
    System.out.println(solution.mySqrt(9)); // 3
    System.out.println(solution.mySqrt(2147395599)); // 46339
    System.out.println(solution.mySqrt(46339)); //215
    System.out.println(solution.mySqrt(463395)); //680
    System.out.println(solution.mySqrt(146339)); //382
    System.out.println(solution.mySqrt(35646339)); //5970
  }

  public int mySqrt(int x) {
    var left = 0;
    var right = x / 2 + 1;
    var result = 0;
    while (left <= right) {
      result = left + (right - left) / 2;
      if (1l * result * result > x) {
        right = result - 1;
      } else {
        left = result + 1;
      }
    }
    return right;
  }
}
