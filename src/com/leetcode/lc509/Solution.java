package com.leetcode.lc509;
/*
509. Fibonacci Number

The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence,
such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,
F(0) = 0, F(1) = 1
F(n) = F(n - 1) + F(n - 2), for n > 1.
Given n, calculate F(n).
Example 1:
Input: n = 2
Output: 1
Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
Example 2:
Input: n = 3
Output: 2
Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
Example 3:
Input: n = 4
Output: 3
Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
Constraints:
    0 <= n <= 30
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    int n;

    n = 0;
    System.out.println(solution.fibR(n)); // 0
    System.out.println(solution.fib(n)); // 0

    n = 1;
    System.out.println(solution.fibR(n)); // 1
    System.out.println(solution.fib(n)); // 1

    n = 2;
    System.out.println(solution.fibR(n)); // 1
    System.out.println(solution.fib(n)); // 1

    n = 3;
    System.out.println(solution.fibR(n)); // 2
    System.out.println(solution.fib(n)); // 2

    n = 4;
    System.out.println(solution.fibR(n)); // 3
    System.out.println(solution.fib(n)); // 3

    n = 21;
    System.out.println(solution.fibR(n)); // 10946
    System.out.println(solution.fib(n)); // 10946

    n = 30;
    System.out.println(solution.fibR(n)); // 832040
    System.out.println(solution.fib(n)); // 832040
  }

  public int fibR(int n) {
    if (n == 0)
      return 0;
    if (n == 1) {
      return 1;
    }
    return fibR(n - 2) + fibR(n - 1);
  }

  public int fib(int n) {
    if (n == 0)
      return 0;
    if (n == 1) {
      return 1;
    }
    int prevPrev = 0;
    int prev = 1;
    int current = 0;
    for (int i = 2; i <= n; i++) {
      current = prev + prevPrev;
      prevPrev = prev;
      prev = current;
    }
    return current;
  }
}
