package com.leetcode.lc1473;

import java.util.Arrays;

/*
1473. Paint House III

There is a row of m houses in a small city, each house must be painted with one of the n colors (labeled from 1 to n), some houses that have been painted last summer should not be painted again.

A neighborhood is a maximal group of continuous houses that are painted with the same color.

    For example: houses = [1,2,2,3,3,2,1,1] contains 5 neighborhoods [{1}, {2,2}, {3,3}, {2}, {1,1}].

Given an array houses, an m x n matrix cost and an integer target where:

    houses[i]: is the color of the house i, and 0 if the house is not painted yet.
    cost[i][j]: is the cost of paint the house i with the color j + 1.

Return the minimum cost of painting all the remaining houses in such a way that there are exactly target neighborhoods. If it is not possible, return -1.



Example 1:

Input: houses = [0,0,0,0,0], cost = [[1,10],[10,1],[10,1],[1,10],[5,1]], m = 5, n = 2, target = 3
Output: 9
Explanation: Paint houses of this way [1,2,2,1,1]
This array contains target = 3 neighborhoods, [{1}, {2,2}, {1,1}].
Cost of paint all houses (1 + 1 + 1 + 1 + 5) = 9.

Example 2:

Input: houses = [0,2,1,2,0], cost = [[1,10],[10,1],[10,1],[1,10],[5,1]], m = 5, n = 2, target = 3
Output: 11
Explanation: Some houses are already painted, Paint the houses of this way [2,2,1,2,2]
This array contains target = 3 neighborhoods, [{2,2}, {1}, {2,2}].
Cost of paint the first and last house (10 + 1) = 11.

Example 3:

Input: houses = [3,1,2,3], cost = [[1,1,1],[1,1,1],[1,1,1],[1,1,1]], m = 4, n = 3, target = 3
Output: -1
Explanation: Houses are already painted with a total of 4 neighborhoods [{3},{1},{2},{3}] different of target = 3.



Constraints:

    m == houses.length == cost.length
    n == cost[i].length
    1 <= m <= 100
    1 <= n <= 20
    1 <= target <= m
    0 <= houses[i] <= n
    1 <= cost[i][j] <= 104
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(Integer.MAX_VALUE/2 + 1);
    System.out.println(solution.minCost(new int[]{0, 0, 0, 0, 0}, new int[][]{{1, 10}, {10, 1}, {10, 1}, {1, 10}, {5, 1}}, 5, 2, 3));
    System.out.println(solution.minCost(new int[]{0, 2, 1, 2, 0}, new int[][]{{1, 10}, {10, 1}, {10, 1}, {1, 10}, {5, 1}}, 5, 2, 3));
    System.out.println(solution.minCost(new int[]{3, 1, 2, 3}, new int[][]{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}, {1, 1, 1}}, 4, 3, 3));
  }

  public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
    int[][][] arr = new int[m][n + 1][target + 1];
    final int MAX = Integer.MAX_VALUE/2 + 1;
    for (int[][] row : arr) {
      for (int[] col : row) {
        Arrays.fill(col, MAX);
      }
    }

    if (houses[0] == 0) {
      for (int color = 1; color <= n; color++) {
        arr[0][color][1] = cost[0][color - 1];
      }
    } else {
      arr[0][houses[0]][1] = 0;
    }

    for (int houseIdx = 1; houseIdx < m; houseIdx++) {
      if (houses[houseIdx] == 0) {
        for (int currentColor = 1; currentColor <= n; currentColor++) {
          for (int neighborhoods = 1; neighborhoods <= Math.min(target, houseIdx + 1); neighborhoods++) {
            for (int previousColor = 1; previousColor <= n; previousColor++) {
              if (currentColor == previousColor) {
                arr[houseIdx][currentColor][neighborhoods] = Math.min(arr[houseIdx][currentColor][neighborhoods], arr[houseIdx - 1][currentColor][neighborhoods] + cost[houseIdx][currentColor - 1]);
              } else {
                arr[houseIdx][currentColor][neighborhoods] = Math.min(arr[houseIdx][currentColor][neighborhoods], arr[houseIdx - 1][previousColor][neighborhoods - 1] + cost[houseIdx][currentColor - 1]);
              }
            }
          }
        }
      } else {
        int currentColor = houses[houseIdx];
        for (int neighborhoods = 1; neighborhoods <= Math.min(target, houseIdx + 1); neighborhoods++) {
          for (int previousColor = 1; previousColor <= n; previousColor++) {
            if (currentColor == previousColor) {
              arr[houseIdx][currentColor][neighborhoods] = Math.min(arr[houseIdx][currentColor][neighborhoods], arr[houseIdx - 1][currentColor][neighborhoods]);
            } else {
              arr[houseIdx][currentColor][neighborhoods] = Math.min(arr[houseIdx][currentColor][neighborhoods], arr[houseIdx - 1][previousColor][neighborhoods - 1]);
            }
          }
        }
      }
    }

    int minCostResult = MAX;
    for (int color = 1; color <= n; color++) {
      minCostResult = Math.min(minCostResult, arr[m - 1][color][target]);
    }

    if (minCostResult < MAX)
      return minCostResult;
    else
      return -1;
  }
}
