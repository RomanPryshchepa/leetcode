package com.leetcode.lc2373;

import java.util.Arrays;

/*
2373. Largest Local Values in a Matrix

You are given an n x n integer matrix grid.

Generate an integer matrix maxLocal of size (n - 2) x (n - 2) such that:

    maxLocal[i][j] is equal to the largest value of the 3 x 3 matrix in grid centered around row i + 1 and column j + 1.

In other words, we want to find the largest value in every contiguous 3 x 3 matrix in grid.

Return the generated matrix.



Example 1:

Input: grid = [[9,9,8,1],[5,6,2,6],[8,2,6,4],[6,2,2,2]]
Output: [[9,9],[8,6]]
Explanation: The diagram above shows the original matrix and the generated matrix.
Notice that each value in the generated matrix corresponds to the largest value of a contiguous 3 x 3 matrix in grid.

Example 2:

Input: grid = [[1,1,1,1,1],[1,1,1,1,1],[1,1,2,1,1],[1,1,1,1,1],[1,1,1,1,1]]
Output: [[2,2,2],[2,2,2],[2,2,2]]
Explanation: Notice that the 2 is contained within every contiguous 3 x 3 matrix in grid.



Constraints:

    n == grid.length == grid[i].length
    3 <= n <= 100
    1 <= grid[i][j] <= 100
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(Arrays.deepToString(solution.largestLocal(new int[][]{
            {9, 9, 8, 1},
            {5, 6, 2, 6},
            {8, 2, 6, 4},
            {6, 2, 2, 2}
        })));

    System.out.println(Arrays.deepToString(solution.largestLocal(new int[][]{
        {1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1},
        {1, 1, 2, 1, 1},
        {1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1}
    })));
  }

  public int[][] largestLocal(int[][] grid) {
    int max;
    int[][] result = new int[grid.length - 2][];
    for (int i = 0; i < result.length; i++) {
      result[i] = new int[grid[i].length - 2];
    }
    for (int i = 0; i < grid.length - 2; i++) {
      for (int j = 0; j < grid[i].length - 2; j++) {
        max = 1;
        for (int ii = 0; ii < 3; ii++) {
          for (int ij = 0; ij < 3; ij++) {
            if (grid[i + ii][j + ij] > max) {
              max = grid[i + ii][j + ij];
            }
          }
        }
        result[i][j] = max;
      }
    }
    return result;
  }

  public int[][] largestLocal2(int[][] grid) {
    int size = grid.length - 2;
    int[][] result = new int[size][size];
    int[] x = new int[]{-1, -1, -1, 0, 0, 0, 1, 1, 1};
    int[] y = new int[]{-1, 0, 1, -1, 0, 1, -1, 0, 1};
    for (int i = 1; i < size + 1; i++) {
      for (int j = 1; j < size + 1; j++) {
        int max = 0;
        for (int k = 0; k < 9; k++) {
          if (grid[i + x[k]][j + y[k]] > max) {
            max = grid[i + x[k]][j + y[k]];
          }
        }
        result[i - 1][j - 1] = max;
      }
    }
    return result;
  }
}
