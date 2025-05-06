package com.leetcode.lc746;

/*
746. Min Cost Climbing Stairs

You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.

You can either start from the step with index 0, or the step with index 1.

Return the minimum cost to reach the top of the floor.



Example 1:

Input: cost = [10,15,20]
Output: 15
Explanation: You will start at index 1.
- Pay 15 and climb two steps to reach the top.
The total cost is 15.

Example 2:

Input: cost = [1,100,1,1,1,100,1,1,100,1]
Output: 6
Explanation: You will start at index 0.
- Pay 1 and climb two steps to reach index 2.
- Pay 1 and climb two steps to reach index 4.
- Pay 1 and climb two steps to reach index 6.
- Pay 1 and climb one step to reach index 7.
- Pay 1 and climb two steps to reach index 9.
- Pay 1 and climb one step to reach the top.
The total cost is 6.



Constraints:

    2 <= cost.length <= 1000
    0 <= cost[i] <= 999
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.minCostClimbingStairs(new int[]{10, 15, 20})); // 15
    System.out.println(solution.minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1})); // 6
    System.out.println(solution.minCostClimbingStairs(new int[]{90, 11, 55, 0, 3, 56, 19, 24, 49, 19, 3, 95})); // 79
    System.out.println(solution.minCostClimbingStairs(new int[]{46, 85, 96, 68, 14, 88, 54, 93, 80, 37, 6, 70, 85, 22, 67, 77, 25, 23})); // 473
    System.out.println(solution.minCostClimbingStairs(new int[]{55, 5, 10, 2, 11, 29, 45, 13, 71, 29, 54, 65, 92, 21, 5, 58, 68, 8, 2})); // 230
    System.out.println(solution.minCostClimbingStairs(new int[]{99, 46, 53, 99, 91, 63, 44, 11, 72, 20, 69, 21, 43, 48, 22, 37, 73, 47})); // 392
    System.out.println(solution.minCostClimbingStairs(new int[]{53, 32, 4, 69, 99, 12, 50, 36, 82, 20, 33, 24, 83, 84, 81, 49})); // 326
    System.out.println(solution.minCostClimbingStairs(new int[]{10, 15, 20, 1})); // 16
    System.out.println(solution.minCostClimbingStairs(new int[]{10, 15, 20, 10})); // 25
    System.out.println(solution.minCostClimbingStairs(new int[]{10, 15, 20, 100})); // 30
    System.out.println(solution.minCostClimbingStairs(new int[]{1, 1})); // 1
    System.out.println(solution.minCostClimbingStairs(new int[]{2, 1})); // 1
    System.out.println(solution.minCostClimbingStairs(new int[]{1, 2})); // 1
    System.out.println(solution.minCostClimbingStairs(new int[]{0, 2})); // 0
    System.out.println(solution.minCostClimbingStairs(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1})); // 6
    System.out.println(solution.minCostClimbingStairs(new int[]{1, 1, 1})); // 1
    System.out.println(solution.minCostClimbingStairs(new int[]{1, 2, 1})); // 2
    System.out.println(solution.minCostClimbingStairs(new int[]{1, 3, 1})); // 2
  }

  public int minCostClimbingStairs(int[] cost) {
    var prev = 0;
    var prevPrev = 0;
    var curr = 0;
    for (int i = 2; i <= cost.length; i++) {
      curr = Math.min(prevPrev + cost[i - 2], prev + cost[i - 1]);
      prevPrev = prev;
      prev = curr;
    }
    return prev;
  }
}
