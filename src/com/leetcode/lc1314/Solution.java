package com.leetcode.lc1314;

import java.util.Arrays;

/*
1314. Matrix Block Sum

Given a m x n matrix mat and an integer k, return a matrix answer where each answer[i][j] is the sum of all elements mat[r][c] for:

    i - k <= r <= i + k,
    j - k <= c <= j + k, and
    (r, c) is a valid position in the matrix.



Example 1:

Input: mat = [[1,2,3],[4,5,6],[7,8,9]], k = 1
Output: [[12,21,16],[27,45,33],[24,39,28]]

Example 2:

Input: mat = [[1,2,3],[4,5,6],[7,8,9]], k = 2
Output: [[45,45,45],[45,45,45],[45,45,45]]



Constraints:

    m == mat.length
    n == mat[i].length
    1 <= m, n, k <= 100
    1 <= mat[i][j] <= 100
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(Arrays.deepToString(solution.matrixBlockSum(new int[][]{{1,2,3},{4,5,6},{7,8,9}}, 1)));
    System.out.println(Arrays.deepToString(solution.matrixBlockSum(new int[][]{{1,2,3},{4,5,6},{7,8,9}}, 2)));
  }

  public int[][] matrixBlockSum(int[][] mat, int k) {

    var result = new int[mat.length][];
    for (int i = 0; i < mat.length; i++) {
      result[i] = new int[mat[i].length];
      for (int j = 0; j < mat[i].length; j++) {
        result[i][j] = sumK(mat, i, j, k);
      }
    }
    return result;
  }

  private int sumK(int[][] mat, int i, int j, int k) {
    var startI = Math.max(i - k, 0);
    var endI = i + k >= mat.length ? mat.length - 1 : i + k;
    var startJ = Math.max(j - k, 0);
    var endJ = j + k >= mat[0].length ? mat[0].length - 1 : j + k;
    var sum = 0;
    for (var i0 = startI; i0 <= endI; i0++) {
      for (var j0 = startJ; j0 <= endJ; j0++) {
        sum += mat[i0][j0];
      }
    }
    return sum;
  }
}
