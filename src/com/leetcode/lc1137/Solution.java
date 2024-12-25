package com.leetcode.lc1137;

/*
1137. N-th Tribonacci Number
Easy
Topics
Companies
Hint

The Tribonacci sequence Tn is defined as follows:

T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.

Given n, return the value of Tn.



Example 1:

Input: n = 4
Output: 4
Explanation:
T_3 = 0 + 1 + 1 = 2
T_4 = 1 + 1 + 2 = 4

Example 2:

Input: n = 25
Output: 1389537



Constraints:

    0 <= n <= 37
    The answer is guaranteed to fit within a 32-bit integer, ie. answer <= 2^31 - 1.
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.tribonacci(4)); // 4
    System.out.println(solution.tribonacci(25));// 1389537
    System.out.println(solution.tribonacci(34));// 334745777
    System.out.println(solution.tribonacci(35));// 615693474
  }

  public int tribonacci(int n) {
    if (n == 0) return 0;
    if (n == 1) return 1;
    if (n == 2) return 1;
    var tn = 0;
    var tn1 = 1;
    var tn2 = 1;
    var tn3 = 0;
    for (int i = 3; i <= n; i++) {
      tn3 = tn + tn1 + tn2;
      tn = tn1;
      tn1 = tn2;
      tn2 = tn3;
    }
    return tn3;
  }

  public int tribonacciRecurSwitch(int n) {
    return switch (n) {
      case 0 -> 0;
      case 1, 2 -> 1;
      default -> tribonacciRecurSwitch(n - 1) + tribonacciRecurSwitch(n - 2) + tribonacciRecurSwitch(n - 3);
    };
  }

  public int tribonacciRecur(int n) {
    if (n == 0) return 0;
    if (n == 1) return 1;
    if (n == 2) return 1;
    return tribonacciRecur(n - 1) + tribonacciRecur(n - 2) + tribonacciRecur(n - 3);
  }
}
