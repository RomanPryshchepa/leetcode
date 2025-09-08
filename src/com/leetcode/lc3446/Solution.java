package com.leetcode.lc3446;

import java.util.Arrays;
import java.util.Collections;

/*
3446. Sort Matrix by Diagonals

You are given an n x n square matrix of integers grid. Return the matrix such that:

    The diagonals in the bottom-left triangle (including the middle diagonal) are sorted in non-increasing order.
    The diagonals in the top-right triangle are sorted in non-decreasing order.



Example 1:

Input: grid = [[1,7,3],[9,8,2],[4,5,6]]

Output: [[8,2,3],[9,6,7],[4,5,1]]

Explanation:

The diagonals with a black arrow (bottom-left triangle) should be sorted in non-increasing order:

    [1, 8, 6] becomes [8, 6, 1].
    [9, 5] and [4] remain unchanged.

The diagonals with a blue arrow (top-right triangle) should be sorted in non-decreasing order:

    [7, 2] becomes [2, 7].
    [3] remains unchanged.

Example 2:

Input: grid = [[0,1],[1,2]]

Output: [[2,1],[1,0]]

Explanation:

The diagonals with a black arrow must be non-increasing, so [0, 2] is changed to [2, 0]. The other diagonals are already in the correct order.

Example 3:

Input: grid = [[1]]

Output: [[1]]

Explanation:

Diagonals with exactly one element are already in order, so no changes are needed.



Constraints:

    grid.length == grid[i].length == n
    1 <= n <= 10
    -105 <= grid[i][j] <= 105
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(Arrays.deepToString(solution.sortMatrix(new int[][]{{1,7,3},{9,8,2},{4,5,6}})));
    System.out.println(Arrays.deepToString(solution.sortMatrix(new int[][]{{0,1},{1,2}})));
    System.out.println(Arrays.deepToString(solution.sortMatrix(new int[][]{{1}})));
  }

  public int[][] sortMatrix(int[][] grid) {
    var n = grid.length;
    for (var k = 1; k < n - 1; k++) {
      var arr = new int[n - k];
      for (var j = k; j < n; j++)
        arr[j - k] = grid[j - k][j];
      Arrays.sort(arr);
      for (var j = k; j < n; j++)
        grid[j - k][j] = arr[j - k];
    }
    for (var k = 0; k < n - 1; k++) {
      var arr = new Integer[n - k];
      for (var i = k; i < n; i++)
        arr[i - k] = grid[i][i - k];
      Arrays.sort(arr, Collections.reverseOrder());
      for (var i = k; i < n; i++)
        grid[i][i - k] = arr[i - k];
    }
    return grid;
  }

}
