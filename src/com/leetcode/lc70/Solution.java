package com.leetcode.lc70;

/*
70. Climbing Stairs

You are climbing a staircase. It takes n steps to reach the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
Example 1:
Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:
Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
Constraints:
    1 <= n <= 45
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    int n;

    n = 2;
    System.out.println(solution.climbStairs(n)); // 2
    System.out.println(solution.climbStairsR(n)); // 2

    n = 3;
    System.out.println(solution.climbStairs(n)); // 3
    System.out.println(solution.climbStairsR(n)); // 3

    n = 4;
    System.out.println(solution.climbStairs(n)); // 5
    System.out.println(solution.climbStairsR(n)); // 5

    n = 5;
    System.out.println(solution.climbStairs(n)); // 8
    System.out.println(solution.climbStairsR(n)); // 8
  }

  public int climbStairsR(int n) {
    if (n == 0) {
      return 0;
    }
    if (n == 1) {
      return 1;
    }
    if (n == 2) {
      return 2;
    }
    return climbStairsR(n - 2) + climbStairsR(n - 1);
  }

  public int climbStairs(int n) {
    if (n == 0) {
      return 0;
    }
    if (n == 1) {
      return 1;
    }
    if (n == 2) {
      return 2;
    }
    int prevPrev = 1;
    int prev = 2;
    int current = 0;
    for (int i = 3; i <= n; i++) {
      current = prev + prevPrev;
      prevPrev = prev;
      prev = current;
    }
    return current;
  }
}
